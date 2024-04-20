package com.appjam.aeteut.exception;


import com.appjam.aeteut.exception.type.ErrorType;

public class ObituaryNotFoundException extends GloabalException{
    public static GloabalException EXCEPTION = new UserNotFoundException();

    public ObituaryNotFoundException() {
        super(ErrorType.OBITUARY_NOT_FOUND);
    }
}
