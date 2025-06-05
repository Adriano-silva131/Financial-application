package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.CategoriaDTO;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.nome());
        categoria.setDescricao(categoriaDTO.descricao());

        Categoria categoriaCriada = categoriaService.create(categoria);

        return ResponseEntity.ok(categoriaCriada);

    }
}
