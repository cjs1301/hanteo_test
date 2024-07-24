package org.example.hanteo.config;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        final ErrorResponse res = ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR,"internal server error"/*ex.getMessage()*/);
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
        final ErrorResponse res = ErrorResponse.create(ex, HttpStatus.NOT_FOUND,"해당 요청을 찾을 수 없습니다.");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
