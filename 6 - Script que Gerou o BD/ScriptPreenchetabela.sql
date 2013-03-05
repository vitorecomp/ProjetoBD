insert into Pais(Nome, Sigla, Capital, Bandeira) values ("Brasil", "BR", "Brasília", ,LOAD_FILE('"bandeira-do-brasil.gif'));
insert into Pais(Nome, Sigla, Capital, Bandeira) values ("França", "FRA", "Paris", ,LOAD_FILE('"bandeira-do-brasil.gif'));
insert into Pais(Nome, Sigla, Capital, Bandeira) values ("Inglaterra", "ING", "Londres", ,LOAD_FILE('"bandeira-do-brasil.gif'));
insert into Pais(Nome, Sigla, Capital, Bandeira) values ("Alemanha", "GER", "Berlin", ,LOAD_FILE('"bandeira-do-brasil.gif'));

insert into Integrante(Nome, Nacionalidade, Data_Nasc) values ("Pierre", "Frances", "04/05/1956");
insert into Integrante(Nome, Nacionalidade, Data_Nasc) values ("Marco", "Alemao", "06/12/1966");

insert into Copa(Ano, idPais, dataIni, dataFim, Camp) values (1998, 2, "14/06/1998", "14/06/1998", 2);

insert into Equipe(idTreinador, idPais, idCopa) values(1, 1, 1);
insert into Equipe(idTreinador, idPais, idCopa) values(2, 1, 1);