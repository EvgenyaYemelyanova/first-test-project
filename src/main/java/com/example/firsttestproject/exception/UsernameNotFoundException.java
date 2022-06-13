package com.example.firsttestproject.exception;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String msg) {
        super(msg);
    }
}
