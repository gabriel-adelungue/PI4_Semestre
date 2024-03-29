CREATE DATABASE Bangkok;

USE Bangkok;

CREATE TABLE HospedeEntity (
Id INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(100),
Cpf VARCHAR(11),
Email VARCHAR(60),
Celular VARCHAR(14)
);
CREATE TABLE QuartoEntity (
Id INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(100),
NumeroQuarto INT,
Valor FLOAT
);

SELECT * FROM QuartoEntity;


CREATE TABLE FuncionarioEntity (
Id INT PRIMARY KEY AUTO_INCREMENT,
Nome VARCHAR(100),
Cpf VARCHAR(11),
Email VARCHAR(60),
Celular VARCHAR(14),
Endereco VARCHAR(100),
Cargo VARCHAR(100)
);
CREATE TABLE ReservaEntity (
Id INT PRIMARY KEY AUTO_INCREMENT,
IdFuncionario INT,
IdQuarto INT,
IdHospede INT,
ValorQuarto FLOAT,
DataInicioReserva DATE NOT NULL,
DataFimReserva DATE NOT NULL
);
ALTER TABLE ReservaEntity
ADD FOREIGN KEY (IdFuncionario)
REFERENCES FuncionarioEntity(Id);

ALTER TABLE ReservaEntity
ADD FOREIGN KEY (IdQuarto)
REFERENCES QuartoEntity(Id);

ALTER TABLE ReservaEntity
ADD FOREIGN KEY (IdHospede)
REFERENCES HospedeEntity(Id);

