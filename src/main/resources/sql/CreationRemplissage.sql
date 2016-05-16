# création de la base de données LO54
create database LO54;

# --------------------------------------------------------
# ========================================================
# --------------------------------------------------------

# création de la table LOCATION
create table LOCATION
(	
	ID_LOCATION int auto_increment,
	CITY varchar(50) not null,
	primary key (ID_LOCATION)
);

# --------------------------------------------------------

# création de la table COURSE
create table COURSE
(
	CODE varchar(10) not null,
	TITLE varchar(100) not null,
	primary key (CODE)
);

# --------------------------------------------------------

# création de la table COURSE_SESSION
create table COURSE_SESSION
(
	ID_COURSE_SESSION int auto_increment,
	START_DATE date not null,
	END_DATE date not null,
	COURSE_CODE varchar(10),
	LOCATION_ID int,
	PRIMARY KEY (ID_COURSE_SESSION),
	constraint FK_COURSE_CODE
		foreign key (COURSE_CODE)
	    references COURSE(CODE),
	constraint FK_LOCATION_ID
		foreign key (LOCATION_ID)
	    references LOCATION(ID_LOCATION)
);

# --------------------------------------------------------

# création de la table CLIENT
create table CLIENT
(
	ID_CLIENT int auto_increment,
	LASTNAME varchar(30) not null,
	FIRSTNAME varchar(30) not null,
	ADDRESS varchar(100) not null,
	PHONE varchar(15) not null,
	EMAIL varchar(50),
	COURSE_SESSION_ID int,
	primary key (ID_CLIENT),
	constraint FK_COURSE_SESSION_ID
		foreign key (COURSE_SESSION_ID)
		references COURSE_SESSION(ID_COURSE_SESSION)
);

# --------------------------------------------------------
# ========================================================
# --------------------------------------------------------

# Insertion dans la table LOCATION
insert into LOCATION (CITY)
values 
("Belfort"), 		# id = 1
("Sévenans"), 		# id = 2
("Montbéliard");	# id = 3

# --------------------------------------------------------

# Insertion dans la table COURSE
insert into COURSE (CODE, TITLE)
values 
("LO54", "Java Enterprise Applications Architectures and Development Frameworks"), 
("LO43", "Bases fondamentales de la programmation orientée objet"), 
("LO48", "Programmation Java avancée"),
("BD50", "Conception des bases de données"),
("IN41", "Analyse et traitement du signal"),
("LP40", "Développement Web et multimédia"),
("SM57", "Systèmes embarqués"),
("GL52", "Génie logiciel");

# --------------------------------------------------------

# Insertion dans la table COURSE_SESSION (date en AAAA-MM-JJ)
insert into COURSE_SESSION (START_DATE, END_DATE ,COURSE_CODE, LOCATION_ID)
values 
("2015-11-02", "2016-05-24", "LO43", 1),	# id = 1
("2015-10-08", "2016-06-04", "LO54", 1),	# id = 2
("2016-01-28", "2016-05-20", "LO48", 2),	# id = 3
("2015-12-01", "2016-06-18", "BD50", 3),	# id = 4
("2015-10-08", "2016-05-04", "IN41", 3),	# id = 5
("2016-01-22", "2016-05-20", "LP40", 2),	# id = 6
("2015-12-06", "2016-06-14", "SM57", 1),	# id = 7
("2015-12-01", "2016-06-18", "GL52", 2);	# id = 8

# --------------------------------------------------------

# Insertion dans la table CLIENT
insert into CLIENT (LASTNAME, FIRSTNAME, ADDRESS, PHONE, EMAIL, COURSE_SESSION_ID)
values
("DUPOND", "Marc", "5 Rue Jean-Jaures - BELFORT", "+33(0)612131541", "marc.dupond@utbm.fr", 4),
("DUPONT", "Jean-Pierre", "3 Rue de Bavilliers - Belfort", "(+33)0754685912", "jp.dupont89@gmail.com", 2),
("RUFL", "Marc", "2 bis Rue des sablettes (Sévenans)", "0757745917", "marco_rufl@hotmail.fr", 2),
("VICCES", "Marie", "2 Rue du stade - Sévenans", "(0)656548952", "marvic@hotmail.fr", 1),
("MIRET", "Luce", "1 Rue de Vezelois - Danjoutin", "+33(0)715629898", "luce.miret@utbm.fr", 2),
("MIRET", "Lucas", "1 Rue de Vezelois - Danjoutin", "+33(0)715629899", "lucas_miret@live.fr", 8);
