-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
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
-- Table structure for table `academic_degree`
--

DROP TABLE IF EXISTS `academic_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_degree` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_degree`
--

LOCK TABLES `academic_degree` WRITE;
/*!40000 ALTER TABLE `academic_degree` DISABLE KEYS */;
INSERT INTO `academic_degree` VALUES (1,'Кандидат наук'),(2,'Доктор наук');
/*!40000 ALTER TABLE `academic_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `academic_title`
--

DROP TABLE IF EXISTS `academic_title`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `academic_title` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_title`
--

LOCK TABLES `academic_title` WRITE;
/*!40000 ALTER TABLE `academic_title` DISABLE KEYS */;
INSERT INTO `academic_title` VALUES (1,'Доцент'),(2,'Профессор');
/*!40000 ALTER TABLE `academic_title` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL,
  `id_teacher` int(11) DEFAULT NULL,
  `date_from` date DEFAULT NULL,
  `date_to` date DEFAULT NULL,
  `value_h` int(11) DEFAULT NULL,
  `date_c` varchar(45) DEFAULT NULL,
  `con_aggr_no` varchar(45) DEFAULT NULL,
  `id_funs_account` int(11) DEFAULT NULL,
  `contract_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_teacher1_idx` (`id_teacher`),
  CONSTRAINT `id_teacher` FOREIGN KEY (`id_teacher`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,1,'2001-01-20','2001-01-20',500,'25.12.2019',NULL,1,'234241241');
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `faculty_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_department_faculty1_idx` (`faculty_id`),
  CONSTRAINT `fk_department_faculty1` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Программное обеспечений информационных систем и технологий',7);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Автотракторный факультет'),(2,'Факультет горного дела и инженерной экологии'),(3,'Машиностроительный факультет'),(4,'Механико-технологический факультет'),(5,'Факультет маркетинга, менеджмента, предпринимательства'),(6,'Энергетический факультет'),(7,'Факультет информационных технологий и робототехники'),(8,'Факультет технологий управления и гуманитаризации'),(9,'Инженерно-педагогический факультет'),(10,'Факультет энергетиечского строительства'),(11,'Архитектурный факультет'),(12,'Строительный факультет'),(13,'Приборостроительный факультет'),(14,'Факультет транспортных коммуникаций'),(15,'Военно-технический факультет'),(16,'Спортивно-технический факультет');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logbook`
--

DROP TABLE IF EXISTS `logbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logbook` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL COMMENT 'YYYY-MM-DD HH:MI:SS',
  `id_type` int(11) DEFAULT NULL,
  `id_subj` int(11) DEFAULT NULL,
  `hours` int(11) DEFAULT NULL,
  `id_teach` int(11) DEFAULT NULL,
  `id_sem` int(11) DEFAULT NULL,
  `months_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_logbook_semestr_idx` (`id_sem`),
  KEY `fk_logbook_subject1_idx` (`id_subj`),
  KEY `fk_logbook_teacher1_idx` (`id_teach`),
  KEY `fk_logbook_months1_idx` (`months_id`),
  KEY `fk_logbook_type_of_class1_idx` (`id_type`),
  KEY `fk_logbook_department1_idx` (`department_id`),
  CONSTRAINT `fk_logbook_department1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `fk_logbook_months1` FOREIGN KEY (`months_id`) REFERENCES `months` (`id`),
  CONSTRAINT `id_sem` FOREIGN KEY (`id_sem`) REFERENCES `semestr` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_subj` FOREIGN KEY (`id_subj`) REFERENCES `subject` (`id`),
  CONSTRAINT `id_teach` FOREIGN KEY (`id_teach`) REFERENCES `teacher` (`id`),
  CONSTRAINT `id_type` FOREIGN KEY (`id_type`) REFERENCES `type_of_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logbook`
--

