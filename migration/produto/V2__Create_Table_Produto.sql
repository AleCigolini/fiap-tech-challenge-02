CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    id_categoria BIGINT NOT NULL,
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
('Hamburguer', 'Pão, queijo, alface, tomate, carne.', 1, 30.00),
('Pizza 4 queijos', 'Queijo muçarela, gorgonzola, parmesão, catupiry.', 2, 50.00),
('Porção de tilápia', '500 gramas de peixe', 3, 40.00);
