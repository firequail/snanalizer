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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atributo`
--

/*!40000 ALTER TABLE `atributo` DISABLE KEYS */;
INSERT INTO `atributo` (`id`,`descripcion`,`estado`,`nombre`,`datoMaestro_id`) VALUES 
 (1,NULL,NULL,'DEV',1),
 (2,NULL,NULL,'RRHH',1),
 (3,NULL,NULL,'Finances',1),
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
 (25,'Paintball',0x01,'Paintball',7);
/*!40000 ALTER TABLE `atributo` ENABLE KEYS */;


--
-- Definition of table `datomaestro`
--

DROP TABLE IF EXISTS `datomaestro`;
CREATE TABLE `datomaestro` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
 (7,'Hobby');
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
 (7,25);
/*!40000 ALTER TABLE `datomaestro_atributo` ENABLE KEYS */;


--
-- Definition of table `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
CREATE TABLE `encuesta` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `encuesta`
--

/*!40000 ALTER TABLE `encuesta` DISABLE KEYS */;
INSERT INTO `encuesta` (`id`,`nombre`) VALUES 
 (1,'encuesta1');
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
 (1,7);
/*!40000 ALTER TABLE `encuesta_pregunta` ENABLE KEYS */;


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
 (2,'grupo12-13'),
 (5,'qwe');
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
 (2,5),
 (5,1),
 (5,5),
 (5,7);
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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodo`
--

/*!40000 ALTER TABLE `nodo` DISABLE KEYS */;
INSERT INTO `nodo` (`id`,`recurso_id`) VALUES 
 (1,1),
 (19,1),
 (23,1),
 (27,1),
 (31,1),
 (34,1),
 (37,1),
 (2,2),
 (20,2),
 (24,2),
 (28,2),
 (32,2),
 (35,2),
 (38,2),
 (3,3),
 (21,3),
 (25,3),
 (29,3),
 (4,4),
 (5,5),
 (22,5),
 (26,5),
 (30,5),
 (33,5),
 (36,5),
 (39,5),
 (6,6),
 (7,7),
 (8,8),
 (9,9),
 (10,10),
 (11,11),
 (12,12),
 (13,13),
 (14,14),
 (15,15),
 (16,16),
 (17,17),
 (18,18);
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
 (18,14);
/*!40000 ALTER TABLE `nodo_relacion` ENABLE KEYS */;


--
-- Definition of table `pregunta`
--

DROP TABLE IF EXISTS `pregunta`;
CREATE TABLE `pregunta` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  `maximaIntensidad` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pregunta`
--

/*!40000 ALTER TABLE `pregunta` DISABLE KEYS */;
INSERT INTO `pregunta` (`id`,`descripcion`,`maximaIntensidad`) VALUES 
 (1,'Quien tiene mas conocimientos en usabilidad?',0),
 (2,'pto de vista 2',0),
 (3,'pto de vista 1',0),
 (4,'Quien tiene mas conocimientos en testing?',0),
 (5,'pregunta1',5),
 (6,'pregunta2',5),
 (7,'pregunta3',5);
/*!40000 ALTER TABLE `pregunta` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `puntodevista`
--

/*!40000 ALTER TABLE `puntodevista` DISABLE KEYS */;
INSERT INTO `puntodevista` (`id`,`descripcion`,`pregunta_id`) VALUES 
 (1,'Quien tiene mas conocimientos en usabilidad?',1),
 (2,'pto de vista 2',2),
 (3,'pto de vista 1',3),
 (4,'Quien tiene mas conocimientos en testing?',4),
 (5,'pregunta1',5),
 (6,'pregunta2',6),
 (7,'pregunta3',7),
 (8,'pregunta1',5),
 (9,'pregunta2',6),
 (10,'pregunta3',7);
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
 (5,19),
 (5,20),
 (5,21),
 (5,22),
 (6,23),
 (6,24),
 (6,25),
 (6,26),
 (7,27),
 (7,28),
 (7,29),
 (7,30),
 (8,31),
 (8,32),
 (8,33),
 (9,34),
 (9,35),
 (9,36),
 (10,37),
 (10,38),
 (10,39);
/*!40000 ALTER TABLE `puntodevista_nodo` ENABLE KEYS */;


--
-- Definition of table `recurso`
--

