CREATE TABLE IF NOT EXISTS `entidadBancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEntidadBancaria` varchar(4) DEFAULT NULL,
  `nombreEntidadBancaria` varchar(50) DEFAULT NULL,
  `fechaCreacionEntidadBancaria` date DEFAULT NULL,
  PRIMARY KEY (`idEntidadBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `sucursalBancaria` (
  `idSucursalBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `codigoSucursalBancaria` varchar(4) DEFAULT NULL,
  `nombreSucursalBancaria` varchar(50) DEFAULT NULL,
  `direccionSucursalBancaria` varchar(50) DEFAULT NULL,
  `idEntidadBancaria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSucursalBancaria`),
  CONSTRAINT `FK_sucursalBancaria_entidadBancaria` FOREIGN KEY (`idEntidadBancaria`) REFERENCES `entidadBancaria` (`idEntidadBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `dniCliente` varchar(50) DEFAULT NULL,
  `nombreCliente` varchar(50) DEFAULT NULL,
  `apellido1Cliente` varchar(50) DEFAULT NULL,
  `apellido2Cliente` varchar(50) DEFAULT NULL,
  `loginCliente` varchar(50) DEFAULT NULL,
  `passwordCliente` varchar(50) DEFAULT NULL,
  `apiKey` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `cuentaBancaria` (
  `idCuentaBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `numeroCuentaBancaria` varchar(50) DEFAULT NULL,
  `idSucursalBancaria` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `saldoCuentaBancaria` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idCuentaBancaria`),
  CONSTRAINT `FK_cuentabancaria_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_cuentabancaria_sucursalbancaria` FOREIGN KEY (`idSucursalBancaria`) REFERENCES `sucursalBancaria` (`idSucursalBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `movimientoBancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `conceptoMovimientoBancario` varchar(150) DEFAULT NULL,
  `cantidadMovimientoBancario` decimal(10,2) DEFAULT NULL,
  `tipoMovimiento` enum('DEBE','HABER') DEFAULT NULL,
  `idCuentaBancaria` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoBancario`),
  CONSTRAINT `FK_movimientobancario_cuentabancaria` FOREIGN KEY (`idCuentaBancaria`) REFERENCES `cuentaBancaria` (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `dniEmpleado` varchar(50) DEFAULT NULL,
  `nombreEmpleado` varchar(50) DEFAULT NULL,
  `apellido1Empleado` varchar(50) DEFAULT NULL,
  `apellido2Empleado` varchar(50) DEFAULT NULL,
  `idSucursalBancaria` int(11) DEFAULT NULL,
  `loginEmpleado` varchar(50) DEFAULT NULL,
  `passwordEmpleado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`),
  CONSTRAINT `FK_empleado_sucursalbancaria` FOREIGN KEY (`idSucursalBancaria`) REFERENCES `sucursalBancaria` (`idSucursalBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
