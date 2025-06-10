package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.CategoriaDTO;
import com.finance.financialaccount.dto.CategoriaResponseDTO;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> create(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaResponseDTO categoriaCriada = categoriaService.create(categoriaDTO);
        URI location = URI.create(String.format("/api/categorias/%s", categoriaCriada.id()));
        return ResponseEntity.created(location).body(categoriaCriada);
    }
}
