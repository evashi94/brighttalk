package com.brighttalk.userrealm.service;

import com.brighttalk.userrealm.dto.RealmDto;
import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.dto.NameDescriptionDto;
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

    public RealmDto createRealm(NameDescriptionDto nameDescriptionDto) throws ResponseStatusException {
        Realm realm = new Realm();
        String name = nameDescriptionDto.getName();
        if(name == null || name.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "InvalidRealmName");
        } else if(getRealmByName(name) != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "DuplicateRealmName");
        }
        realm.setName(nameDescriptionDto.getName());
        realm.setDescription(nameDescriptionDto.getDescription());
        realm.setKey(KeyGenerator.generateKey());
        realmRepository.save(realm);
        return new RealmDto(realm.getId(), realm.getName(), realm.getDescription(), realm.getKey());
    }

    public RealmDto getRealmById(String idString) throws ResponseStatusException {
        long id;
        try {
            id = Long.parseLong(idString);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "InvalidArgument");
        }

        Realm realm = realmRepository.getOne(id);
        if(realm == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "RealmNotFound");
        }
        return new RealmDto(realm.getId(), realm.getName(), realm.getDescription(), realm.getKey());
    }

    private Realm getRealmByName(String name){
        return realmRepository.findByName(name);
    }
}
