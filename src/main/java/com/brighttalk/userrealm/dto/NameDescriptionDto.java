package com.brighttalk.userrealm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class NameDescriptionDto {
    @JsonProperty
    String name;

    @JsonProperty
    String description;
}
