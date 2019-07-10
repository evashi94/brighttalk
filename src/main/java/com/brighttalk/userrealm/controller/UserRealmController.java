package com.brighttalk.userrealm.controller;

import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.exception.RealmNotFoundException;
import com.brighttalk.userrealm.model.RealmModel;
import com.brighttalk.userrealm.repository.RealmRepository;
import com.brighttalk.userrealm.service.RealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/user/realm")
public class UserRealmController {

    private RealmService realmService;
    private RealmRepository realmRepository;

    @Autowired
    public UserRealmController(RealmService realmService, RealmRepository realmRepository) {
        this.realmService = realmService;
        this.realmRepository = realmRepository;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public void createRealm(@RequestBody RealmModel realmModel){
        Realm realm = realmService.createRealm(realmModel);
        realmRepository.save(realm);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Realm getRealm(@PathVariable int id) throws RealmNotFoundException {
        return realmService.getRealm(id);
    }

}