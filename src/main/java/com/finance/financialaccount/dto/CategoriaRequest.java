package com.finance.financialaccount.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaRequest {
    @NotBlank
    @Size(min = 5, max = 50, message = "O valor mínimo é de 5 caracteres e o máximo é de 50")
    private String nome;

    @NotBlank
    @Size(min = 5, max = 50, message = "O valor mínimo é de 5 caracteres e o máximo é de 200")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
