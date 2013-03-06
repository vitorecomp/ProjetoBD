
DROP TABLE IF EXISTS Estadio;
DROP TABLE IF EXISTS Pais;
DROP TABLE IF EXISTS Bolao;
DROP TABLE IF EXISTS Gol;
DROP TABLE IF EXISTS Pessoa;
DROP TABLE IF EXISTS Bolao_has_Pessoa;
DROP TABLE IF EXISTS Integrante;
DROP TABLE IF EXISTS Pessoas_has_Torcida;
DROP TABLE IF EXISTS Cartao;
DROP TABLE IF EXISTS Integrante_has_Cartao;
DROP TABLE IF EXISTS Torcida;
DROP TABLE IF EXISTS Copa;
DROP TABLE IF EXISTS Integrante_has_Gol;
DROP TABLE IF EXISTS Torcida_has_Copa;
DROP TABLE IF EXISTS Equipe;
DROP TABLE IF EXISTS Jogo;
DROP TABLE IF EXISTS Equipe_has_Integrante;
DROP TABLE IF EXISTS Jogo_has_Bolao;

CREATE TABLE Pais
	(
		idPais INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Sigla varchar(3) NOT NULL,
		Capital varchar(45) NOT NULL,
		Bandeira BLOB
	);


CREATE TABLE Estadio
	(
		idEstadio INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		idPais INTEGER UNSIGNED REFERENCES Pais(idPais),
		Cidade varchar(65) NOT NULL,
		Capacidade BIGINT UNSIGNED NOT NULL,
		Nome varchar(45) NOT NULL
	);


CREATE TABLE Bolao 
	(
		idBolao INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		Aposta varchar(45) NOT NULL,
		data DATE NOT NULL
	);


CREATE TABLE Pessoa
	(
		idPessoa  INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Nacionalidade varchar(45) NOT NULL,
		Data_Nasc date NOT NULL

	);


CREATE TABLE Integrante
	(
		idIntegrante INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Nacionalidade varchar(45) NOT NULL,
		Data_Nasc DATE NOT NULL,
		Foto BLOB
	);



CREATE TABLE Torcida 
	(
		idTorcida INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		idPais INTEGER UNSIGNED NOT NULL references Pais(idPais) ,
		Foto BLOB,
		Presidente  VARCHAR(45) NOT NULL
	);


CREATE TABLE Copa
	(
		Ano INTEGER UNSIGNED PRIMARY KEY,
		idPais INTEGER UNSIGNED NOT NULL references Pais(idPais),
		dataIni DATE NOT NULL,
		dataFim DATE NOT NULL,
		Camp INTEGER UNSIGNED NOT NULL references Pais(idPais)

	);

CREATE TABLE Equipe
	(
		idEquipe INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		idTreinador INTEGER UNSIGNED NOT NULL references Integrante(idIntegrante),
		idPais INTEGER UNSIGNED NOT NULL references Pais(idPais),
		idCopa INTEGER UNSIGNED NOT NULL references Copa(Ano)
	);



CREATE TABLE Jogo
	(
		idJogo INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		data DATE,
		Copa INTEGER UNSIGNED NOT NULL references Copa(Ano),
		Equipe1 INTEGER UNSIGNED NOT NULL references Equipe(idEquipe),
		Equipe2 INTEGER UNSIGNED NOT NULL references Equipe(idEquipe)
	);


CREATE TABLE Gol
	(
		idGol INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		Jogo INTEGER UNSIGNED NOT NULL references Jogo(idJogo),
		Autor INTEGER UNSIGNED NOT NULL references Integrante(idIntegrante),
		Relogio TIME

	);

CREATE TABLE Cartao
	(
		idCartao INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Jogo INTEGER UNSIGNED NOT NULL references Jogo(idJogo),
		Integrante INTEGER UNSIGNED NOT NULL references Integrante(idIntegrante),
		Tipo char NOT NULL,
		Relogio TIME
	);


CREATE TABLE Bolao_has_Pessoa
	(
		idBolao INTEGER UNSIGNED NOT NULL references Bolao(idBolao),
		idPessoa INTEGER UNSIGNED NOT NULL references Pessoa(idPessoa)
	);

CREATE TABLE Equipe_has_Integrante
	(
		idEquipe INTEGER UNSIGNED NOT NULL references Equipe(idEquipe),
		idIntegrante INTEGER UNSIGNED NOT NULL references Integrante(idIntegrante)
	);

CREATE TABLE Integrante_has_Cartao
	(
		idIntegrante INTEGER UNSIGNED NOT NULL references Integrante(idIntegrante),
		idCartao INTEGER UNSIGNED NOT NULL references Cartao(idCartao)
	);

CREATE TABLE Integrante_has_Gol
	(
		idIntegrante INTEGER UNSIGNED NOT NULL references Integrante(idIntegrante),
		idGol INTEGER UNSIGNED NOT NULL references Gol(idGol)
	);

CREATE TABLE Torcida_has_Copa
	(
		idTorcida INTEGER UNSIGNED NOT NULL references Torcida(idTorcida), 
		idCopa INTEGER UNSIGNED NOT NULL references Copa(Ano)
	);

CREATE TABLE Jogo_has_Bolao
	(
		idJogo INTEGER UNSIGNED NOT NULL references Jogo(idJogo), 
		idBolao INTEGER UNSIGNED NOT NULL references Bolao(idBolao)
	);

CREATE TABLE Pessoas_has_Torcida
	(
		idPessoa INTEGER UNSIGNED NOT NULL references Pessoa(idPessoa),
		idTorcida INTEGER UNSIGNED NOT NULL references Torcida(idTorcida)
	);

