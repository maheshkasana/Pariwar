-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: Pariwar
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `UserSubcaste`
--

DROP TABLE IF EXISTS `UserSubcaste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserSubcaste` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserSubcasteName` varchar(50) DEFAULT NULL,
  `UserCasteId` int(11) DEFAULT NULL,
  `About` varchar(256) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_UserCasteId_UserCaste_Id` (`UserCasteId`),
  CONSTRAINT `fk_UserCasteId_UserCaste_Id` FOREIGN KEY (`UserCasteId`) REFERENCES `usercaste` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserSubcaste`
--

LOCK TABLES `UserSubcaste` WRITE;
/*!40000 ALTER TABLE `UserSubcaste` DISABLE KEYS */;
INSERT INTO `UserSubcaste` VALUES (1,'Kasana',1,'Nothig to Say',0),(2,'Khatana',1,'Nothig to Say',0),(3,'Dayama',1,'Nothig to Say',0),(4,'Langdi',1,'Nothig to Say',0),(5,'Tungad',1,'Nothig to Say',0),(6,'kasana',1,NULL,1),(8,'Jharakhand',15,NULL,1);
/*!40000 ALTER TABLE `UserSubcaste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-20 23:45:50
