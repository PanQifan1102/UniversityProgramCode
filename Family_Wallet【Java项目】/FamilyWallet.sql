-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.3.7-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 account_book 的数据库结构
CREATE DATABASE IF NOT EXISTS `account_book` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `account_book`;

-- 导出  表 account_book.account 结构
CREATE TABLE IF NOT EXISTS `account` (
  `account_id` int(11) NOT NULL,
  `account_type` varchar(20) NOT NULL,
  `account_founder` int(11) NOT NULL,
  `account_money` int(11) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.account 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- 导出  表 account_book.account_pay 结构
CREATE TABLE IF NOT EXISTS `account_pay` (
  `account_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `yes_no` int(20) DEFAULT 0,
  KEY `FK_Reference_3` (`account_id`),
  KEY `FK_Reference_4` (`user_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.account_pay 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `account_pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_pay` ENABLE KEYS */;

-- 导出  表 account_book.manager 结构
CREATE TABLE IF NOT EXISTS `manager` (
  `manager_id` int(11) NOT NULL,
  `manager_passward` int(11) NOT NULL,
  `manager_name` varchar(20) NOT NULL,
  `manager_mail` varchar(20) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.manager 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;

-- 导出  表 account_book.oganization 结构
CREATE TABLE IF NOT EXISTS `oganization` (
  `og_id` int(11) NOT NULL,
  `og_name` varchar(20) NOT NULL,
  `og_founder` varchar(20) NOT NULL,
  PRIMARY KEY (`og_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.oganization 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `oganization` DISABLE KEYS */;
INSERT INTO `oganization` (`og_id`, `og_name`, `og_founder`) VALUES
	(2, 'F4', 'pqf');
/*!40000 ALTER TABLE `oganization` ENABLE KEYS */;

-- 导出  表 account_book.og_account 结构
CREATE TABLE IF NOT EXISTS `og_account` (
  `account_id` int(11) DEFAULT NULL,
  `og_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_5` (`account_id`),
  KEY `FK_Reference_6` (`og_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`og_id`) REFERENCES `oganization` (`og_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.og_account 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `og_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `og_account` ENABLE KEYS */;

-- 导出  表 account_book.og_user 结构
CREATE TABLE IF NOT EXISTS `og_user` (
  `og_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_1` (`og_id`),
  KEY `FK_Reference_2` (`user_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`og_id`) REFERENCES `oganization` (`og_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.og_user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `og_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `og_user` ENABLE KEYS */;

-- 导出  表 account_book.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL,
  `user_passward` varchar(20) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `user_mailbox` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  account_book.user 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_passward`, `user_name`, `user_mailbox`) VALUES
	(1, '1234', 'zyn', 'zyn@qq.com'),
	(6, '123', '张雨轩', 'zyx@qq.com'),
	(7, '123', '张啸言', 'zxy@qq.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
