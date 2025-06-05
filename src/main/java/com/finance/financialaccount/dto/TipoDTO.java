package com.finance.financialaccount.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoDTO(@NotBlank(message = "O nome é obrigatório") @Size(min = 5, message = "O valor minimo para o nome é de 5 caracteres") String nome, @NotBlank @Size(max = 200, message = "o valor máximo para a descrição é de 200 caracteres") String descricao){}
