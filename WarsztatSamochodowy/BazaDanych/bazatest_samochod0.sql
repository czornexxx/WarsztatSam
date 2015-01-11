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
-- Table structure for table `samochod`
--

DROP TABLE IF EXISTS `samochod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `samochod` (
  `idSamochod` int(11) NOT NULL AUTO_INCREMENT,
  `Klient_Pesel` varchar(11) NOT NULL,
  `Marka` varchar(45) DEFAULT NULL,
  `Model` varchar(45) DEFAULT NULL,
  `NumerRej` varchar(10) DEFAULT NULL,
  `Rok` date DEFAULT NULL,
  PRIMARY KEY (`idSamochod`,`Klient_Pesel`),
  UNIQUE KEY `NumerRej_UNIQUE` (`NumerRej`),
  KEY `fk_Samochod_Klient1_idx` (`Klient_Pesel`),
  CONSTRAINT `fk_Samochod_Klient1` FOREIGN KEY (`Klient_Pesel`) REFERENCES `klient` (`Pesel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=53677 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `samochod`
--

LOCK TABLES `samochod` WRITE;
/*!40000 ALTER TABLE `samochod` DISABLE KEYS */;
INSERT INTO `samochod` VALUES (1,'4','Fiat','Stilo','2432','2004-02-02'),(53675,'00000000000','Fiat','Bravo','100','2004-02-02'),(53676,'00000000000','Fiat','Seicento','101','2002-01-01');
/*!40000 ALTER TABLE `samochod` ENABLE KEYS */;
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
