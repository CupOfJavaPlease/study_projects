package Task1;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
//            Account a = new AccountService().getAccountByUserName("test1");
            SecurityService.getInstance().authenticate("test1", "test1");
        } catch (SecurityService.AuthException throwables) {
            throwables.printStackTrace();
        }
    }



}
