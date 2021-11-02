package com.example.springreststubgradledeepparsejson.entities;

public class EventsService {
    private String epkId;
    private Consumer consumer;
    private Events events;

    public EventsService() {
    }

    public EventsService(String epkId, Consumer consumer, Events events) {
        this.epkId = epkId;
        this.consumer = consumer;
        this.events = events;
    }

    public String getEpkId() {
        return epkId;
    }

    public void setEpkId(String epkId) {
        this.epkId = epkId;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }
}
