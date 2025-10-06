package com.finance.financialaccount.service;

import com.finance.financialaccount.dto.TransacaoDTO;
import com.finance.financialaccount.dto.TransacaoResponseDTO;
import com.finance.financialaccount.enums.MetodoPagamento;
import com.finance.financialaccount.enums.TipoTransacao;
import com.finance.financialaccount.exception.categoria.CategoriaExistenteException;
import com.finance.financialaccount.exception.conta.ContaNaoEncontradaException;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.model.Transacao;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.repository.CategoriaRepository;
import com.finance.financialaccount.repository.ContaRepository;
import com.finance.financialaccount.repository.TransacaoRepository;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

    @Transactional
    public TransacaoResponseDTO create(TransacaoDTO transacaoDTO, Usuario usuario) {
        try {
            Categoria categoria = categoriaRepository.findByIdAndUsuario(transacaoDTO.categoriaId(), usuario)
                    .orElseThrow(() -> new CategoriaExistenteException("Categoria não encontrada ou você não tem permissão para usá-la"));

            Conta conta = contaRepository.findByIdAndUsuarioId(transacaoDTO.contaId(), usuario.getId())
                    .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada ou você não tem permissão para usá-la"));

            Transacao transacao = new Transacao(
                    transacaoDTO.descricao(),
                    transacaoDTO.valor(),
                    transacaoDTO.data(),
                    transacaoDTO.tipo(),
                    transacaoDTO.metodoPagamento(),
                    categoria,
                    conta
            );

            atualizarSaldoConta(conta, transacaoDTO.valor(), transacaoDTO.tipo(), transacaoDTO.metodoPagamento());

            contaRepository.save(conta);
            transacaoRepository.save(transacao);

            return TransacaoResponseDTO.from(transacao);

        } catch (OptimisticLockException e) {
            throw new RuntimeException("A conta foi modificada por outra transação simultânea. Por favor, tente novamente.");
        }
    }

    private void atualizarSaldoConta(Conta conta, BigDecimal valor, TipoTransacao tipo, MetodoPagamento metodoPagamento) {
        if (tipo == TipoTransacao.RECEITA) {
            conta.setSaldoConta(conta.getSaldoConta().add(valor));
        } else if (tipo == TipoTransacao.DESPESA) {
            if (metodoPagamento == MetodoPagamento.CARTAO_CREDITO) {
                conta.setSaldoCredito(conta.getSaldoCredito().subtract(valor));
            } else {
                conta.setSaldoConta(conta.getSaldoConta().subtract(valor));
            }
        }
    }
}
