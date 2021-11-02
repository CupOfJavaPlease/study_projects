package com.example.springreststubgradledeepparsejson.entities;

public class Consumer {
    private String projectId;
    private Application application;

    public Consumer() {
    }

    public Consumer(String projectId, Application application) {
        this.projectId = projectId;
        this.application = application;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
