package com.webkaiser.easyappartment.exception;

/**
 * *Developer: ALireza Abolhasani
 * 8/16/2023
 * 8:04 AM
 **/


public class RunTimeReservationError extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RunTimeReservationError(String msg) {
        super(msg);
    }
}
