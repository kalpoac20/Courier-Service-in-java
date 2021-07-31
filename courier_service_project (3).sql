-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 19, 2019 at 12:06 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `courier_service_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL,
  `a_username` varchar(255) NOT NULL,
  `a_pass` varchar(16) NOT NULL,
  `a_type` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`a_id`, `a_username`, `a_pass`, `a_type`) VALUES
(1, 'srt', '123', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `courirer_person`
--

CREATE TABLE `courirer_person` (
  `cp_id` int(11) NOT NULL,
  `cp_password` varchar(16) NOT NULL,
  `cp_phone` varchar(16) NOT NULL,
  `cp_username` varchar(16) NOT NULL,
  `cp_gender` varchar(6) NOT NULL,
  `cp_age` int(6) NOT NULL,
  `cp_email` varchar(16) NOT NULL,
  `cp_status` enum('Active','Inactive') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courirer_person`
--

INSERT INTO `courirer_person` (`cp_id`, `cp_password`, `cp_phone`, `cp_username`, `cp_gender`, `cp_age`, `cp_email`, `cp_status`) VALUES
(1, '123', '01623107428', 'sumon', 'male', 21, 'sumonroytony@gma', 'Active'),
(2, '123', '01623107429', 'lul', 'male', 21, 'lul@gmail.com', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_id` int(11) NOT NULL,
  `c_username` varchar(16) NOT NULL,
  `c_password` varchar(16) NOT NULL,
  `c_email` varchar(255) NOT NULL,
  `c_phoneNumber` varchar(16) NOT NULL,
  `c_gender` varchar(6) NOT NULL,
  `c_birthdate` varchar(11) NOT NULL,
  `c_homeAdress` varchar(255) NOT NULL,
  `c_status` varchar(11) NOT NULL DEFAULT 'n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_id`, `c_username`, `c_password`, `c_email`, `c_phoneNumber`, `c_gender`, `c_birthdate`, `c_homeAdress`, `c_status`) VALUES
(1, 'niloy', '123', 'niloy@gmail.com', '123456', 'male', '0000-00-00', 'dhaka', 'n'),
(2, 'pasa', '123', 'pasa@gmail.com', '123456', 'male', '0000-00-00', 'dhaka', 'y'),
(3, 'masud', '123', 'masud@gmail.com', '123456', 'male', '0000-00-00', 'savar', 'n'),
(4, 'soikat', '123', 'soikat@gmail.com', '123456', 'male', '0000-00-00', 'savar', 'n');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `d_id` int(11) NOT NULL,
  `d_time` datetime(6) NOT NULL,
  `d_adress` varchar(255) NOT NULL,
  `d_status` enum('Active','Inactive') DEFAULT NULL,
  `d_charge` float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `p_id` int(11) NOT NULL,
  `p_weight` float(10,2) NOT NULL,
  `p_details` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `p_order`
--

CREATE TABLE `p_order` (
  `o_id` int(11) NOT NULL,
  `o_history` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `courirer_person`
--
ALTER TABLE `courirer_person`
  ADD PRIMARY KEY (`cp_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`d_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `p_order`
--
ALTER TABLE `p_order`
  ADD PRIMARY KEY (`o_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `courirer_person`
--
ALTER TABLE `courirer_person`
  MODIFY `cp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `p_order`
--
ALTER TABLE `p_order`
  MODIFY `o_id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
