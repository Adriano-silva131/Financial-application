package com.finance.financialaccount.exception.conta;

public class ContaNaoEncontradaException extends RuntimeException {
    public final String code;

    public ContaNaoEncontradaException(String message) {
        super(message);
        this.code = "ACCOUNT_NOT_FOUND";
    }

    public String getCode() {
        return code;
    }
}
