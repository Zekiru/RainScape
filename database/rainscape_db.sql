-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2022 at 01:46 AM
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
  `username` varchar(24) NOT NULL,
  `password` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_accounts`
--

INSERT INTO `rs_accounts` (`username`, `password`) VALUES
('Aya', 'Pangan'),
('Jay', 'Malinis'),
('Joseph', 'Garcia'),
('Justin', 'Lu'),
('Marcus', 'Singson'),
('Mozes', 'Garcia'),
('Raden', 'Alvarez'),
('Wilson', 'Tiu'),
('Zeke', 'Villasurda');

-- --------------------------------------------------------

--
-- Table structure for table `rs_preferences`
--

CREATE TABLE `rs_preferences` (
  `username` varchar(24) NOT NULL,
  `area` varchar(60) NOT NULL,
  `temp_scale` varchar(12) NOT NULL,
  `dark_mode` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_preferences`
--

INSERT INTO `rs_preferences` (`username`, `area`, `temp_scale`, `dark_mode`) VALUES
('Aya', 'Manila', 'celsius', 0),
('Jay', 'Makati', 'celsius', 0),
('Joseph', 'Istanbul', 'celsius', 1),
('Justin', 'Quezon City', 'celsius', 0),
('Marcus', 'Marikina', 'fahrenheit', 0),
('Mozes', 'Hongkong', 'fahrenheit', 1),
('Raden', 'Manila', 'fahrenheit', 0),
('Wilson', 'Manila', 'celsius', 0),
('Zeke', 'Albuquerque', 'celsius', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rs_weatherlogs`
--

CREATE TABLE `rs_weatherlogs` (
  `username` varchar(24) NOT NULL,
  `date_time` varchar(24) NOT NULL,
  `area` varchar(24) NOT NULL,
  `status` varchar(24) NOT NULL,
  `temp_scale` varchar(24) NOT NULL,
  `temp` varchar(24) NOT NULL,
  `clouds` varchar(24) NOT NULL,
  `humidity` varchar(24) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_weatherlogs`
--

INSERT INTO `rs_weatherlogs` (`username`, `date_time`, `area`, `status`, `temp_scale`, `temp`, `clouds`, `humidity`) VALUES
('Jay', '2022-11-22 15:08:05', 'Makati, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Jay', '2022-11-22 15:08:12', 'Manila, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-22 15:08:32', 'Albuquerque, USA', 'Clear', 'celsius', '1°C', '0', '36'),
('Zeke', '2022-11-22 15:08:39', 'Manila, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-22 15:08:47', 'Hongkong', 'Partly cloudy', 'celsius', '26°C', '50', '74'),
('Zeke', '2022-11-22 15:14:54', 'Albuquerque, USA', 'Clear', 'celsius', '1°C', '0', '36'),
('Zeke', '2022-11-22 15:15:17', 'Makati, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-22 15:17:11', 'Makati, Philippines', 'Partly cloudy', 'celsius', '32°C', '25', '56'),
('Zeke', '2022-11-22 21:54:08', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-3°C', '50', '46'),
('Jay', '2022-11-22 22:03:11', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Jay', '2022-11-22 22:04:42', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Jay', '2022-11-22 22:04:47', 'Michigan City, USA', 'Sunny', 'celsius', '-3°C', '0', '78'),
('Zeke', '2022-11-22 22:23:02', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-3°C', '50', '48'),
('Jay', '2022-11-22 22:33:01', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Zeke', '2022-11-22 22:46:55', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '43'),
('Jay', '2022-11-22 22:49:59', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Jay', '2022-11-22 22:53:38', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Zeke', '2022-11-22 22:56:04', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '43'),
('Zeke', '2022-11-22 22:56:11', 'Mississippi State, USA', 'Overcast', 'celsius', '6°C', '100', '76'),
('Zeke', '2022-11-22 22:56:20', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '43'),
('Jay', '2022-11-22 23:04:23', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Justin', '2022-11-22 23:06:51', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Justin', '2022-11-22 23:06:57', 'Quezon, Philippines', 'Clear', 'celsius', '24°C', '8', '88'),
('Justin', '2022-11-22 23:07:04', 'Baligang, Philippines', 'Patchy rain possible', 'celsius', '24°C', '73', '94'),
('Justin', '2022-11-22 23:07:11', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Justin', '2022-11-22 23:09:00', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Justin', '2022-11-22 23:14:29', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Zeke', '2022-11-22 23:16:09', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '43'),
('Zeke', '2022-11-22 23:22:43', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-22 23:22:50', 'Istanbul, Turkey', 'Clear', 'celsius', '13°C', '0', '77'),
('Zeke', '2022-11-22 23:24:07', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Jay', '2022-11-22 23:26:25', 'Makati, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Zeke', '2022-11-22 23:37:20', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-22 23:40:39', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-22 23:41:57', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-22 23:43:53', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-23 00:06:49', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-23 00:11:09', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-23 00:11:36', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Justin', '2022-11-23 00:12:32', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '79'),
('Zeke', '2022-11-23 00:21:37', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-23 00:25:35', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '-2°C', '75', '48'),
('Zeke', '2022-11-23 08:23:40', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '8°C', '75', '25'),
('Zeke', '2022-11-23 08:23:53', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '8°C', '75', '25'),
('Zeke', '2022-11-23 08:23:57', 'Manila, Philippines', 'Partly cloudy', 'celsius', '27°C', '75', '84'),
('Jay', '2022-11-23 08:40:04', 'Makati, Philippines', 'Partly cloudy', 'celsius', '27°C', '75', '84'),
('Justin', '2022-11-23 08:41:23', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '75', '84'),
('Zeke', '2022-11-23 08:44:20', 'Albuquerque, USA', 'Partly cloudy', 'celsius', '8°C', '75', '25'),
('Zeke', '2022-11-23 08:44:36', 'Manila, Philippines', 'Partly cloudy', 'celsius', '27°C', '75', '84');

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
