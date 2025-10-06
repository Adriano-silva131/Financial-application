package com.finance.financialaccount.enums;

public enum TipoTransacao {
    RECEITA("Receita"),
    DESPESA("Despesa"),
    TRANSFERENCIA("Transferência"),
    INVESTIMENTO("Investimento"),
    PAGAMENTO_PIX("Pagamento PIX"),
    CARTAO_CREDITO("Cartão de Crédito");

    private final String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
