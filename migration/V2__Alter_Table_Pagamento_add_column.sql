-- TODO: APENAS PARA TESTE, REMOVER LINHA ABAIXO QUANTO TIVER MÓDULO DE CLIENTE
ALTER TABLE pedido ALTER COLUMN id_cliente DROP NOT NULL;


-- Alteração na tabela pagamento para adicionar o campo status
ALTER TABLE pagamento
    ADD status TEXT NULL;

-- Inserção de pagamentos de pedidos na tabela pagamento
INSERT INTO pagamento
(id, cd_pedido, preco, status)
VALUES
    ('e389406d-5531-4acf-a354-be5cc46a8ce1','e389406d-5531-4acf-a354-be5cc46a8cb2', 110, 'SUCESSO'),
    ('e389406d-5531-4acf-a354-be5cc46a8ce2','e389406d-5531-4acf-a354-be5cc46a8cb5', 110, 'FALHOU'),
    ('e389406d-5531-4acf-a354-be5cc46a8ce3','e389406d-5531-4acf-a354-be5cc46a8cb5', 110, 'SUCESSO');

