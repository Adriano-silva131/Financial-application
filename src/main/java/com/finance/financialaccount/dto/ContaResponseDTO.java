package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Conta;

import java.math.BigDecimal;

public record ContaResponseDTO(Long id, String nome, BigDecimal saldoConta, BigDecimal saldoCredito, Long usuarioID) {

    public static ContaResponseDTO from(Conta conta) {
        return new ContaResponseDTO(
                conta.getId(),
                conta.getNome(),
                conta.getSaldoConta(),
                conta.getSaldoCredito(),
                conta.getUsuario().getId()
        );
    }

}
