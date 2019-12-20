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
-- Table structure for table `CreateVillageFailedDetails`
--

DROP TABLE IF EXISTS `CreateVillageFailedDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CreateVillageFailedDetails` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TehsilId` int(11) DEFAULT NULL,
  `ErrorDetail` varchar(1024) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2039 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CreateVillageFailedDetails`
--

LOCK TABLES `CreateVillageFailedDetails` WRITE;
/*!40000 ALTER TABLE `CreateVillageFailedDetails` DISABLE KEYS */;
INSERT INTO `CreateVillageFailedDetails` VALUES (123,485,'yachavaram'),(615,668,'sho-somavaram'),(616,688,'mpen-bl-i-and-ii'),(617,735,'empong-mpong'),(618,757,'p-h-q-officers-colony'),(619,840,'daukha-nagar-1'),(620,843,'saidpur-pt-i'),(621,843,'saidpur-pt-ii'),(622,843,'saidpur-pt-iii'),(623,844,'naraindhar-t-e'),(624,847,'kumbhirgram-t-e'),(625,853,'no-2-bezpara'),(626,854,'niz-sarabari'),(627,860,'owani-gaon'),(674,954,'niz-banekuchi'),(686,1127,'itahri'),(687,1136,'khiri'),(689,1289,'ajnaura-b-o'),(691,1496,'arazi-nankar'),(811,2031,'shopora-a'),(812,2031,'shopora-b'),(813,2031,'zaldoora-a'),(814,2031,'zaldoora-b-reshipora'),(818,2056,'ahmeds-guest-house'),(819,2056,'indira-nagar-a'),(820,2056,'indira-nagar-sec-c'),(821,2232,'langurahi'),(822,2337,'bandalli-a-beat'),(823,2337,'bandalli-b-beat'),(824,2337,'bejjalane-a-beat'),(825,2337,'bijjalaneb-beat'),(826,2337,'budabalu-a-beat'),(827,2337,'budabalu-b-beat'),(828,2337,'bylore-east-beat'),(829,2337,'bylore-west-beat'),(830,2337,'gundal-a-beat'),(831,2337,'gundal-b-beat'),(832,2337,'indiganatha-a-beat'),(833,2337,'indiganatha-b-beat'),(834,2337,'kothanur-a-beat'),(835,2337,'kothanur-b-beat'),(836,2337,'martalli-a-beat'),(837,2337,'martalli-b-beat'),(838,2337,'mavathur-a-beat'),(839,2337,'mavathur-b-beat'),(840,2337,'minnya-a-beat'),(841,2337,'minnya-b-beat'),(842,2337,'saggayam-a-beat'),(843,2337,'saggayam-b-beat'),(844,2337,'saggayam-c-beat'),(845,2337,'satyamangala-a-beat'),(846,2337,'satyamangala-b-beat'),(919,2511,'erimayur-i'),(921,2567,'bharatpura'),(922,2567,'chopra'),(923,2567,'damotipura'),(924,2567,'deori'),(925,2567,'imaliya'),(926,2567,'jamuniya'),(927,2567,'khero'),(928,2567,'khuwa'),(929,2567,'lalguwan'),(930,2567,'mara'),(931,2567,'matipura'),(932,2567,'pali'),(933,2567,'patan'),(934,2567,'purwa'),(935,2567,'raidaspura'),(936,2567,'ratanpura'),(937,2567,'surai'),(938,2567,'tapariyan'),(939,2567,'tapariyan'),(940,2567,'tikri'),(1047,2812,'warkhed-bk'),(1176,3196,'gonda-songgitchamgiri'),(1177,3228,'bamunpukhuria'),(1178,3228,'bamunpukhurib'),(1179,3228,'diphupar-a'),(1180,3228,'diphupar-b'),(1181,3228,'puranabazara'),(1182,3228,'puranabazarb'),(1183,3228,'seithekemaa'),(1184,3228,'seithekemac'),(1185,3228,'toluvi-b'),(1186,3229,'keyavi-a'),(1187,3229,'pukhahe-keyavi-b'),(1188,3232,'zuikhu-a'),(1189,3232,'zuikhu-b'),(1190,3234,'kiyezhua'),(1191,3234,'kiyezhub'),(1192,3238,'nkio-b'),(1193,3238,'pellhang-b'),(1194,3238,'vongkithemb'),(1195,3252,'akumen-c'),(1196,3252,'yajang-a'),(1197,3252,'yajang-b'),(1198,3252,'yajang-c'),(1199,3255,'anaki-c'),(1200,3255,'kangtsung-c-soyimlenden'),(1201,3255,'kangtsung-d-aobenzu'),(1202,3270,'jalukie-b'),(1203,3270,'lilen-b'),(1204,3292,'panso-a'),(1205,3292,'panso-b'),(1206,3293,'shothumi-a'),(1207,3293,'shothumi-b'),(1208,3296,'rurur-a-b'),(1209,3296,'sukiur-a-b'),(1210,3311,'achikuchu-a'),(1211,3311,'achikuchu-b'),(1212,3311,'khumishi-a'),(1213,3311,'khumishi-b'),(1214,3319,'kawoto-a'),(1215,3319,'kawoto-b'),(1216,3384,'shortts-island'),(1238,3510,'balapaju'),(1239,3540,'raighati-r-f'),(1240,3553,'nilakanthapur'),(1241,3556,'gobardhanpur'),(1242,3576,'kadaguma'),(1257,3796,'jhadol'),(1258,3796,'ramgarh'),(1283,3817,'amli-para'),(1284,3817,'baori-para'),(1287,3928,'jalor-b'),(1291,3983,'amrati-ka-badia'),(1292,3983,'biliyawas'),(1293,3983,'kaladeh'),(1294,3983,'kherata'),(1295,3983,'palra'),(1296,3983,'rajwa'),(1297,3983,'sirola'),(1298,3983,'thoriya'),(1426,4066,'p-gollahalli'),(1454,4124,'spencers-road'),(1455,4129,'commissioners-road'),(1456,4129,'peytons-road'),(1457,4129,'st-marys-hill'),(1459,4162,'anna-nagar-c'),(1464,4205,'kanappa-colony'),(1465,4223,'mel-g-marathur'),(1466,4235,'gudipalli'),(1467,4235,'m-g-r-nagar'),(1469,4246,'nedumanur'),(1494,4533,'ngos-colony-ndbo'),(1509,4741,'rentars-colony'),(1569,4996,'rampur-t-ghunchai'),(1570,5004,'gauchara-llllll'),(2038,5432,'henrys-island');
/*!40000 ALTER TABLE `CreateVillageFailedDetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-20 23:45:47
