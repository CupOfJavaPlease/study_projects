package com.example.springreststubgradledeepparsejson.entities;

public class Uuid {
    private String userChannel;
    private String sub;
    private String userId;

    public Uuid() {
    }

    public Uuid(String userChannel, String sub, String userId) {
        this.userChannel = userChannel;
        this.sub = sub;
        this.userId = userId;
    }

    public String getUserChannel() {
        return userChannel;
    }

    public void setUserChannel(String userChannel) {
        this.userChannel = userChannel;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
