package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Transacao;

import java.math.BigDecimal;

public record TransacaoResponseDTO(
    Long id,
    String descricao,
    BigDecimal valor,
    String dataTransacao,
    String tipoTransacao,
    String categoriaNome,
    String categoriaDescricao
) {
    public static TransacaoResponseDTO from(Transacao transacao) {
        return new TransacaoResponseDTO(
                transacao.getId(),
                transacao.getDescricao(),
                transacao.getValor(),
                transacao.getData().toString(),
                transacao.getTipo().getDescricao(),
                transacao.getCategoria().getNome(),
                transacao.getCategoria().getDescricao());
    }
}
