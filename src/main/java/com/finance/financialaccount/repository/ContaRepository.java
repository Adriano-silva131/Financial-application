package com.finance.financialaccount.repository;

import com.finance.financialaccount.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsByNomeAndUsuarioId(String nome, Long usuarioId);
}
