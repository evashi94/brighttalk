package com.brighttalk.userrealm.controller;

import com.brighttalk.userrealm.dto.NameDescriptionDto;
import com.brighttalk.userrealm.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRealmController {

    private RealmService realmService;

    @Autowired
    public UserRealmController(RealmService realmService) {
        this.realmService = realmService;
    }

    @PostMapping(value = "/service/user/realm", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> createRealm(@RequestBody NameDescriptionDto nameDescriptionDto) {
        return realmService.createRealm(nameDescriptionDto);
    }

    @GetMapping(value = "/service/user/realm/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getRealm(@PathVariable String id) {
        return realmService.getRealmById(id);
    }

    @GetMapping("/alive")
    public String checkAlive(){
        return "Running";
    }

}