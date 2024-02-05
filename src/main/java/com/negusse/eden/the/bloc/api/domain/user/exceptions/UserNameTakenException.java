package com.negusse.eden.the.bloc.api.domain.user.exceptions;

public class UserNameTakenException extends RuntimeException{
    public UserNameTakenException(String message) {
        super(message);
    }
}
