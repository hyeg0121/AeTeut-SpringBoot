package com.appjam.aeteut.exception.handler;

import com.appjam.aeteut.exception.LetterNotFoundException;
import com.appjam.aeteut.exception.ObituaryNotFoundException;
import com.appjam.aeteut.exception.UserNotFoundException;
import com.appjam.aeteut.exception.UserObituaryMappingAlreadyExistException;
import com.appjam.aeteut.exception.response.ErrorResponse;
import com.appjam.aeteut.exception.type.ErrorType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(e.getErrorType().getHttpStatus())
                .body(ErrorResponse.of(ErrorType.USER_NOT_FOUND));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleObituaryNotFoundException(ObituaryNotFoundException e) {
        return ResponseEntity.status(e.getErrorType().getHttpStatus())
                .body(ErrorResponse.of(ErrorType.OBITUARY_NOT_FOUND));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleLetterNotFoundException(LetterNotFoundException e) {
        return ResponseEntity.status(e.getErrorType().getHttpStatus())
                .body(ErrorResponse.of(ErrorType.LETTER_NOT_FOUND));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserObituaryMappingAlreadyExistException(UserObituaryMappingAlreadyExistException e) {
        return ResponseEntity.status(e.getErrorType().getHttpStatus())
                .body(ErrorResponse.of(ErrorType.USER_OBITUARY_MAPPING_ALREADY_EXIST));
    }

}
