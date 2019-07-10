package com.brighttalk.userrealm.service;

import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.exception.RealmNotFoundException;
import com.brighttalk.userrealm.model.RealmModel;
import com.brighttalk.userrealm.repository.RealmRepository;
import com.brighttalk.userrealm.util.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealmService {

    public Realm createRealm(RealmModel realmModel){
        Realm realm = new Realm();
        realm.setName(realmModel.getName());
        realm.setDescription(realmModel.getDescription());
        realm.setKey(KeyGenerator.generateKey());
        return realm;
    }

    public Realm getRealm(int id) throws RealmNotFoundException {
        // todo: check if id is not an integer, would it throw 400
        // error code InvalidArgument
        Realm realm = getRealm(id);
        if(realm == null){
            throw new RealmNotFoundException("Realm Not Found in Repository");
        }
        return realm;
    }
}
