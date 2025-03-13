package com.finance.financialaccount.exception.usuario;

public class UsuarioDuplicadoException extends RuntimeException {
    private final String code;

    public UsuarioDuplicadoException(String message) {
        super(message);
        this.code = "DUPLICATE_USER";
    }

    public String getCode() {
        return code;
    }
}
