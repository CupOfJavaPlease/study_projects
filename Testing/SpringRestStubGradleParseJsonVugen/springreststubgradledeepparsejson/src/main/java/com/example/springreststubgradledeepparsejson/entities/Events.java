package com.example.springreststubgradledeepparsejson.entities;

public class Events {
    private String icalendar;
    private Meta meta;

    public Events() {
    }

    public Events(String icalendar, Meta meta) {
        this.icalendar = icalendar;
        this.meta = meta;
    }

    public String getIcalendar() {
        return icalendar;
    }

    public void setIcalendar(String icalendar) {
        this.icalendar = icalendar;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
