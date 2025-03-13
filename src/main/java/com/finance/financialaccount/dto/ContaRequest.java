package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ContaRequest {

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    private BigDecimal saldoConta;
    private BigDecimal saldoCredito;

    @NotNull(message = "O usuario não pode ser nulo")
    private Usuario usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }

    public BigDecimal getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(BigDecimal saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
