package com.brighttalk.userrealm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "RealmNotFound")
public class RealmNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public RealmNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
