package com.example.entities;

public class Profile {
    private String name;
    private String lastName;
    private String middleName;
    private String birthday;
    private String passport;

    public Profile() {
    }

    public Profile(String name, String lastName, String middleName, String birthday, String passport) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
