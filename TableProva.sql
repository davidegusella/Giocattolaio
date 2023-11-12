CREATE DATABASE Giocattolaio;
USE Giocattolaio;
CREATE TABLE Prova
(
	id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20),
    prezzo DOUBLE
);
INSERT INTO Prova (nome, prezzo) VALUES ("nome1", 12.23), ("nome2", 34.34), ("nome3", 78.90);