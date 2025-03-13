package com.finance.financialaccount.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank(message = "O campo nome é obrigatório")
    @Size(min = 3, message = "O valor mínimo aceito é de 3 caracteres")
    private String nome;

    @NotBlank(message = "O campo de e-mail não pode estar em branco")
    @Email(message = "O email deve ser válido.")
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
