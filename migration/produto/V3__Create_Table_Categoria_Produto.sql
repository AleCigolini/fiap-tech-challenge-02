-- Criação da tabela categoria_produto
CREATE TABLE categoria_produto
(
    id               BIGSERIAL PRIMARY KEY,
    nome             VARCHAR(50)             NOT NULL,
    data_criacao     TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    e_ativo          BOOLEAN NOT NULL DEFAULT TRUE
);

-- Inserção de categorias na tabela categoria_produto
INSERT INTO categoria_produto (nome)
VALUES ('Acompanhamento'),
       ('Lanche'),
       ('Bebida'),
       ('Sobremesa');