package Task1;

import java.time.LocalDateTime;

public class Account {
    private int user_id;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime createdOn;
    private LocalDateTime last_login;
    // ...
    /*
    created_on TIMESTAMP NOT NULL,
    last_login TIMESTAMP
    */
    public Account(String userName){
        this.userName = userName;
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(String userName, String password, LocalDateTime last_login) {
        this.userName = userName;
        this.password = password;
        this.last_login = last_login;
    }

    public Account() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getLast_login() {
        return last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }
}