-- Criação da tabela categoria_produto
CREATE TABLE usuario (
                         id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                         nome VARCHAR(255),
                         email VARCHAR(254) UNIQUE,
                         cpf VARCHAR(11) UNIQUE
);