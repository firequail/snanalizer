-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sna
--

CREATE DATABASE IF NOT EXISTS sna;
USE sna;

--
-- Definition of table `atributo`
--

DROP TABLE IF EXISTS `atributo`;
CREATE TABLE `atributo` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  `estado` bit(1) default NULL,
  `nombre` varchar(255) default NULL,
  `datoMaestro_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK20FDAAD8398792ED` (`datoMaestro_id`),
  CONSTRAINT `FK20FDAAD8398792ED` FOREIGN KEY (`datoMaestro_id`) REFERENCES `datomaestro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atributo`
--

/*!40000 ALTER TABLE `atributo` DISABLE KEYS */;
INSERT INTO `atributo` (`id`,`descripcion`,`estado`,`nombre`,`datoMaestro_id`) VALUES 
 (1,'',0x01,'DEV',1),
 (2,'',0x01,'RRHH',1),
 (3,'',0x01,'Finances',1),
 (4,NULL,NULL,'FA',2),
 (5,NULL,NULL,'DEV',2),
 (6,NULL,NULL,'QC',2),
 (7,NULL,NULL,'Junior',3),
 (8,NULL,NULL,'Semisenior',3),
 (9,NULL,NULL,'Senior',3),
 (10,'Idioma Inglés',0x01,'Inglés',4),
 (11,'Idioma Portugués',0x01,'Portugués',4),
 (12,'Idioma Alemán',0x01,'Alemán',4),
 (13,'Idioma Francés',0x01,'Francés',4),
 (14,'Nivel Básico',0x01,'Básico',5),
 (15,'Nivel Intermedio',0x01,'Intermedio',5),
 (16,'Nivel Avanzado',0x01,'Avanzado',5),
 (17,'Nivel Nativo',0x01,'Nativo',5),
 (18,'Universidad Tecnológica Nacional',0x01,'UTN',6),
 (19,'Universidad de Buenos Aires',0x01,'UBA',6),
 (20,'Instituto Técnico de Bs. As.',0x01,'ITBA',6),
 (21,'Universidad Argentina de la Empresa',0x01,'UADE',6),
 (22,'Deporte',0x01,'Deporte',7),
 (23,'Teatro',0x01,'Teatro',7),
 (24,'Viajes',0x01,'Traveling',7),
 (25,'Paintball',0x01,'Paintball',7),
 (26,'Buenos Aires',0x01,'Buenos Aires',8),
 (27,'Córdoba',0x01,'Córdoba',8),
 (28,'',0x01,'Soltero/a',9),
 (29,'',0x01,'Casado/a',9),
 (30,'',0x01,'Viudo/a',9),
 (31,'',0x01,'Divorciado/a',9),
 (33,'Tucuman',0x01,'Tucuman',8),
 (34,'Chubut',0x01,'Chubut',8),
 (35,'Catamarca',0x01,'Catamarca',8),
 (36,'Chaco',0x01,'Chaco',8),
 (37,'Corrientes',0x01,'Corrientes',8),
 (38,'Entre Rios',0x01,'Entre Rios',8),
 (39,'Formosa',0x01,'Formosa',8),
 (40,'Jujuy',0x01,'Jujuy',8),
 (41,'La Pampa',0x01,'La Pampa',8),
 (42,'La Rioja',0x01,'La Rioja',8),
 (43,'Mendoza',0x01,'Mendoza',8),
 (44,'Misiones',0x01,'Misiones',8),
 (45,'Neuquen',0x01,'Neuquen',8),
 (46,'Rio Negro',0x01,'Rio Negro',8),
 (47,'Salta',0x01,'Salta',8),
 (48,'San Juan',0x01,'San Juan',8),
 (49,'San Luis',0x01,'San Luis',8),
 (50,'Santa Cruz',0x01,'Santa Cruz',8),
 (51,'Santa Fe',0x01,'Santa Fe',8),
 (52,'Santiago del Estero',0x01,'Santiago del Estero',8),
 (53,'Tierra del Fuego',0x01,'Tierra del Fuego',8),
 (54,'Catamarca',0x01,'Catamarca',8),
 (55,'Mendoza',0x01,'Mendoza',8),
 (56,'La Rioja',0x01,'La Rioja',8),
 (57,'Misiones',0x01,'Misiones',8);
/*!40000 ALTER TABLE `atributo` ENABLE KEYS */;


--
-- Definition of table `datomaestro`
--

DROP TABLE IF EXISTS `datomaestro`;
CREATE TABLE `datomaestro` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datomaestro`
--

/*!40000 ALTER TABLE `datomaestro` DISABLE KEYS */;
INSERT INTO `datomaestro` (`id`,`descripcion`) VALUES 
 (1,'Area'),
 (2,'Puesto'),
 (3,'Seniority'),
 (4,'Idioma'),
 (5,'Nivel'),
 (6,'Institución'),
 (7,'Hobby'),
 (8,'Provincia'),
 (9,'Estado Civil');
/*!40000 ALTER TABLE `datomaestro` ENABLE KEYS */;


--
-- Definition of table `datomaestro_atributo`
--

DROP TABLE IF EXISTS `datomaestro_atributo`;
CREATE TABLE `datomaestro_atributo` (
  `DatoMaestro_id` int(11) NOT NULL,
  `atributos_id` int(11) NOT NULL,
  UNIQUE KEY `atributos_id` (`atributos_id`),
  KEY `FK833E9BE0567DEE04` (`atributos_id`),
  KEY `FK833E9BE0398792ED` (`DatoMaestro_id`),
  CONSTRAINT `FK833E9BE0398792ED` FOREIGN KEY (`DatoMaestro_id`) REFERENCES `datomaestro` (`id`),
  CONSTRAINT `FK833E9BE0567DEE04` FOREIGN KEY (`atributos_id`) REFERENCES `atributo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datomaestro_atributo`
--

/*!40000 ALTER TABLE `datomaestro_atributo` DISABLE KEYS */;
INSERT INTO `datomaestro_atributo` (`DatoMaestro_id`,`atributos_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (2,4),
 (2,5),
 (2,6),
 (3,7),
 (3,8),
 (3,9),
 (4,10),
 (4,11),
 (4,12),
 (4,13),
 (5,14),
 (5,15),
 (5,16),
 (5,17),
 (6,18),
 (6,19),
 (6,20),
 (6,21),
 (7,22),
 (7,23),
 (7,24),
 (7,25),
 (8,26),
 (8,27),
 (8,54),
 (8,55),
 (8,56),
 (8,57),
 (9,28),
 (9,29),
 (9,30),
 (9,31);
