package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.TipoRequest;
import com.finance.financialaccount.model.Tipo;
import com.finance.financialaccount.service.TipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipos")
public class TipoController {
    @Autowired
    private TipoService tipoService;

    @PostMapping
    public ResponseEntity<Tipo> create (@Valid @RequestBody TipoRequest tipoRequest) {
        Tipo tipo = new Tipo();
        tipo.setNome(tipoRequest.getNome());
        tipo.setDescricao(tipoRequest.getDescricao());
        Tipo tipoCriado = tipoService.create(tipo);

        return ResponseEntity.ok(tipoCriado);
    }
}
