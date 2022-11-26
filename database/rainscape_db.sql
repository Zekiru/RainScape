-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 26, 2022 at 07:16 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rainscape_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `rs_accounts`
--

CREATE TABLE `rs_accounts` (
  `username` varchar(40) NOT NULL,
  `password` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_accounts`
--

INSERT INTO `rs_accounts` (`username`, `password`) VALUES
('Aya', 'Pangan'),
('Hotdog', 'hotdog'),
('Jay', 'Malinis'),
('Joseph', 'Garcia'),
('Justin', 'Lu'),
('Marcus', 'Singson'),
('Mozes', 'Garcia'),
('Raden', 'Alvarez'),
('User', 'Password'),
('Zeke', 'Villasurda');

-- --------------------------------------------------------

--
-- Table structure for table `rs_preferences`
--

CREATE TABLE `rs_preferences` (
  `username` varchar(40) NOT NULL,
  `area` varchar(60) NOT NULL,
  `temp_scale` varchar(12) NOT NULL,
  `dark_mode` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_preferences`
--

INSERT INTO `rs_preferences` (`username`, `area`, `temp_scale`, `dark_mode`) VALUES
('Aya', 'Manila', 'celsius', 0),
('Hotdog', 'Manila', 'celsius', 0),
('Jay', 'Makati', 'celsius', 0),
('Joseph', 'Istanbul', 'celsius', 1),
('Justin', 'Quezon City', 'celsius', 0),
('Marcus', 'Marikina', 'fahrenheit', 0),
('Mozes', 'Hongkong', 'fahrenheit', 1),
('Raden', 'Manila', 'fahrenheit', 0),
('User', 'Makati', 'celsius', 0),
('Zeke', 'Quezon City', 'celsius', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rs_weatherlogs`
--

CREATE TABLE `rs_weatherlogs` (
  `username` varchar(40) NOT NULL,
  `date_time` varchar(24) NOT NULL,
  `area` varchar(60) NOT NULL,
  `status` varchar(60) NOT NULL,
  `temp_scale` varchar(24) NOT NULL,
  `temp` varchar(24) NOT NULL,
  `clouds` varchar(24) NOT NULL,
  `humidity` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_weatherlogs`
--

INSERT INTO `rs_weatherlogs` (`username`, `date_time`, `area`, `status`, `temp_scale`, `temp`, `clouds`, `humidity`) VALUES
('Aya', '2022-11-25 11:09:59', 'Manila, Philippines', 'Partly cloudy', 'celsius', '28°C', '75', '79'),
('Aya', '2022-11-25 11:10:11', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '75', '79'),
('Aya', '2022-11-25 11:10:23', 'Manila, Philippines', 'Partly cloudy', 'celsius', '28°C', '75', '79'),
('Aya', '2022-11-25 11:10:36', 'Calamba, Philippines', 'Patchy rain possible', 'celsius', '31°C', '63', '61'),
('Aya', '2022-11-25 11:11:23', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '75', '79'),
('Aya', '2022-11-25 11:11:26', 'Manila, Philippines', 'Partly cloudy', 'celsius', '28°C', '75', '79'),
('Aya', '2022-11-25 11:17:52', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 11:28:00', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Hotdog', '2022-11-25 11:28:49', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Hotdog', '2022-11-25 11:29:03', 'Tokyo, Japan', 'Partly cloudy', 'celsius', '16°C', '25', '51'),
('Hotdog', '2022-11-25 11:29:12', 'Puntarenas Chacarita Airport, Costa Rica', 'Patchy rain possible', 'celsius', '27°C', '81', '76'),
('Hotdog', '2022-11-25 11:29:14', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Hotdog', '2022-11-25 11:29:22', 'Korenovsk, Russia', 'Moderate or heavy rain with thunder', 'celsius', '9°C', '62', '81'),
('Hotdog', '2022-11-25 11:29:28', 'Korenovsk, Russia', 'Moderate or heavy rain with thunder', 'celsius', '9°C', '62', '81'),
('Hotdog', '2022-11-25 11:29:35', 'Seoul, South Korea', 'Mist', 'celsius', '13°C', '50', '54'),
('Aya', '2022-11-25 11:30:32', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 11:38:07', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 11:48:19', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 11:58:27', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 12:08:34', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 12:09:12', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 12:09:24', 'Colorado Springs, USA', 'Clear', 'celsius', '-3°C', '0', '65'),
('Aya', '2022-11-25 12:09:36', 'Manila, Philippines', 'Partly cloudy', 'celsius', '30°C', '75', '66'),
('Aya', '2022-11-25 12:18:41', 'Manila, Philippines', 'Partly cloudy', 'celsius', '32°C', '50', '59'),
('Zeke', '2022-11-26 13:01:33', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:04:04', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:04:50', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:05:31', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:07:31', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:08:02', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:08:08', 'Gaming, Austria', 'Light drizzle', 'celsius', '3°C', '81', '94'),
('Zeke', '2022-11-26 13:08:27', 'Colorado Springs, USA', 'Clear', 'celsius', '2°C', '0', '28'),
('Zeke', '2022-11-26 13:08:34', 'Minecraft, Ghana', 'Patchy rain possible', 'celsius', '23°C', '73', '93'),
('Zeke', '2022-11-26 13:08:52', 'Tokyo, Japan', 'Partly cloudy', 'celsius', '15°C', '50', '88'),
('Zeke', '2022-11-26 13:08:56', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:15:29', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-26 13:32:53', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59'),
('Zeke', '2022-11-26 13:34:17', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59'),
('Zeke', '2022-11-26 13:34:36', 'Quezon City, Philippines', 'Partly cloudy', 'fahrenheit', '89°F', '25', '59'),
('Zeke', '2022-11-26 13:34:46', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59'),
('Zeke', '2022-11-26 13:35:13', 'Tacloban City, Philippines', 'Patchy rain possible', 'celsius', '29°C', '88', '76'),
('Zeke', '2022-11-26 13:35:45', 'Hawaiian Gardens, USA', 'Clear', 'celsius', '12°C', '0', '52'),
('Zeke', '2022-11-26 13:35:54', 'Hawaiian Gardens, USA', 'Clear', 'celsius', '12°C', '0', '52'),
('Zeke', '2022-11-26 13:35:58', 'Bogota, Colombia', 'Partly cloudy', 'celsius', '13°C', '75', '94'),
('Zeke', '2022-11-26 13:36:10', 'Bogota, Colombia', 'Partly cloudy', 'celsius', '13°C', '75', '94'),
('Zeke', '2022-11-26 13:36:14', 'Emei, China', 'Overcast', 'celsius', '13°C', '94', '82'),
('User', '2022-11-26 13:46:56', 'Makati, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59'),
('User', '2022-11-26 13:47:37', 'Makati, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59'),
('Zeke', '2022-11-26 13:51:58', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59'),
('User', '2022-11-26 14:03:14', 'Makati, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '59');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rs_accounts`
--
ALTER TABLE `rs_accounts`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `rs_preferences`
--
ALTER TABLE `rs_preferences`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rs_preferences`
--
ALTER TABLE `rs_preferences`
  ADD CONSTRAINT `username` FOREIGN KEY (`username`) REFERENCES `rs_accounts` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
