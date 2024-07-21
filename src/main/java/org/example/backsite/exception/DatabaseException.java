package org.example.backsite.exception;

import org.example.backsite.exception.BaseException;
import org.example.backsite.exception.handler.ApiErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = ApiErrorMessages.INTERNAL_SERVER_ERROR)
public class DatabaseException extends BaseException {

    public DatabaseException() {
        this(ApiErrorMessages.INTERNAL_SERVER_ERROR);
    }

    public DatabaseException(String s) {
        super(s);
    }
}
