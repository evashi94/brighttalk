package com.brighttalk.userrealm.controller;

import com.brighttalk.userrealm.dto.RealmDto;
import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.dto.NameDescriptionDto;
import com.brighttalk.userrealm.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/user/realm")
public class UserRealmController {

    private RealmService realmService;

    @Autowired
    public UserRealmController(RealmService realmService) {
        this.realmService = realmService;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(code = HttpStatus.CREATED)
    public RealmDto createRealm(@RequestBody NameDescriptionDto nameDescriptionDto) {
        return realmService.createRealm(nameDescriptionDto);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public RealmDto getRealm(@PathVariable String id) {
        return realmService.getRealmById(id);
    }

}