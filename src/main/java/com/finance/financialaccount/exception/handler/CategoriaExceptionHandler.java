package com.finance.financialaccount.exception.handler;

import com.finance.financialaccount.exception.categoria.CategoriaExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.finance.financialaccount.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CategoriaExceptionHandler {

    @ExceptionHandler(CategoriaExistenteException.class)
    public ResponseEntity<ErrorResponse> handlerCategoriaExistenteException(CategoriaExistenteException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
