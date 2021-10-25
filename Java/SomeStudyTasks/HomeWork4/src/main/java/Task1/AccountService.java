package Task1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AccountService {

    // метод возвращает значение типа Account
    public Account getAccountByUserName(String userName) throws SQLException {
        //
        Account a = null;
        final String sql = "select * from accounts where username = ?";
        try (Connection c = DataBaseUtil.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, userName);
            try (ResultSet rs = s.executeQuery()) {
                if (rs.next()) {
                    String email = rs.getString("email");
                    System.out.println("getAccountByUserName.email=" + email);
                    // используем метод getObject для получения даты и времени из created_on
                    LocalDateTime createdOn = rs.getObject("created_on", LocalDateTime.class);
                    // st.setObject(1, createdOn);
                    System.out.println("getAccountByUserName.createdOn=" + createdOn);
                    a = new Account(userName);
                    a.setCreatedOn(createdOn);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return a;
    }
}
