package com.brighttalk.userrealm.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "realm")
public class RealmDto {

    @JacksonXmlProperty(isAttribute = true)
    int id;

    @JacksonXmlProperty(isAttribute = true)
    String name;

    @JacksonXmlProperty
    String description;

    @JacksonXmlProperty
    String key;
}
