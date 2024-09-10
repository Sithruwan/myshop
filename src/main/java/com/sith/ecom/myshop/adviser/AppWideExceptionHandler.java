package com.sith.ecom.myshop.adviser;

import com.sith.ecom.myshop.exception.EntryNotFoundException;
import com.sith.ecom.myshop.utill.StandardResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponce> handleEntryNotFoundException(Exception e) {

        return new ResponseEntity<>(
                new StandardResponce(404,e.getMessage(),e),
                HttpStatus.NOT_FOUND
        );

    }
}
