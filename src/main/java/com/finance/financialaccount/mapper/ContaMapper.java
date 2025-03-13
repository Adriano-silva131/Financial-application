package com.finance.financialaccount.mapper;

import com.finance.financialaccount.dto.ContaRequest;
import com.finance.financialaccount.model.Conta;

public class ContaMapper {
    public static Conta toEntity(ContaRequest contaRequest) {
        Conta conta = new Conta();
        conta.setNome(contaRequest.getNome());
        conta.setNome(contaRequest.getNome());
        conta.setSaldoConta(contaRequest.getSaldoConta());
        conta.setSaldoCredito(contaRequest.getSaldoCredito());
        conta.setUsuario(contaRequest.getUsuario());
        return conta;
    }
}
