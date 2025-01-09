CREATE TABLE produto (
    id UUID PRIMARY KEY DEFAULT GEN_RANDOM_UUID(),
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    id_categoria UUID NOT NULL,
    preco DECIMAL(10,2) NOT NULL DEFAULT 00.00,
    data_criacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    e_ativo BOOL NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_produto_id_categoria_produto FOREIGN KEY (id_categoria) REFERENCES categoria_produto(id)
);

CREATE INDEX ik_produto_nome ON produto(nome);
CREATE INDEX ik_produto_descricao ON produto(descricao);
CREATE INDEX ik_produto_id_categoria ON produto(id_categoria);
CREATE UNIQUE INDEX uk_produto_nao_duplicado ON produto(nome, descricao, id_categoria, preco) WHERE e_ativo;

INSERT INTO produto (nome, descricao, id_categoria, preco) VALUES
('Hamburguer', 'Pão, queijo, alface, tomate, carne.', '4ce30a87-5654-486b-bed6-88c6f83f491a', 30.00),
('Pizza 4 queijos', 'Queijo muçarela, gorgonzola, parmesão, catupiry.', '2ae01e62-6805-4095-9bc3-9b9081517b87', 50.00),
('Porção de tilápia', '500 gramas de peixe', 'e397f412-9c76-4fb5-b029-7c3a99b7e982', 40.00);
