-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: estac02
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

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
-- Table structure for table `tbl_patio`
--

DROP TABLE IF EXISTS `tbl_patio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_patio` (
  `id_saida` int(11) NOT NULL AUTO_INCREMENT,
  `dataSaida` date DEFAULT NULL,
  `horaSaida` time DEFAULT NULL,
  `total_paga` varchar(45) DEFAULT NULL,
  `id_veiculo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_saida`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_patio`
--

LOCK TABLES `tbl_patio` WRITE;
/*!40000 ALTER TABLE `tbl_patio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_patio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(15) DEFAULT NULL,
  `tbl_senha` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_veiculo`
--

DROP TABLE IF EXISTS `tbl_veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_veiculo` (
  `id_veiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(12) DEFAULT NULL,
  `dataEntrada` date DEFAULT NULL,
  `horaEntrada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_veiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_veiculo`
--

LOCK TABLES `tbl_veiculo` WRITE;
/*!40000 ALTER TABLE `tbl_veiculo` DISABLE KEYS */;
INSERT INTO `tbl_veiculo` VALUES (1,'tre-3585',NULL,NULL),(2,'TES-4245','2018-08-29',NULL),(3,'TRE-3456','2018-08-29',NULL),(4,'TRG-9987','2018-08-30',NULL),(5,'YHF-6679','2018-08-30',NULL),(6,'YHF-6679','2018-08-30',NULL),(7,'YHF-6679','2018-08-30',NULL),(8,'Teste','2018-08-30',NULL),(9,NULL,NULL,NULL),(10,NULL,NULL,NULL),(11,NULL,NULL,NULL),(12,NULL,NULL,NULL),(13,'OUT3333',NULL,NULL),(14,'OOP1122',NULL,NULL),(15,NULL,'2018-09-04',NULL),(16,'Teste','2018-09-04',NULL),(17,'Teste02','2018-09-04',NULL),(18,'Teste3','2018-09-04',NULL),(19,'Teste4','2018-09-04',NULL),(20,'Teste05','2018-09-04',NULL),(21,'Teste05','2018-09-04',NULL),(22,'Teste06','2018-09-04',NULL),(23,'Teste07','2018-09-04',NULL),(24,'Teste08','2018-09-04',NULL),(25,'Teste09','2018-09-04',NULL),(26,'Teste10','2018-09-04',NULL),(27,'Teste11','2018-09-04',NULL),(28,'Teste12','2018-09-04',NULL),(29,'Teste13','2018-09-04',NULL),(30,'Test15','2018-09-04',NULL),(31,'Test15','2018-09-04',NULL),(32,'Test15','2018-09-04',NULL),(33,'Test16','2018-09-04',NULL),(34,'Teste18','2018-09-04',NULL),(35,'Teste19','2018-09-04',NULL),(36,'Test20','2018-09-04',NULL),(37,'Test21','2018-09-04',NULL),(38,'test22','2018-09-04',NULL),(39,'test25','2018-09-04',NULL),(40,'TEST26','2018-09-04',NULL),(41,'tESTE30','2018-09-04',NULL),(42,'tESTE31','2018-09-04',NULL),(43,'TEST33','2018-09-04',NULL),(44,NULL,'2018-09-04',NULL),(45,'TEST34','2018-09-04',NULL),(46,'tESTE31','2018-09-04',NULL),(47,'Teste32','2018-09-04',NULL),(48,'TESTE34','2018-09-04',NULL),(49,'TESTE35','2018-09-04',NULL),(50,'TESTE36','2018-09-04',NULL),(51,'TESTE40','2018-09-04',NULL),(52,'TESTE34','2018-09-04',NULL),(53,'TESTE42','2018-09-04',NULL),(54,NULL,'2018-09-04',NULL),(55,'TESTE44','2018-09-04',NULL),(56,'TESTE46','2018-09-04',NULL);
/*!40000 ALTER TABLE `tbl_veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-04 18:05:38
