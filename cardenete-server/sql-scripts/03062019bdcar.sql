-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-06-2019 a las 23:07:16
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

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
(2, 'prueba 5', 'asdfa sfsadjflsadjf lasd jfasldf jlñaksdfjlkñasdjf lñadskjf lañsdfj ñlasjf', '2019-05-27 00:00:00', '<p>sadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfaf</p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p>asdf</p><p><br></p><p><br></p><p><br></p><p>sadf</p><p><br></p><p><br></p><p><br></p><p><br></p><p>sadfsad</p><p>f</p><p>sadf</p>', NULL, 2, 7),
(22, 'prueba 5', 'asdfa sfsadjflsadjf lasd jfasldf jlñaksdfjlkñasdjf lñadskjf lañsdfj ñlasjf', '2019-04-11 00:00:00', 'sadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfafsadfj asldfasdhf ksahdf kashdflkashfdasdfaf', NULL, 2, 2),
(26, 'La fuente vuelve a estar operativa!', 'Lee más abajo si quieres saber por qué!!', '2019-05-26 18:35:18', '<p>POS PORQUE ME CAGO EN TOS TUS MALOS MUERTOS JOPUTA</p><table style=\"width: 100%;\"><tbody><tr><td style=\"width: 50.0000%;\">asdfasdf</td><td style=\"width: 50.0000%;\">sadfasdfsad</td></tr><tr><td style=\"width: 50.0000%;\">fasdfas</td><td style=\"width: 50.0000%;\">fasdfasfd</td></tr></tbody></table><p><br></p><p><br></p><p><br></p><p>asdfasdf</p><p>asdf</p><p>asdf</p><p><br></p><p><br></p><p><br></p><p>safdas</p><p>dfasdfasdfsdfds</p><p>sadf</p>', '', 2, 2),
(27, 'Bolsa de empleo abierta!', 'La bolsa de empleo para trabajar en la vivienda tutelada está abierta!', '2019-05-29 02:28:14', '<p><span style=\"font-size: 30px;\">Bolsa de empleo para la vivienda tutelada</span></p><p>Los <span style=\"background-color: rgb(247, 218, 100);\">requisitos</span> que se deben de reunir son:</p><ol><li>T&iacute;tulo de <strong>cuidados</strong><strong>&nbsp;a personas con necesidad y discapacitados</strong>.</li><li>T&iacute;tulo de <strong>primeros auxilios</strong>.</li><li>Curso de <strong>prevenci&oacute;n de riesgos laborales.</strong></li><li>Buena <strong>presencia</strong> y <strong>puntualidad</strong>.</li><li><strong>Amabilidad</strong> con los pacientes.</li></ol><p><span style=\"color: rgb(226, 80, 65);\">Se valorar&aacute; de manera positiva la experiencia de trabajo en puestos similares.</span></p>', '', 2, 1),
(28, 'Aviso CORTE DE AGUA', 'Debido a un mantenimiento, se cortará el agua en las siguientes zonas del pueblo.', '2019-05-29 02:30:37', '<p>Debido a la rotura de la arqueta situada en la plaza, durante el d&iacute;a 03 de junio se cortar&aacute; el agua para proceder al cambio de la misma</p>', '', 2, 1),
(32, 'DIRECCIONES Y TELÉFONOS', 'Direcciones y teléfonos de locales interesantes y servicios importantes de Cardenete.', '2019-06-01 18:50:24', '<table border=\"0\" width=\"89%\"><tbody><tr><td align=\"left\" width=\"50%\">AYUNTAMIENTO:</td><td align=\"left\" width=\"30%\">&nbsp; Plaza Sanochaores, 1.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 01</td></tr><tr><td align=\"left\">SERVICIOS SOCIALES:</td><td align=\"left\">&nbsp; C/ Nueva, 20.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 81 29</td></tr><tr><td align=\"left\">OFICINA MUNICIPAL DE INFORMACI&Oacute;N Y CONSUMO:</td><td align=\"left\">&nbsp; C/ Nueva, 20.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 81 29</td></tr><tr><td align=\"left\">LUDOTECA MUNICIPAL:</td><td align=\"left\">&nbsp; C/ Nueva, 20.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 81 29</td></tr><tr><td align=\"left\">VIVIENDA DE MAYORES:</td><td align=\"left\">&nbsp; C/ Nueva, 20.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 81 52</td></tr><tr><td align=\"left\">GUARDIA CIVIL:</td><td align=\"left\">&nbsp; C/ Gral. Juan Ramos Herraiz, 6</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 21</td></tr><tr><td align=\"left\">CENTRO DE SALUD:</td><td align=\"left\">&nbsp; C/ La Iglesia, 1.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 82 10</td></tr><tr><td align=\"left\">FARMACIA:</td><td align=\"left\">&nbsp; C/ La Iglesia, 29.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 03</td></tr><tr><td align=\"left\">COLEGIO RURAL AGRUPADO &quot;SERRAN&Iacute;A BAJA&quot;:</td><td align=\"left\">&nbsp; C/ Amargura, 47.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 81 28</td></tr><tr><td align=\"left\">BAR-HOSTAL TRES HERMANOS:</td><td align=\"left\">&nbsp; C/ La Iglesia, 40.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 40</td></tr><tr><td align=\"left\">MES&Oacute;N TORRES:</td><td align=\"left\">&nbsp; C/ La Iglesia, 31.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 20</td></tr><tr><td align=\"left\">PUB TONY&#39;S:</td><td align=\"left\">&nbsp; C/ La Iglesia, 32.</td><td align=\"left\" colspan=\"2\">&nbsp;&nbsp;</td></tr><tr><td align=\"left\">HOGAR DEL PENSIONISTA:</td><td align=\"left\">&nbsp; Plaza Sanochaores, 1 bajo.</td><td align=\"left\" colspan=\"2\">&nbsp;&nbsp;</td></tr><tr><td align=\"left\" valign=\"top\"><a href=\"http://www.casaruralelatroje.com/\" target=\"_blank\">RESTAURANTE LA REBOTICA:</a></td><td align=\"left\" valign=\"top\">&nbsp; C/ La Iglesia, 27.</td><td align=\"left\" width=\"7%\">&nbsp; Tfno:<br>&nbsp; &nbsp; &nbsp; &nbsp;</td><td align=\"left\" width=\"13%\">969 34 80 24<br>629 57 10 15</td></tr><tr><td align=\"left\"><a href=\"http://www.arelcastillo.com/\" target=\"_blank\">APARTAMENTOS RURALES EL CASTILLO:</a></td><td align=\"left\">&nbsp; C/ Gandarra, 12.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 82 59</td></tr><tr><td align=\"left\" valign=\"top\"><a href=\"http://www.casarurallatinaja.com/\" target=\"_blank\">CASA RURAL LA TINAJA:</a></td><td align=\"left\" valign=\"top\">&nbsp; Plaza Sanochaores, 2.</td><td align=\"left\" width=\"7%\">&nbsp; Tfno:<br>&nbsp; &nbsp; &nbsp; &nbsp;</td><td align=\"left\" width=\"13%\">969 34 82 59<br>617 85 77 02</td></tr><tr><td align=\"left\" valign=\"top\"><a href=\"http://www.casaruralelatroje.com/\" target=\"_blank\">CASA RURAL EL ATROJE:</a></td><td align=\"left\" valign=\"top\">&nbsp; C/ La Amargura, 15.</td><td align=\"left\" valign=\"top\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 24<br>629 57 10 15</td></tr><tr><td align=\"left\" width=\"50%\">CASA RURAL EL ESTUDIO:</td><td align=\"left\" width=\"30%\">&nbsp; Cr Cruce de Y&eacute;meda.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">630 17 59 36</td></tr><tr><td align=\"left\" valign=\"top\"><a href=\"http://www.apartamentoselnido.com/\" target=\"_blank\">APARTAMENTOS RURALES EL NIDO:</a></td><td align=\"left\" valign=\"top\">&nbsp; C/ Obispo Torrijos, 1.</td><td align=\"left\" valign=\"top\">&nbsp; Tfno:</td><td align=\"left\">969 34 89 93<br>638 92 07 68</td></tr><tr><td align=\"left\" valign=\"top\"><a href=\"https://www.carpinteriatortola.es/\" target=\"_blank\">CARPINTER&Iacute;A T&Oacute;RTOLA:</a></td><td align=\"left\" valign=\"top\">&nbsp; C/ Molino, 19.</td><td align=\"left\" valign=\"top\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 97<br>620 14 12 68</td></tr><tr><td align=\"left\" valign=\"top\"><a href=\"http://www.vilarhoyos.es/\" target=\"_blank\">HERMANOS VILAR HOYOS:</a></td><td align=\"left\" valign=\"top\">&nbsp; Cr Camporrobles, 2.</td><td align=\"left\" valign=\"top\">&nbsp; Tfno:</td><td align=\"left\">969 34 81 48</td></tr><tr><td align=\"left\" width=\"50%\">ESTACI&Oacute;N DE SERVICIO JOS&Eacute; ANTONIO MACHIR&Aacute;N:</td><td align=\"left\" width=\"30%\">&nbsp; Cr Camporrobles, 109.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 51</td></tr><tr><td align=\"left\" width=\"50%\">SUMINISTROS INDUSTRIALES LA CERCA:</td><td align=\"left\" width=\"30%\">&nbsp; C/ La Cerca, 2.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">606 55 31 62</td></tr><tr><td align=\"left\" width=\"50%\">CHARTER - COMERCIAL YEPES ESLAVA:</td><td align=\"left\" width=\"30%\">&nbsp; C/ La Iglesia, 6.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 11</td></tr><tr><td align=\"left\" width=\"50%\">PANADER&Iacute;A TEJEDA:</td><td align=\"left\" width=\"30%\">&nbsp; C/ La Iglesia, 7.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 82 95</td></tr><tr><td align=\"left\" width=\"50%\">JOS&Eacute; ANTONIO AU&Ntilde;&Oacute;N ESLAVA:</td><td align=\"left\" width=\"30%\">&nbsp; C/ Amargura, 24.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 33</td></tr><tr><td align=\"left\" width=\"50%\">AMADEO AU&Ntilde;&Oacute;N ESLAVA:</td><td align=\"left\" width=\"30%\">&nbsp; C/ Amargura, 10.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 82 03</td></tr><tr><td align=\"left\" width=\"50%\">LIBERBANK:</td><td align=\"left\" width=\"30%\">&nbsp; C/ La Iglesia, 31.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 80 06</td></tr><tr><td align=\"left\" width=\"50%\">GLOBALCAJA:</td><td align=\"left\" width=\"30%\">&nbsp; C/ La Iglesia, 13.</td><td align=\"left\">&nbsp; Tfno:</td><td align=\"left\">969 34 83 04</td></tr></tbody></table>', '', 1, 1),
(33, ' HORARIOS DE AUTOBUSES', '', '2019-06-01 19:00:31', '<div style=\"text-align: center;\"></div><table border=\"0\" width=\"53%\"><tbody><tr align=\"center\" valign=\"middle\"><td width=\"50%\"><div style=\"text-align: center;\"><u>Cardenete</u></div></td><td width=\"50%\"><div style=\"text-align: center;\"><u>Cuenca</u></div></td></tr><tr align=\"center\" valign=\"middle\"><td><div style=\"text-align: center;\">06:45</div></td><td><div style=\"text-align: center;\">07:45</div></td></tr><tr align=\"center\" valign=\"middle\"><td><div style=\"text-align: center;\">&nbsp;</div></td><td><div style=\"text-align: center;\">&nbsp;</div></td></tr><tr align=\"center\" valign=\"middle\"><td width=\"50%\"><div style=\"text-align: center;\"><u>Cuenca</u></div></td><td width=\"50%\"><div style=\"text-align: center;\"><u>Cardenete</u></div></td></tr><tr align=\"center\" valign=\"middle\"><td><div style=\"text-align: center;\">14:30</div></td><td><div style=\"text-align: center;\">15:30</div></td></tr></tbody></table><div style=\"text-align: center;\"></div><div style=\"text-align: center;\"></div>', '', 1, 1);

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
(1, 'pene', NULL, 'enlace foto', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `id` int(11) NOT NULL,
  `nom_seccion` varchar(255) NOT NULL,
  `descripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`id`, `nom_seccion`, `descripcion`) VALUES
(1, 'Información', ''),
(2, 'Tablón de anuncios', 'Mira las novedades que ocurren en Cardenete!');

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
(2, 'Usuario'),
(11, 'prueba11'),
(12, 'prueba12'),
(13, 'prueba13'),
(14, 'prueba14');

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
  `token` varchar(255) DEFAULT NULL,
  `confirmado` tinyint(1) NOT NULL,
  `id_tipo_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `ape1`, `ape2`, `fecha_nacimiento`, `fecha_alta`, `login`, `pass`, `email`, `token`, `confirmado`, `id_tipo_usuario`) VALUES
(1, 'admin', 'admin', 'admin', '2019-05-01', '2019-05-26 03:16:17', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '', NULL, 1, 1),
(2, 'Hector', 'Martinez', 'Martinez', '2019-05-08', '2019-05-26 01:52:44', 'hec3555', '8c5fd24986a4248cebf8be6f4aa27cab81412c1ca042830765eac60544f880c5', 'hec3555@gmail.com', NULL, 1, 1),
(7, 'usuario', 'usuario', 'usuario', '2019-05-10', '2019-05-26 02:20:17', 'usuario', '9250e222c4c71f0c58d4c54b50a880a312e9f9fed55d5c3aa0b0e860ded99165', 'usuario@usuario.com', NULL, 1, 2),
(11, 'prueba11', 'prueba11', 'prueba11', '2019-05-01', '2019-05-26 03:16:17', 'prueba11', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '', NULL, 1, 1),
(12, 'prueba12', 'prueba12', 'prueba12', '2019-05-08', '2019-05-26 01:52:44', 'prueba12', '8c5fd24986a4248cebf8be6f4aa27cab81412c1ca042830765eac60544f880c5', 'hec3555@gmail.com', NULL, 1, 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

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
