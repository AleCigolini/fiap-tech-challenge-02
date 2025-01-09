-- >>>>>>>>>>>> ROLLBACK

-- ALTER TABLE pedido
--     DROP CONSTRAINT fk_pedido_id_pedido_produto;
-- drop table pedido_produto;
-- drop table pedido;

-- >>>>>>>>>>>> INICIO

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

CREATE TABLE pedido_produto (
    id_pedido UUID NOT NULL,
    id_produto UUID NOT NULL,
    PRIMARY KEY (id_pedido, id_produto),
    CONSTRAINT fk_pedido_produto_id_pedido FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    CONSTRAINT fk_pedido_produto_id_produto FOREIGN KEY (id_produto) REFERENCES produto(id)
);



-- >>>>>>>>>>>> FAZER VINCULO N:N (PEDIDO:PRODUTO) COM CONSTRAINT?

-- ALTER TABLE pedido
--     ADD id_pedido_produto UUID NULL;

-- ALTER TABLE pedido
--     ADD CONSTRAINT fk_pedido_id_pedido_produto
--         FOREIGN KEY (id_pedido_produto)
--             REFERENCES pedido_produto(id);

-- CREATE INDEX ik_pedido_id_pedido_produto ON pedido(id_pedido_produto);
-- CREATE UNIQUE INDEX uk_pedido_nao_duplicado ON pedido(codigo, status, preco, id_pedido_produto) WHERE e_ativo;




INSERT INTO produto
    (id, nome, descricao, id_categoria, preco)
VALUES
    ('e389406d-5531-4acf-a354-be5cc46a8ca1', 'Hamburguer', 'Pão, queijo, alface, tomate, carne.', '4ce30a87-5654-486b-bed6-88c6f83f491a', 25.00),
    ('e389406d-5531-4acf-a354-be5cc46a8ca2', 'Pizza 4 queijos', 'Queijo muçarela, gorgonzola, parmesão, catupiry.', '2ae01e62-6805-4095-9bc3-9b9081517b87', 45.00),
    ('e389406d-5531-4acf-a354-be5cc46a8ca3', 'Porção de tilápia', '500 gramas de peixe', 'e397f412-9c76-4fb5-b029-7c3a99b7e982', 35.00);

INSERT INTO pedido
(id, codigo, status, preco)
VALUES
    ('e389406d-5531-4acf-a354-be5cc46a8cb1', '00001', 'ABERTO.', 100.00),
    ('e389406d-5531-4acf-a354-be5cc46a8cb2', '00002', 'EM_ANDAMENTO', 110.00),
    ('e389406d-5531-4acf-a354-be5cc46a8cb3', '00003', 'CANCELADO', 120.00);

INSERT INTO pedido_produto
(id_pedido, id_produto)
VALUES
    ('e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca3'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca3'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
    ('e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca3');




-- >>>>>>>>>>>> FAZER VINCULO N:N (PEDIDO:PRODUTO) COM CONSTRAINT?

-- INSERT INTO pedido_produto
-- (id, id_pedido, id_produto)
-- VALUES
--     ('e389406d-5531-4acf-a354-be5cc46a8cc1','e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc2','e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc3','e389406d-5531-4acf-a354-be5cc46a8cb1', 'e389406d-5531-4acf-a354-be5cc46a8ca3'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc4','e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc5','e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc6','e389406d-5531-4acf-a354-be5cc46a8cb2', 'e389406d-5531-4acf-a354-be5cc46a8ca3'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc7','e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca1'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc8','e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca2'),
--     ('e389406d-5531-4acf-a354-be5cc46a8cc9','e389406d-5531-4acf-a354-be5cc46a8cb3', 'e389406d-5531-4acf-a354-be5cc46a8ca3');


