-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2024 at 02:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `automobilerentalservicess`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_address` varchar(255) NOT NULL,
  `admin_pNum` varchar(255) NOT NULL,
  `admin_title` varchar(255) NOT NULL,
  `admin_department` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_address`, `admin_pNum`, `admin_title`, `admin_department`, `user_id`) VALUES
(25, 'Tangkak,Johor', '019-8765423', 'Manager', 'Management', 101),
(26, 'Jasin,Melaka', '012-6543234', 'Head Department', 'Sale', 102),
(27, 'Merlimau,Melaka', '011-8765345', 'Head Department', 'Finance', 103),
(30, 'Serkam,Melaka', '011-2327688', 'Head Department', 'Marketing', 128);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `booking_date` date NOT NULL,
  `end_date` date NOT NULL,
  `pickup_location` varchar(255) NOT NULL,
  `drop_location` varchar(255) NOT NULL,
  `rr_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `booking_days` int(11) NOT NULL,
  `total_price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `booking_date`, `end_date`, `pickup_location`, `drop_location`, `rr_id`, `car_id`, `booking_days`, `total_price`) VALUES
(39, '2024-07-08', '2024-07-11', 'Muar', 'Muar', 6, 129, 4, 320),
(40, '2024-07-10', '2024-07-10', 'UITM JASIN', 'UITM BANDARAYA', 3, 131, 1, 80),
(42, '2024-07-13', '2024-07-14', 'Batu Pahat', 'Uitm', 1, 129, 2, 160),
(43, '2024-07-13', '2024-07-14', 'Muar', 'UKM', 1, 133, 2, 170),
(44, '2024-07-13', '2024-07-14', 'Shah Alam', 'Setia Alam', 3, 131, 0, 160);

--
-- Triggers `booking`
--
DELIMITER $$
CREATE TRIGGER `calcEnd_date` BEFORE INSERT ON `booking` FOR EACH ROW BEGIN
    SET NEW.end_date = DATE_ADD(NEW.booking_date, INTERVAL (NEW.booking_days - 1) DAY);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `car_id` int(11) NOT NULL,
  `car_type` varchar(255) NOT NULL,
  `car_brand` varchar(255) NOT NULL,
  `car_model` varchar(255) NOT NULL,
  `car_color` varchar(255) NOT NULL,
  `no_of_seats` int(11) NOT NULL,
  `availability` varchar(255) NOT NULL,
  `price_per_day` double NOT NULL,
  `rr_id` int(11) NOT NULL,
  `car_plate` varchar(255) DEFAULT NULL,
  `ownerBusy` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`car_id`, `car_type`, `car_brand`, `car_model`, `car_color`, `no_of_seats`, `availability`, `price_per_day`, `rr_id`, `car_plate`, `ownerBusy`) VALUES
