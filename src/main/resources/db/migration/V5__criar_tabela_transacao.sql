CREATE TABLE transacoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(19,2) NOT NULL,
    data_transacao date,
    tipo_id BIGINT NOT NULL,
    categoria_id BIGINT NOT NULL,
    conta_id BIGINT NOT NULL,
    CONSTRAINT fk_tipo FOREIGN KEY (tipo_id) REFERENCES tipos(id),
    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id),
    CONSTRAINT fk_conta FOREIGN KEY (conta_id) REFERENCES contas(id)
);