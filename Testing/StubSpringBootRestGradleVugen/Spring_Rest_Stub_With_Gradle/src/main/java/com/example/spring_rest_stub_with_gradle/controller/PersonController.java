package com.example.spring_rest_stub_with_gradle.controller;

import com.example.spring_rest_stub_with_gradle.entities.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class PersonController {

    @GetMapping("/test")
    public ResponseEntity<String> catchPostMapping() {
        return new ResponseEntity<String>("String OK", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Profile> catchPostMapping(@RequestBody Profile object){
        Profile requestProfile = new Profile();
        requestProfile.setName(object.getName());
        requestProfile.setLastName(object.getLastName());
        requestProfile.setMiddleName(object.getMiddleName());
        requestProfile.setBirthday("05-05-05");
        requestProfile.setPassport("55 05 555555");
        return new ResponseEntity<Profile>(requestProfile, HttpStatus.OK);
    }
}

