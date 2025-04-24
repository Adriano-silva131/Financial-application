create table usuarios (
    id BIGINT auto_increment primary key,
    nome  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL
)