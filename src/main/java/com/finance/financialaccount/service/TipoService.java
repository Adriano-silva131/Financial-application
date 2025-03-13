package com.finance.financialaccount.service;

import com.finance.financialaccount.model.Tipo;
import com.finance.financialaccount.repository.TipoRepository;
import com.finance.financialaccount.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService {
    @Autowired
    private final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Transactional
    public Tipo create(Tipo tipo) {
        tipoRepository.save(tipo);
        return tipo;
    }
}
