package org.example.backsite.exception;

import org.example.backsite.exception.BaseException;
import org.example.backsite.exception.handler.ApiErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = ApiErrorMessages.NOT_FOUND)
public class CustomNotFoundException extends BaseException {

    public CustomNotFoundException() {
        this(ApiErrorMessages.NOT_FOUND);
    }

    public CustomNotFoundException(String s) {
        super(s);
    }

}
