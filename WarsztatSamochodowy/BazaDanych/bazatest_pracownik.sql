CREATE DATABASE  IF NOT EXISTS `bazatest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bazatest`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bazatest
-- ------------------------------------------------------
-- Server version	5.6.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pracownik`
--

DROP TABLE IF EXISTS `pracownik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pracownik` (
  `Pesel` varchar(11) NOT NULL,
  `Imie` varchar(45) NOT NULL,
  `Nazwisko` varchar(45) NOT NULL,
  `Miejscowosc` varchar(45) DEFAULT NULL,
  `KodPocztowy` varchar(6) DEFAULT NULL,
  `Ulica` varchar(45) DEFAULT NULL,
  `Stanowisko_idStanowisko` int(11) NOT NULL,
  PRIMARY KEY (`Pesel`),
  KEY `fk_Pracownik_Stanowisko1_idx` (`Stanowisko_idStanowisko`),
  CONSTRAINT `fk_Pracownik_Stanowisko1` FOREIGN KEY (`Stanowisko_idStanowisko`) REFERENCES `stanowisko` (`idStanowisko`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pracownik`
--

LOCK TABLES `pracownik` WRITE;
/*!40000 ALTER TABLE `pracownik` DISABLE KEYS */;
INSERT INTO `pracownik` VALUES ('11111111111','Administrator','Administrator',NULL,NULL,NULL,0),('2234123','Jan','Matejko','Wrocław','22-243','zła',1),('22342','Sławek','Malinowski','Wrocław','22-432','Kita',1),('2343','Andrzej','Grabowski','Wrocław','22-534','Kowia',1),('235432','Artur','Szlachta','Wrocław','22-323','Kita',2),('23553','Andrzej','Wozniak','Wrocław','22-432','Kromera',1),('2532','Sebastian','Lipka','Wrocław','22-423','Lipowej',1),('3256','Marian','Rokita','Oleśnica','42-235',NULL,4),('4234','Mariusz','Pankiewicz','Wrocław','22-243','Zła',1),('5234','Jakub','Mateja','Wrocław','22-432','Kasprowicza',1),('5237','Adam','Dobry','Wrocław','22-534','Krakowska',1),('5263','Joanna','Nowak','Wrocław','22-234','Jakas',3),('88883','Pawel','Noga','Hebzie',NULL,NULL,1),('888883','Damian','Noga','Hebzie',NULL,NULL,1),('92120904731','Damian','Noga','Rzeszów','23-442',NULL,1);
/*!40000 ALTER TABLE `pracownik` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-03 18:07:22