LOCK TABLES `logbook` WRITE;
/*!40000 ALTER TABLE `logbook` DISABLE KEYS */;
INSERT INTO `logbook` VALUES (1,'2001-01-20',2,1,70,1,1,1,1);
/*!40000 ALTER TABLE `logbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `months`
--

DROP TABLE IF EXISTS `months`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `months` (
  `id` int(11) NOT NULL,
  `month` varchar(45) DEFAULT NULL,
  `semestr_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_months_semestr1_idx` (`semestr_id`),
  CONSTRAINT `fk_months_semestr1` FOREIGN KEY (`semestr_id`) REFERENCES `semestr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `months`
--

LOCK TABLES `months` WRITE;
/*!40000 ALTER TABLE `months` DISABLE KEYS */;
INSERT INTO `months` VALUES (1,'Январь',1),(2,'Февраль',2),(3,'Март',2),(4,'Апрель',2),(5,'Май',2),(6,'Июнь',2),(7,'Июль',2),(8,'Август',2),(9,'Сентябрь',1),(10,'Октябрь',1),(11,'Ноябрь',1),(12,'Декабрь',1);
/*!40000 ALTER TABLE `months` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id_month` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `id_sem` int(11) NOT NULL,
  `hours` int(11) DEFAULT NULL,
  `teacher_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_months_has_type_of_class_type_of_class1_idx` (`id_type`),
  KEY `fk_months_has_type_of_class_months1_idx` (`id_month`),
  KEY `fk_months_has_type_of_class_semestr1_idx` (`id_sem`),
  KEY `fk_plan_teacher1_idx` (`teacher_id`),
  CONSTRAINT `fk_months_has_type_of_class_months1` FOREIGN KEY (`id_month`) REFERENCES `months` (`id`),
  CONSTRAINT `fk_months_has_type_of_class_semestr1` FOREIGN KEY (`id_sem`) REFERENCES `semestr` (`id`),
  CONSTRAINT `fk_months_has_type_of_class_type_of_class1` FOREIGN KEY (`id_type`) REFERENCES `type_of_class` (`id`),
  CONSTRAINT `fk_plan_teacher1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'MODERATOR'),(3,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_has_users`
--

DROP TABLE IF EXISTS `roles_has_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles_has_users` (
  `roles_id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`roles_id`,`users_id`),
  KEY `fk_roles_has_users_users1_idx` (`users_id`),
  KEY `fk_roles_has_users_roles1_idx` (`roles_id`),
  KEY `fk_roles_has_users_teacher1_idx` (`teacher_id`),
  CONSTRAINT `fk_roles_has_users_roles1` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_roles_has_users_teacher1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`),
  CONSTRAINT `fk_roles_has_users_users1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_has_users`
--

LOCK TABLES `roles_has_users` WRITE;
/*!40000 ALTER TABLE `roles_has_users` DISABLE KEYS */;
INSERT INTO `roles_has_users` VALUES (1,2,1),(2,2,1),(3,2,1);
/*!40000 ALTER TABLE `roles_has_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semestr`
--

DROP TABLE IF EXISTS `semestr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semestr` (
  `id` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semestr`
--

LOCK TABLES `semestr` WRITE;
/*!40000 ALTER TABLE `semestr` DISABLE KEYS */;
INSERT INTO `semestr` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `semestr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `subject` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Распределенная и параллельная обработка данных'),(2,'Технологии проектирования иныомрационных систем');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `surname` varchar(70) NOT NULL,
  `name` varchar(45) NOT NULL,
  `fathername` varchar(45) DEFAULT NULL,
  `passport` varchar(45) DEFAULT NULL,
  `id_passport` varchar(45) DEFAULT NULL,
  `id_insurance` varchar(45) DEFAULT NULL,
  `date_passport` date DEFAULT NULL,
  `place_passport` varchar(45) DEFAULT NULL,
  `post_code` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `main_job` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `tel_home` varchar(13) DEFAULT NULL,
  `tel_job` varchar(13) DEFAULT NULL,
  `tel_mobile` varchar(13) DEFAULT NULL,
  `id_degree` int(11) NOT NULL,
  `id_title` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_teacher_academic_degree1_idx` (`id_degree`),
  KEY `fk_teacher_academic_title1_idx` (`id_title`),
  CONSTRAINT `fk_teacher_academic_degree1` FOREIGN KEY (`id_degree`) REFERENCES `academic_degree` (`id`),
  CONSTRAINT `fk_teacher_academic_title1` FOREIGN KEY (`id_title`) REFERENCES `academic_title` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Новикова','Анастасия','Александровна','ЬЗ360790','342234',NULL,NULL,NULL,NULL,NULL,'ООО \"НетКрэкерБел\"','младший системный аналитик','14124124','124124','2353',1,1);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_of_class`
--

DROP TABLE IF EXISTS `type_of_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type_of_class` (
  `id` int(11) NOT NULL,
  `name` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_of_class`
--

LOCK TABLES `type_of_class` WRITE;
/*!40000 ALTER TABLE `type_of_class` DISABLE KEYS */;
INSERT INTO `type_of_class` VALUES (1,'Лекции'),(2,'Практические занятия'),(3,'Лабораторные занятия'),(4,'Курсовое проектирование'),(5,'РГР'),(6,'Контрольные работы'),(7,'Зачеты'),(8,'Консультации'),(9,'Экзамены'),(10,'Руководство практикой'),(11,'Руководство дипломной работой'),(12,'Консультации дипломных работ'),(13,'Рецензирование дипломных работ'),(14,'ГЭК'),(15,'Руководство магистрантами'),(16,'Руководство аспирантами');
/*!40000 ALTER TABLE `type_of_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `id_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'anastasiya.novikava2@bntu.by','$2a$10$ZuO.Ng7ieyrJI0.oTFHRy.PDuRxEVwJJLg4nDWuLNyxpLfh6VeI8G',NULL),(2,'anastasiya.novikava@bntu.by','$2a$10$vkOaJuanPaadetjvv2cYPedrTVsAM67vlLgN2Pe6SKX0SsToAjIF2',NULL);
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

-- Dump completed on 2022-01-05 14:06:37
