
ALTER TABLE `cliente` DISABLE KEYS ;
ALTER TABLE `cuentaBancaria` DISABLE KEYS ;
ALTER TABLE `empleado` DISABLE KEYS ;
ALTER TABLE `entidadBancaria` DISABLE KEYS ;
ALTER TABLE `movimientoBancario` DISABLE KEYS ;
ALTER TABLE `sucursalBancaria` DISABLE KEYS ;



INSERT INTO `entidadBancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, 'SBcam', 'Sabadell', '2015-01-18'),
	(2, 'ST', 'Santander', '2014-10-08'),
	(3, 'BBVA', 'Banco Bilbao', '2014-10-17'),
	(4, 'BK', 'Bankia', '2014-10-17'),
	(6, 'Bankia2', 'Bankia2', '2015-01-01');

INSERT INTO `sucursalBancaria` (`idSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
	(2, 'Sucursal2', 'Madrid', 2),
	(3, 'Susursal3', 'Valencia', 1),
	(4, 'Sucursal4', 'Barcelona', 2),
	(5, 'prueba', 'prueba', 3),
	(6, 'dsf', 'dfgh', 2),
	(7, 'dfg', 'dfg', 4),
	(8, 'sdf', 'sdf', 4);

INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`, `loginCliente`, `passwordCliente`) VALUES
	(1, '123456789-R', 'Marti', 'Gomez', 'Fabia', 'cliente1', 'cliente1'),
	(2, '987654321-Q', 'Jona', 'Hidalgo', 'Mora', 'cliente2', 'cliente2'),
	(3, '123456789-A', 'Ivan', 'Sanchez', 'Aaaa', 'cliente3', 'cliente3'),
	(4, '123456789-B', 'Fran', 'Navarro', 'Flores', 'cliente4', 'cliente4'),
	(5, 'prueba', 'prueba', 'prueba', 'prueba', 'b', 'b');

INSERT INTO `cuentaBancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`, `saldoCuentaBancaria`) VALUES
	(1, 123456789, 2, 2, 0),
	(2, 987654321, 2, 2, 0),
	(3, 0, 3, 2, 0),
	(4, 789654123, 4, 3, 0),
	(5, 444444444, 5, 2, 0),
	(6, 234, 2, 2, 0),
	(7, 33333333, 5, 1, 0);

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