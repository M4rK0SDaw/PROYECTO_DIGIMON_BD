create database DIGIMON_BD;
use DIGIMON_BD;

CREATE TABLE PLAYER (
id_name int auto_increment,
NAME_J VARCHAR(20) unique,
PASSWD VARCHAR(32) NOT NULL,
Administrador BOOLEAN,
constraint JU_PK primary KEY( NAME_J)
);

CREATE TABLE DIGIMON(
ID_DIGIMON auto_increment,
NAME_Digi varchar(30) unique,
ID_EVOLUTION int DEFAULT null ,
ATTACK  INT NOT NULL DEFAULT 40,
DEFENSE INT NOT NULL DEFAULT 40,
TYPE_DIGI ENUM("vacuna","virus","elemental","animal","planta") DEFAULT "vacuna",
LVL ENUM('1','2','3') default 1,
constraint DIG_PK primary key (ID_DIGIMON)
);
/*
He creado el campo campo del id_evolucion para poder asociarlo a su proxima digievolucion,
ya que se puede definir al crear un digimon nuevo.
*/

CREATE TABLE TENER_DIGI(
id_name int ,
ID_DIGIMON  int ,

constraint TD_PK PRIMARY KEY ( NAME_J,ID_DIGIMON)
);

alter table TENER_DIGI
add constraint TD_JU_FK foreign key (NAME_J ) references PLAYER (NAME_J );

alter table TENER_DIGI
add constraint TD_DI_FK foreign key (ID_DIGIMON ) references DIGIMON (ID_DIGIMON )on delete on CASCADE;
