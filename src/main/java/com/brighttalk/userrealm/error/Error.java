package com.brighttalk.userrealm.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class Error {
    String code;
}