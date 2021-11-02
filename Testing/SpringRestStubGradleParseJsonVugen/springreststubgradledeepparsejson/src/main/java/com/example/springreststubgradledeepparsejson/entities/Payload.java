package com.example.springreststubgradledeepparsejson.entities;

public class Payload {
    private EventsService eventsService;

    public Payload() {
    }

    public Payload(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    public EventsService getEventsService() {
        return eventsService;
    }

    public void setEventsService(EventsService eventsService) {
        this.eventsService = eventsService;
    }
}
