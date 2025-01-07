-- Criação da tabela categoria_produto
CREATE TABLE categoria_produto
(
    id               SERIAL PRIMARY KEY,
    nome             VARCHAR(50)             NOT NULL,
    data_criacao     TIMESTAMP DEFAULT NOW() NOT NULL,
    data_atualizacao TIMESTAMP DEFAULT NOW() NOT NULL,
    e_ativo          BOOLEAN   DEFAULT TRUE  NOT NULL
);

-- Inserção de categorias na tabela categoria_produto
INSERT INTO categoria_produto (nome)
VALUES ('Acompanhamento'),
       ('Lanche'),
       ('Bebida'),
       ('Sobremesa');