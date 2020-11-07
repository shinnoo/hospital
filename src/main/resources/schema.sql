CREATE TABLE `doctor` (
  `id` varchar(255) NOT NULL,
  `id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `academic_level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;