-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: shield_photos_task_db
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
-- Table structure for table `table_photo_data`
--

DROP TABLE IF EXISTS `table_photo_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `table_photo_data` (
  `table_id` int NOT NULL AUTO_INCREMENT,
  `download_datetime` datetime DEFAULT NULL,
  `file_size` mediumtext,
  `photo_id` int DEFAULT NULL,
  `album_id` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_photo_data`
--

LOCK TABLES `table_photo_data` WRITE;
/*!40000 ALTER TABLE `table_photo_data` DISABLE KEYS */;
INSERT INTO `table_photo_data` VALUES (57,'2021-07-19 20:56:31','10888',1,1,'amazing island view','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_1_amazing island view.jpeg'),(58,'2021-07-19 20:56:31','65332',2,1,'Starry Blue Night blue sky night nature stars','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_2_Starry Blue Night blue sky night nature stars.jpeg'),(59,'2021-07-19 20:56:32','65332',3,1,'A View From The Google NYC Deck','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_3_A View From The Google NYC Deck.jpeg'),(60,'2021-07-19 20:56:32','76570',4,1,'sea beside rock formation during golden hour photo','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_4_sea beside rock formation during golden hour photo.jpeg'),(61,'2021-07-19 20:56:33','59982',5,1,'mount fuji','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_5_mount fuji.jpeg'),(62,'2021-07-19 20:56:33','74799',6,1,'Chicago view','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_6_Chicago view.jpeg'),(63,'2021-07-19 20:56:33','12775',7,1,'NYC','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_7_NYC.jpeg'),(64,'2021-07-19 20:56:34','138601',8,1,'Panoramic view of London','C:\\Users\\baraky\\Downloads\\Photostask\\src\\main\\resources\\downloadedFilesStorage\\1_8_Panoramic view of London.jpeg');
/*!40000 ALTER TABLE `table_photo_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-19 21:06:40
