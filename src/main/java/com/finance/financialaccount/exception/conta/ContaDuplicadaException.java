package com.finance.financialaccount.exception.conta;

public class ContaDuplicadaException extends RuntimeException {
    public final String code;

    public ContaDuplicadaException(String message) {
        super(message);
        this.code = "DUPLICATE_ACCOUNT_USER";
    }

    public String getCode() {
        return code;
    }
}
