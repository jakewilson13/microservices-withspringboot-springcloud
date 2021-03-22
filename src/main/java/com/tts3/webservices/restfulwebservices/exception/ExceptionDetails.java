package com.tts3.webservices.restfulwebservices.exception;


import java.util.Date;

//creating a basic structure of exceptions
//structure is important because we are creating a java service

public class ExceptionDetails {
    //timestamp
    //message
    //detail

    //whenever we get a response back we want it in this specific format
    private Date timestamp;
    private String message;
    private String details;


    public ExceptionDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ExceptionDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
