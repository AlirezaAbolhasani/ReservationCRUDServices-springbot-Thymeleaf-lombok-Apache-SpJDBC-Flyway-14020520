package com.webkaiser.easyappartment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * *Developer: ALireza Abolhasani
 * 8/15/2023
 * 5:10 PM
 **/

@ControllerAdvice
public class ReservationExceptionController {

    @ExceptionHandler(value = ReservationException.class)

    public ResponseEntity<Object> exception(ReservationException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
