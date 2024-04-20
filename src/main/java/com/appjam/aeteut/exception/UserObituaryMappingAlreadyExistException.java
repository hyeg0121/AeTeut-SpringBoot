package com.appjam.aeteut.exception;

import com.appjam.aeteut.exception.type.ErrorType;

public class UserObituaryMappingAlreadyExistException extends GloabalException {
    public static GloabalException EXCEPTION =new UserObituaryMappingAlreadyExistException();

    public UserObituaryMappingAlreadyExistException() {
        super(ErrorType.USER_OBITUARY_MAPPING_ALREADY_EXIST);
    }
}
