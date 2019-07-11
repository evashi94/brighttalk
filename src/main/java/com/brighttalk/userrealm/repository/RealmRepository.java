package com.brighttalk.userrealm.repository;

import com.brighttalk.userrealm.entity.Realm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealmRepository extends JpaRepository<Realm, Integer> {

    Realm findByName(String name);
}