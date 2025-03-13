package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.UsuarioRequest;
import com.finance.financialaccount.mapper.UsuarioMapper;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Usuario> create(@Valid @RequestBody UsuarioRequest usuarioRequest) {
            Usuario usuario = UsuarioMapper.toEntity(usuarioRequest);
            Usuario usuarioCriado = usuarioService.create(usuario);

            URI location = URI.create(String.format("/api/usuarios/%s", usuarioCriado.getId()));

            return ResponseEntity.created(location).body(usuarioCriado);
    }
}
