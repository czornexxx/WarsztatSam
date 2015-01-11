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
-- Table structure for table `stanowisko`
--

DROP TABLE IF EXISTS `stanowisko`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stanowisko` (
  `idStanowisko` int(11) NOT NULL AUTO_INCREMENT,
  `Opis` varchar(255) DEFAULT NULL,
  `Wynagrodzenie` float DEFAULT NULL,
  `Nazwa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idStanowisko`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stanowisko`
--

LOCK TABLES `stanowisko` WRITE;
/*!40000 ALTER TABLE `stanowisko` DISABLE KEYS */;
INSERT INTO `stanowisko` VALUES (0,'Admin',0,'Admin'),(1,'Wykonuje prace naprawcze na warsztacie.',2900,'Mechanik'),(2,'Nadzoruje pracę mechaników.',3500,'Kierownik'),(3,'Rozmowa z klientami, dodawanie zleceń, obsługa klienta.',1500,'Asystent'),(4,'Siedzi i nic nie robi.',6000,'Szef'),(5,'Test Test Tesst',2000,'Test');
/*!40000 ALTER TABLE `stanowisko` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-11 21:26:48
