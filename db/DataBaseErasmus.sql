DROP DATABASE IF EXISTS Erasmus;
CREATE DATABASE Erasmus;
USE Erasmus;

DROP TABLE IF EXISTS Account;

CREATE TABLE Account (	
  ID int primary key AUTO_INCREMENT,
  Nome char(20) not null,
  Cognome char(20) not null,
  Sesso char(1),
  Data char(11),
  Matricola char(11),
  PostaElettronica char(50),
  Password char(30),
  CittaNascita char(35),
  CittaResidenza char(35),
  Indirizzo char(30),
  NumeroCivico int,
  CAP int,
  NumeroTelefonico char(20),
  Admin boolean
);

INSERT INTO Account values (1,"Impiegato","Erasmus","M"," "," ","impiegato@erasmus.it","admin"," "," "," ",0,0," ",true);
INSERT INTO Account values (2,"Adamo","Coppola","M","21/05/1996","0512103631","A.COPPOLA136@studenti.unisa.it","adamo","Torre Annunziata","Boscotrecase","Via Annunziatella",42,80042,"3407033613",false);
/*INSERT INTO Account values (3,"","","M"," "," ","",""," "," "," ",0,0," ",false);*/

DROP TABLE IF EXISTS Modulo;

CREATE TABLE Modulo (	
  ID int primary key AUTO_INCREMENT,
  IDProprietario int,
  Nome char(20) not null,
  Cognome char(20) not null,
  Sesso char (1),
  DataNascita char(11),
  Data char(11),
  PostaElettronica char(50),
  Matricola char(11),
  CittaNascita char(35),
  CittaResidenza char(35),
  Indirizzo char(30),
  NumeroCivico int,
  CAP int,
  NumeroTelefonico char(20),
  CartaIdentita char(10),
  Destinazione1 char(60),
  Destinazione2 char(60),
  Destinazione3 char(60),
  Domanda boolean,
  InviaModulo boolean DEFAULT false,
  ConfermaModulo boolean DEFAULT false
);

INSERT INTO Modulo values(1,2,"Adamo","Coppola","M","21/05/1996","09/01/2018","A.COPPOLA136@studenti.unisa.it","0512103631","Torre Annunziata","Boscotrecase","Via Annunziatella",42,80042,"3407033613"," ","Inghilterra","Francia"," ",true,false,false);
INSERT INTO Modulo values(2,2,"Adamo","Coppola","M","21/05/1996","09/01/2018","A.COPPOLA136@studenti.unisa.it","0512103631","Torre Annunziata","Boscotrecase","Via Annunziatella",42,80042,"3407033613"," ","Spagna","Cina"," ",true,false,false);

DROP TABLE IF EXISTS Graduatoria;

CREATE TABLE Graduatoria (	
  ID int primary key AUTO_INCREMENT,
  NomeGrad char(50),
  TipoGrad char(40),
  PesoGrad long,
  Graduatoria longblob NOT NULL,
);

DROP TABLE IF EXISTS Messaggio;

CREATE TABLE Messaggio (	
  ID int primary key AUTO_INCREMENT,
  IDProprietario int,
  Titolo char (50),
  Messaggio longblob,
  Visto boolean
);

INSERT INTO Messaggio values (1,2,"Prova","Questo &egrave un messaggio di prova per vedere se come esce il messaggio e vedere la grandezza e vedere se funziona il sito quindi devo scivere molto giusto per fare qualcosa di utile",false)


