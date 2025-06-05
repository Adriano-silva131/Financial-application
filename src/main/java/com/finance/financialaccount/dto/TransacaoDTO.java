package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.model.Tipo;
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
    Tipo tipo,

    @NotNull
    Categoria categoria,

    @NotNull
    Conta conta
) {}
