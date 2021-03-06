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
-- Table structure for table `zlecenia_has_usługa`
--

DROP TABLE IF EXISTS `zlecenia_has_usługa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zlecenia_has_usługa` (
  `Zlecenia_idZlecenia` int(11) NOT NULL,
  `Usługa_idUsługa` int(11) NOT NULL,
  `Wykonano` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Zlecenia_idZlecenia`,`Usługa_idUsługa`),
  KEY `fk_Zlecenia_has_Usługa_Usługa1_idx` (`Usługa_idUsługa`),
  KEY `fk_Zlecenia_has_Usługa_Zlecenia1_idx` (`Zlecenia_idZlecenia`),
  CONSTRAINT `fk_Zlecenia_has_Usługa_Usługa1` FOREIGN KEY (`Usługa_idUsługa`) REFERENCES `usługa` (`idUsługa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Zlecenia_has_Usługa_Zlecenia1` FOREIGN KEY (`Zlecenia_idZlecenia`) REFERENCES `zlecenia` (`idZlecenia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zlecenia_has_usługa`
--

LOCK TABLES `zlecenia_has_usługa` WRITE;
/*!40000 ALTER TABLE `zlecenia_has_usługa` DISABLE KEYS */;
INSERT INTO `zlecenia_has_usługa` VALUES (1,1,0),(1,2,1),(1,3,0),(1,4,1),(2,1,0),(2,2,1),(2,3,1),(4,1,0),(4,2,0),(4,4,0);
/*!40000 ALTER TABLE `zlecenia_has_usługa` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ALLOW_INVALID_DATES,ERROR_FOR_DIVISION_BY_ZERO,TRADITIONAL,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `bazatest`.`Zlecenia_has_Usługa_AFTER_UPDATE` AFTER UPDATE ON `Zlecenia_has_Usługa` FOR EACH ROW 
Begin


END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-11 21:26:48
