package com.webkaiser.easyappartment.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * *Developer: ALireza Abolhasani
 * 8/15/2023
 * 6:32 PM
 **/

@Data
public class EntityError {
    private HttpStatus status;
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
    private Date timestamp;

    public EntityError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
