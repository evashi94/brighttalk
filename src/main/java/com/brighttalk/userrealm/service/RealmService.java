package com.brighttalk.userrealm.service;

import com.brighttalk.userrealm.dto.ExceptionResponseDto;
import com.brighttalk.userrealm.dto.NameDescriptionDto;
import com.brighttalk.userrealm.dto.RealmDto;
import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.repository.RealmRepository;
import com.brighttalk.userrealm.util.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RealmService {

    private RealmRepository realmRepository;

    @Autowired
    public RealmService(RealmRepository realmRepository) {
        this.realmRepository = realmRepository;
    }

    public ResponseEntity<?> createRealm(NameDescriptionDto nameDescriptionDto) {
        Realm realm = new Realm();
        String name = nameDescriptionDto.getName();
        if (name == null || name.isEmpty()) {
            return new ResponseEntity<>(new ExceptionResponseDto("InvalidRealmName"), HttpStatus.BAD_REQUEST);
        } else if (getRealmByName(name) != null) {
            return new ResponseEntity<>(new ExceptionResponseDto("DuplicateRealmName"), HttpStatus.BAD_REQUEST);
        }

        realm.setName(nameDescriptionDto.getName());
        realm.setDescription(nameDescriptionDto.getDescription());
        realm.setKey(KeyGenerator.generateKey());
        realmRepository.save(realm);

        RealmDto realmDto = new RealmDto(realm.getId(), realm.getName(), realm.getDescription(), realm.getKey());
        return new ResponseEntity<>(realmDto, HttpStatus.CREATED);
    }

    public ResponseEntity<?> getRealmById(String idString) throws ResponseStatusException {
        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (Exception e) {
            return new ResponseEntity<>(new ExceptionResponseDto("InvalidArgument"), HttpStatus.BAD_REQUEST);
        }
        if (id < 0) {
            return new ResponseEntity<>(new ExceptionResponseDto("InvalidArgument"), HttpStatus.BAD_REQUEST);
        }

        Realm realm = realmRepository.getOne(id);
        try {
            realm.isValid();
        } catch (Exception e) {
            return new ResponseEntity<>(new ExceptionResponseDto("RealmNotFound"), HttpStatus.NOT_FOUND);
        }

        RealmDto realmDto = new RealmDto(realm.getId(), realm.getName(), realm.getDescription(), realm.getKey());
        return new ResponseEntity<>(realmDto, HttpStatus.CREATED);
    }

    private Realm getRealmByName(String name) {
        return realmRepository.findByName(name);
    }
}
