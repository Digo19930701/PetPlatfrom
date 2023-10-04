CREATE DATABASE  IF NOT EXISTS `4a2b` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `4a2b`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: 4a2b
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `backgrounddata`
--

DROP TABLE IF EXISTS `backgrounddata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backgrounddata` (
  `backgroundId` int NOT NULL AUTO_INCREMENT,
  `orderDateTime1` timestamp NOT NULL,
  `orderDateTime2` timestamp NOT NULL,
  `orderPrice` int NOT NULL,
  `completeTime` int NOT NULL,
  `sellerId` varchar(100) NOT NULL,
  `orderSchedule` timestamp NOT NULL,
  `serviceId` varchar(200) NOT NULL,
  `quota` int NOT NULL,
  `orderId` varchar(200) NOT NULL,
  PRIMARY KEY (`backgroundId`),
  UNIQUE KEY `serviceNum` (`serviceId`),
  KEY `FK_sellerID` (`sellerId`),
  KEY `FK_orderNum` (`orderId`),
  CONSTRAINT `FK_backgroundOrder` FOREIGN KEY (`orderId`) REFERENCES `ordertable` (`orderId`),
  CONSTRAINT `FK_backgroundSeller` FOREIGN KEY (`sellerId`) REFERENCES `sellerinfo` (`sellerId`),
  CONSTRAINT `FK_backgroundService` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backgrounddata`
--

LOCK TABLES `backgrounddata` WRITE;
/*!40000 ALTER TABLE `backgrounddata` DISABLE KEYS */;
/*!40000 ALTER TABLE `backgrounddata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankaccount`
--

DROP TABLE IF EXISTS `bankaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankaccount` (
  `bankId` int NOT NULL,
  `realName` varchar(255) NOT NULL,
  `bank` varchar(255) NOT NULL,
  `region` varchar(20) NOT NULL,
  `accountName` varchar(20) NOT NULL,
  `accountNum` int NOT NULL,
  `sellerId` varchar(20) NOT NULL,
  `defaultAccount` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bankId`),
  KEY `FK_bankseller` (`sellerId`),
  CONSTRAINT `FK_bankseller` FOREIGN KEY (`sellerId`) REFERENCES `sellerinfo` (`sellerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankaccount`
--

LOCK TABLES `bankaccount` WRITE;
/*!40000 ALTER TABLE `bankaccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `bankaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banklist`
--

DROP TABLE IF EXISTS `banklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banklist` (
  `bankCode` varchar(3) NOT NULL,
  `bank` varchar(20) NOT NULL,
  PRIMARY KEY (`bankCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banklist`
--

LOCK TABLES `banklist` WRITE;
/*!40000 ALTER TABLE `banklist` DISABLE KEYS */;
INSERT INTO `banklist` VALUES ('004','臺灣銀行'),('005','臺灣土地銀行'),('006','合作金庫商業銀行'),('007','第一商業銀行'),('008','華南商業銀行'),('011','上海商業儲蓄銀行'),('012','台北冨邦商業銀行'),('013','國泰世華商業銀行'),('016','高雄銀行'),('017','兆豐國際商業銀行'),('020','日商瑞穗銀行'),('021','花旗商業銀行'),('048','王道商業銀行'),('050','臺灣中小企業銀行'),('052','渣打國際商業銀行'),('053','台中商業銀行'),('054','京城商業銀行'),('081','匯豐（台灣）商業銀行'),('101','瑞興商業銀行'),('102','華泰商業銀行'),('103','臺灣新光商業銀行'),('108','陽信商業銀行'),('118','板信商業銀行'),('147','三信商業銀行'),('700','中華郵政股份有限公司'),('803','聯邦商業銀行'),('805','遠東國際商業銀行'),('806','元大商業銀行'),('807','永豐商業銀行'),('808','玉山商業銀行'),('809','凱基商業銀行'),('810','星展（台灣）商業銀行'),('812','台新國際商業銀行'),('816','安泰商業銀行'),('822','中國信託商業銀行');
/*!40000 ALTER TABLE `banklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_table`
--

DROP TABLE IF EXISTS `book_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_table` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `bookNo` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `coverImage` longtext,
  `discount` double DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `listPrice` double DEFAULT NULL,
  `mimeType` varchar(255) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `FK_Publisher_Id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Publisher_Id` (`FK_Publisher_Id`),
  CONSTRAINT `FK_Publisher_Id` FOREIGN KEY (`FK_Publisher_Id`) REFERENCES `publisher_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_table`
--

LOCK TABLES `book_table` WRITE;
/*!40000 ALTER TABLE `book_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(50) NOT NULL,
  `serviceId` varchar(200) NOT NULL,
  `typeId` int NOT NULL,
  `petNum` int NOT NULL,
  PRIMARY KEY (`cartId`),
  KEY `FK_cartUser` (`userEmail`),
  KEY `FK_cartService` (`serviceId`),
  KEY `FK_cartType` (`typeId`),
  KEY `FK_cartPet` (`petNum`),
  CONSTRAINT `FK_cartPet` FOREIGN KEY (`petNum`) REFERENCES `petinfo` (`petNum`),
  CONSTRAINT `FK_cartService` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`),
  CONSTRAINT `FK_cartType` FOREIGN KEY (`typeId`) REFERENCES `servicetypes` (`typeId`),
  CONSTRAINT `FK_cartUser` FOREIGN KEY (`userEmail`) REFERENCES `useraccount` (`userEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_table`
--

DROP TABLE IF EXISTS `member_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_table` (
  `seqNo` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `comment` longtext,
  `email` varchar(255) DEFAULT NULL,
  `fileName` varchar(255) DEFAULT NULL,
  `memberId` varchar(255) DEFAULT NULL,
  `memberImage` longblob,
  `mimeType` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `registerTime` datetime(6) DEFAULT NULL,
  `totalAmt` double DEFAULT NULL,
  `unpaid_amount` double DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`seqNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_table`
--

LOCK TABLES `member_table` WRITE;
/*!40000 ALTER TABLE `member_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifycenter`
--

DROP TABLE IF EXISTS `notifycenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifycenter` (
  `notifyId` int NOT NULL AUTO_INCREMENT,
  `orderId` varchar(200) NOT NULL,
  `serviceId` int NOT NULL,
  `sysTime` timestamp NOT NULL,
  PRIMARY KEY (`notifyId`),
  KEY `orderNum` (`orderId`),
  KEY `serviceNum` (`serviceId`),
  CONSTRAINT `FK_centerOrder` FOREIGN KEY (`orderId`) REFERENCES `ordertable` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifycenter`
--

LOCK TABLES `notifycenter` WRITE;
/*!40000 ALTER TABLE `notifycenter` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifycenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifysetting`
--

DROP TABLE IF EXISTS `notifysetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notifysetting` (
  `notifysettingId` int NOT NULL AUTO_INCREMENT,
  `notifyNewOrder` tinyint(1) NOT NULL DEFAULT '1',
  `notifyCancelOrder` tinyint(1) NOT NULL DEFAULT '1',
  `notifyRate` tinyint(1) NOT NULL DEFAULT '1',
  `notifyAccounting` tinyint(1) NOT NULL DEFAULT '1',
  `notifyFunction` tinyint(1) NOT NULL DEFAULT '1',
  `notifyMaintain` tinyint(1) NOT NULL DEFAULT '1',
  `notifyAbnormal` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`notifysettingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifysetting`
--

LOCK TABLES `notifysetting` WRITE;
/*!40000 ALTER TABLE `notifysetting` DISABLE KEYS */;
/*!40000 ALTER TABLE `notifysetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitems` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `bookId` bigint DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `orderNo` int DEFAULT NULL,
  `publisherName` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `FK_OrderBean_orderNo` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_OrderBean_orderNo` (`FK_OrderBean_orderNo`),
  CONSTRAINT `FK_OrderBean_orderNo` FOREIGN KEY (`FK_OrderBean_orderNo`) REFERENCES `orders` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderNo` bigint NOT NULL AUTO_INCREMENT,
  `bno` varchar(255) DEFAULT NULL,
  `cancelTag` varchar(255) DEFAULT NULL,
  `invoiceTitle` varchar(255) DEFAULT NULL,
  `memberId` varchar(255) DEFAULT NULL,
  `orderDate` datetime(6) DEFAULT NULL,
  `shippingAddress` varchar(255) DEFAULT NULL,
  `shippingDate` datetime(6) DEFAULT NULL,
  `totalAmount` double DEFAULT NULL,
  PRIMARY KEY (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertable`
--

DROP TABLE IF EXISTS `ordertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordertable` (
  `orderId` varchar(200) NOT NULL,
  `userEmail` varchar(50) NOT NULL,
  `sellerId` varchar(20) NOT NULL,
  `timeline1` timestamp NOT NULL,
  `totalPrice` int NOT NULL,
  `petNum` int DEFAULT NULL,
  `serviceId` varchar(200) NOT NULL,
  `price` int NOT NULL,
  `orderDateTime1` timestamp NOT NULL,
  `orderDateTime2` timestamp NOT NULL,
  `orderMsg` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FK_orderuser` (`userEmail`),
  KEY `FK_orderseller` (`sellerId`),
  KEY `FK_orderpet` (`petNum`),
  KEY `FK_orderservice` (`serviceId`),
  CONSTRAINT `FK_orderpet` FOREIGN KEY (`petNum`) REFERENCES `petinfo` (`petNum`),
  CONSTRAINT `FK_orderseller` FOREIGN KEY (`sellerId`) REFERENCES `sellerinfo` (`sellerId`),
  CONSTRAINT `FK_orderService` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`),
  CONSTRAINT `FK_orderuser` FOREIGN KEY (`userEmail`) REFERENCES `useraccount` (`userEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertable`
--

LOCK TABLES `ordertable` WRITE;
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentId` int NOT NULL AUTO_INCREMENT,
  `orderId` varchar(200) DEFAULT NULL,
  `timeline2` timestamp NOT NULL,
  `timeline3` timestamp NOT NULL,
  `timeline4` timestamp NULL DEFAULT NULL,
  `timeline5` timestamp NULL DEFAULT NULL,
  `timeline6` timestamp NULL DEFAULT NULL,
  `timeline7` timestamp NULL DEFAULT NULL,
  `payMethod` varchar(10) NOT NULL,
  `payment` int NOT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `FK_payorder` (`orderId`),
  CONSTRAINT `FK_payOrder` FOREIGN KEY (`orderId`) REFERENCES `ordertable` (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `petinfo`
--

DROP TABLE IF EXISTS `petinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `petinfo` (
  `petNum` int NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(50) NOT NULL,
  `petId` int DEFAULT NULL,
  `petName` varchar(50) NOT NULL,
  `petClass` varchar(50) DEFAULT NULL,
  `petVariety` varchar(50) DEFAULT NULL,
  `petAge` int DEFAULT NULL,
  `petImage` mediumblob,
  `petCharacter` varchar(50) DEFAULT NULL,
  `petGender` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`petNum`),
  KEY `FK_petuser` (`userEmail`),
  CONSTRAINT `FK_petuser` FOREIGN KEY (`userEmail`) REFERENCES `useraccount` (`userEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `petinfo`
--

LOCK TABLES `petinfo` WRITE;
/*!40000 ALTER TABLE `petinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `petinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher_table`
--

DROP TABLE IF EXISTS `publisher_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher_table` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher_table`
--

LOCK TABLES `publisher_table` WRITE;
/*!40000 ALTER TABLE `publisher_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `publisher_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `reviewId` int NOT NULL AUTO_INCREMENT,
  `serviceId` varchar(200) NOT NULL,
  `userEmail` varchar(50) NOT NULL,
  `rate` int DEFAULT NULL,
  `orderComment` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `reply` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rateTime` timestamp NOT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `FK_reviewservice` (`serviceId`),
  KEY `FK_reviewuser` (`userEmail`),
  CONSTRAINT `FK_reviewService` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`),
  CONSTRAINT `FK_reviewuser` FOREIGN KEY (`userEmail`) REFERENCES `useraccount` (`userEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellerinfo`
--

DROP TABLE IF EXISTS `sellerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sellerinfo` (
  `sellerId` varchar(20) NOT NULL,
  `sellerName` varchar(20) NOT NULL,
  `sellerDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sellerPhone` char(10) NOT NULL,
  `sellerAdd` varchar(20) NOT NULL,
  `unitTime` int NOT NULL,
  `sellerImg` varchar(500) DEFAULT NULL,
  `sellerPark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sellerPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`sellerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellerinfo`
--

LOCK TABLES `sellerinfo` WRITE;
/*!40000 ALTER TABLE `sellerinfo` DISABLE KEYS */;
INSERT INTO `sellerinfo` VALUES ('SELLER1','sellerName1','sellerDesc1','0912334567','sellerAdd1',3,NULL,'Seller Park 1','sellerPassword1'),('seller2','YOIYOI寵物美容','YOIYOI寵物美容是一家專業的寵物美容沙龍，我們致力於為您的寵物提供高品質的美容服務。','0919394959','403台中市西區五權八街141號',60,'https://images.pexels.com/photos/384555/pexels-photo-384555.jpeg?auto=compress&cs=tinysrgb&w=1600','Parking 2','password2'),('seller3','ONE MORE NIGHT寵物精品沙龍','ONE MORE NIGHT寵物精品沙龍是您寵物的完美去處。我們致力於提供一流的寵物美容和護理服務，以確保您的毛茸茸的朋友看起來和感覺都最棒。我們的經驗豐富的美容師將以愛心和專業的態度照顧您的寵物，提供洗澡、修剪、美甲和皮膚護理等多種服務。我們的沙龍設施現代化且乾淨，我們使用高質量的美容產品，確保您的寵物總是保持最佳狀態。','0955655755','Address 3',45,'image3.jpg','Parking 3','password3');
/*!40000 ALTER TABLE `sellerinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `serviceName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `serviceId` varchar(100) NOT NULL,
  `sellerId` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `serviceDesc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `servicePeriod` time NOT NULL,
  `upperLimit` int NOT NULL,
  `availTime1` time NOT NULL,
  `availTime2` time NOT NULL,
  `acceptDay1` int NOT NULL,
  `acceptDay2` int NOT NULL,
  `serviceImage1` varchar(500) DEFAULT NULL,
  `serviceImage2` varchar(500) DEFAULT NULL,
  `serviceImage3` varchar(500) DEFAULT NULL,
  `serviceImage4` varchar(500) DEFAULT NULL,
  `serviceImage5` varchar(500) DEFAULT NULL,
  `monday` tinyint(1) DEFAULT '0',
  `tuesday` tinyint(1) DEFAULT '0',
  `wednesday` tinyint(1) DEFAULT '0',
  `thursday` tinyint(1) DEFAULT '0',
  `friday` tinyint(1) DEFAULT '0',
  `saturday` tinyint(1) DEFAULT '0',
  `sunday` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`serviceId`),
  KEY `FK_serviceseller` (`sellerId`),
  CONSTRAINT `FK_serviceseller` FOREIGN KEY (`sellerId`) REFERENCES `sellerinfo` (`sellerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES ('洗澡和吹乾','Service 2','seller2','BEAUTY','我們的 洗澡和吹乾 服務是為了確保您的寵物總是保持清潔、舒適和健康。我們的專業美容師會使用溫和的洗澡產品，根據您的寵物的需要來選擇適當的洗澡方式。在洗澡過程中，我們會輕柔地清潔您寵物的皮膚和毛髮，去除灰塵、污垢和過多的油脂。我們會確保水溫適中，以確保您的寵物感到舒適。\n\n洗澡結束後，我們會使用專業吹風機輕柔地吹乾您的寵物，確保其毛髮完全乾燥，避免潮濕引起的皮膚問題。我們的美容師會小心地照顧每一隻寵物，確保他們的洗澡和吹乾過程是一個愉快的體驗。\n\n洗澡和吹乾 服務不僅可以讓您的寵物保持清潔和舒適，還可以改善其皮膚和毛髮的健康狀態。無論您的寵物是小狗、貓咪還是其他種類的寵物，我們都將以愛和專業的態度照顧他們，確保他們始終保持最佳的外表和健康。','09:00:00',15,'11:00:00','16:00:00',2,4,'https://images.pexels.com/photos/1741235/pexels-photo-1741235.jpeg?auto=compress&cs=tinysrgb&w=1600','image2_2.jpg','image2_3.jpg','image2_4.jpg','image2_5.jpg',0,1,0,1,0,1,0),('Service Name 1','SERVICE1','SELLER1','BEAUTY','Service Description 1','12:34:56',3,'09:00:00','18:00:00',1,5,'image1.jpg','image2.jpg','image3.jpg','image4.jpg','image5.jpg',1,1,1,1,1,0,0),('毛髮修剪和造型','service103','seller2','BEAUTY','我們的 毛髮修剪和造型 服務旨在為您的寵物提供專業的毛髮修剪和時尚造型','10:00:00',25,'12:00:00','17:00:00',3,6,'https://images.pexels.com/photos/96428/pexels-photo-96428.jpeg?auto=compress&cs=tinysrgb&w=1600','image3_2.jpg','image3_3.jpg','image3_4.jpg','image3_5.jpg',1,1,1,1,0,0,1);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicetypes`
--

DROP TABLE IF EXISTS `servicetypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicetypes` (
  `typeId` int NOT NULL AUTO_INCREMENT,
  `serviceId` varchar(200) NOT NULL,
  `petType` varchar(100) NOT NULL,
  `spec` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`typeId`),
  KEY `FK_serviceService` (`serviceId`),
  CONSTRAINT `FK_serviceService` FOREIGN KEY (`serviceId`) REFERENCES `services` (`serviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicetypes`
--

LOCK TABLES `servicetypes` WRITE;
/*!40000 ALTER TABLE `servicetypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicetypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shoppingcart` (
  `shoppingCarId` varchar(255) NOT NULL,
  `payment` int DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `serviceImg` longblob,
  `serviceName` varchar(255) DEFAULT NULL,
  `servicePeriod` date DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `variety` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shoppingCarId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useraccount` (
  `userEmail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userPassword` varchar(20) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userGender` varchar(20) NOT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `userAdd` varchar(20) DEFAULT NULL,
  `birthDay` date NOT NULL,
  `userId` varchar(20) DEFAULT NULL,
  `userPassword2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-05  2:16:55
