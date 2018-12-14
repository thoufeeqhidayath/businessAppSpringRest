CREATE DATABASE  IF NOT EXISTS `businessapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `businessapp`;
-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: businessapp
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `purchase_invoice`
--

DROP TABLE IF EXISTS `purchase_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase_invoice` (
  `purchase_no` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_date` date DEFAULT NULL,
  `supplier_code` int(11) DEFAULT NULL,
  `bank_code` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `delete_flag` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`purchase_no`),
  KEY `supplier_code` (`supplier_code`),
  KEY `bank_code` (`bank_code`),
  CONSTRAINT `purchase_invoice_ibfk_1` FOREIGN KEY (`supplier_code`) REFERENCES `supplier` (`supplier_code`),
  CONSTRAINT `purchase_invoice_ibfk_2` FOREIGN KEY (`supplier_code`) REFERENCES `supplier` (`supplier_code`),
  CONSTRAINT `purchase_invoice_ibfk_3` FOREIGN KEY (`bank_code`) REFERENCES `bank_table` (`bank_code`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_invoice`
--

LOCK TABLES `purchase_invoice` WRITE;
INSERT INTO `purchase_invoice` VALUES (2,'2018-11-28',1,1,2,NULL),(3,'2018-11-28',1,1,0,NULL),(4,'2018-11-29',2,1,0,NULL),(5,'2018-11-29',2,1,0,NULL),(6,'2018-11-29',1,1,0,NULL),(7,'2018-11-29',1,1,0,NULL),(8,'2018-11-29',1,1,0,NULL),(9,'2018-11-29',2,1,0,NULL),(10,'2018-11-29',1,1,0,NULL),(11,'2018-11-29',1,1,0,NULL),(12,'2018-11-29',1,1,0,NULL),(13,'2018-11-29',1,1,0,NULL),(14,'2018-11-29',1,1,0,NULL),(15,'2018-11-29',1,1,0,NULL);
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_purchase_invoice` AFTER UPDATE ON `purchase_invoice` FOR EACH ROW begin
update supplier set balance=balance+new.total where supplier_code=new.supplier_code;
end */;;
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

-- Dump completed on 2018-12-13 18:56:31
