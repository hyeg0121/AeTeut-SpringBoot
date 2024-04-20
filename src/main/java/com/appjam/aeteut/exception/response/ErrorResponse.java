package com.appjam.aeteut.exception.response;


import com.appjam.aeteut.exception.type.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String reasonPhrase;
    private Integer statusCode;
    private String errorMessage;

    public static ErrorResponse of(ErrorType errorType) {
        return new ErrorResponse(errorType.getHttpStatus().getReasonPhrase(), errorType.getHttpStatus().value(), errorType.getErrorMessage());
    }
}
