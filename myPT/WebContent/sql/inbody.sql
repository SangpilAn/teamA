-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.21 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- mypt 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `mypt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mypt`;

-- 테이블 mypt.inbody 구조 내보내기
CREATE TABLE IF NOT EXISTS `inbody` (
  `I_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `I_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MUSCLE` float DEFAULT NULL,
  `FAT` float DEFAULT NULL,
  `HEIGHT` float DEFAULT NULL,
  `WEIGHT` float DEFAULT NULL,
  PRIMARY KEY (`I_ID`,`I_DATE`) USING BTREE,
  KEY `FK_inbody_user` (`I_ID`) USING BTREE,
  CONSTRAINT `FK_inbody_user` FOREIGN KEY (`I_ID`) REFERENCES `user` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 mypt.inbody:~10 rows (대략적) 내보내기
/*!40000 ALTER TABLE `inbody` DISABLE KEYS */;
INSERT INTO `inbody` (`I_ID`, `I_DATE`, `MUSCLE`, `FAT`, `HEIGHT`, `WEIGHT`) VALUES
	('F932009007', '2020-04-06 00:30:11', 25.3, 15.9, 168, 65.2),
	('F932009007', '2020-05-09 05:39:08', 34, 14.9, 168, 67),
	('F932009007', '2020-06-13 05:38:38', 26.6, 12, 168, 66.5),
	('F932009007', '2020-07-03 00:30:42', 22, 15.2, 168, 66.1),
	('F932009007', '2020-07-05 22:21:24', 24.5, 13, 168, 62),
	('F932009007', '2020-08-16 22:21:58', 28, 14.3, 168, 59),
	('F932009007', '2020-08-29 22:20:54', 25, 13.5, 168, 60.2),
	('F932009007', '2020-09-02 22:22:39', 27.4, 15, 168, 59),
	('F932009007', '2020-09-04 22:23:01', 27.1, 15, 168, 59.8),
	('F932009007', '2020-09-06 00:29:44', 26.9, 13.3, 168, 64.3);
/*!40000 ALTER TABLE `inbody` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
