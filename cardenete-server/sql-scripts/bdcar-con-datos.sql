-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 18-02-2019 a las 07:50:01
-- Versión del servidor: 5.7.23
-- Versión de PHP: 7.1.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` int(11) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` datetime NOT NULL,
  `articulo` longtext NOT NULL,
  `etiquetas` varchar(255) DEFAULT NULL,
  `id_seccion` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `titulo`, `descripcion`, `fecha`, `articulo`, `etiquetas`, `id_seccion`, `id_usuario`) VALUES
(1, 'Cierre de la fuente de los caños', 'Debido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses', '2019-02-18 16:32:00', 'Debido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses\r\nDebido a un filtrado de gasoil al agua de la fuente se procede a precintar la fuente durante los próximos 3 meses', 'fuente,gasoil,potable,los caños', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `descripcion`) VALUES
(1, 'Naturaleza'),
(2, 'Monumentos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id` int(11) NOT NULL,
  `nom_imagen` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `foto` varchar(255) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id`, `nom_imagen`, `descripcion`, `foto`, `id_usuario`, `id_categoria`) VALUES
(1, 'Foto', 'foto', 'foto.jpg', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `id` int(11) NOT NULL,
  `nom_seccion` varchar(255) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`id`, `nom_seccion`, `descripcion`) VALUES
(3, 'Anuncios', 'tablon de anuncios'),
(4, 'Datos de interés', 'En esta sección encontrarás datos sobre Cardenete, datos relativos a su origen, historia, su clima o situación geográfica.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencia`
--

CREATE TABLE `sugerencia` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sugerencia` longtext NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sugerencia`
--

INSERT INTO `sugerencia` (`id`, `nombre`, `email`, `sugerencia`, `id_usuario`) VALUES
(1, 'Anonimo', 'Anonimo', '¿Podría el ayuntamiento hacer una pista de patinaje en la plaza?', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`id`, `descripcion`) VALUES
(1, 'Administrador'),
(2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `ape1` varchar(255) NOT NULL,
  `ape2` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fecha_alta` datetime NOT NULL,
  `login` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `confirmado` tinyint(1) NOT NULL,
  `id_tipo_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `ape1`, `ape2`, `fecha_nacimiento`, `fecha_alta`, `login`, `pass`, `email`, `token`, `confirmado`, `id_tipo_usuario`) VALUES
(1, 'Hector', 'Martinez', 'Martinez', '1998-11-27', '2019-01-23 00:00:00', 'hec3555', 'babydriver', 'hec3555@gmail.com', 'ajajajajuasjuasjuasxdxd', 0, 1),
(2, 'Usuario', 'apeUsu1', 'apeUsu2', '1995-06-05', '2019-02-18 16:37:00', 'usuario', 'usuario', 'usuario@usu.com', 'lkjdsaf83424SDasf32pr8sdfasdaf', 1, 2),
(3, 'Administrador', 'apeAdmin1', 'apeAdmin2', '1998-11-27', '2019-02-18 16:39:00', 'admin', 'admin', 'admin@admin.com', 'nvhafowefskjfhafasfmasfiu32twrfqa9876431wqr1', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_articulo_seccion_idx` (`id_seccion`),
  ADD KEY `fk_articulo_usuario1_idx` (`id_usuario`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_imagen_usuario1_idx` (`id_usuario`),
  ADD KEY `fk_imagen_categoria1_idx` (`id_categoria`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sugerencia_usuario1_idx` (`id_usuario`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario_tipo_usuario1_idx` (`id_tipo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `seccion`
--
ALTER TABLE `seccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `fk_articulo_seccion` FOREIGN KEY (`id_seccion`) REFERENCES `seccion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_articulo_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `fk_imagen_categoria1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_imagen_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD CONSTRAINT `fk_sugerencia_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipo_usuario1` FOREIGN KEY (`id_tipo_usuario`) REFERENCES `tipo_usuario` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
