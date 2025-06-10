package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.ContaDTO;
import com.finance.financialaccount.dto.ContaResponseDTO;
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
    public ResponseEntity<ContaResponseDTO> create(@Valid @RequestBody ContaDTO contaDTO) {
            ContaResponseDTO contaSalva = contaService.create(contaDTO);
            URI location = URI.create(String.format("/api/contas/%s", contaSalva.id()));
            return ResponseEntity.created(location).body(contaSalva);
    }
}
