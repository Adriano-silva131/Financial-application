package com.finance.financialaccount.exception.handler;

import com.finance.financialaccount.exception.ErrorResponse;
import com.finance.financialaccount.exception.conta.ContaDuplicadaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContaExceptionHandler {

    @ExceptionHandler(ContaDuplicadaException.class)
    public ResponseEntity<ErrorResponse> handlerContaDuplicadaException(ContaDuplicadaException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
