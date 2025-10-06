package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Categoria;

public record CategoriaResponseDTO(Long id,String nome, String descricao) {
    public static CategoriaResponseDTO from(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }
}