CREATE TABLE IF NOT EXISTS `person`(
`id`bigint (20) NOT NULL AUTO_INCREMENT,
`address`varchar(100) NOT NULL,
`first_name`varchar(90) NOT NULL,
`gender` varchar(6) NOT NULL,
`last_name`varchar(80) NOT NULL,
PRIMARY KEY(`id`)
);

/*
DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client ;
/*!50503 SET character_set_client = utf8mb4 ;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
