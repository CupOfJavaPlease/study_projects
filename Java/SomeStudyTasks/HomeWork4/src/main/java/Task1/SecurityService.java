package Task1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class SecurityService {
    private static SecurityService instance;//приватная статическая переменная

    private SecurityService() {
    }//приватный конструктор

    public static SecurityService getInstance() {//проверка на одиночку
        if(instance == null){
            instance = new SecurityService();
        }
        return instance;
    }

    public void authenticate(String username, String password) throws AuthException {//аутентификация пробрасываем исключение
        final String sql = "SELECT username, \"password\" FROM accounts where username =? and \"password\" = ?";//строка селекта
        try (Connection c = DataBaseUtil.getConnection();//try-with-resourses
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, username);//проверяем имя
            s.setString(2, password);//и пароль
            try (ResultSet rs = s.executeQuery()) {//направляем запрос
                if (rs.next()) {//если совпадение есть
                    LocalDateTime time = LocalDateTime.now();//определяемся сразу со временем, дорога каждая мс
                    System.out.println("Enter to account is successful");//костыль что совпадение есть
                    final String sqlUpd = "UPDATE accounts SET last_login=? WHERE username=?";//запрос на апдейт
                    try (Connection conn = DataBaseUtil.getConnection();//пробуем
                         PreparedStatement ps = conn.prepareStatement(sqlUpd)) {
                        ps.setString(2, username);//определяем индивидуума
                        ps.setObject(1, time);//ставим время
                        int i = ps.executeUpdate();//исполняем запрос
                        System.out.println("Now we added in this.account localtimedateNOW");//костыль что у нас обновлено время

                    }catch(SQLException ex){
                        ex.printStackTrace();
                    }

                }else {
                    throw new AuthException("You entered wrong username or password");//если совпадения имени и пароля нет, то пробрасываем исключение ошибку аутентификации
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            throw new AuthException("You entered wrong username or password");
        }

    }

    public class AuthException extends Exception {//наше исключение-ошибка аутентификации
        public AuthException() { }

        public AuthException(String message) {
            super(message);
        }
    }
}
