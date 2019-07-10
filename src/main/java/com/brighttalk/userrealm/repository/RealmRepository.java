package com.brighttalk.userrealm.repository;

import com.brighttalk.userrealm.entity.Realm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RealmRepository extends JpaRepository<Realm, Integer> {
}