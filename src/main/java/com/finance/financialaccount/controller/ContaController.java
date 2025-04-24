package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.ContaRequest;
import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    @Autowired
    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ContaRequest contaRequest) {
            Conta contaSalva = contaService.create(contaRequest.toEntity());
            URI location = URI.create(String.format("/api/contas/%s", contaSalva.getId()));
            return ResponseEntity.created(location).body(contaSalva);
    }
}
