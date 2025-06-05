package com.finance.financialaccount.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoriaDTO(
    @NotBlank
    @Size(min = 5, max = 50, message = "O valor mínimo é de 5 caracteres e o máximo é de 50")
    String nome,

    @NotBlank
    @Size(min = 5, max = 50, message = "O valor mínimo é de 5 caracteres e o máximo é de 200")
    String descricao
) {}
