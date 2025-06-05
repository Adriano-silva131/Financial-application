package com.finance.financialaccount.service;

import com.finance.financialaccount.model.Transacao;
import com.finance.financialaccount.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao create(Transacao transacao) {
        transacaoRepository.save(transacao);
        return transacao;
    }
}
