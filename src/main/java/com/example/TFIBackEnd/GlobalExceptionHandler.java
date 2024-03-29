package com.example.TFIBackEnd;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errores(Exception exc, WebRequest request){
        logger.error(exc.getMessage());
        return new ResponseEntity<>("Error "+exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
