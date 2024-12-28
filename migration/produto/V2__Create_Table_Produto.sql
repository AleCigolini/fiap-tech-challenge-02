CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    descricao TEXT NOT NULL,
    data_criacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    e_ativo BOOL NOT NULL DEFAULT TRUE
);

CREATE INDEX ik_produto_nome ON produto(nome);
CREATE INDEX ik_produto_descricao ON produto(descricao);

INSERT INTO produto (nome, descricao) VALUES
('Hamburguer', 'Pão, queijo, alface, tomate, carne.'),
('Pizza 4 queijos', 'Queijo muçarela, gorgonzola, parmesão, catupiry.'),
('Porção de tilápia', '500 gramas de peixe');
