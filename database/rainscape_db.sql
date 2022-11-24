-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 25, 2022 at 12:05 AM
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
('User', 'password'),
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
