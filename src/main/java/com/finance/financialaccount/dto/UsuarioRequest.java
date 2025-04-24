package com.finance.financialaccount.dto;

import com.finance.financialaccount.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "O campo nome é obrigatório")
        @Size(min = 3, message = "O valor mínimo aceito é de 3 caracteres")
        String nome,
        @NotBlank(message = "O campo de e-mail não pode estar em branco")
        @Email(message = "O email deve ser válido.")
        String email
) {
    public Usuario toEntity() {
        return new Usuario(nome, email);
    }
}
