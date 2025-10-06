package com.finance.financialaccount.exception.usuario;

public class UsuarioDuplicadoException extends RuntimeException {
    private final String code;

    public UsuarioDuplicadoException(String message) {
        super(message);
        this.code = "USER_ERROR";
    }

    public String getCode() {
        return code;
    }
}
