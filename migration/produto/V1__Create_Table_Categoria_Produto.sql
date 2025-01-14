-- Criação da tabela categoria_produto
CREATE TABLE categoria_produto
(
    id               UUID PRIMARY KEY DEFAULT GEN_RANDOM_UUID(),
    nome             VARCHAR(50)             NOT NULL,
    data_criacao     TIMESTAMP DEFAULT NOW() NOT NULL,
    data_atualizacao TIMESTAMP DEFAULT NOW() NOT NULL,
    e_ativo          BOOLEAN   DEFAULT TRUE  NOT NULL
);

CREATE UNIQUE INDEX uk_categoria_produto_nome ON categoria_produto(nome) WHERE e_ativo;

-- Inserção de categorias na tabela categoria_produto
INSERT INTO categoria_produto (id, nome)
VALUES ('4ce30a87-5654-486b-bed6-88c6f83f491a', 'Acompanhamento'),
       ('2ae01e62-6805-4095-9bc3-9b9081517b87', 'Lanche'),
       ('e397f412-9c76-4fb5-b029-7c3a99b7e982', 'Bebida'),
       ('d5b5a378-3862-4436-bdcc-29d8c8a2ee65', 'Sobremesa');