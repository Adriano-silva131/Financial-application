package com.finance.financialaccount.service;

import com.finance.financialaccount.exception.usuario.UsuarioDuplicadoException;
import com.finance.financialaccount.exception.usuario.UsuarioNaoEncontradoException;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario create(Usuario usuario) {
        if(usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new UsuarioDuplicadoException("Usuário com este e-mail já encontrado no sistema");
        }
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
}
