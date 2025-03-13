package com.finance.financialaccount.service;

import com.finance.financialaccount.dto.TransacaoRequest;
import com.finance.financialaccount.model.Transacao;
import com.finance.financialaccount.repository.TransacaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao create(Transacao transacao) {
        transacaoRepository.save(transacao);
        return transacao;
    }
}
