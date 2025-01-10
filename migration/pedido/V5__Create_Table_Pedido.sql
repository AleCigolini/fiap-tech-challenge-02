-- Criação da tabela pedido
CREATE TABLE pedido (
    id UUID PRIMARY KEY DEFAULT GEN_RANDOM_UUID(),
    codigo VARCHAR(5) NOT NULL,
    status TEXT NOT NULL,
    preco DECIMAL(10,2) NOT NULL DEFAULT 00.00,
    id_pagamento UUID NULL,
    data_criacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    e_ativo BOOL NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_pedido_id_pagamento FOREIGN KEY (id_pagamento) REFERENCES pagamento(id)
);
CREATE INDEX ik_pedido_status ON pedido(status);

-- Criação da tabela produto_pedido
CREATE TABLE produto_pedido (
    id UUID PRIMARY KEY DEFAULT GEN_RANDOM_UUID(),
    observacao VARCHAR(255) NULL,
    id_pedido UUID NOT NULL,
    id_produto UUID NOT NULL,
    data_criacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    e_ativo BOOL NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_produto_pedido_id_pedido FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    CONSTRAINT fk_produto_pedido_id_produto FOREIGN KEY (id_produto) REFERENCES produto(id)
);

-- Inserção de produtos para pedidos na tabela produto
INSERT INTO produto
    (id, nome, descricao, id_categoria, preco)
VALUES
    ('e389406d-5531-4acf-a354-be5cc46a8ca1', 'Hamburguer', 'Pão, queijo, alface, tomate, carne.', '4ce30a87-5654-486b-bed6-88c6f83f491a', 25.00),
    ('e389406d-5531-4acf-a354-be5cc46a8ca2', 'Pizza 4 queijos', 'Queijo muçarela, gorgonzola, parmesão, catupiry.', '2ae01e62-6805-4095-9bc3-9b9081517b87', 45.00),
    ('e389406d-5531-4acf-a354-be5cc46a8ca3', 'Porção de tilápia', '500 gramas de peixe', 'e397f412-9c76-4fb5-b029-7c3a99b7e982', 35.00);

-- Inserção de pedido na tabela pedido
INSERT INTO pedido
(id, codigo, status, preco)
VALUES
    ('e389406d-5531-4acf-a354-be5cc46a8cb1', '00001', 'ABERTO', 100.00),
    ('e389406d-5531-4acf-a354-be5cc46a8cb2', '00002', 'EM_ANDAMENTO', 110.00),
    ('e389406d-5531-4acf-a354-be5cc46a8cb3', '00003', 'CANCELADO', 120.00);

-- Inserção de produtos no pedido na tabela produto_pedido
INSERT INTO produto_pedido
(id, observacao, id_pedido, id_produto)
VALUES
   ('e389406d-5531-4acf-a354-be5cc46a8cc1', 'Mal passado', 'e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc2', 'Bem passado', 'e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc3', 'Bem gelado', 'e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca3'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc4', 'Mal passado', 'e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc5', 'Bem passado', 'e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc6', 'Bem gelado', 'e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca3'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc7', 'Mal passado', 'e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc8', 'Bem passado', 'e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
   ('e389406d-5531-4acf-a354-be5cc46a8cc9', 'Bem gelado', 'e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca3');