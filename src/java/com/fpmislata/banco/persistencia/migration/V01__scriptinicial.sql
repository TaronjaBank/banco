CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEntidadBancaria` varchar(50) DEFAULT NULL,
  `nombreEntidadBancaria` varchar(50) DEFAULT NULL,
  `fechaCreacionEntidadBancaria` date DEFAULT NULL,
  PRIMARY KEY (`idEntidadBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursalBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSucursalBancaria` varchar(50) DEFAULT NULL,
  `direccionSucursalBancaria` varchar(50) DEFAULT NULL,
  `idEntidadBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idSucursalBancaria`),
  CONSTRAINT `FK_sucursalBancaria_entidadBancaria` FOREIGN KEY (`idEntidadBancaria`) REFERENCES `entidadbancaria` (`idEntidadBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `dniCliente` varchar(50) NOT NULL,
  `nombreCliente` varchar(50) NOT NULL,
  `apellido1Cliente` varchar(50) DEFAULT NULL,
  `apellido2Cliente` varchar(50) DEFAULT NULL,
  `loginCliente` varchar(50) NOT NULL,
  `passwordCliente` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuentaBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `numeroCuentaBancaria` int(11) NOT NULL DEFAULT '0',
  `idSucursalBancaria` int(11) NOT NULL DEFAULT '0',
  `idCliente` int(11) DEFAULT NULL,
`saldoCuentaBancaria` decimal(10,2) DEFAULT '0',
  PRIMARY KEY (`idCuentaBancaria`),
  CONSTRAINT `FK_cuentabancaria_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_cuentabancaria_sucursalbancaria` FOREIGN KEY (`idSucursalBancaria`) REFERENCES `sucursalbancaria` (`idSucursalBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `idCuentaBancariaDestino` int(11) NOT NULL,
  `cantidadMovimientoBancario` decimal(10,2) DEFAULT '0.00',
  `tipoMovimiento` enum('DEBE','HABER') NOT NULL DEFAULT 'DEBE',
  `idCuentaBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idMovimientoBancario`),
  CONSTRAINT `FK_movimientobancario_cuentabancaria` FOREIGN KEY (`idCuentaBancaria`) REFERENCES `cuentabancaria` (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmpleado` int(11) NOT NULL DEFAULT '0',
  `dniEmpleado` varchar(50) DEFAULT '0',
  `nombreEmpleado` varchar(50) DEFAULT '0',
  `apellido1Empleado` varchar(50) DEFAULT '0',
  `apellido2Empleado` varchar(50) DEFAULT '0',
  `idSucursalBancaria` int(11) NOT NULL DEFAULT '0',
  `loginEmpleado` varchar(50) NOT NULL DEFAULT '0',
  `passwordEmpleado` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idEmpleado`),
  CONSTRAINT `FK_empleado_sucursalbancaria` FOREIGN KEY (`idSucursalBancaria`) REFERENCES `sucursalbancaria` (`idSucursalBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
