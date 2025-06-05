package com.finance.financialaccount.service;

import com.finance.financialaccount.dto.ContaDTO;
import com.finance.financialaccount.dto.ContaResponseDTO;
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
    public ContaResponseDTO create(ContaDTO contaDTO) {

        Usuario usuario = getByIdOrThrow(contaDTO.usuarioID());

        contaRepository.findByNomeAndUsuarioId(contaDTO.nome(), usuario.getId())
                .ifPresent(c -> {throw new ContaDuplicadaException("Esta conta já está vinculada a este usuário");});

        Conta conta = new Conta(usuario, contaDTO.nome());
        contaRepository.save(conta);

        return ContaResponseDTO.from(conta);
    }

    private Usuario getByIdOrThrow(Long id) {
        return usuarioService.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com o id: " + id + " não foi encontrado"));
    }
}
