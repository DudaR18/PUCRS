CREATE TABLE Livros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200),
    autor VARCHAR(200),
    ano INT,
    codigo_usuario INT DEFAULT -1
);

CREATE TABLE Usuarios (
    codigo INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200),
    ano_nascimento INT
);

INSERT INTO livros (codigo,titulo,autor,ano) VALUES
(10,'Introdução ao Java','Huguinho Pato',2022);
INSERT INTO livros (codigo,titulo,autor,ano) VALUES
(20,'Introdução ao Spring-Boot','Zezinho Pato',2020);
INSERT INTO livros (codigo,titulo,autor,ano) VALUES
(15,'Principios SOLID','Luizinho Pato',2023);
INSERT INTO livros (codigo,titulo,autor,ano) VALUES
(17,'Padroes de Projeto','Lala Pato',2019);