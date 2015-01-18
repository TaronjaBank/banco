-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.40-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Volcando datos para la tabla banco.cliente: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`) VALUES
	(1, '123456789-R', 'Marti', 'Gomez', 'Fabia'),
	(2, '987654321-Q', 'Jona', 'Hidalgo', 'Mora'),
	(3, '123456789-A', 'Ivan', 'Sanchez', 'Aaaa'),
	(4, '123456789-B', 'Fran', 'Navarro', 'Flores'),
	(5, 'prueba', 'prueba', 'prueba', 'prueba');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando datos para la tabla banco.cuentabancaria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`) VALUES
	(1, 123456789, 1, 2),
	(2, 987654321, 2, 2),
	(3, 0, 3, 2),
	(4, 789654123, 4, 3),
	(5, 444444444, 5, 2);
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;

-- Volcando datos para la tabla banco.empleado: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`idEmpleado`, `dniEmpleado`, `nombreEmpleado`, `apellido1Empleado`, `apellido2Empleado`, `idSucursalBancaria`, `loginEmpleado`, `passwordEmpleado`) VALUES
	(5, 'prueba', 'prueba', 'prueba', 'prueba', 5, 'a', 'a'),
	(1, '12345-A', 'Marti', 'Gomez', 'Fabia', 1, 'login1', 'password1'),
	(2, '67890-B', 'Jona', 'Hidalgo', 'Mora', 2, 'login2', 'password2'),
	(3, '12345-B', 'Ivan', 'Sanchez', 'Aaaa', 3, 'login3', 'password3'),
	(4, '45678-C', 'Fran', 'Navarro', 'Flores', 4, 'login4', 'password4');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando datos para la tabla banco.entidadbancaria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, 'SB', 'Sabadell', '2014-10-08'),
	(2, 'ST', 'Santander', '2014-10-08'),
	(3, 'BBVA', 'Banco Bilbao', '2014-10-17'),
	(4, 'BK', 'Bankia', '2014-10-17'),
	(5, 'prueba', 'prueba', '2014-10-17');
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;

-- Volcando datos para la tabla banco.movimientobancario: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `movimientobancario` DISABLE KEYS */;
INSERT INTO `movimientobancario` (`idMovimientoBancario`, `idCuentaBancariaOrigen`, `idCuentaBancariaDestino`, `cantidadMovimientoBancario`, `tipoMovimiento`) VALUES
	(1, 2, 3, 4536.00, 'HABER'),
	(5, 3, 6, 445.00, 'HABER'),
	(6, 2, 1, 234.00, 'HABER'),
	(7, 4, 4, 2345.00, 'HABER'),
	(9, 1, 4, 432.00, 'HABER');
/*!40000 ALTER TABLE `movimientobancario` ENABLE KEYS */;

-- Volcando datos para la tabla banco.schema_version: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `schema_version` DISABLE KEYS */;
INSERT INTO `schema_version` (`version_rank`, `installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
	(1, 1, '01', 'scriptinicial', 'SQL', 'V01__scriptinicial.sql', -1554046774, 'root', '2015-01-17 16:26:45', 812, 1),
	(2, 2, '02', 'insertardatos', 'SQL', 'V02__insertardatos.sql', 650536516, 'root', '2015-01-17 16:26:46', 312, 1);
/*!40000 ALTER TABLE `schema_version` ENABLE KEYS */;

-- Volcando datos para la tabla banco.sucursalbancaria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `sucursalbancaria` DISABLE KEYS */;
INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
	(1, 'Susursal1', 'Valencia', 1),
	(2, 'Sucursal2', 'Madrid', 2),
	(3, 'Susursal3', 'Valencia', 1),
	(4, 'Sucursal4', 'Barcelona', 1),
	(5, 'prueba', 'prueba', 3);
/*!40000 ALTER TABLE `sucursalbancaria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
