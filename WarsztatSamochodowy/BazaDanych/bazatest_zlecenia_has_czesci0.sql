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
-- Table structure for table `zlecenia_has_czesci`
--

DROP TABLE IF EXISTS `zlecenia_has_czesci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zlecenia_has_czesci` (
  `Zlecenia_idZlecenia` int(11) NOT NULL,
  `Czesci_idCzesci` int(11) NOT NULL,
  `Ilosc` int(11) NOT NULL,
  PRIMARY KEY (`Zlecenia_idZlecenia`,`Czesci_idCzesci`),
  KEY `fk_Zlecenia_has_Czesci_Czesci1_idx` (`Czesci_idCzesci`),
  KEY `fk_Zlecenia_has_Czesci_Zlecenia1_idx` (`Zlecenia_idZlecenia`),
  CONSTRAINT `fk_Zlecenia_has_Czesci_Czesci1` FOREIGN KEY (`Czesci_idCzesci`) REFERENCES `czesci` (`idCzesci`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zlecenia_has_Czesci_Zlecenia1` FOREIGN KEY (`Zlecenia_idZlecenia`) REFERENCES `zlecenia` (`idZlecenia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zlecenia_has_czesci`
--

LOCK TABLES `zlecenia_has_czesci` WRITE;
/*!40000 ALTER TABLE `zlecenia_has_czesci` DISABLE KEYS */;
INSERT INTO `zlecenia_has_czesci` VALUES (4,2,2),(4,4,5),(4,5,1);
/*!40000 ALTER TABLE `zlecenia_has_czesci` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-11 21:26:49
