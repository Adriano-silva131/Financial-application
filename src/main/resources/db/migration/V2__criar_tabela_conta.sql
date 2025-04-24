create table contas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_conta varchar(255) not null,
    saldo_conta DECIMAL(19,2),
    saldo_credito DECIMAL(19,2),
    usuario_id BIGINT,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);