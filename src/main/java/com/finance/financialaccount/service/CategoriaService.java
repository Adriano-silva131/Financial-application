package com.finance.financialaccount.service;

import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria create(Categoria categoria) {
        categoriaRepository.save(categoria);
        return categoria;
    }
}
