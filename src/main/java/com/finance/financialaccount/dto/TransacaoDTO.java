package com.finance.financialaccount.dto;

import com.finance.financialaccount.enums.MetodoPagamento;
import com.finance.financialaccount.enums.TipoTransacao;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Conta;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoDTO(
    @NotNull
    String descricao,

    @NotNull
    @PositiveOrZero
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    BigDecimal valor,

    @PastOrPresent
    LocalDate data,

    @NotNull
    TipoTransacao tipo,

    @NotNull
    MetodoPagamento metodoPagamento,

    @NotNull
    Categoria categoria,

    @NotNull
    Conta conta
) {}
