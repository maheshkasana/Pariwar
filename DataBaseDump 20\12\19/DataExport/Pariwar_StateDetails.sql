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
-- Table structure for table `StateDetails`
--

DROP TABLE IF EXISTS `StateDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `StateDetails` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CountryId` int(11) NOT NULL,
  `StateName` varchar(30) NOT NULL,
  `StateCode` varchar(30) DEFAULT NULL,
  `Flag` int(11) DEFAULT NULL,
  `About` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_CountryId_CountryDetails_Id` (`CountryId`),
  CONSTRAINT `fk_CountryId_CountryDetails_Id` FOREIGN KEY (`CountryId`) REFERENCES `countrydetails` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `StateDetails`
--

LOCK TABLES `StateDetails` WRITE;
/*!40000 ALTER TABLE `StateDetails` DISABLE KEYS */;
INSERT INTO `StateDetails` VALUES (13,1,'Andaman And Nicobar Islands','andaman-and-nicobar-islands',0,NULL),(14,1,'Andhra Pradesh','andhra-pradesh',0,NULL),(15,1,'Arunachal Pradesh','arunachal-pradesh',0,NULL),(16,1,'Assam','assam',0,NULL),(17,1,'Bihar','bihar',0,NULL),(18,1,'Chandigarh','chandigarh',0,NULL),(19,1,'Chattisgarh','chattisgarh',0,NULL),(20,1,'Dadra And Nagar Haveli','dadra-and-nagar-haveli',0,NULL),(21,1,'Daman And Diu','daman-and-diu',0,NULL),(22,1,'Delhi','delhi',0,NULL),(23,1,'Goa','goa',0,NULL),(24,1,'Gujarat','gujarat',0,NULL),(25,1,'Haryana','haryana',0,NULL),(26,1,'Himachal Pradesh','himachal-pradesh',0,NULL),(27,1,'Jammu And Kashmir','jammu-and-kashmir',0,NULL),(28,1,'Jharkhand','jharkhand',0,NULL),(29,1,'Karnataka','karnataka',0,NULL),(30,1,'Kerala','kerala',0,NULL),(31,1,'Lakshadweep','lakshadweep',0,NULL),(32,1,'Madhya Pradesh','madhya-pradesh',0,NULL),(33,1,'Maharashtra','maharashtra',0,NULL),(34,1,'Manipur','manipur',0,NULL),(35,1,'Meghalaya','meghalaya',0,NULL),(36,1,'Madhya Pradesh','mizoram',0,NULL),(37,1,'Nagaland','nagaland',0,NULL),(38,1,'Odisha','odisha',0,NULL),(39,1,'Pondicherry','pondicherry',0,NULL),(40,1,'Punjab','punjab',0,NULL),(41,1,'Rajasthan','rajasthan',0,NULL),(42,1,'Sikkim','sikkim',0,NULL),(43,1,'Tamil Nadu','tamil-nadu',0,NULL),(44,1,'Telangana','telangana',0,NULL),(45,1,'Tripura','tripura',0,NULL),(46,1,'Uttar Pradesh','uttar-pradesh',0,NULL),(47,1,'Uttarakhand','uttarakhand',0,NULL),(48,1,'West Bengal','west-bengal',0,NULL),(49,1,'ladakh','Ladakh',0,NULL);
/*!40000 ALTER TABLE `StateDetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-20 23:45:49
