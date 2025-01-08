-- Criação da tabela categoria_produto
CREATE TABLE usuario (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome VARCHAR(255),
    email VARCHAR(254) UNIQUE,
    cpf VARCHAR(11) UNIQUE
);

INSERT INTO usuario (id, nome, email, cpf)
    VALUES ("12345678-1234-1234-1234-123456789012", 'Teste Usuário', 'teste.usuario@email.com', '12345678900');
