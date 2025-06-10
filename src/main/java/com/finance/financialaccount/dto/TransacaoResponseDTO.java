package com.finance.financialaccount.dto;

public record TransacaoResponseDTO(
    Long id,
    String descricao,
    Double valor,
    String dataTransacao,
    String tipoTransacao,
    String categoriaNome,
    String categoriaDescricao
) {
}
