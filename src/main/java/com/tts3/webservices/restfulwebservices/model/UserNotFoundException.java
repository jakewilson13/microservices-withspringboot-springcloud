package com.tts3.webservices.restfulwebservices.model;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//response status allows us to add a http response status
// when the information is trying to be requested
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    //user not found exception which is being thrown in retrieve user
    //calling the super class "Runtime Exception"
    //passing in a message as an input that is a string
    public UserNotFoundException(String message) {
        super(message);
    }
}
