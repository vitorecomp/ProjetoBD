SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;



CREATE  TABLE IF NOT EXISTS Pais
	(
		idPais INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Sigla varchar(3) NOT NULL,
		Capital varchar(45) NOT NULL,
		Bandeira BLOB
	);

CREATE  TABLE IF NOT EXISTS Integrante
	(
		idIntegrante INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Nacionalidade varchar(45) NOT NULL,
		Data_Nasc DATE NOT NULL,
		Foto BLOB
	);

CREATE  TABLE IF NOT EXISTS Estadio
	(
		idEstadio INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		idPais INTEGER REFERENCES Pais(idPais),
		Cidade varchar(65) NOT NULL,
		Capacidade BIGINT NOT NULL,
		Nome varchar(45) NOT NULL
	);


CREATE  TABLE IF NOT EXISTS Bolao 
	(
		idBolao INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		Aposta varchar(45) NOT NULL,
		data DATE NOT NULL
	);


CREATE  TABLE IF NOT EXISTS Pessoa
	(
		idPessoa  INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Nacionalidade varchar(45) NOT NULL,
		Data_Nasc date NOT NULL

	);


CREATE  TABLE IF NOT EXISTS Torcida 
	(
		idTorcida INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		idPais INTEGER references Pais(idPais),
		Foto BLOB,
		Presidente  VARCHAR(45) NOT NULL
	);



CREATE  TABLE IF NOT EXISTS Copa
	(
		Ano INTEGER UNSIGNED PRIMARY KEY,
		idPais INTEGER references Pais(idPais),
		dataIni DATE NOT NULL,
		dataFim DATE NOT NULL,
		Camp INTEGER references Pais(idPais)

	);


CREATE  TABLE IF NOT EXISTS Equipe
	(
		idEquipe INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		idTreinador INTEGER references Integrante(idIntegrante),
		idPais INTEGER references Pais(idPais),
		idCopa INTEGER references Copa(Ano)
	);



CREATE  TABLE IF NOT EXISTS Jogo
	(
		idJogo INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		data DATE,
		Copa INTEGER references Copa(Ano),
		Equipe1 INTEGER references Equipe(idEquipe),
		Equipe2 INTEGER references Equipe(idEquipe)
	);


CREATE  TABLE IF NOT EXISTS Gol
	(
		idGol INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		Jogo INTEGER references Jogo(idJogo),
		Autor INTEGER references Integrante(idIntegrante),
		Relogio TIME

	);


CREATE  TABLE IF NOT EXISTS Cartao
	(
		idCartao INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Jogo INTEGER references Jogo(idJogo),
		Integrante INTEGER references Integrante(idIntegrante),
		Tipo char NOT NULL,
		Relogio TIME
	);


CREATE  TABLE IF NOT EXISTS Bolao_has_Pessoa
	(
		idBolao INTEGER references Bolao(idBolao),
		idPessoa INTEGER references Pessoa(idPessoa)
	);

CREATE  TABLE IF NOT EXISTS Equipe_has_Integrante
	(
		idEquipe INTEGER references Equipe(idEquipe),
		idIntegrante INTEGER references Integrante(idIntegrante)
	);

CREATE  TABLE IF NOT EXISTS Integrante_has_Cartao
	(
		idIntegrante INTEGER references Integrante(idIntegrante),
		idCartao INTEGER references Cartao(idCartao)
	);

CREATE  TABLE IF NOT EXISTS Integrante_has_Gol
	(
		idIntegrante INTEGER references Integrante(idIntegrante),
		idGol INTEGER references Gol(idGol)
	);

CREATE  TABLE IF NOT EXISTS Torcida_has_Copa
	(
		idTorcida INTEGER references Torcida(idTorcida), 
		idCopa INTEGER references Copa(Ano)
	);

CREATE  TABLE IF NOT EXISTS Jogo_has_Bolao
	(
		idJogo INTEGER references Jogo(idJogo), 
		idBolao INTEGER references Bolao(idBolao)
	);

CREATE  TABLE IF NOT EXISTS Pessoas_has_Torcida
	(
		idPessoa INTEGER references Pessoa(idPessoa),
		idTorcida INTEGER references Torcida(idTorcida)
	);
