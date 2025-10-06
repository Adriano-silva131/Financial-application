package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.TransacaoDTO;
import com.finance.financialaccount.dto.TransacaoResponseDTO;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> create(@Valid @RequestBody TransacaoDTO transacaoDTO, @AuthenticationPrincipal Usuario usuario) {
        TransacaoResponseDTO transacao = transacaoService.create(transacaoDTO, usuario);
        URI location = URI.create(String.format("/api/transacoes/%s", transacao.id()));
        return ResponseEntity.created(location).body(transacao);
    }
}