DROP TABLE IF EXISTS `recurso`;
CREATE TABLE `recurso` (
  `id` int(11) NOT NULL auto_increment,
  `anioEgreso` int(11) default NULL,
  `anioIngreso` int(11) default NULL,
  `estado` bit(1) default NULL,
  `estadoCivil` varchar(255) default NULL,
  `experiencia` varchar(255) default NULL,
  `fechaNac` datetime default NULL,
  `localidad` varchar(255) default NULL,
  `picture` varchar(255) default NULL,
  `titulo` varchar(255) default NULL,
  `area_id` int(11) default NULL,
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
  KEY `FKA3C27229FC5C2A5` (`nivelIdioma1_id`),
  KEY `FKA3C27229FC63704` (`nivelIdioma2_id`),
  KEY `FKA3C272297198C4F2` (`area_id`),
  KEY `FKA3C27229E2C3BCEF` (`hobbie3_id`),
  KEY `FKA3C27229E2C4A5AD` (`hobbie5_id`),
  KEY `FKA3C2722958FC123` (`idioma1_id`),
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recurso`
--

/*!40000 ALTER TABLE `recurso` DISABLE KEYS */;
INSERT INTO `recurso` (`id`,`anioEgreso`,`anioIngreso`,`estado`,`estadoCivil`,`experiencia`,`fechaNac`,`localidad`,`picture`,`titulo`,`area_id`,`hobbie1_id`,`hobbie2_id`,`hobbie3_id`,`hobbie4_id`,`hobbie5_id`,`hobbie6_id`,`idioma1_id`,`idioma2_id`,`idioma3_id`,`institucion_id`,`nivelIdioma1_id`,`nivelIdioma2_id`,`nivelIdioma3_id`,`provincia_id`,`puesto_id`,`seniority_id`,`usuario_id`) VALUES 
 (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,4,7,4),
 (2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,4,8,5),
 (3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,5,9,6),
 (4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,22,23,24,25,NULL,NULL,10,11,13,18,14,15,14,NULL,5,8,7),
 (5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,8),
 (6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,9),
 (7,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10),
 (8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,11),
 (9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,12),
 (10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,13),
 (11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,14),
 (12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,15),
 (13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,16),
 (14,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,17),
 (15,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,18),
 (16,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,19),
 (17,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20),
 (18,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,21);
/*!40000 ALTER TABLE `recurso` ENABLE KEYS */;


--
-- Definition of table `red`
--

DROP TABLE IF EXISTS `red`;
CREATE TABLE `red` (
  `id` int(11) NOT NULL auto_increment,
  `descripcion` varchar(255) default NULL,
  `nombre` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `red`
--

/*!40000 ALTER TABLE `red` DISABLE KEYS */;
INSERT INTO `red` (`id`,`descripcion`,`nombre`) VALUES 
 (1,'Red de Prueba',NULL),
 (2,'Red de Prueba2',NULL),
 (3,'desc red1','red1'),
 (4,'desc red2','red2');
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
 (2,3),
 (2,4),
 (3,5),
 (3,6),
 (3,7),
 (4,8),
 (4,9),
 (4,10);
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

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
 (14,3,18,16);
/*!40000 ALTER TABLE `relacion` ENABLE KEYS */;


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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`,`apellido`,`email`,`nombre`,`password`,`rol`) VALUES 
 (1,'','admin','','admin','ADMIN'),
 (2,'','analista','','analista','ANALISTA'),
 (3,'','hr','','hr','HR'),
 (4,'Lopez','r1@hotmail.com','Pepe','','RECURSO'),
 (5,'Ticolis','r2@hotmail.com','Nestor','','RECURSO'),
 (6,'Candado','r3@hotmail.com','Juan','','RECURSO'),
 (7,'Ortega','r4@hotmail.com','Ariel','','RECURSO'),
 (8,'Lopez','r13@hotmail.com','Pepe','','RECURSO'),
 (9,'Ticolis','r14@hotmail.com','Nestor','','RECURSO'),
 (10,'Candado','r15@hotmail.com','Juan','','RECURSO'),
 (11,'Ortega','r16@hotmail.com','Ariel','','RECURSO'),
 (12,'Alterio','r17@hotmail.com','Hector','','RECURSO'),
 (13,'Lopez','r9@hotmail.com','Pepe','','RECURSO'),
 (14,'Ticolis','r10@hotmail.com','Nestor','','RECURSO'),
 (15,'Candado','r11hotmail.com','Juan','','RECURSO'),
 (16,'Ortega','r12@hotmail.com','Ariel','','RECURSO'),
 (17,'Lopez','r5@hotmail.com','Pepe','','RECURSO'),
 (18,'Ticolis','r6@hotmail.com','Nestor','','RECURSO'),
 (19,'Candado','r7@hotmail.com','Juan','','RECURSO'),
 (20,'Ortega','r8@hotmail.com','Ariel','','RECURSO'),
 (21,'Ibarra','r9@hotmail.com','Anibal','','RECURSO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
