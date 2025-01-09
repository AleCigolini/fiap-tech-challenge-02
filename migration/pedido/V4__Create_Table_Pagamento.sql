-- Criação da tabela pagamento
CREATE TABLE pagamento (
    id UUID PRIMARY KEY DEFAULT GEN_RANDOM_UUID(),
    preco DECIMAL(10,2) NOT NULL DEFAULT 00.00,
    data_criacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    e_ativo BOOL NOT NULL DEFAULT TRUE
);