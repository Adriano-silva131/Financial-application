package com.finance.financialaccount.service;

import com.finance.financialaccount.dto.CategoriaDTO;
import com.finance.financialaccount.dto.CategoriaResponseDTO;
import com.finance.financialaccount.exception.categoria.CategoriaExistenteException;
import com.finance.financialaccount.model.Categoria;
import com.finance.financialaccount.model.Usuario;
import com.finance.financialaccount.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponseDTO create(CategoriaDTO categoriaDTO, Usuario usuario) {
        categoriaRepository.findByNomeIgnoreCaseAndUsuario(categoriaDTO.nome(), usuario)
                .ifPresent(c -> {
                    throw new CategoriaExistenteException("Você já possui uma categoria com o nome '" + categoriaDTO.nome() + "'.");
                });

        Categoria categoria = new Categoria(categoriaDTO.nome(), categoriaDTO.descricao(), usuario);

        categoriaRepository.save(categoria);

        return CategoriaResponseDTO.from(categoria);
    }

    public List<CategoriaResponseDTO> listarPorUsuario(Usuario usuario) {
        return categoriaRepository.findByUsuario(usuario)
                .stream()
                .map(CategoriaResponseDTO::from)
                .toList();
    }

    public CategoriaResponseDTO obterPorIdUsuario(Long id, Usuario usuario) {
        Categoria categoria = categoriaRepository.findByIdAndUsuario(id, usuario)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada ou você não tem permissão para acessá-la"));
        return CategoriaResponseDTO.from(categoria);
    }
}
