package com.brighttalk.userrealm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Realm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(unique = true, length = 250)
    String name;

    String description;

    @Column(name = "\"key\"", length = 32)
    String key;

    public boolean isValid() {
        return name != null && description != null && key != null;
    }
}