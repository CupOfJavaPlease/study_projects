package com.example.springreststubgradledeepparsejson.entities;

public class Profile {
    private long messageId;
    private String sessionId;
    private String messageName;
    private Uuid uuid;
    private Payload payload;


    public Profile() {
    }

    public Profile(long messageId, String sessionId, String messageName, Uuid uuid) {
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.messageName = messageName;
        this.uuid = uuid;
    }

    public Profile(long messageId, String sessionId, Uuid uuid, Payload payload) {
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.uuid = uuid;
        this.payload = payload;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public Uuid getUuid() {
        return uuid;
    }

    public void setUuid(Uuid uuid) {
        this.uuid = uuid;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}



