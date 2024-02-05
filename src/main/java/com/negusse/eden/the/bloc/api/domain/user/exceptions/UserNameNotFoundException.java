package com.negusse.eden.the.bloc.api.domain.user.exceptions;

public class UserNameNotFoundException extends RuntimeException{
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
