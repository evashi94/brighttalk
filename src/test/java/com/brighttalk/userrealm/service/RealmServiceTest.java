package com.brighttalk.userrealm.service;

import com.brighttalk.userrealm.dto.NameDescriptionDto;
import com.brighttalk.userrealm.dto.RealmDto;
import com.brighttalk.userrealm.entity.Realm;
import com.brighttalk.userrealm.model.ExceptionResponse;
import com.brighttalk.userrealm.repository.RealmRepository;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class RealmServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    RealmRepository realmRepository;

    @InjectMocks
    RealmService realmService;


    @Test
    @Parameters({"Emma, love coding", "-1234, sa7vsf)b", "!@£$@$%, fvd*fa4sed"})
    public void createRealmShouldCreateAndReturnRealm(String name, String description) {
        NameDescriptionDto nameDescriptionDto = new NameDescriptionDto(name, description);
        ResponseEntity<?> responseEntity = realmService.createRealm(nameDescriptionDto);
        RealmDto actualRealmDto = (RealmDto) responseEntity.getBody();
        int actualHttpResponse = responseEntity.getStatusCodeValue();
        assertEquals(name, actualRealmDto.getName());
        assertEquals(description, actualRealmDto.getDescription());
        assertEquals(HttpStatus.CREATED.value(), actualHttpResponse);
    }

    @Test
    @Parameters({"enjoy cooking", "-123sf)b", "!@£$@$sed"})
    public void createRealmShouldReturnInvalidRealmName(String description) {
        NameDescriptionDto nameDescriptionDto = new NameDescriptionDto("", description);
        ResponseEntity<?> responseEntity = realmService.createRealm(nameDescriptionDto);
        ExceptionResponse exceptionResponse = (ExceptionResponse) responseEntity.getBody();
        int actualHttpResponse = responseEntity.getStatusCodeValue();
        assertEquals("InvalidRealmName", exceptionResponse.getCode());
        assertEquals(HttpStatus.BAD_REQUEST.value(), actualHttpResponse);
    }

    @Test
    @Parameters({"exist name 1, description", "exist name 2, description"})
    public void createRealmShouldReturnDuplicateRealmName(String name, String description) {
        Mockito.when(realmRepository.findByName(name)).thenReturn(new Realm(1, "name", "descriptoin", "key"));
        NameDescriptionDto nameDescriptionDto = new NameDescriptionDto(name, description);
        ResponseEntity<?> responseEntity = realmService.createRealm(nameDescriptionDto);
        ExceptionResponse exceptionResponse = (ExceptionResponse) responseEntity.getBody();
        int actualHttpResponse = responseEntity.getStatusCodeValue();
        assertEquals("DuplicateRealmName", exceptionResponse.getCode());
        assertEquals(HttpStatus.BAD_REQUEST.value(), actualHttpResponse);
    }


    @Test
    @Parameters({"123", "7", "5009"})
    public void getRealmByIdShouldReturnRealm(String idString) {
        Mockito.when(realmRepository.getOne(Integer.parseInt(idString))).thenReturn(new Realm(Integer.parseInt(idString), "name", "descriptoin", "key"));
        ResponseEntity<?> responseEntity = realmService.getRealmById(idString);
        RealmDto actualRealmDto = (RealmDto) responseEntity.getBody();
        int actualHttpResponse = responseEntity.getStatusCodeValue();
        assertEquals(Integer.parseInt(idString), actualRealmDto.getId());
        assertEquals(HttpStatus.CREATED.value(), actualHttpResponse);
    }


    @Test
    @Parameters({"-86123", "7.65", "50.1409"})
    public void getRealmByIdShouldReturnInvalidArgument(String idString) {
        ResponseEntity<?> responseEntity = realmService.getRealmById(idString);
        ExceptionResponse exceptionResponse = (ExceptionResponse) responseEntity.getBody();
        int actualHttpResponse = responseEntity.getStatusCodeValue();
        assertEquals("InvalidArgument", exceptionResponse.getCode());
        assertEquals(HttpStatus.BAD_REQUEST.value(), actualHttpResponse);
    }

    @Test
    @Parameters({"999999", "799999", "66554444"})
    public void getRealmByIdShouldReturnRealmNotFound(String idString) {
        Mockito.when(realmRepository.getOne(Integer.parseInt(idString))).thenReturn(null);
        ResponseEntity<?> responseEntity = realmService.getRealmById(idString);
        ExceptionResponse exceptionResponse = (ExceptionResponse) responseEntity.getBody();
        int actualHttpResponse = responseEntity.getStatusCodeValue();
        assertEquals("RealmNotFound", exceptionResponse.getCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), actualHttpResponse);
    }


}