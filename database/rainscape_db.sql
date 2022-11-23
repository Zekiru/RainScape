-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2022 at 12:29 AM
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
('Jay', 'Makati', 'celsius', 0),
('Joseph', 'Istanbul', 'celsius', 1),
('Justin', 'Quezon City', 'celsius', 0),
('Marcus', 'Marikina', 'fahrenheit', 0),
('Mozes', 'Hongkong', 'fahrenheit', 1),
('Raden', 'Manila', 'fahrenheit', 0),
('Wilson', 'Manila', 'celsius', 0),
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
('Zeke', '2022-11-24 04:05:46', 'Tacloban City, Philippines', 'Light rain shower', 'celsius', '24°C', '54', '92'),
('Zeke', '2022-11-24 04:07:27', 'Tacloban City, Philippines', 'Light rain shower', 'celsius', '24°C', '54', '92'),
('Zeke', '2022-11-24 04:07:44', 'Tacloban City, Philippines', 'Light rain shower', 'celsius', '24°C', '54', '92'),
('Zeke', '2022-11-24 04:09:48', 'Tacloban City, Philippines', 'Light rain shower', 'celsius', '24°C', '54', '92'),
('Zeke', '2022-11-24 04:13:25', 'Tacloban City, Philippines', 'Light rain shower', 'celsius', '24°C', '54', '92'),
('Zeke', '2022-11-24 04:14:37', 'Tacloban City, Philippines', 'Light rain shower', 'celsius', '24°C', '54', '92'),
('Zeke', '2022-11-24 04:16:11', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:18:45', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:19:21', 'Cavite, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:20:04', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:21:18', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:21:38', 'Quezon City, Philippines', 'Partly cloudy', 'fahrenheit', '80°F', '25', '79'),
('Zeke', '2022-11-24 04:22:51', 'Quezon City, Philippines', 'Partly cloudy', 'fahrenheit', '80°F', '25', '79'),
('Zeke', '2022-11-24 04:23:16', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:25:50', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:28:20', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:29:02', 'Brasilia, Brazil', 'Partly cloudy', 'celsius', '23°C', '75', '73'),
('Zeke', '2022-11-24 04:29:12', 'Colorado Springs, USA', 'Partly cloudy', 'celsius', '12°C', '25', '5'),
('Zeke', '2022-11-24 04:29:18', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:30:40', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 04:57:10', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 05:08:40', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 05:15:04', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 05:59:28', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 06:57:26', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 07:09:10', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 07:10:11', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '27°C', '25', '79'),
('Zeke', '2022-11-24 07:24:03', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '74'),
('Zeke', '2022-11-24 07:28:06', 'Quezon City, Philippines', 'Partly cloudy', 'celsius', '28°C', '25', '74');

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
