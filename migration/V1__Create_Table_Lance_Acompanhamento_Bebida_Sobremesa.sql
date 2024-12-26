-- Criação das sequences
CREATE SEQUENCE seq_lanche_id START 1;
CREATE SEQUENCE seq_acompanhamento_id START 1;
CREATE SEQUENCE seq_bebida_id START 1;
CREATE SEQUENCE seq_sobremesa_id START 1;

-- Criação das tabelas
CREATE TABLE Lanche (
                        id INTEGER PRIMARY KEY DEFAULT nextval('seq_lanche_id'),
                        nome VARCHAR(50) NOT NULL
);

CREATE TABLE Acompanhamento (
                                id INTEGER PRIMARY KEY DEFAULT nextval('seq_acompanhamento_id'),
                                nome VARCHAR(50) NOT NULL
);

CREATE TABLE Bebida (
                        id INTEGER PRIMARY KEY DEFAULT nextval('seq_bebida_id'),
                        nome VARCHAR(50) NOT NULL
);

CREATE TABLE Sobremesa (
                           id INTEGER PRIMARY KEY DEFAULT nextval('seq_sobremesa_id'),
                           nome VARCHAR(50) NOT NULL
);
INSERT INTO Lanche (nome) VALUES
                              ('Cheeseburger'),
                              ('Hambúrguer Clássico'),
                              ('Double Bacon'),
                              ('Vegetariano'),
                              ('Chicken Burger');
INSERT INTO Acompanhamento (nome) VALUES
                                      ('Batata Frita'),
                                      ('Onion Rings'),
                                      ('Salada Coleslaw'),
                                      ('Mozzarella Sticks'),
                                      ('Batata Rústica');
INSERT INTO Bebida (nome) VALUES
                              ('Refrigerante'),
                              ('Água Mineral'),
                              ('Suco Natural'),
                              ('Chá Gelado'),
                              ('Milkshake');
INSERT INTO Sobremesa (nome) VALUES
                                 ('Sorvete'),
                                 ('Torta de Maçã'),
                                 ('Brownie com Sorvete'),
                                 ('Milkshake de Chocolate'),
                                 ('Petit Gâteau');