/*!40000 ALTER TABLE `datomaestro_atributo` ENABLE KEYS */;


--
-- Definition of table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
CREATE TABLE `encuesta` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuesta`
--

/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` (`id`,`nombre`) VALUES 
 (1,'Encuesta Area Desarrollo'),
 (2,'Encuesta Marian'),
 (3,'Encuesta de Nico');
/*!40000 ALTER TABLE `encuesta` ENABLE KEYS */;


--
-- Definition of table `encuesta_pregunta`
--

DROP TABLE IF EXISTS `encuesta_pregunta`;
CREATE TABLE `encuesta_pregunta` (
  `Encuesta_id` int(11) NOT NULL,
  `preguntas_id` int(11) NOT NULL,
  UNIQUE KEY `preguntas_id` (`preguntas_id`),
  KEY `FKF726801317148A27` (`Encuesta_id`),
  KEY `FKF7268013E8A18D68` (`preguntas_id`),
  CONSTRAINT `FKF726801317148A27` FOREIGN KEY (`Encuesta_id`) REFERENCES `encuesta` (`id`),
  CONSTRAINT `FKF7268013E8A18D68` FOREIGN KEY (`preguntas_id`) REFERENCES `pregunta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuesta_pregunta`
--

/*!40000 ALTER TABLE `encuesta_pregunta` DISABLE KEYS */;
INSERT INTO `encuesta_pregunta` (`Encuesta_id`,`preguntas_id`) VALUES 
 (1,5),
 (1,6),
 (1,7),
 (1,8),
 (2,9),
 (2,10),
 (3,11),
 (3,12);
/*!40000 ALTER TABLE `encuesta_pregunta` ENABLE KEYS */;


--
-- Definition of table `encuestadeportal`
--

DROP TABLE IF EXISTS `encuestadeportal`;
CREATE TABLE `encuestadeportal` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuestadeportal`
--

/*!40000 ALTER TABLE `encuestadeportal` DISABLE KEYS */;
INSERT INTO `encuestadeportal` (`id`,`nombre`) VALUES 
 (1,'Encuesta portal de prueba'),
 (2,'Encuesta de prueba 2');
/*!40000 ALTER TABLE `encuestadeportal` ENABLE KEYS */;


--
-- Definition of table `encuestadeportal_preguntadeportal`
--

DROP TABLE IF EXISTS `encuestadeportal_preguntadeportal`;
CREATE TABLE `encuestadeportal_preguntadeportal` (
  `EncuestaDePortal_id` int(11) NOT NULL,
  `preguntas_id` int(11) NOT NULL,
  UNIQUE KEY `preguntas_id` (`preguntas_id`),
  KEY `FK5B7CBAB3B1FD9247` (`EncuestaDePortal_id`),
  KEY `FK5B7CBAB3314346D5` (`preguntas_id`),
  CONSTRAINT `FK5B7CBAB3314346D5` FOREIGN KEY (`preguntas_id`) REFERENCES `preguntadeportal` (`id`),
  CONSTRAINT `FK5B7CBAB3B1FD9247` FOREIGN KEY (`EncuestaDePortal_id`) REFERENCES `encuestadeportal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuestadeportal_preguntadeportal`
--

/*!40000 ALTER TABLE `encuestadeportal_preguntadeportal` DISABLE KEYS */;
INSERT INTO `encuestadeportal_preguntadeportal` (`EncuestaDePortal_id`,`preguntas_id`) VALUES 
 (1,1),
 (2,2);
/*!40000 ALTER TABLE `encuestadeportal_preguntadeportal` ENABLE KEYS */;


--
-- Definition of table `gruporecursos`
--

DROP TABLE IF EXISTS `gruporecursos`;
CREATE TABLE `gruporecursos` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gruporecursos`
--

/*!40000 ALTER TABLE `gruporecursos` DISABLE KEYS */;
INSERT INTO `gruporecursos` (`id`,`descripcion`) VALUES 
 (1,'Grupo de Recursos de DEV'),
 (2,'Grupo Marian'),
 (5,'Nico');
/*!40000 ALTER TABLE `gruporecursos` ENABLE KEYS */;


--
-- Definition of table `gruporecursos_recurso`
--

DROP TABLE IF EXISTS `gruporecursos_recurso`;
CREATE TABLE `gruporecursos_recurso` (
  `GrupoRecursos_id` int(11) NOT NULL,
  `recursos_id` int(11) NOT NULL,
  KEY `FKB2874C9DD7A6C4ED` (`GrupoRecursos_id`),
  KEY `FKB2874C9DEB6DA2AC` (`recursos_id`),
  CONSTRAINT `FKB2874C9DD7A6C4ED` FOREIGN KEY (`GrupoRecursos_id`) REFERENCES `gruporecursos` (`id`),
  CONSTRAINT `FKB2874C9DEB6DA2AC` FOREIGN KEY (`recursos_id`) REFERENCES `recurso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gruporecursos_recurso`
--

/*!40000 ALTER TABLE `gruporecursos_recurso` DISABLE KEYS */;
INSERT INTO `gruporecursos_recurso` (`GrupoRecursos_id`,`recursos_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,1),
 (2,2),
 (2,3),
 (2,4),
 (2,9),
 (5,1),
 (5,2),
 (5,3),
 (5,4),
 (5,5),
 (5,6),
 (5,7),
 (5,8),
 (5,9),
 (5,10),
 (5,11),
 (5,12),
 (5,13),
 (5,14),
 (5,15),
 (5,16),
 (5,17),
 (5,18),
 (5,19),
 (5,20);
/*!40000 ALTER TABLE `gruporecursos_recurso` ENABLE KEYS */;


--
-- Definition of table `nodo`
--

DROP TABLE IF EXISTS `nodo`;
CREATE TABLE `nodo` (
  `id` int(11) NOT NULL auto_increment,
  `recurso_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK25222C7D38E34D` (`recurso_id`),
  CONSTRAINT `FK25222C7D38E34D` FOREIGN KEY (`recurso_id`) REFERENCES `recurso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=415 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodo`
--

/*!40000 ALTER TABLE `nodo` DISABLE KEYS */;
INSERT INTO `nodo` (`id`,`recurso_id`) VALUES 
 (1,1),
 (19,1),
 (24,1),
 (181,1),
 (200,1),
 (219,1),
 (238,1),
 (257,1),
 (276,1),
 (295,1),
 (314,1),
 (335,1),
 (355,1),
 (375,1),
 (395,1),
 (2,2),
 (20,2),
 (25,2),
 (182,2),
 (201,2),
 (220,2),
 (239,2),
 (258,2),
 (277,2),
 (296,2),
 (315,2),
 (336,2),
 (356,2),
 (376,2),
 (396,2),
 (3,3),
 (21,3),
 (26,3),
 (183,3),
 (202,3),
 (221,3),
 (240,3),
 (259,3),
 (278,3),
 (297,3),
 (316,3),
 (337,3),
 (357,3),
 (377,3),
 (397,3),
 (4,4),
 (22,4),
 (27,4),
 (184,4),
 (203,4),
 (222,4),
 (241,4),
 (260,4),
 (279,4),
 (298,4),
 (317,4),
 (338,4),
 (358,4),
 (378,4),
 (398,4),
 (5,5),
 (185,5),
 (204,5),
 (223,5),
 (242,5),
 (261,5),
 (280,5),
 (299,5),
 (318,5),
 (339,5),
 (359,5),
 (379,5),
 (399,5),
 (6,6),
 (186,6),
 (205,6),
 (224,6),
 (243,6),
 (262,6),
 (281,6),
 (300,6),
 (319,6),
 (340,6),
 (360,6),
 (380,6),
 (400,6),
 (7,7),
 (187,7),
 (206,7),
 (225,7),
 (244,7),
 (263,7),
 (282,7),
 (301,7),
 (320,7),
 (341,7),
 (361,7),
 (381,7),
 (401,7),
 (8,8),
 (188,8),
 (207,8),
 (226,8),
 (245,8),
 (264,8),
 (283,8),
 (302,8),
 (321,8),
 (342,8),
 (362,8),
 (382,8),
 (402,8),
 (9,9),
 (23,9),
 (28,9),
 (189,9),
 (208,9),
 (227,9),
 (246,9),
 (265,9),
 (284,9),
 (303,9),
 (322,9),
 (343,9),
 (363,9),
 (383,9),
 (403,9),
 (10,10),
 (190,10),
 (209,10),
 (228,10),
 (247,10),
 (266,10),
 (285,10),
 (304,10),
 (323,10),
 (344,10),
 (364,10),
 (384,10),
 (404,10),
 (11,11),
 (191,11),
 (210,11),
 (229,11),
 (248,11),
 (267,11),
 (286,11),
 (305,11),
 (324,11),
 (345,11),
 (365,11),
 (385,11),
 (405,11),
 (12,12),
 (192,12),
 (211,12),
 (230,12),
 (249,12),
 (268,12),
 (287,12),
 (306,12),
 (325,12),
 (346,12),
 (366,12),
 (386,12),
 (406,12),
 (13,13),
 (193,13),
 (212,13),
 (231,13),
 (250,13),
 (269,13),
 (288,13),
 (307,13),
 (326,13),
 (347,13),
 (367,13),
 (387,13),
 (407,13),
 (14,14),
 (194,14),
 (213,14),
 (232,14),
 (251,14),
 (270,14),
 (289,14),
 (308,14),
 (327,14),
 (348,14),
 (368,14),
 (388,14),
 (408,14),
 (15,15),
 (195,15),
 (214,15),
 (233,15),
 (252,15),
 (271,15),
 (290,15),
 (309,15),
 (328,15),
 (349,15),
 (369,15),
 (389,15),
 (409,15),
 (16,16),
 (196,16),
 (215,16),
 (234,16),
 (253,16),
 (272,16),
 (291,16),
 (310,16),
 (329,16),
 (350,16),
 (370,16),
 (390,16),
 (410,16),
 (17,17),
 (197,17),
 (216,17),
 (235,17),
 (254,17),
 (273,17),
 (292,17),
 (311,17),
 (330,17),
 (351,17),
 (371,17),
 (391,17),
 (411,17),
 (18,18),
 (198,18),
 (217,18),
 (236,18),
 (255,18),
 (274,18),
 (293,18),
 (312,18),
 (331,18),
 (352,18),
 (372,18),
 (392,18),
 (412,18),
 (199,19),
 (218,19),
 (237,19),
 (256,19),
 (275,19),
 (294,19),
 (313,19),
 (332,19),
 (353,19),
 (373,19),
 (393,19),
 (413,19),
 (333,20),
 (334,20),
 (354,20),
 (374,20),
 (394,20),
 (414,20);
/*!40000 ALTER TABLE `nodo` ENABLE KEYS */;


--
-- Definition of table `nodo_relacion`
--

DROP TABLE IF EXISTS `nodo_relacion`;
CREATE TABLE `nodo_relacion` (
  `Nodo_id` int(11) NOT NULL,
  `relaciones_id` int(11) NOT NULL,
  KEY `FKFF4C6480A2BE8699` (`relaciones_id`),
  KEY `FKFF4C6480BEF08E7` (`Nodo_id`),
  CONSTRAINT `FKFF4C6480A2BE8699` FOREIGN KEY (`relaciones_id`) REFERENCES `relacion` (`id`),
  CONSTRAINT `FKFF4C6480BEF08E7` FOREIGN KEY (`Nodo_id`) REFERENCES `nodo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodo_relacion`
--

/*!40000 ALTER TABLE `nodo_relacion` DISABLE KEYS */;
INSERT INTO `nodo_relacion` (`Nodo_id`,`relaciones_id`) VALUES 
 (1,1),
 (2,1),
 (2,2),
 (2,3),
 (2,4),
 (3,2),
 (3,4),
 (4,3),
 (5,5),
 (6,5),
 (8,6),
 (9,6),
 (10,7),
 (10,10),
 (11,7),
 (11,8),
 (11,9),
 (11,10),
 (12,8),
 (13,9),
 (14,11),
 (15,11),
 (15,12),
 (15,13),
 (16,12),
 (16,14),
 (17,13),
 (18,14),
 (19,15),
 (19,17),
 (25,16),
 (25,18),
 (21,15),
 (21,19),
 (24,16),
 (24,20),
 (22,19),
 (22,21),
 (27,22),
 (20,17),
 (20,23),
 (23,21),
 (23,23),
 (26,20),
 (26,22),
 (26,24),
 (28,18),
 (28,24),
 (335,25),
 (355,26),
 (356,28),
 (337,29),
 (357,26),
 (357,28),
 (357,30),
 (338,31),
 (339,27),
 (339,33),
 (359,30),
 (359,34),
 (360,36),
 (341,37),
 (342,39),
 (364,44),
 (345,45),
 (365,46),
 (346,47),
 (347,49),
 (366,48),
 (366,50),
 (367,50),
 (348,49),
 (348,51),
 (368,48),
 (368,52),
 (340,31),
 (340,33),
 (340,35),
 (340,53),
 (349,47),
 (349,53),
 (362,32),
 (362,40),
 (362,54),
 (369,46),
 (369,54),
 (336,25),
 (336,27),
 (336,29),
 (336,55),
 (354,37),
 (354,55),
 (358,32),
 (358,56),
 (374,36),
 (374,56),
 (344,43),
 (344,57),
 (353,57),
 (363,42),
 (363,58),
 (373,38),
 (373,40),
 (373,58),
 (343,35),
 (343,41),
 (343,51),
 (343,59),
 (352,39),
 (352,41),
 (352,59),
 (361,34),
 (361,38),
 (361,60),
 (372,60),
 (223,61),
 (237,61),
 (246,62),
 (256,62),
 (199,63),
 (201,64),
 (218,64),
 (231,65),
 (236,65),
 (250,66),
 (255,66),
 (193,67),
 (198,67),
 (212,68),
 (217,68),
 (230,69),
 (249,70),
 (192,71),
 (211,72),
 (225,73),
 (244,74),
 (187,75),
 (206,76),
 (221,77),
 (235,69),
 (235,73),
 (235,77),
 (240,78),
 (254,70),
 (254,74),
 (254,78),
 (183,63),
 (183,79),
 (197,71),
 (197,75),
 (197,79),
 (202,80),
 (216,72),
 (216,76),
 (216,80),
 (350,45),
 (350,81),
 (351,43),
 (351,81),
 (370,44),
 (370,82),
 (371,42),
 (371,52),
 (371,82);
/*!40000 ALTER TABLE `nodo_relacion` ENABLE KEYS */;


--
-- Definition of table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
CREATE TABLE `pregunta` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  `maximaIntensidad` int(11) NOT NULL,
  `encuesta_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKB7202F0A17148A27` (`encuesta_id`),
  CONSTRAINT `FKB7202F0A17148A27` FOREIGN KEY (`encuesta_id`) REFERENCES `encuesta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pregunta`
--

/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` (`id`,`descripcion`,`maximaIntensidad`,`encuesta_id`) VALUES 
 (1,'Quien tiene mas conocimientos en usabilidad?',0,NULL),
 (2,'pto de vista 2',0,NULL),
 (3,'pto de vista 1',0,NULL),
 (4,'Quien tiene mas conocimientos en testing?',0,NULL),
 (5,'A quién consulta cuando tiene una duda de .NET?',5,1),
 (6,'A quién consulta cuando tiene una duda no técnica?',5,1),
 (7,'Quién fue su mentor cuando ingresó a la empresa?',5,1),
 (8,'Quién lo ayuda más diariamente?',5,1),
 (9,'A quién consulta sobre tal cosa?',5,2),
 (10,'A quién consulta sobre tal otra?',5,2),
 (11,'Quien te ayuda mas?',5,3),
 (12,'Quien se viste mejor?',5,3);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;


--
-- Definition of table `preguntadeportal`
--

DROP TABLE IF EXISTS `preguntadeportal`;
CREATE TABLE `preguntadeportal` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preguntadeportal`
--

/*!40000 ALTER TABLE `preguntadeportal` DISABLE KEYS */;
INSERT INTO `preguntadeportal` (`id`,`descripcion`) VALUES 
 (1,'De qué cuadro sos?'),
 (2,'Jugas al fútbol?');
/*!40000 ALTER TABLE `preguntadeportal` ENABLE KEYS */;


--
-- Definition of table `preguntadeportal_respuestadeportal`
--

DROP TABLE IF EXISTS `preguntadeportal_respuestadeportal`;
CREATE TABLE `preguntadeportal_respuestadeportal` (
  `PreguntaDePortal_id` int(11) NOT NULL,
  `respuestas_id` int(11) NOT NULL,
  UNIQUE KEY `respuestas_id` (`respuestas_id`),
  KEY `FKAC4A8B457E38DDC7` (`PreguntaDePortal_id`),
  KEY `FKAC4A8B4547764EC7` (`respuestas_id`),
  CONSTRAINT `FKAC4A8B4547764EC7` FOREIGN KEY (`respuestas_id`) REFERENCES `respuestadeportal` (`id`),
  CONSTRAINT `FKAC4A8B457E38DDC7` FOREIGN KEY (`PreguntaDePortal_id`) REFERENCES `preguntadeportal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `preguntadeportal_respuestadeportal`
--

/*!40000 ALTER TABLE `preguntadeportal_respuestadeportal` DISABLE KEYS */;
INSERT INTO `preguntadeportal_respuestadeportal` (`PreguntaDePortal_id`,`respuestas_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (2,4),
 (2,5);
/*!40000 ALTER TABLE `preguntadeportal_respuestadeportal` ENABLE KEYS */;


--
-- Definition of table `puntodevista`
--

DROP TABLE IF EXISTS `puntodevista`;
CREATE TABLE `puntodevista` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  `pregunta_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK63AB4EC85B1355A7` (`pregunta_id`),
  CONSTRAINT `FK63AB4EC85B1355A7` FOREIGN KEY (`pregunta_id`) REFERENCES `pregunta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntodevista`
--

/*!40000 ALTER TABLE `puntodevista` DISABLE KEYS */;
INSERT INTO `puntodevista` (`id`,`descripcion`,`pregunta_id`) VALUES 
 (1,'Quien tiene mas conocimientos en usabilidad?',1),
 (2,'pto de vista 2',2),
 (3,'pto de vista 1',3),
 (4,'Quien tiene mas conocimientos en testing?',4),
 (5,'A quién consulta cuando tiene una duda de .NET?',5),
 (6,'A quién consulta cuando tiene una duda no técnica?',6),
 (7,'Quién fue su mentor cuando ingresó a la empresa?',7),
 (8,'Quién lo ayuda más diariamente?',8),
 (9,'A quién consulta sobre tal cosa?',9),
 (10,'A quién consulta sobre tal otra?',10),
 (19,'A quién consulta sobre tal cosa?',9),
 (20,'A quién consulta sobre tal otra?',10),
 (21,'A quién consulta sobre tal cosa?',9),
 (22,'A quién consulta sobre tal otra?',10),
 (23,'A quién consulta cuando tiene una duda de .NET?',5),
 (24,'A quién consulta cuando tiene una duda no técnica?',6),
 (25,'Quién fue su mentor cuando ingresó a la empresa?',7),
 (26,'Quién lo ayuda más diariamente?',8),
 (27,'A quién consulta sobre tal cosa?',9),
 (28,'A quién consulta sobre tal otra?',10),
 (29,'A quién consulta sobre tal cosa?',9),
 (30,'A quién consulta sobre tal otra?',10),
 (31,'Quien te ayuda mas?',11),
 (32,'Quien se viste mejor?',12);
/*!40000 ALTER TABLE `puntodevista` ENABLE KEYS */;


--
-- Definition of table `puntodevista_nodo`
--

DROP TABLE IF EXISTS `puntodevista_nodo`;
CREATE TABLE `puntodevista_nodo` (
  `PuntoDeVista_id` int(11) NOT NULL,
  `nodos_id` int(11) NOT NULL,
  UNIQUE KEY `nodos_id` (`nodos_id`),
  KEY `FKA3DE894352D33627` (`PuntoDeVista_id`),
  KEY `FKA3DE8943D16E112C` (`nodos_id`),
  CONSTRAINT `FKA3DE894352D33627` FOREIGN KEY (`PuntoDeVista_id`) REFERENCES `puntodevista` (`id`),
  CONSTRAINT `FKA3DE8943D16E112C` FOREIGN KEY (`nodos_id`) REFERENCES `nodo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntodevista_nodo`
--

/*!40000 ALTER TABLE `puntodevista_nodo` DISABLE KEYS */;
INSERT INTO `puntodevista_nodo` (`PuntoDeVista_id`,`nodos_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,5),
 (2,6),
 (2,7),
 (2,8),
 (2,9),
 (3,10),
 (3,11),
 (3,12),
 (3,13),
 (4,14),
 (4,15),
 (4,16),
 (4,17),
 (4,18),
 (9,19),
 (9,20),
 (9,21),
 (9,22),
 (9,23),
 (10,24),
 (10,25),
 (10,26),
 (10,27),
 (10,28),
 (19,181),
 (19,182),
 (19,183),
 (19,184),
 (19,185),
 (19,186),
 (19,187),
 (19,188),
 (19,189),
 (19,190),
 (19,191),
 (19,192),
 (19,193),
 (19,194),
 (19,195),
 (19,196),
 (19,197),
 (19,198),
 (19,199),
 (20,200),
 (20,201),
 (20,202),
 (20,203),
 (20,204),
 (20,205),
 (20,206),
 (20,207),
 (20,208),
 (20,209),
 (20,210),
 (20,211),
 (20,212),
 (20,213),
 (20,214),
 (20,215),
 (20,216),
 (20,217),
 (20,218),
 (21,219),
 (21,220),
 (21,221),
 (21,222),
 (21,223),
 (21,224),
 (21,225),
 (21,226),
 (21,227),
 (21,228),
 (21,229),
 (21,230),
 (21,231),
 (21,232),
 (21,233),
 (21,234),
 (21,235),
 (21,236),
 (21,237),
 (22,238),
 (22,239),
 (22,240),
 (22,241),
 (22,242),
 (22,243),
 (22,244),
 (22,245),
 (22,246),
 (22,247),
 (22,248),
 (22,249),
 (22,250),
 (22,251),
 (22,252),
 (22,253),
 (22,254),
 (22,255),
 (22,256),
 (23,257),
 (23,258),
 (23,259),
 (23,260),
 (23,261),
 (23,262),
 (23,263),
 (23,264),
 (23,265),
 (23,266),
 (23,267),
 (23,268),
 (23,269),
 (23,270),
 (23,271),
 (23,272),
 (23,273),
 (23,274),
 (23,275),
 (24,276),
 (24,277),
 (24,278),
 (24,279),
 (24,280),
 (24,281),
 (24,282),
 (24,283),
 (24,284),
 (24,285),
 (24,286),
 (24,287),
 (24,288),
 (24,289),
 (24,290),
 (24,291),
 (24,292),
 (24,293),
 (24,294),
 (25,295),
 (25,296),
 (25,297),
 (25,298),
 (25,299),
 (25,300),
 (25,301),
 (25,302),
 (25,303),
 (25,304),
 (25,305),
 (25,306),
 (25,307),
 (25,308),
 (25,309),
 (25,310),
 (25,311),
 (25,312),
 (25,313),
 (26,314),
 (26,315),
 (26,316),
 (26,317),
 (26,318),
 (26,319),
 (26,320),
 (26,321),
 (26,322),
 (26,323),
 (26,324),
 (26,325),
 (26,326),
 (26,327),
 (26,328),
 (26,329),
 (26,330),
 (26,331),
 (26,332),
 (27,333),
 (28,334),
 (29,335),
 (29,336),
 (29,337),
 (29,338),
 (29,339),
 (29,340),
 (29,341),
 (29,342),
 (29,343),
 (29,344),
 (29,345),
 (29,346),
 (29,347),
 (29,348),
 (29,349),
 (29,350),
 (29,351),
 (29,352),
 (29,353),
 (29,354),
 (30,355),
 (30,356),
 (30,357),
 (30,358),
 (30,359),
 (30,360),
 (30,361),
 (30,362),
 (30,363),
 (30,364),
 (30,365),
 (30,366),
 (30,367),
 (30,368),
 (30,369),
 (30,370),
 (30,371),
 (30,372),
 (30,373),
 (30,374),
 (31,375),
 (31,376),
 (31,377),
 (31,378),
 (31,379),
 (31,380),
 (31,381),
 (31,382),
 (31,383),
 (31,384),
 (31,385),
 (31,386),
 (31,387),
 (31,388),
 (31,389),
 (31,390),
 (31,391),
 (31,392),
 (31,393),
 (31,394),
 (32,395),
 (32,396),
 (32,397),
 (32,398),
 (32,399),
 (32,400),
 (32,401),
 (32,402),
 (32,403),
 (32,404),
 (32,405),
 (32,406),
 (32,407),
 (32,408),
 (32,409),
 (32,410),
 (32,411),
 (32,412),
 (32,413),
 (32,414);
/*!40000 ALTER TABLE `puntodevista_nodo` ENABLE KEYS */;


--
-- Definition of table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
CREATE TABLE `recurso` (
  `id` int(11) NOT NULL auto_increment,
  `anioEgreso` int(11) NOT NULL,
  `anioIngreso` int(11) NOT NULL,
  `estado` bit(1) default NULL,
  `experiencia` varchar(255) default NULL,
  `fechaNac` datetime default NULL,
  `localidad` varchar(255) default NULL,
  `picture` varchar(255) default NULL,
  `titulo` varchar(255) default NULL,
  `area_id` int(11) default NULL,
  `estadoCivil_id` int(11) default NULL,
  `hobbie1_id` int(11) default NULL,
  `hobbie2_id` int(11) default NULL,
  `hobbie3_id` int(11) default NULL,
  `hobbie4_id` int(11) default NULL,
  `hobbie5_id` int(11) default NULL,
  `hobbie6_id` int(11) default NULL,
  `idioma1_id` int(11) default NULL,
  `idioma2_id` int(11) default NULL,
  `idioma3_id` int(11) default NULL,
  `institucion_id` int(11) default NULL,
  `nivelIdioma1_id` int(11) default NULL,
  `nivelIdioma2_id` int(11) default NULL,
  `nivelIdioma3_id` int(11) default NULL,
  `provincia_id` int(11) default NULL,
  `puesto_id` int(11) default NULL,
  `seniority_id` int(11) default NULL,
  `usuario_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKA3C272299F9A5AB1` (`puesto_id`),
  KEY `FKA3C27229FC6AB63` (`nivelIdioma3_id`),
  KEY `FKA3C272295903582` (`idioma2_id`),
  KEY `FKA3C27229590A9E1` (`idioma3_id`),
  KEY `FKA3C2722958A9FD2D` (`usuario_id`),
  KEY `FKA3C27229E2C51A0C` (`hobbie6_id`),
  KEY `FKA3C27229E2C2D431` (`hobbie1_id`),
  KEY `FKA3C27229E2C4314E` (`hobbie4_id`),
  KEY `FKA3C27229E2C34890` (`hobbie2_id`),
  KEY `FKA3C27229B45A6C96` (`institucion_id`),
  KEY `FKA3C27229923805D2` (`provincia_id`),
  KEY `FKA3C27229EBAFC761` (`seniority_id`),
  KEY `FKA3C272292ACF2D32` (`estadoCivil_id`),
  KEY `FKA3C27229FC63704` (`nivelIdioma2_id`),
  KEY `FKA3C27229FC5C2A5` (`nivelIdioma1_id`),
  KEY `FKA3C272297198C4F2` (`area_id`),
  KEY `FKA3C27229E2C3BCEF` (`hobbie3_id`),
  KEY `FKA3C27229E2C4A5AD` (`hobbie5_id`),
  KEY `FKA3C2722958FC123` (`idioma1_id`),
  CONSTRAINT `FKA3C272292ACF2D32` FOREIGN KEY (`estadoCivil_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C2722958A9FD2D` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKA3C2722958FC123` FOREIGN KEY (`idioma1_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C272295903582` FOREIGN KEY (`idioma2_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229590A9E1` FOREIGN KEY (`idioma3_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C272297198C4F2` FOREIGN KEY (`area_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229923805D2` FOREIGN KEY (`provincia_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C272299F9A5AB1` FOREIGN KEY (`puesto_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229B45A6C96` FOREIGN KEY (`institucion_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229E2C2D431` FOREIGN KEY (`hobbie1_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229E2C34890` FOREIGN KEY (`hobbie2_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229E2C3BCEF` FOREIGN KEY (`hobbie3_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229E2C4314E` FOREIGN KEY (`hobbie4_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229E2C4A5AD` FOREIGN KEY (`hobbie5_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229E2C51A0C` FOREIGN KEY (`hobbie6_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229EBAFC761` FOREIGN KEY (`seniority_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229FC5C2A5` FOREIGN KEY (`nivelIdioma1_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229FC63704` FOREIGN KEY (`nivelIdioma2_id`) REFERENCES `atributo` (`id`),
  CONSTRAINT `FKA3C27229FC6AB63` FOREIGN KEY (`nivelIdioma3_id`) REFERENCES `atributo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recurso`
--

/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` (`id`,`anioEgreso`,`anioIngreso`,`estado`,`experiencia`,`fechaNac`,`localidad`,`picture`,`titulo`,`area_id`,`estadoCivil_id`,`hobbie1_id`,`hobbie2_id`,`hobbie3_id`,`hobbie4_id`,`hobbie5_id`,`hobbie6_id`,`idioma1_id`,`idioma2_id`,`idioma3_id`,`institucion_id`,`nivelIdioma1_id`,`nivelIdioma2_id`,`nivelIdioma3_id`,`provincia_id`,`puesto_id`,`seniority_id`,`usuario_id`) VALUES 
 (1,0,0,0x01,NULL,'2008-10-01 00:00:00','Capital Federal',NULL,NULL,1,28,22,23,24,25,NULL,NULL,10,11,13,18,16,15,14,26,4,7,4),
 (2,0,0,0x01,NULL,'2008-10-01 00:00:00',NULL,NULL,NULL,1,NULL,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,4,8,5),
 (3,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,5,9,6),
 (4,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,5,8,7),
 (5,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,8),
 (6,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,9),
 (7,0,0,0x01,NULL,NULL,NULL,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,10),
 (8,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,9,11),
 (9,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5,9,12),
 (10,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,13),
 (11,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,6,7,14),
 (12,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,15),
 (13,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,16),
 (14,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,17),
 (15,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,18),
 (16,0,0,0x01,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,19),
 (17,0,0,0x00,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,20),
 (18,0,0,0x00,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,21),
 (19,0,0,0x01,NULL,'2008-07-01 23:00:00',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,23),
 (20,0,0,0x01,NULL,'2008-03-04 00:00:00',NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,7,25);
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;


--
-- Definition of table `red`
--

DROP TABLE IF EXISTS `red`;
CREATE TABLE `red` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  `nombre` varchar(255) default NULL,
  `encuesta_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1407117148A27` (`encuesta_id`),
  CONSTRAINT `FK1407117148A27` FOREIGN KEY (`encuesta_id`) REFERENCES `encuesta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `red`
--

/*!40000 ALTER TABLE `red` DISABLE KEYS */;
INSERT INTO `red` (`id`,`descripcion`,`nombre`,`encuesta_id`) VALUES 
 (1,'Red de Prueba','Red de Prueba',1),
 (2,'Red de Prueba2','Red de Prueba2',NULL),
 (3,'Red de Marian','Red de Marian',2),
 (8,'','Red de Nico',2),
 (9,'','Red de Nico',2),
 (10,'Red de Nico2','Red de Nico2',1),
 (11,'','Nico',2),
 (12,'','Prueba muchos',2),
 (13,'','Muchos Nico',3);
/*!40000 ALTER TABLE `red` ENABLE KEYS */;


--
-- Definition of table `red_puntodevista`
--

DROP TABLE IF EXISTS `red_puntodevista`;
CREATE TABLE `red_puntodevista` (
  `Red_id` int(11) NOT NULL,
  `puntosDeVista_id` int(11) NOT NULL,
  UNIQUE KEY `puntosDeVista_id` (`puntosDeVista_id`),
  KEY `FKD53777D65B098ED2` (`puntosDeVista_id`),
  KEY `FKD53777D6930BEFCD` (`Red_id`),
  CONSTRAINT `FKD53777D65B098ED2` FOREIGN KEY (`puntosDeVista_id`) REFERENCES `puntodevista` (`id`),
  CONSTRAINT `FKD53777D6930BEFCD` FOREIGN KEY (`Red_id`) REFERENCES `red` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `red_puntodevista`
--

/*!40000 ALTER TABLE `red_puntodevista` DISABLE KEYS */;
INSERT INTO `red_puntodevista` (`Red_id`,`puntosDeVista_id`) VALUES 
 (1,1),
 (1,2),
 (1,5),
 (1,6),
 (1,7),
 (1,8),
 (2,3),
 (2,4),
 (3,9),
 (3,10),
 (8,19),
 (8,20),
 (9,21),
 (9,22),
 (10,23),
 (10,24),
 (10,25),
 (10,26),
 (11,27),
 (11,28),
 (12,29),
 (12,30),
 (13,31),
 (13,32);
/*!40000 ALTER TABLE `red_puntodevista` ENABLE KEYS */;


--
-- Definition of table `relacion`
--

DROP TABLE IF EXISTS `relacion`;
CREATE TABLE `relacion` (
  `id` int(11) NOT NULL auto_increment,
  `intensidad` int(11) NOT NULL,
  `destino_id` int(11) default NULL,
  `origen_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKE2C6A3CD81C8DB89` (`origen_id`),
  KEY `FKE2C6A3CDD57B676B` (`destino_id`),
  CONSTRAINT `FKE2C6A3CD81C8DB89` FOREIGN KEY (`origen_id`) REFERENCES `nodo` (`id`),
  CONSTRAINT `FKE2C6A3CDD57B676B` FOREIGN KEY (`destino_id`) REFERENCES `nodo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relacion`
--

/*!40000 ALTER TABLE `relacion` DISABLE KEYS */;
INSERT INTO `relacion` (`id`,`intensidad`,`destino_id`,`origen_id`) VALUES 
 (1,3,1,2),
 (2,3,3,2),
 (3,3,4,2),
 (4,3,2,3),
 (5,3,5,6),
 (6,3,9,8),
 (7,3,10,11),
 (8,3,12,11),
 (9,3,13,11),
 (10,3,11,10),
 (11,3,14,15),
 (12,3,16,15),
 (13,3,17,15),
 (14,3,18,16),
 (15,3,21,19),
 (16,4,25,24),
 (17,5,19,20),
 (18,5,28,25),
 (19,5,22,21),
 (20,3,24,26),
 (21,4,23,22),
 (22,4,26,27),
 (23,5,20,23),
 (24,4,26,28),
 (25,1,336,335),
 (26,2,357,355),
 (27,3,339,336),
 (28,3,357,356),
 (29,3,336,337),
 (30,4,359,357),
 (31,5,340,338),
 (32,1,362,358),
 (33,5,340,339),
 (34,1,361,359),
 (35,2,343,340),
 (36,4,374,360),
 (37,4,354,341),
 (38,1,373,361),
 (39,2,352,342),
 (40,2,373,362),
 (41,2,352,343),
 (42,3,371,363),
 (43,1,351,344),
 (44,4,370,364),
 (45,2,350,345),
 (46,1,369,365),
 (47,1,349,346),
 (48,4,368,366),
 (49,5,348,347),
 (50,5,366,367),
 (51,5,343,348),
 (52,3,371,368),
 (53,2,340,349),
 (54,1,362,369),
 (55,4,336,354),
 (56,4,358,374),
 (57,1,344,353),
 (58,3,363,373),
 (59,3,343,352),
 (60,5,361,372),
 (61,5,223,237),
 (62,1,246,256),
 (63,1,183,199),
 (64,2,201,218),
 (65,2,236,231),
 (66,2,255,250),
 (67,1,198,193),
 (68,3,217,212),
 (69,1,235,230),
 (70,5,254,249),
 (71,4,197,192),
 (72,3,216,211),
 (73,1,235,225),
 (74,1,254,244),
 (75,1,197,187),
 (76,3,216,206),
 (77,3,235,221),
 (78,5,254,240),
 (79,5,197,183),
 (80,5,216,202),
 (81,5,351,350),
 (82,5,371,370);
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;


--
-- Definition of table `respuestadeportal`
--

DROP TABLE IF EXISTS `respuestadeportal`;
CREATE TABLE `respuestadeportal` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `respuestadeportal`
--

/*!40000 ALTER TABLE `respuestadeportal` DISABLE KEYS */;
INSERT INTO `respuestadeportal` (`id`,`descripcion`) VALUES 
 (1,'Boca Juniors'),
 (2,'River Plate'),
 (3,'Godoy Cruz'),
 (4,'SI'),
 (5,'NO');
/*!40000 ALTER TABLE `respuestadeportal` ENABLE KEYS */;


--
-- Definition of table `respuestaderecurso`
--

DROP TABLE IF EXISTS `respuestaderecurso`;
CREATE TABLE `respuestaderecurso` (
  `id` int(11) NOT NULL auto_increment,
  `encuesta_id` int(11) default NULL,
  `recurso_id` int(11) default NULL,
  `respuesta_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK405BAAC87D38E34D` (`recurso_id`),
  KEY `FK405BAAC848C17794` (`encuesta_id`),
  KEY `FK405BAAC8E0F1789A` (`respuesta_id`),
  CONSTRAINT `FK405BAAC848C17794` FOREIGN KEY (`encuesta_id`) REFERENCES `encuestadeportal` (`id`),
  CONSTRAINT `FK405BAAC87D38E34D` FOREIGN KEY (`recurso_id`) REFERENCES `recurso` (`id`),
  CONSTRAINT `FK405BAAC8E0F1789A` FOREIGN KEY (`respuesta_id`) REFERENCES `respuestadeportal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `respuestaderecurso`
--

/*!40000 ALTER TABLE `respuestaderecurso` DISABLE KEYS */;
INSERT INTO `respuestaderecurso` (`id`,`encuesta_id`,`recurso_id`,`respuesta_id`) VALUES 
 (1,1,1,2),
 (2,1,2,1),
 (3,1,3,3),
 (4,1,4,2),
 (5,2,1,4),
 (6,2,19,5),
 (7,1,19,1),
 (8,1,18,1),
 (9,2,18,4);
/*!40000 ALTER TABLE `respuestaderecurso` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL auto_increment,
  `apellido` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `nombre` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `rol` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`,`apellido`,`email`,`nombre`,`password`,`rol`) VALUES 
 (1,'Admin','admin','Admin','admin','ADMIN'),
 (2,'Analista','analista','Analista','analista','ANALISTA'),
 (3,'HR','hr','HR','hr','HR'),
 (4,'Lopez','r1@hotmail.com','Pepe','pepelopez','RECURSO'),
 (5,'Ticolis','r2@hotmail.com','Nestor','nestorticolis','RECURSO'),
 (6,'Candado','r3@hotmail.com','Juan','password','RECURSO'),
 (7,'Ortega','r4@hotmail.com','Ariel','password','RECURSO'),
 (8,'Tsiros','r13@hotmail.com','Pedro','password','RECURSO'),
 (9,'Martinez','r14@hotmail.com','Carlos','password','RECURSO'),
 (10,'Romano','r15@hotmail.com','Martin','password','RECURSO'),
 (11,'Ruffo','r16@hotmail.com','Oscar','password','RECURSO'),
 (12,'Sidders','r17@hotmail.com','Alejandro','password','RECURSO'),
 (13,'Domenico','r9@hotmail.com','Gabriel','password','RECURSO'),
 (14,'Cao','r10@hotmail.com','Leandro','password','RECURSO'),
 (15,'Andrade','r11@hotmail.com','Nicolas','password','RECURSO'),
 (16,'Gunelli','r12@hotmail.com','Patricio','password','RECURSO'),
 (17,'Torres','r5@hotmail.com','Gustavo','password','RECURSO'),
 (18,'Ferraro','r6@hotmail.com','Daniel','password','RECURSO'),
 (19,'Medina','r7@hotmail.com','Jose','password','RECURSO'),
 (20,'Nicosia','r8@hotmail.com','Gonzalo','password','RECURSO'),
 (21,'Aguirre','r9@hotmail.com','Pablo','password','RECURSO'),
 (22,'Arias','asd@asd.com','Luciano','asd','ADMIN'),
 (23,'Arroyo','asd@asd.com','Javier','password','RECURSO'),
 (24,'Campo','javier@hotmail.com','Sebastian','javier','ADMIN'),
 (25,'Castillo','nicolasfont@gmail.com','Ignacio','nicolas','RECURSO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
