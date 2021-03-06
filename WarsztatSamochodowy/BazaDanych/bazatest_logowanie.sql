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
-- Table structure for table `logowanie`
--

DROP TABLE IF EXISTS `logowanie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logowanie` (
  `IdUzytkownika` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(45) DEFAULT NULL,
  `Haslo` varchar(45) DEFAULT NULL,
  `Uprawnienia` int(11) DEFAULT NULL,
  `IdKlient` varchar(11) DEFAULT NULL,
  `IdPracownik` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`IdUzytkownika`),
  KEY `fk_Logowanie_Pracownik1_idx` (`IdPracownik`),
  KEY `fk_Logowanie_Klient_idx` (`IdKlient`),
  CONSTRAINT `fk_Logowanie_Klient` FOREIGN KEY (`IdKlient`) REFERENCES `klient` (`Pesel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logowanie_Pracownik1` FOREIGN KEY (`IdPracownik`) REFERENCES `pracownik` (`Pesel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logowanie`
--

LOCK TABLES `logowanie` WRITE;
/*!40000 ALTER TABLE `logowanie` DISABLE KEYS */;
INSERT INTO `logowanie` VALUES (0,'admin','admin',0,NULL,'11111111111'),(1,'test','test',5,'00000000000',NULL),(2,'prac','prac',4,NULL,NULL),(3,'22222222222','22222222222',5,'22222222222',NULL),(4,'33333333333','33333333333',5,'33333333333',NULL);
/*!40000 ALTER TABLE `logowanie` ENABLE KEYS */;
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
