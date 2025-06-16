CREATE DATABASE  IF NOT EXISTS `apimonitoraai` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `apimonitoraai`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: apimonitoraai
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `emprestimo`
--

DROP TABLE IF EXISTS `emprestimo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emprestimo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_devolucao` date DEFAULT NULL,
  `data_emprestimo` date NOT NULL,
  `devolvido` bit(1) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `colaborador_id` bigint DEFAULT NULL,
  `equipamento_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7vsx48de9ywiygto00geqb4tu` (`colaborador_id`),
  KEY `FK5n75cijctjobg67uu7k57ofuo` (`equipamento_id`),
  CONSTRAINT `FK5n75cijctjobg67uu7k57ofuo` FOREIGN KEY (`equipamento_id`) REFERENCES `equipamento` (`id`),
  CONSTRAINT `FK7vsx48de9ywiygto00geqb4tu` FOREIGN KEY (`colaborador_id`) REFERENCES `colaborador` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emprestimo`
--

LOCK TABLES `emprestimo` WRITE;
/*!40000 ALTER TABLE `emprestimo` DISABLE KEYS */;
INSERT INTO `emprestimo` VALUES (1,NULL,'2025-05-01',_binary '\0',NULL,1,1),(2,NULL,'2025-05-02',_binary '\0',NULL,2,2),(3,NULL,'2025-05-03',_binary '\0',NULL,3,3),(4,NULL,'2025-05-04',_binary '\0',NULL,4,4),(5,NULL,'2025-05-05',_binary '\0',NULL,5,5),(6,NULL,'2025-05-06',_binary '\0',NULL,6,6),(7,'2025-06-12','2025-05-07',_binary '','DSAFSAFASDAS',7,7),(8,'2025-06-10','2025-05-08',_binary '','dsadasdas',8,8),(9,'2025-06-10','2025-05-09',_binary '','rachado',9,9),(10,'2025-06-10','2025-05-10',_binary '','quebrado',10,10),(11,'2025-06-12','2025-06-10',_binary '','DEVOLUÇÃO ATÉ QUE ENFIM PARA ESTER',2,1);
/*!40000 ALTER TABLE `emprestimo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-15 22:26:16
