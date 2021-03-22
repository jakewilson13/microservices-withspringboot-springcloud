package com.tts3.webservices.restfulwebservices.exception;


import com.tts3.webservices.restfulwebservices.model.UserNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

//we want this to be defined in all of the controllers
//want to define it as a rest controller because it is providing a response back
//ControllerAdvice allows this to be accessed across all of the other spring controllers
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    //defualt method within the ResponseEntityExceptionHandler class
    //have to implement it in order to override it's implementation
    //exception handler will just handle any exception that is going to be thrown
    //inferring all types of exceptions by using (Exception.class)
    @ExceptionHandler(Exception.class)
     public final ResponseEntity<Object> handleAllExceptions
    (Exception ex, WebRequest request) {
        ExceptionDetails exceptionResponse =
                new ExceptionDetails(new Date(), ex.getMessage(),
                        request.getDescription(false));
       return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //wanting this to handle the specific exception "usernotfound" which we created
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException
            (UserNotFoundException ex, WebRequest request) {
        ExceptionDetails exceptionResponse =
                new ExceptionDetails(new Date(), ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ExceptionDetails exceptionResponse =
                new ExceptionDetails(new Date(), "Validation Failed",
                        ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
