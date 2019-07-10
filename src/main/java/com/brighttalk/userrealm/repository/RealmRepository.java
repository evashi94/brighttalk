package com.brighttalk.userrealm.repository;

import com.brighttalk.userrealm.entity.Realm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RealmRepository extends JpaRepository<Realm, Long> {

    Realm findByName(String name);
}