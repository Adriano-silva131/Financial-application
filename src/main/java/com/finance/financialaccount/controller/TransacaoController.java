package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.CategoriaResponseDTO;
import com.finance.financialaccount.dto.TransacaoDTO;
import com.finance.financialaccount.dto.TransacaoResponseDTO;
import com.finance.financialaccount.model.Transacao;
import com.finance.financialaccount.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> create(@Valid @RequestBody TransacaoDTO transacaoDTO) {
        TransacaoResponseDTO transacao = transacaoService.create(transacaoDTO);
        URI location = URI.create(String.format("/api/transacoes/%s", transacao.id()));
        return ResponseEntity.created(location).body(transacao);
    }
}
