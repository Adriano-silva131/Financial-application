package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.TransacaoDTO;
import com.finance.financialaccount.model.Transacao;
import com.finance.financialaccount.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> create(@Valid @RequestBody TransacaoDTO transacaoRequest) {
        Transacao transacao = new Transacao();
        transacao.setDescricao(transacaoRequest.descricao());
        transacao.setValor(transacaoRequest.valor());
        transacao.setConta(transacaoRequest.conta());
        transacao.setData(transacaoRequest.data());
        transacao.setTipo(transacaoRequest.tipo());
        transacao.setCategoria(transacaoRequest.categoria());

        transacaoService.create(transacao);
        return ResponseEntity.ok(transacao);
    }
}
