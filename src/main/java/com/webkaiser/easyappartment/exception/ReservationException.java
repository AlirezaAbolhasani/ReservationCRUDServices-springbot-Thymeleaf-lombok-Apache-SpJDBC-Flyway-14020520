package com.webkaiser.easyappartment.exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


/**
 * *Developer: ALireza Abolhasani
 * 8/15/2023
 * 5:11 PM
 **/

public class ReservationException extends RuntimeException {
    //private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;
    private String msgError;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

}
