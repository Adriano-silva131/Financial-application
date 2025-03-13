package com.finance.financialaccount.mapper;

import com.finance.financialaccount.dto.UsuarioRequest;
import com.finance.financialaccount.model.Usuario;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        return usuario;
    }
}
