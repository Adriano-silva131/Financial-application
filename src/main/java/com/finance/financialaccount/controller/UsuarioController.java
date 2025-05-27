package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.NewUsuarioDTO;
import com.finance.financialaccount.dto.UsuarioDTO;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<NewUsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuarioDTO) {
            Usuario usuarioCriado = usuarioService.create(usuarioDTO.toEntity());
            URI location = URI.create(String.format("/api/usuarios/%s", usuarioCriado.getId()));
            return ResponseEntity.created(location).body(new NewUsuarioDTO(usuarioCriado.getNome(), usuarioCriado.getEmail()));
    }
}
