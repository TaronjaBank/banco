
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `dniCliente` varchar(50) NOT NULL,
  `nombreCliente` varchar(50) NOT NULL,
  `apellido1Cliente` varchar(50) DEFAULT NULL,
  `apellido2Cliente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `dniEmpleado` varchar(50) DEFAULT '0',
  `nombreEmpleado` varchar(50) DEFAULT '0',
  `apellido1Empleado` varchar(50) DEFAULT '0',
  `apellido2Empleado` varchar(50) DEFAULT '0',
  `idSucursalBancaria` int(11) NOT NULL DEFAULT '0',
  `loginEmpleado` varchar(50) DEFAULT '0',
  `passwordEmpleado` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idEmpleado`),
  KEY `FKSucursalBancariaEmpleado` (`idSucursalBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;




CREATE TABLE `cuentaBancaria` (
  `idCuentaBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `numeroCuentaBancaria` int(11) NOT NULL DEFAULT '0',
  `idEntidadBancaria` int(11) NOT NULL DEFAULT '0',
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCuentaBancaria`),
  KEY `FKidEntidadBancariaCuenta` (`idEntidadBancaria`),
  KEY `FKidCliente` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;




CREATE TABLE `entidadBancaria` (
  `idEntidadBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEntidadBancaria` varchar(50) DEFAULT NULL,
  `nombreEntidadBancaria` varchar(50) DEFAULT NULL,
  `fechaCreacionEntidadBancaria` date DEFAULT NULL,
  PRIMARY KEY (`idEntidadBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;




CREATE TABLE `movimientoBancario` (
  `idMovimientoBancario` int(11) NOT NULL AUTO_INCREMENT,
  `idCuentaBancariaOrigen` int(11) NOT NULL,
  `idCuentaBancariaDestino` int(11) NOT NULL,
  `cantidadMovimientoBancario` decimal(10,2) DEFAULT '0.00',
  `conceptoMovimientoBancario` varchar(50) DEFAULT '0',
  PRIMARY KEY (`idMovimientoBancario`),
  KEY `FKCuentaBancariaMovimiento` (`idCuentaBancariaOrigen`),
  KEY `FKCuentaBancariaMovimiento2` (`idCuentaBancariaDestino`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;




CREATE TABLE `sucursalBancaria` (
  `idSucursalBancaria` int(11) NOT NULL AUTO_INCREMENT,
  `nombreSucursalBancaria` varchar(50) DEFAULT NULL,
  `direccionSucursalBancaria` varchar(50) DEFAULT NULL,
  `idEntidadBancaria` int(11) NOT NULL,
  PRIMARY KEY (`idSucursalBancaria`),
  KEY `FKEntidadBancariaSucursal` (`idEntidadBancaria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;



