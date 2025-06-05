package com.finance.financialaccount.repository;

import com.finance.financialaccount.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByNomeAndUsuarioId(String nome, Long usuarioId);
}
