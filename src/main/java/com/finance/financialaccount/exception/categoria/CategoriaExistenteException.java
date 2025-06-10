package com.finance.financialaccount.exception.categoria;

public class CategoriaExistenteException extends RuntimeException {
    public final String code;

    public CategoriaExistenteException(String message) {
        super(message);
        this.code = "CATEGORY_ALREADY_EXISTS";
    }

    public String getCode() {
        return code;
    }
}
