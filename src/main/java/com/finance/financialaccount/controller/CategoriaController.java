package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.CategoriaDTO;
import com.finance.financialaccount.dto.CategoriaResponseDTO;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> create(@Valid @RequestBody CategoriaDTO categoriaDTO, @AuthenticationPrincipal Usuario usuario) {
        CategoriaResponseDTO categoriaCriada = categoriaService.create(categoriaDTO, usuario);
        URI location = URI.create(String.format("/api/categorias/%s", categoriaCriada.id()));
        return ResponseEntity.created(location).body(categoriaCriada);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAll(@AuthenticationPrincipal Usuario usuario) {
        List<CategoriaResponseDTO> categorias = categoriaService.listarPorUsuario(usuario);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> findById(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        CategoriaResponseDTO categoria = categoriaService.obterPorIdUsuario(id, usuario);
        return ResponseEntity.ok(categoria);
    }
}
