package com.appjam.aeteut.exception;

import com.appjam.aeteut.exception.type.ErrorType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GloabalException extends RuntimeException{
    private final ErrorType errorType;
}