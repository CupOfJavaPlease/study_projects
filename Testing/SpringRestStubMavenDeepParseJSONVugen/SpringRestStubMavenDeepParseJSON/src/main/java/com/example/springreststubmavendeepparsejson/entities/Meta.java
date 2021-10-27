package com.example.springreststubmavendeepparsejson.entities;

public class Meta {
    private Superapp superapp;
    private Companion companion;

    public Meta() {
    }

    public Meta(Superapp superapp, Companion companion) {
        this.superapp = superapp;
        this.companion = companion;
    }

    public Superapp getSuperapp() {
        return superapp;
    }

    public void setSuperapp(Superapp superapp) {
        this.superapp = superapp;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }
}
