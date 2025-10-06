package com.finance.financialaccount.repository;

import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNomeIgnoreCase(String nome);
    Optional<Categoria> findByNomeIgnoreCaseAndUsuario(String nome, Usuario usuario);

    List<Categoria> findByUsuario(Usuario usuario);
    Optional<Categoria> findByIdAndUsuario(Long id, Usuario usuario);
}
