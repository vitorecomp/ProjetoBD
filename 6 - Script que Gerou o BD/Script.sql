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
DROP TABLE IF EXISTS Equipe_has_Integrante;
DROP TABLE IF EXISTS Jogo_has_Bolao;

--dar uma olhada no TIME E no BLOB

--ok
CREATE TABLE Pais
	(
		idPais INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Sigla varchar(3) NOT NULL,
		Capital varchar(45) NOT NULL,
		Bandeira BLOB												--Conferir aqui com e o blob na declaraçao de tableas
	);

--ok
CREATE TABLE Estadio
	(
		idEstadio INTEGER USIGNED PRIMARY KEY AUTO_INCREMENT,
		Cidade varchar(65) NOT NULL,
		Capacidade DOUBLE UNSIGNED NOT NULL,
		Nome varchar(45) NOT NULL,
		idPais references Pais(idPais)
	);

--ta faltando 2 aquiY 
CREATE TABLE Bolao 
	(
		idBolao INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		Aposta varchar(45) NOT NULL,
		data DATE NOT NULL
	);

--falta 1 e dar um review na nacianlidade
CREATE TABLE Pessoa
	(
		idPessoa  INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Nacionalidade ...,
		Data_Nasc date NOT NULL,

	);

--sera que tem que existir / dar um review na nacianlidade
CREATE TABLE Integrante
	(
		idIntegrante INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		Nome varchar(45) NOT NULL,
		Nacionalidade ...,
		Data_Nasc DATE NOT NULL,
		Foto BLOB
	);

--Foto tem que ser uma nova tabela
--presidente e um referencia a uma pessoa
CREATE TABLE Torcida 
	(
		idTorcida INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		idPais references Pais(idPais) NOT NULL,
		Foto BLOB,
		Presidente 
	);

--id do Pais e realmente um chave primeria
--falta 1
CREATE TABLE Copa
	(
		Ano DATE UNSIGNED PRIMARY KEY,
		idPais references Pais(idPais) NOT NULL,
		dataIni DATE NOT NULL,
		dataFim DATE NOT NULL

	);

--falta 1
CREATE TABLE Equipe
	(
		idEquipe INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		idTreinador references Integrante(idIntegrante),
		idPais references Pais(idPais)
		idCopa references Copa(Ano)
	);

--falta 2 ja dei 1 review
--temos que ter os times
CREATE TABLE Jogo
	(
		idJogo INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
		data DATE,
		idCopa references Copa(Ano),
		idEquipe1 references Equipe(idEquipe),
		idEquipe2 references Equipe(idEquipe)
	);

--olhar aqui dois atributos
CREATE TABLE Gol
	(
		idGol INTEGER UNSIGNED PRIMARY kEY AUTO_INCREMENT,
		idJogo references Jogos(idJogo)
		idCopa references Copa(idCopa)
		Tempo --ver isso daqui
		Relogio --ver isso daqui
	);

--ok
CREATE TABLE Cartao
	(
		idCartao INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
		idJogo references Jogo(idJogo),
		idCopa references Copa(idCopa),
		Tipo char NOT NULL,
		Tempo TIME
	);

--Tabelas de Ligaçao
CREATE TABLE Bolao_has_Pessoa
	(
		idBolao references Bolao(idBolao),
		idPessoa references Pessoa(idPessoa)
	);

CREATE TABLE Pessoas_has_Torcida
	(
		idPessoa
		idTorcida
		idPais
	);

CREATE TABLE Integrante_has_Cartao
	(
		idIntegrante
		idCartao
	);

CREATE TABLE Integrante_has_Gol
	(
		Ano
		idPais
		dataIni
		dataFim

	);

CREATE TABLE Torcida_has_Copa
	(
		Ano
		idPais
		dataIni
		dataFim

	);

CREATE TABLE Equipe_has_Integrante
	(
		Ano
		idPais
		dataIni
		dataFim

	);

CREATE TABLE Jogo_has_Bolao
	(
		Ano
		idPais
		dataIni
		dataFim

	);
