package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ContaDTO(
        @NotBlank(message = "O campo nome é obrigatório.") String nome,
        @PositiveOrZero(message = "Saldo da conta deve ser ≥ 0") BigDecimal saldoConta,
        @PositiveOrZero(message = "Saldo de crédito deve ser ≥ 0") BigDecimal saldoCredito,
        @NotNull(message = "O usuário não pode ser nulo.") Long usuarioID) {
}
