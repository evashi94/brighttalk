package com.brighttalk.userrealm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RealmModel {
    @JsonProperty
    String name;

    @JsonProperty
    String description;
}
