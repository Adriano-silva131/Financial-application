package com.finance.financialaccount.service;

import com.finance.financialaccount.dto.CategoriaDTO;
import com.finance.financialaccount.dto.CategoriaResponseDTO;
import com.finance.financialaccount.exception.categoria.CategoriaExistenteException;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponseDTO create(CategoriaDTO categoriaDTO) {
        categoriaRepository.findByNomeIgnoreCase(categoriaDTO.nome())
                .ifPresent(c -> {
                    throw new CategoriaExistenteException("Categoria com o nome '" + categoriaDTO.nome() + "' já existe.");
                });

        Categoria categoria = new Categoria(categoriaDTO.nome(), categoriaDTO.descricao());

        categoriaRepository.save(categoria);

        return CategoriaResponseDTO.from(categoria);
    }
}
