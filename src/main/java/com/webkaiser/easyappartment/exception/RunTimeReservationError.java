package com.webkaiser.easyappartment.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * *Developer: ALireza Abolhasani
 * 8/16/2023
 * 8:04 AM
 **/


public class RunTimeReservationError extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;
    private String msg;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RunTimeReservationError (HttpStatus httpStatus , String msg){
        this.httpStatus = httpStatus;
        this.msg = msg;
    }
    public RunTimeReservationError(String msg) {
        super(msg);
    }
}
