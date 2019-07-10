package com.brighttalk.userrealm.service;

import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.model.RealmModel;
import com.brighttalk.userrealm.repository.RealmRepository;
import com.brighttalk.userrealm.util.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RealmService {

    private RealmRepository realmRepository;

    @Autowired
    public RealmService(RealmRepository realmRepository) {
        this.realmRepository = realmRepository;
    }

    public Realm createRealm(RealmModel realmModel) throws ResponseStatusException {
        Realm realm = new Realm();
        String name = realmModel.getName();
        if(name == null || name.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "InvalidRealmName");
        } else if(getRealmByName(name) != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DuplicateRealmName");
        }
        realm.setName(realmModel.getName());
        realm.setDescription(realmModel.getDescription());
        realm.setKey(KeyGenerator.generateKey());
        realmRepository.save(realm);
        return realm;
    }

    public Realm getRealmById(String idString) throws ResponseStatusException {
        long id;
        try {
            id = Long.parseLong(idString);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "InvalidArgument");
        }

        Realm realm = realmRepository.getOne(id);
        if(realm == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "RealmNotFound");
        }
        return realm;
    }

    private Realm getRealmByName(String name){
        return realmRepository.findByName(name);
    }
}
