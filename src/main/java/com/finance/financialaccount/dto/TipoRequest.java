package com.finance.financialaccount.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TipoRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 5, message = "O valor minimo para o nome é de 5 caracteres")
    private String nome;

    @NotBlank
    @Size(max = 200, message = "o valor máximo para a descrição é de 200 caracteres")
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
