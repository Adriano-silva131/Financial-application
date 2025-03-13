package com.finance.financialaccount.service;

import com.finance.financialaccount.exception.conta.ContaDuplicadaException;
import com.finance.financialaccount.exception.usuario.UsuarioNaoEncontradoException;
import com.finance.financialaccount.model.Conta;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {
    @Autowired
    private final ContaRepository contaRepository;
    private final UsuarioService usuarioService;

    public ContaService(ContaRepository contaRepository, UsuarioService usuarioService) {
        this.contaRepository = contaRepository;
        this.usuarioService = usuarioService;
    }

    @Transactional
    public Conta create(Conta conta) {
        Usuario usuario = usuarioService.findById(conta.getUsuario().getId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com o id: " + conta.getUsuario().getId() + " não foi encontrado"));

        if(contaRepository.existsByNomeAndUsuarioId(conta.getNome(), usuario.getId())) {
            throw new ContaDuplicadaException("Esta conta já está vinculada a este usuário");
        }

        conta.setUsuario(usuario);
        atualizarSaldoConta(conta);
        contaRepository.save(conta);

        return conta;
    }

    private void atualizarSaldoConta(Conta conta) {
        if (conta.getSaldoConta() == null && conta.getSaldoCredito() == null) {
            conta.setSaldoConta(BigDecimal.ZERO);
            conta.setSaldoCredito(BigDecimal.ZERO);
        }
    }
}
