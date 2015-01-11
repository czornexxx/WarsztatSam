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
-- Table structure for table `usługa`
--

DROP TABLE IF EXISTS `usługa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usługa` (
  `idUsługa` int(11) NOT NULL AUTO_INCREMENT,
  `Nazwa` varchar(45) DEFAULT NULL,
  `Opis` varchar(255) DEFAULT NULL,
  `Cena` decimal(7,2) DEFAULT NULL,
  `Dostepna` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsługa`),
  UNIQUE KEY `idUsługa_UNIQUE` (`idUsługa`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usługa`
--

LOCK TABLES `usługa` WRITE;
/*!40000 ALTER TABLE `usługa` DISABLE KEYS */;
INSERT INTO `usługa` VALUES (1,'Wymiana opon','Wymiana opon.',20.00,1),(2,'Wymiana klocków hamulcowych.','Naprawa polega na wymianie klocków na jednej z osi.',100.00,1),(3,'Wymiana rozrządu','Wymiana paska rozrządu wraz z napinaczami oraz opcjonalnie pompą wody.',300.00,1),(4,'Wymiana szyby czołoewj','Wycięcie starej szyby oraz wklejenie nowej.',100.00,1),(5,'Malowanie.','Malowanie elementu.',300.00,0),(6,'Wymiana amortyzatorów','Wymiana amortyzatorów z przodu',999.00,1),(8,'Wymiana szyby bocznej','Wklejenie nowej szyby',30.00,1),(9,'Wyniana kolumny mc-persona','Naprawa polega na wymianie kolumny',100.00,1),(10,'Wyniana kolumny mc-persona','Naprawa polega na wymianie kolumny',100.00,1);
/*!40000 ALTER TABLE `usługa` ENABLE KEYS */;
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
