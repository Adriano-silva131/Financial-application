package com.finance.financialaccount.service;

import com.finance.financialaccount.dto.TransacaoDTO;
import com.finance.financialaccount.dto.TransacaoResponseDTO;
import com.finance.financialaccount.exception.categoria.CategoriaExistenteException;
import com.finance.financialaccount.exception.conta.ContaNaoEncontradaException;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.model.Transacao;
import com.finance.financialaccount.repository.CategoriaRepository;
import com.finance.financialaccount.repository.ContaRepository;
import com.finance.financialaccount.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private TransacaoRepository transacaoRepository;
    private CategoriaRepository categoriaRepository;
    private ContaRepository contaRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository, CategoriaRepository categoriaRepository, ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
        this.contaRepository = contaRepository;
    }

    public TransacaoResponseDTO create(TransacaoDTO transacaoDTO) {
        Categoria categoria = categoriaRepository.findById(transacaoDTO.categoriaId())
                .orElseThrow(() -> new CategoriaExistenteException("Categoria não encontrada com o ID: " + transacaoDTO.categoriaId()));

        Conta conta = contaRepository.findById(transacaoDTO.contaId())
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada com o ID: " + transacaoDTO.contaId()));

        Transacao transacao = new Transacao(
                transacaoDTO.descricao(),
                transacaoDTO.valor(),
                transacaoDTO.data(),
                transacaoDTO.tipo(),
                transacaoDTO.metodoPagamento(),
                categoria,
                conta
        );

        transacaoRepository.save(transacao);
        return TransacaoResponseDTO.from(transacao);
    }
}
