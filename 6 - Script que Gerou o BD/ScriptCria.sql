DROP TABLE IF EXISTS Estadio;
DROP TABLE IF EXISTS Pais;
DROP TABLE IF EXISTS Bolao;
DROP TABLE IF EXISTS Gol;
DROP TABLE IF EXISTS Pessoa;
DROP TABLE IF EXISTS Bolao_has_Pessoa;
DROP TABLE IF EXISTS Integrante;
DROP TABLE IF EXISTS Pessoas_has_Torcida;
DROP TABLE IF EXISTS Cartao;
DROP TABLE IF EXISTS Integrantes_has_Cartao;
DROP TABLE IF EXISTS Torcida;
DROP TABLE IF EXISTS Copa;
DROP TABLE IF EXISTS Integrante_has_Gol;
DROP TABLE IF EXISTS Torcida_has_Copa;
DROP TABLE IF EXISTS Equipe;
DROP TABLE IF EXISTS Jogos;
DROP TABLE IF EXISTS Equipe_has_Integrante
DROP TABLE IF EXISTS Jogo_has_Bolao;

--ok
CREATE TABLE Pais
	(
		idPais INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Sigla varchar(3) NOT NULL,
		Capital varchar(45) NOT NULL,
		Bandeira BLOB
	);

--ok
CREATE TABLE Estadio
	(
		idEstadio INTEGER USIGNED PRIMARY KEY AUTO_INCREMENT,
		idPais references Pais(idPais),
		Cidade varchar(65) NOT NULL,
		Capacidade LONG INT UNSIGNED NOT NULL,
		Nome varchar(45) NOT NULL
	);

--ok
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
		Data_Nasc date NOT NULL,

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
		idPais references Pais(idPais) NOT NULL,
		Foto BLOB,
		Presidente  VARCHAR(45) NOT NULL;
	);

--ok

CREATE TABLE Copa
	(
		Ano INTEGER UNSIGNED PRIMARY KEY,
		idPais references Pais(idPais),
		dataIni DATE NOT NULL,
		dataFim DATE NOT NULL
		Camp references Pais(idPais),

	);

--ok
CREATE TABLE Equipe
	(
		idEquipe INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		idTreinador references Integrante(idIntegrante),
		idPais references Pais(idPais)
		idCopa references Copa(Ano)
	);



CREATE TABLE Jogo
	(
		idJogo INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		data DATE,
		Copa references Copa(Ano),
		Equipe1 references Equipe(idEquipe),
		Equipe2 references Equipe(idEquipe)
	);


CREATE TABLE Gol
	(
		idGol INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		Jogo references Jogo(idJogo),
		Autor references Integrante(idIntegrante),
		Relogio TIME

	);

--ok
CREATE TABLE Cartao
	(
		idCartao INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Jogo references Jogo(idJogo),
		Integrante references Integrante(idIntegrante),
		Tipo char NOT NULL,
		Relogio TIME
	);

--Tabelas de Ligaçao
CREATE TABLE Bolao_has_Pessoa
	(
		idBolao references Bolao(idBolao),
		idPessoa references Pessoa(idPessoa)
	);

CREATE TABLE Equipe_has_Integrante
	(
		idEquipe references Equipe(idEquipe),
		idIntegrante references Integrante(idIntegrante)
	);

CREATE TABLE Integrante_has_Cartao
	(
		idIntegrante references Integrante(idIntegrante),
		idCartao references Cartao(idCartao)
	);

CREATE TABLE Integrante_has_Gol
	(
		idIntegrante references Integrante(idIntegrante),
		idGol references Gol(idGol)
	);

CREATE TABLE Torcida_has_Copa
	(
		idTorcida references Torcida(idTorcida), 
		idCopa references Copa(Ano)
	);

CREATE TABLE Jogo_has_Bolao
	(
		idJogo references Jogo(idJogo), 
		idBolao references Bolao(idBolao)
	);

CREATE TABLE Pessoas_has_Torcida
	(
		idPessoa references Pessoa(idPessoa),
		idTorcida references Torcida(idTorcida)
	);
