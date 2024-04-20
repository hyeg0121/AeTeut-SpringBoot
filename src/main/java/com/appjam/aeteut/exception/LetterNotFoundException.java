package com.appjam.aeteut.exception;

import com.appjam.aeteut.exception.type.ErrorType;

public class LetterNotFoundException extends GloabalException{
    public static GloabalException EXCEPTION = new LetterNotFoundException();

    public LetterNotFoundException() {
        super(ErrorType.USER_NOT_FOUND);
    }
}