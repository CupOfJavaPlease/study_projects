package com.example.springreststubgradledeepparsejson.controller;

import com.example.springreststubgradledeepparsejson.entities.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class ProfileController {

    @PostMapping("/")

        public ResponseEntity<Profile> catchPostMapping(@RequestBody Profile object){
            Profile requestProfile = new Profile();
            Uuid requestUuid = new Uuid();

            Payload payload = new Payload();
            EventsService requestEService = new EventsService();
            Consumer requestConsumer = new Consumer();
            Application requestApplication = new Application();
            Companion companion = new Companion();
            Events events = new Events();
            Meta meta = new Meta();

            Superapp superapp = new Superapp();

            requestProfile.setMessageId(object.getMessageId());
            requestProfile.setSessionId(object.getSessionId());
            requestProfile.setUuid(object.getUuid());
            requestProfile.setPayload(object.getPayload());

            requestUuid.setSub(requestProfile.getUuid().getSub());
            String id = requestProfile.getUuid().getUserId();
            requestUuid.setUserId(id);
            requestUuid.setUserChannel("FEBRUARY");

            requestEService.setEpkId(id);

            requestConsumer.setProjectId(id);

            requestApplication.setAppId(id);
            requestApplication.setVersion("1.2.3");

            events.setIcalendar("BEGIN:VCALENDAR");

            superapp.setField1("value1");
            superapp.setField2("value2");

            companion.setField1("value1");
            companion.setField2("value2");

            meta.setSuperapp(superapp);
            meta.setCompanion(companion);
            events.setMeta(meta);
            requestConsumer.setApplication(requestApplication);
            requestEService.setConsumer(requestConsumer);
            requestEService.setEvents(events);
            payload.setEventsService(requestEService);
            requestProfile.setPayload(payload);

            return new ResponseEntity<Profile>(requestProfile, HttpStatus.OK);
    }
}
