package com.webkaiser.easyappartment.exception;

/*import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/

import java.util.Date;

/**
 * *Developer: ALireza Abolhasani
 * 8/16/2023
 * 8:11 AM
 **/

/*@Data
@Getter
@Setter
@NoArgsConstructor*/
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

    public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }
    public ErrorMessage(){}

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
