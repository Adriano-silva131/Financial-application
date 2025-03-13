package com.finance.financialaccount.exception.usuario;

public class UsuarioNaoEncontradoException extends RuntimeException {
    private final String code;

    public UsuarioNaoEncontradoException(String message) {
        super(message);
        this.code = "NOT_FOUND_USER";
    }

    public String getCode() {
        return code;
    }
}
