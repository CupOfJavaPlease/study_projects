package com.example.controller;

import com.example.entities.Profile;
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
            return new ResponseEntity<Profile>(requestProfile, HttpStatus.OK);
    }
}
