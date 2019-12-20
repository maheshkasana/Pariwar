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
-- Table structure for table `UserCaste`
--

DROP TABLE IF EXISTS `UserCaste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserCaste` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserCasteName` varchar(50) DEFAULT NULL,
  `UserReligionId` int(11) DEFAULT NULL,
  `About` varchar(256) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_UserReligionId_UserReligion_Id` (`UserReligionId`),
  CONSTRAINT `fk_UserReligionId_UserReligion_Id` FOREIGN KEY (`UserReligionId`) REFERENCES `userreligion` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserCaste`
--

LOCK TABLES `UserCaste` WRITE;
/*!40000 ALTER TABLE `UserCaste` DISABLE KEYS */;
INSERT INTO `UserCaste` VALUES (1,'Gurjar',13,'Nothig to Say',0),(2,'Rajput',13,'Nothig to Say',0),(3,'Jaat',13,'Nothig to Say',0),(4,'Meena',13,'Nothig to Say',0),(5,'Bishnoi',13,'Nothig to Say',0),(6,'Pathan',17,'Nothig to Say',0),(7,'Shiekh',17,'Nothig to Say',0),(8,'Khan',17,'Nothig to Say',0),(9,'Kunjra',17,'Nothig to Say',0),(10,'Ansari',17,'Nothig to Say',0),(11,'Digambar',14,'Nothig to Say',0),(12,'Shwetambar',14,'Nothig to Say',0),(14,'Mahesh',13,NULL,1),(15,'Jharakhand',22,NULL,1);
/*!40000 ALTER TABLE `UserCaste` ENABLE KEYS */;
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
