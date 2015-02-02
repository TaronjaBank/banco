
ALTER TABLE `cliente` DISABLE KEYS ;
ALTER TABLE `cuentaBancaria` DISABLE KEYS ;
ALTER TABLE `empleado` DISABLE KEYS ;
ALTER TABLE `entidadBancaria` DISABLE KEYS ;
ALTER TABLE `movimientoBancario` DISABLE KEYS ;
ALTER TABLE `sucursalBancaria` DISABLE KEYS ;



INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, 'E001', 'Sabadell', '2015-01-18'),
	(2, 'E002', 'Santander', '2014-10-08'),
	(3, 'E003', 'Banco Bilbao', '2014-10-17'),
	(4, 'E004', 'Bankia', '2014-10-17'),
	(6, 'E006', 'Bankia2', '2015-01-01');

INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `codigoSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
	(2, 'S002', 'Sucursal2', 'Madrid', 2),
	(3, 'S003', 'Susursal3', 'Valencia', 1),
	(4, 'S004', 'Sucursal4', 'Barcelona', 2),
	(5, 'S005', 'prueba', 'prueba', 3),
	(6, 'S006', 'dsf', 'dfgh', 2),
	(7, 'S007', 'dfg', 'dfg', 4),
	(8, 'S008', 'sdf', 'sdf', 4);

INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`, `loginCliente`, `passwordCliente`) VALUES
	(1, '123456789-R', 'Marti', 'Gomez', 'Fabia', 'cliente1', 'cliente1'),
	(2, '987654321-Q', 'Jona', 'Hidalgo', 'Mora', 'cliente2', 'cliente2'),
	(3, '123456789-A', 'Ivan', 'Sanchez', 'Aaaa', 'cliente3', 'cliente3'),
	(4, '123456789-B', 'Fran', 'Navarro', 'Flores', 'cliente4', 'cliente4'),
	(5, 'prueba', 'prueba', 'prueba', 'prueba', 'b', 'b');

INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`, `saldoCuentaBancaria`) VALUES
	(1, 'E002-S002-1', 2, 2, 0.00),
	(2, 'E002-S002-2', 2, 4, 0.00),
	(3, 'E001-S003-3', 3, 2, 0.00),
	(4, 'E002-S004-4', 4, 3, 0.00),
	(5, 'E003-S005-5', 5, 4, 0.00),
	(6, 'E002-S002-6', 2, 2, 0.00),
	(7, 'E003-S005-7', 5, 1, 0.00);

INSERT INTO `movimientoBancario` (`idMovimientoBancario`, `idCuentaBancariaDestino`, `cantidadMovimientoBancario`, `tipoMovimiento`, `idCuentaBancaria`) VALUES
	(1, 2, 4536.00, 'DEBE', 1),
	(5, 3, 445.00, 'HABER', 3),
	(6, 2, 234.00, 'HABER', 1),
	(7, 4, 2345.00, 'DEBE', 2),
	(9, 1, 432.00, 'HABER', 4),
	(10, 2, 1324.00, 'DEBE', 2),
	(11, 1, 345.00, 'DEBE', 5);

INSERT INTO `empleado` (`idEmpleado`, `dniEmpleado`, `nombreEmpleado`, `apellido1Empleado`, `apellido2Empleado`, `idSucursalBancaria`, `loginEmpleado`, `passwordEmpleado`) VALUES
	(5, 'prueba', 'prueba', 'prueba', 'prueba', 5, 'a', 'a'),
	(1, '12345-A', 'Marti', 'Gomez', 'Fabia', 2, 'login1', 'password1'),
	(2, '67890-B', 'Jona', 'Hidalgo', 'Mora', 2, 'login2', 'password2'),
	(3, '12345-B', 'Ivan', 'Sanchez', 'Aaaa', 3, 'login3', 'password3'),
	(4, '45678-C', 'Fran', 'Navarro', 'Flores', 4, 'login4', 'password4');


ALTER TABLE `sucursalBancaria` ENABLE KEYS ;
ALTER TABLE `cliente` ENABLE KEYS ;
ALTER TABLE `movimientoBancario` ENABLE KEYS ;
 ALTER TABLE `entidadBancaria` ENABLE KEYS ;
ALTER TABLE `empleado` ENABLE KEYS;
 ALTER TABLE `cuentaBancaria` ENABLE KEYS ;
