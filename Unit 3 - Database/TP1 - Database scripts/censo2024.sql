-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 17-09-2025 a las 00:53:14
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
-- Base de datos: `censo2024`
--
CREATE DATABASE IF NOT EXISTS `censo2024` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `censo2024`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitante`
--

CREATE TABLE `habitante` (
  `NRO_HABIT` int(11) NOT NULL,
  `PROVINCIA` varchar(20) NOT NULL,
  `EDAD` int(11) NOT NULL,
  `NIVEL_EDUCATIVO_ALCANZADO` varchar(15) NOT NULL,
  `USA_COMPUTADORAS` tinyint(1) NOT NULL,
  `TRABAJA` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitante`
--

INSERT INTO `habitante` (`NRO_HABIT`, `PROVINCIA`, `EDAD`, `NIVEL_EDUCATIVO_ALCANZADO`, `USA_COMPUTADORAS`, `TRABAJA`) VALUES
(1, 'Chaco', 18, 'Secundario', 0, 1),
(2, 'Neuquén', 35, 'Ninguno', 0, 1),
(3, 'Mendoza', 70, 'Primario', 1, 0),
(4, 'Córdoba', 73, 'Secundario', 1, 0),
(5, 'Santa Cruz', 70, 'Ninguno', 0, 1),
(6, 'Catamarca', 18, 'Secundario', 0, 1),
(7, 'La Rioja', 68, 'Universitario', 0, 1),
(8, 'Formosa', 17, 'Secundario', 0, 1),
(9, 'Chubut', 41, 'Ninguno', 0, 0),
(10, 'San Luis', 67, 'Secundario', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitante`
--
ALTER TABLE `habitante`
  ADD PRIMARY KEY (`NRO_HABIT`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
