CREATE DATABASE  IF NOT EXISTS `food` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `food`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: food
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `saladdressing`
--

DROP TABLE IF EXISTS `saladdressing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saladdressing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `proteins` double NOT NULL,
  `fats` double NOT NULL,
  `carbs` double NOT NULL,
  `energy` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saladdressing`
--

LOCK TABLES `saladdressing` WRITE;
/*!40000 ALTER TABLE `saladdressing` DISABLE KEYS */;
INSERT INTO `saladdressing` VALUES (1,'Vegetable oil','simple',0,100,0,900),(2,'Olive oil','simple',0,100,0,900),(3,'Sour cream 10%','simple',2.8,10,3.1,110),(4,'Sour cream 20%','simple',2.5,20,2.9,200),(5,'Lemon juice','simple',0.9,0.1,3,16),(6,'Mayo','simple',3.1,67,2.6,624),(7,'Greek yogurt','simple',5,3.2,3.5,66),(8,'Sesame ginger','compound',0.6,13.5,10.5,165),(9,'Balsamic vinaigrette','compound',0,54,1,498),(10,'Avocado lime','compound',3,21,7.5,225),(11,'Lemon vinaigrette','compound',0,40.5,9,400),(12,'Honey mustard','compound',0,27,40.5,400),(13,'Greek yogurt ranch','compound',3,6,6,90),(14,'Apple cider vinaigrette','compound',0,36,3,336),(15,'Ginger turmeric','compound',0,54,7.5,516),(16,'Red Wine vinegar','simple',0,0,6,14),(17,'Balsamic vinegar','simple',0,0,17,88);
/*!40000 ALTER TABLE `saladdressing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vegetables`
--

DROP TABLE IF EXISTS `vegetables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vegetables` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `proteins` double NOT NULL,
  `fats` double NOT NULL,
  `carbs` double NOT NULL,
  `energy` double NOT NULL,
  `fibre` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vegetables`
--

LOCK TABLES `vegetables` WRITE;
/*!40000 ALTER TABLE `vegetables` DISABLE KEYS */;
INSERT INTO `vegetables` VALUES (1,'Cauliflower Boiled','FLOWER',2.9,0.9,2.1,28.1,1.6),(2,'Broccoli Boiled','FLOWER',3.1,0.8,1.1,24,7),(3,'Artichoke','FLOWER',3.3,0.2,10.5,57,5.4),(4,'Spinach','LEAFY',2.8,0.8,1.6,24.8,2.1),(5,'Cabbage Boiled','LEAFY',1.2,0.2,5,26.6,2.1),(6,'Lettuce','LEAFY',1.1,0.3,1.8,14.3,1.2),(7,'Brussels Sprouts Boiled','LEAFY',3,1.2,3,34.8,3.3),(8,'Kale Boiled','LEAFY',2.4,1.1,1,23.5,2.8),(9,'Watercress ','LEAFY',3,1,0.4,22.6,1.5),(10,'Potato Boiled','TUBER',1.8,0.1,17,76.1,1.2),(11,'Sweet Potato Boiled','TUBER',1.1,0.3,21,91.1,2.3),(12,'Carrot Boiled','ROOT',0.6,0.4,4.4,23.6,2.3),(13,'Radish','ROOT',0.7,0.2,1.9,12.2,0.9),(14,'Beet Boiled','ROOT',1.7,0.18,10,48.42,2),(15,'Onion','BULB',1.2,0.2,8,38.6,1.3),(16,'Shallot','BULB',6,0.1,12,72.9,3.2),(17,'Garlic','BULB',6.5,0.5,30,150.5,0.2),(18,'Springonion','BULB',2,0.5,3,24.5,1.5),(19,'Fennel Boiled','BULB',0.9,0.2,1.5,11.4,2.3),(20,'Asparagus','STEM',2.9,0.6,1.9,24.6,1.7),(21,'Celery','STEM',0.5,0.2,0.9,7.4,1),(22,'Leek Boiled','STEM',1.2,0.7,2.6,21.5,1.7),(23,'Tomatoes','FRUIT',0.9,0.2,3.9,21,1.2),(24,'Cucumbers','FRUIT',0.7,0.1,1.5,9.7,0.6),(25,'Tomato Cherry','FRUIT',0.7,0.3,3,17.5,0.5),(26,'Bellpepper','FRUIT',0.8,0.3,5.3,27.1,1.3),(27,'Avocado','FRUIT',2,15,8.5,177,7),(28,'Peas','POD',6,1,9.7,71.8,4.6),(29,'Beans','POD',7.9,0.6,11.7,83.8,6.5),(30,'Peanut','POD',26,49,16,609,8.5);
/*!40000 ALTER TABLE `vegetables` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-27 15:05:26
