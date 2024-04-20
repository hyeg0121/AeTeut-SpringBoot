package com.appjam.aeteut.exception;


import com.appjam.aeteut.exception.type.ErrorType;

public class UserNotFoundException extends GloabalException{
    public static GloabalException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(ErrorType.USER_NOT_FOUND);
    }
}
