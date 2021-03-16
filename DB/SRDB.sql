-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sverigesradio
CREATE DATABASE IF NOT EXISTS `sverigesradio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sverigesradio`;

-- Dumping structure for table sverigesradio.categories
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.categories: ~0 rows (approximately)
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;

-- Dumping structure for table sverigesradio.channels
CREATE TABLE IF NOT EXISTS `channels` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `info` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.channels: ~0 rows (approximately)
/*!40000 ALTER TABLE `channels` DISABLE KEYS */;
/*!40000 ALTER TABLE `channels` ENABLE KEYS */;

-- Dumping structure for table sverigesradio.episodes
CREATE TABLE IF NOT EXISTS `episodes` (
  `id` int(11) NOT NULL,
  `program_id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `publishdateutc` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_episodes_programs` (`program_id`),
  CONSTRAINT `FK_episodes_programs` FOREIGN KEY (`program_id`) REFERENCES `programs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.episodes: ~0 rows (approximately)
/*!40000 ALTER TABLE `episodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `episodes` ENABLE KEYS */;

-- Dumping structure for table sverigesradio.favorites
CREATE TABLE IF NOT EXISTS `favorites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  `program_id` int(11) NOT NULL,
  `episode_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_favorites_users` (`user_id`),
  KEY `FK_favorites_channels` (`channel_id`),
  KEY `FK_favorites_programs` (`program_id`),
  KEY `FK_favorites_episodes` (`episode_id`),
  CONSTRAINT `FK_favorites_channels` FOREIGN KEY (`channel_id`) REFERENCES `channels` (`id`),
  CONSTRAINT `FK_favorites_episodes` FOREIGN KEY (`episode_id`) REFERENCES `episodes` (`id`),
  CONSTRAINT `FK_favorites_programs` FOREIGN KEY (`program_id`) REFERENCES `programs` (`id`),
  CONSTRAINT `FK_favorites_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.favorites: ~0 rows (approximately)
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;

-- Dumping structure for table sverigesradio.friend_relationships
CREATE TABLE IF NOT EXISTS `friend_relationships` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `friends_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_friend_relationships_users` (`user_id`),
  KEY `FK_friend_relationships_users_2` (`friends_id`),
  CONSTRAINT `FK_friend_relationships_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_friend_relationships_users_2` FOREIGN KEY (`friends_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.friend_relationships: ~0 rows (approximately)
/*!40000 ALTER TABLE `friend_relationships` DISABLE KEYS */;
/*!40000 ALTER TABLE `friend_relationships` ENABLE KEYS */;

-- Dumping structure for table sverigesradio.programs
CREATE TABLE IF NOT EXISTS `programs` (
  `id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  `programcategoryid` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `publishdateutc` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_programs_channels` (`channel_id`),
  KEY `FK_programs_categories` (`programcategoryid`),
  CONSTRAINT `FK_programs_categories` FOREIGN KEY (`programcategoryid`) REFERENCES `categories` (`id`),
  CONSTRAINT `FK_programs_channels` FOREIGN KEY (`channel_id`) REFERENCES `channels` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.programs: ~0 rows (approximately)
/*!40000 ALTER TABLE `programs` DISABLE KEYS */;
/*!40000 ALTER TABLE `programs` ENABLE KEYS */;

-- Dumping structure for table sverigesradio.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table sverigesradio.users: ~0 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
