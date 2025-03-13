package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.model.Tipo;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoRequest {

    private String descricao;

    @NotNull
    @PositiveOrZero
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "999999999.99", inclusive = true)
    private BigDecimal valor;

    @PastOrPresent
    private LocalDate data;

    @NotNull
    private Tipo tipo;

    @NotNull
    private Categoria categoria;

    @NotNull
    private Conta conta;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
