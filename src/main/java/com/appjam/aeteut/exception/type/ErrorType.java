package com.appjam.aeteut.exception.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다."),
    OBITUARY_NOT_FOUND(HttpStatus.NOT_FOUND, "부고장이 존재하지 않습니다."),
    LETTER_NOT_FOUND(HttpStatus.NOT_FOUND, "애도 편지가 존재하지 않습니다."),
    USER_OBITUARY_MAPPING_ALREADY_EXIST(HttpStatus.CONFLICT, "이미 저장된 부고장입니다.");
    private final HttpStatus httpStatus;
    private final String errorMessage;
}

