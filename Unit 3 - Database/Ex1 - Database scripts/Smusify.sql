-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 17-09-2025 a las 01:31:13
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Smusify`
--
CREATE DATABASE IF NOT EXISTS `Smusify` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `Smusify`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion`
--

CREATE TABLE `cancion` (
  `cod_cancion` int(11) NOT NULL,
  `anio` int(11) DEFAULT NULL,
  `titulo_cancion` varchar(25) DEFAULT NULL,
  `foto_album_url` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cancion`
--

INSERT INTO `cancion` (`cod_cancion`, `anio`, `titulo_cancion`, `foto_album_url`) VALUES
(1, 2020, 'Dulce Despertar en Zumba', 'image/album/.scv'),
(2, 2010, 'A Otra Cosa Mariposa', 'image/album/.scv'),
(3, 2014, 'De Mi Cantar, la Samba', 'image/album/.scv'),
(4, 2008, 'Quisiera Ser Tu Bamba', 'image/album/.scv');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD PRIMARY KEY (`cod_cancion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
