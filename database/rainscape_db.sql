-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 16, 2022 at 09:13 AM
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
('Justin', 'Lu'),
('Marcus', 'Singson'),
('Zeke', 'Villasurda');

-- --------------------------------------------------------

--
-- Table structure for table `rs_preferences`
--

CREATE TABLE `rs_preferences` (
  `username` varchar(24) NOT NULL,
  `area` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rs_preferences`
--

INSERT INTO `rs_preferences` (`username`, `area`) VALUES
('Aya', 'Manila'),
('Jay', 'Makati City'),
('Justin', 'Quezon City'),
('Marcus', 'Manila'),
('Zeke', 'Quezon City');

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
