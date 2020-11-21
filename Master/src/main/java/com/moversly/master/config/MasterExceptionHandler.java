package com.moversly.master.config;

import com.moversly.master.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MasterExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                "status",
                "date",
                ex.getMessage(),
                "description");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
}

@Data
class ErrorMessage {
    String status;
    String date;
    String message;
    String description;

    public ErrorMessage(String status, String date, String message, String description) {
    }
}