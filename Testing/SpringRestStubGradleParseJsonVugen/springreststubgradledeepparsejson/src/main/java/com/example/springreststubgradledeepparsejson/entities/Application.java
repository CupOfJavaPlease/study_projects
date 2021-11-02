package com.example.springreststubgradledeepparsejson.entities;

public class Application {
    private String appId;
    private String version;

    public Application() {
    }

    public Application(String appId, String version) {
        this.appId = appId;
        this.version = version;

    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
