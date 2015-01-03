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
-- Table structure for table `zlecenia`
--

DROP TABLE IF EXISTS `zlecenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zlecenia` (
  `idZlecenia` int(11) NOT NULL AUTO_INCREMENT,
  `DataPrzyjecia` date DEFAULT NULL,
  `DataZakonczenia` date DEFAULT NULL,
  `Koszt` float DEFAULT NULL,
  `Wykonano` tinyint(1) DEFAULT '0',
  `Samochod_idSamochod` int(11) NOT NULL,
  `Samochod_Klient_Pesel` varchar(11) NOT NULL,
  `Pracownik_Pesel` varchar(11) NOT NULL,
  `MiejsceSerwisowe_idMiejsceSerwisowe` int(11) NOT NULL,
  PRIMARY KEY (`idZlecenia`),
  KEY `fk_Zlecenia_Samochod1_idx` (`Samochod_idSamochod`,`Samochod_Klient_Pesel`),
  KEY `fk_Zlecenia_Pracownik1_idx` (`Pracownik_Pesel`),
  KEY `fk_Zlecenia_MiejsceSerwisowe1_idx` (`MiejsceSerwisowe_idMiejsceSerwisowe`),
  CONSTRAINT `fk_Zlecenia_MiejsceSerwisowe1` FOREIGN KEY (`MiejsceSerwisowe_idMiejsceSerwisowe`) REFERENCES `miejsceserwisowe` (`idMiejsceSerwisowe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zlecenia_Pracownik1` FOREIGN KEY (`Pracownik_Pesel`) REFERENCES `pracownik` (`Pesel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zlecenia_Samochod1` FOREIGN KEY (`Samochod_idSamochod`, `Samochod_Klient_Pesel`) REFERENCES `samochod` (`idSamochod`, `Klient_Pesel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zlecenia`
--

LOCK TABLES `zlecenia` WRITE;
/*!40000 ALTER TABLE `zlecenia` DISABLE KEYS */;
INSERT INTO `zlecenia` VALUES (1,'2014-02-22','2014-02-25',520,0,1,'4','2343',1),(2,'2014-02-11','2014-03-22',420,0,1,'4','2343',2),(3,'2014-03-21','2014-05-22',NULL,0,1,'4','2343',3),(4,'2015-01-01','2015-01-05',NULL,0,53675,'00000000000','2343',3),(5,'2015-01-02','2015-01-15',NULL,0,53676,'00000000000','2343',3),(6,'2014-10-01','2014-10-02',NULL,0,53675,'00000000000','2343',1),(7,'2014-11-11','2014-12-01',NULL,0,53675,'00000000000','2343',2);
/*!40000 ALTER TABLE `zlecenia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-03 18:07:23