(129, 'Hatchback', 'Perodua', 'Axia', 'Blue', 5, 'Unavailable', 84, 2, 'JVD7865', 'false'),
(130, 'Sedan', 'Proton', 'Wira', 'Black', 5, 'Available', 80, 1, 'JSG5677', 'false'),
(131, 'Hatchback', 'Perodua', 'Myvi', 'Red', 5, 'Unavailable', 80, 1, 'JWQ3298', 'false'),
(133, 'Sedan', 'Proton', 'Persona', 'Grey', 5, 'Unavailable', 85, 2, 'VDD3421', 'false'),
(139, 'Sedan', 'Perodua', 'Bezza', 'Blue', 5, 'Available', 80, 1, 'JWW2345', 'false'),
(142, 'Hatchback', 'Perodua', 'Kancil', 'Chrome', 5, 'Available', 60, 3, 'ADF2654', 'false'),
(145, 'Sedan', 'Perodua', 'Bezza', 'Maroonm', 5, 'Available', 89, 3, 'WHH3276', 'false');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `payment_type` varchar(255) NOT NULL,
  `booking_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `payment_type`, `booking_id`) VALUES
(5, 'Cash', 39),
(6, 'Debit Card', 40),
(8, 'Cash', 42),
(9, 'Debit Card', 43),
(10, 'Paypal', 44);

-- --------------------------------------------------------

--
-- Table structure for table `renter_renting`
--

CREATE TABLE `renter_renting` (
  `rr_id` int(11) NOT NULL,
  `rr_address` varchar(255) DEFAULT NULL,
  `rr_pNum` varchar(255) DEFAULT NULL,
  `rr_license` varchar(255) DEFAULT NULL,
  `rr_experience` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `renter_renting`
--

INSERT INTO `renter_renting` (`rr_id`, `rr_address`, `rr_pNum`, `rr_license`, `rr_experience`, `user_id`) VALUES
(1, 'Bukit Gambir, Johor', '011-3456543', 'B2, D', '3 Years', 118),
(2, 'Tangkak,Johor', '019-112233445', 'B2, D', '3 Years', 119),
(3, 'Jasin,Melaka', '011-2385736', 'B2, D', '3 Years', 120),
(6, 'Johor Bahru, Johor', '012-3465542', 'B2, D', '1 Year', 121),
(7, NULL, NULL, NULL, NULL, 122),
(10, NULL, NULL, NULL, NULL, 125),
(12, NULL, NULL, NULL, NULL, 129);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_email`, `user_role`) VALUES
(101, 'Adham', 'adham1', 'adham123@gmail.com', 'Admin'),
(102, 'Ammar ', 'ammar2', 'ammar123@gmail.com', 'Admin'),
(103, 'Afiq', 'afiq3', 'afiq123@gmail.com', 'Admin'),
(104, 'Akmal', 'akmal4', 'akmal123@gmail.com', 'Admin'),
(118, 'Mirza', 'mirza03', 'mirza@gmail.com', 'RENTER/RENTING'),
(119, 'Amirul', 'amirul99', 'amirul22@gmail.com', 'RENTER/RENTING'),
(120, 'Ikhwan', 'ikhwan100', 'ikhwan34@gmail.com', 'RENTER/RENTING'),
(121, 'Shahfizal', 'shah246', 'shahfizalnor@gmail.com', 'RENTER/RENTING'),
(122, 'Aqiman', '123aqiman', 'aqiman@gmail.com', 'RENTER/RENTING'),
(125, 'kondok', 'kjshdjkhdjk', 'shahfizalnor@gmail.com', 'RENTER/RENTING'),
(127, 'Akmal', 'akmal4', 'akmalsem@gmail.com', 'admin'),
(128, 'Mal', 'mal4', 'malajusin@gmail.com', 'admin'),
(129, 'Arif', 'arif555', 'arifff@gmail.com', 'RENTER/RENTING');

--
-- Triggers `user`
--
DELIMITER $$
CREATE TRIGGER `user_id` AFTER INSERT ON `user` FOR EACH ROW BEGIN
	IF(NEW.user_role='admin')
    THEN
    INSERT INTO admin (user_id) VALUES (NEW.user_id);
    ELSE
    INSERT INTO renter_renting(user_id) VALUES(NEW.user_id);
    end if;
    end
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `admin_ibfk_1` (`user_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `booking_userID_FK` (`rr_id`),
  ADD KEY `booking_carID_FK` (`car_id`);

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`car_id`),
  ADD KEY `car_userID_FK` (`rr_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `booking_id` (`booking_id`);

--
-- Indexes for table `renter_renting`
--
ALTER TABLE `renter_renting`
  ADD PRIMARY KEY (`rr_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=146;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `renter_renting`
--
ALTER TABLE `renter_renting`
  MODIFY `rr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`rr_id`) REFERENCES `renter_renting` (`rr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`car_id`) REFERENCES `cars` (`car_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`rr_id`) REFERENCES `renter_renting` (`rr_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `renter_renting`
--
ALTER TABLE `renter_renting`
  ADD CONSTRAINT `renter_renting_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
