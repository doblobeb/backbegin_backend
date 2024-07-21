package org.example.backsite.exception;


public class BaseException extends RuntimeException {

    public BaseException(String s) {
        super(s);
    }

    public BaseException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
