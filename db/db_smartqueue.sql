-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2019 at 10:24 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_smartqueue`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_doc_reg`
--

CREATE TABLE `tbl_doc_reg` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `district` varchar(50) NOT NULL,
  `place` varchar(50) NOT NULL,
  `hos` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_doc_reg`
--

INSERT INTO `tbl_doc_reg` (`id`, `name`, `email`, `state`, `district`, `place`, `hos`, `password`, `image`, `status`) VALUES
(2, 'nivin', 'nivin@gmail.com', 'kerala', 'palakkad', 'pattambi', 'nclinick', '1234', 'nivin.JPEG', 0),
(3, 'dheeraj', 'dheeraj@gmail.com', 'kerala', 'thrissur', 'thrissur', 'clinick', '1234', 'dheeraj.JPEG', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_notification`
--

CREATE TABLE `tbl_notification` (
  `n_id` int(11) NOT NULL,
  `notification` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_notification`
--

INSERT INTO `tbl_notification` (`n_id`, `notification`) VALUES
(1, 'hello');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_seat`
--

CREATE TABLE `tbl_seat` (
  `seat_id` int(11) NOT NULL,
  `doc_id` varchar(10) NOT NULL,
  `seats` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_seat`
--

INSERT INTO `tbl_seat` (`seat_id`, `doc_id`, `seats`) VALUES
(4, '2', '10'),
(10, '3', '12');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_seat_details`
--

CREATE TABLE `tbl_seat_details` (
  `seat_d_id` int(11) NOT NULL,
  `doc_id` varchar(10) NOT NULL,
  `seatno` varchar(10) NOT NULL,
  `patient` varchar(100) NOT NULL,
  `age` varchar(10) NOT NULL,
  `phone` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `q_status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_seat_details`
--

INSERT INTO `tbl_seat_details` (`seat_d_id`, `doc_id`, `seatno`, `patient`, `age`, `phone`, `status`, `q_status`) VALUES
(26, '2', '1', 'null', 'null', 0, 0, 1),
(27, '2', '2', 'null', 'null', 0, 0, 1),
(28, '2', '3', 'null', 'null', 0, 0, 0),
(29, '2', '4', 'null', 'null', 0, 0, 0),
(30, '2', '5', 'null', 'null', 0, 0, 0),
(31, '2', '6', 'null', 'null', 0, 0, 0),
(32, '2', '7', 'null', 'null', 0, 0, 0),
(33, '2', '8', 'null', 'null', 0, 0, 0),
(34, '2', '9', 'null', 'null', 0, 0, 0),
(35, '2', '10', 'null', 'null', 0, 0, 0),
(83, '3', '1', 'null', 'null', 0, 0, 0),
(84, '3', '2', 'null', 'null', 0, 0, 0),
(85, '3', '3', 'null', 'null', 0, 0, 0),
(86, '3', '4', 'null', 'null', 0, 0, 0),
(87, '3', '5', 'null', 'null', 0, 0, 0),
(88, '3', '6', 'null', 'null', 0, 0, 0),
(89, '3', '7', 'null', 'null', 0, 0, 0),
(90, '3', '8', 'null', 'null', 0, 0, 0),
(91, '3', '9', 'null', 'null', 0, 0, 0),
(92, '3', '10', 'null', 'null', 0, 0, 0),
(93, '3', '11', 'null', 'null', 0, 0, 0),
(94, '3', '12', 'musthafa', '22', 9539206718, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_reg`
--

CREATE TABLE `tbl_user_reg` (
  `u_id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `contact` bigint(20) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user_reg`
--

INSERT INTO `tbl_user_reg` (`u_id`, `email`, `name`, `contact`, `password`) VALUES
(1, 'prakash@gmail.com', 'prakash', 9539206718, '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_doc_reg`
--
ALTER TABLE `tbl_doc_reg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_notification`
--
ALTER TABLE `tbl_notification`
  ADD PRIMARY KEY (`n_id`);

--
-- Indexes for table `tbl_seat`
--
ALTER TABLE `tbl_seat`
  ADD PRIMARY KEY (`seat_id`);

--
-- Indexes for table `tbl_seat_details`
--
ALTER TABLE `tbl_seat_details`
  ADD PRIMARY KEY (`seat_d_id`);

--
-- Indexes for table `tbl_user_reg`
--
ALTER TABLE `tbl_user_reg`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_doc_reg`
--
ALTER TABLE `tbl_doc_reg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_notification`
--
ALTER TABLE `tbl_notification`
  MODIFY `n_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_seat`
--
ALTER TABLE `tbl_seat`
  MODIFY `seat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tbl_seat_details`
--
ALTER TABLE `tbl_seat_details`
  MODIFY `seat_d_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT for table `tbl_user_reg`
--
ALTER TABLE `tbl_user_reg`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
