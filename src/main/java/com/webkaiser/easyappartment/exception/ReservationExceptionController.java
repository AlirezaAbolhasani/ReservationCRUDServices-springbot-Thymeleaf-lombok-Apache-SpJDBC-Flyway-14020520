package com.webkaiser.easyappartment.exception;

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
    public ResponseEntity<EntityError> exception(ReservationException exception) {
        ReservationException a = (ReservationException) exception;
        EntityError businessError = new EntityError(a.getHttpStatus(), a.getMsgError());
        return new ResponseEntity<>(businessError, a.getHttpStatus());
    }

}
