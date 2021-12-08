-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: rentcar
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`account`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES ('黄雯','男','admin1','123456'),('黎莹','女','admin2','123456'),('徐川','男','admin3','123456'),('刘可','女','admin4','123456'),('王雪','女','admin5','123456');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buses`
--

DROP TABLE IF EXISTS `buses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buses` (
  `flag` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vehicleId` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `brand` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `seat` int DEFAULT NULL,
  `rent` float DEFAULT NULL,
  `date` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`vehicleId`),
  UNIQUE KEY `vehicleId_UNIQUE` (`vehicleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buses`
--

LOCK TABLES `buses` WRITE;
/*!40000 ALTER TABLE `buses` DISABLE KEYS */;
INSERT INTO `buses` VALUES ('1','京6566754','金杯',16,800,'0'),('1','京8696997','金龙',16,800,'0'),('1','京8696998','金龙',34,1500,'0'),('1','京9696996','金杯',34,1500,'0'),('1','京A-10SC1','宇通',16,1200,'0'),('1','京A-78BNL','宇通',16,1200,'0'),('1','京B-25JBD','宇通',16,1200,'0'),('1','京B-DBN45','宇通',16,1200,'0'),('1','京B-DDC51','宇通',16,1200,'0'),('1','京B-FQW41','宇通',16,1200,'0'),('1','京B-H78NL','宇通',16,1200,'0'),('1','京B-I74VF','宇通',16,1200,'0'),('1','京B-NML54','宇通',16,1200,'0'),('1','京C-SXB41','宇通',16,1200,'0'),('1','川A-N12B4','金杯',24,1000,'0'),('1','川B-01SX5','沃尔沃',24,1300,'0'),('1','川B-2S5XV','沃尔沃',24,1300,'0'),('1','川B-SFKV5','沃尔沃',24,1300,'0'),('1','川B-SL5X1','沃尔沃',24,1250,'0'),('1','川B-VFC52','沃尔沃',24,1300,'0'),('1','川B-XS1C0','沃尔沃',24,1300,'0'),('1','川S-75862','东风',24,1300,'0');
/*!40000 ALTER TABLE `buses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `flag` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vehicleId` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `brand` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `rent` float DEFAULT NULL,
  `date` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`vehicleId`),
  UNIQUE KEY `vehicleId_UNIQUE` (`vehicleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES ('1','京CNY3284','宝马','550i',600,'0'),('1','京NT37465','别克','林荫大道',300,'0'),('1','京NT96968','别克','GL8',600,'0'),('1','京NY28588','宝马','X6',800,'0'),('1','川A-2Z0S5','宝马','550i',600,'0'),('1','川A-58CDJ','宝马','550i',600,'0'),('1','川A-88888','奥迪','Q7',750,'0'),('1','川A-CKD58','宝马','550i',600,'0'),('1','川A-H2S12','奥迪','Q3',500,'0'),('1','川A-S0Z21','宝马','550i',600,'0'),('202031130031','川A-S5Z8S','宝马','550i',600,'2021-12-03 16:10:26'),('1','川A-XD4SX','宝马','550i',600,'0'),('1','川A-XT42G','宝马','550i',600,'0'),('1','川A-ZAC51','宝马','550i',600,'0'),('1','川S-1S5Z8','奥迪','Q7',750,'0'),('1','川S-A7NJ0','奥迪','Q7',750,'0'),('202031061355','川S-BX098','奥迪','Q7',750,'2021-12-03 16:13:41'),('1','川S-H4N5S','奥迪','Q7',750,'0'),('1','川S-H4NB8','奥迪','Q7',750,'0'),('1','川S-H4O5P','奥迪','Q7',750,'0'),('1','川S-HG452','奥迪','Q7',750,'0'),('1','川S-HW123','宝马','X6',850,'0'),('1','川S-J56NB8','奥迪','Q7',750,'0'),('1','川S-JUNH2','奥迪','Q7',750,'0'),('1','川S-UHNL5','奥迪','Q7',750,'0'),('1','睆A-AB485','奥拓','A1',350,'0');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `income` (
  `time` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `vehicleId` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `days` int DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `income`
--

LOCK TABLES `income` WRITE;
/*!40000 ALTER TABLE `income` DISABLE KEYS */;
INSERT INTO `income` VALUES ('2021-11-26 18:14:21','京CNY3284',0,0),('2021-11-29 18:20:03','京GD53456',3,2400),('2021-11-29 23:12:46','京GD53456',1,800),('2021-12-03 16:10:13','川S-75862',1,1300),('2021-12-03 16:13:32','京NT37465',1,300),('2021-12-03 17:21:29','川S-75862',0,0),('2021-12-03 17:22:38','川A-58CDJ',0,0);
/*!40000 ALTER TABLE `income` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_data`
--

DROP TABLE IF EXISTS `other_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `other_data` (
  `number` int NOT NULL,
  `money` float DEFAULT NULL,
  `super_password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_data`
--

LOCK TABLES `other_data` WRITE;
/*!40000 ALTER TABLE `other_data` DISABLE KEYS */;
INSERT INTO `other_data` VALUES (1,4800,'hw1415821217');
/*!40000 ALTER TABLE `other_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trucks`
--

DROP TABLE IF EXISTS `trucks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trucks` (
  `flag` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vehicleId` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `brand` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tonnage` float DEFAULT NULL,
  `rent` float DEFAULT NULL,
  `date` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`vehicleId`),
  UNIQUE KEY `vehicleId_UNIQUE` (`vehicleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trucks`
--

LOCK TABLES `trucks` WRITE;
/*!40000 ALTER TABLE `trucks` DISABLE KEYS */;
INSERT INTO `trucks` VALUES ('1','京D-HVO56','东风',20,800,'0'),('1','京GD53456','东风',20,800,'0'),('1','京GD56577','解放',10,700,'0'),('1','川A-5D1C2','解放',30,1000,'0'),('1','川A-8W4D1','解放',10,700,'0'),('1','川A-A20D1','解放',10,700,'0'),('1','川A-B5D21','解放',10,700,'0'),('1','川A-MJH2G','解放',20,850,'0'),('1','川A-UH54D','解放',10,700,'0'),('202031061398','川A-WE120','解放',20,850,'2021-12-02 14:26:07'),('1','川D-NBO56','东风',20,800,'0'),('1','赣A-B5X2A','东风',20,800,'0'),('1','赣D-HVO56','东风',20,800,'0'),('1','赣D-HXK54','东风',30,900,'0'),('1','赣D-SJ523','东风',20,800,'0'),('1','赣D-SJ58Z','东风',30,900,'0');
/*!40000 ALTER TABLE `trucks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_rent` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `balance` float DEFAULT NULL,
  PRIMARY KEY (`account`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('周英','女','202031061298','123456','0',500),('曹林','男','202031061310','123456','0',450),('马秋婷','女','202031061355','123456','川S-BX098',10100),('黄雯','男','202031061360','123456','0',0),('曾华','男','202031061361','123456','0',850),('王丽','女','202031061362','123456','0',1000),('李素素','女','202031061363','123456','0',750),('黄一秋','男','202031061364','123456','0',900),('刘可','女','202031061366','123456','0',1500),('徐川','男','202031061374','123456','0',8000),('周强','男','202031061387','123456','0',0),('孙荣','男','202031061398','123456','川A-WE120',950),('王雪','女','202031130030','123456','0',9000),('黎莹','女','202031130031','123456','川A-S5Z8S',700),('王雨雪','女','202031130125','123456','0',1050),('王晓新','女','202031135632','123456','0',950),('黄丽玲','女','202031136321','123456','0',650),('李晓瑞','女','202031137895','123456','0',850),('张思婷','女','202031139841','123456','0',750);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-03 18:21:38
