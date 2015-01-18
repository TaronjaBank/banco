INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`) VALUES
	(1, '123456789-R', 'Marti', 'Gomez', 'Fabia'),
	(2, '987654321-Q', 'Jona', 'Hidalgo', 'Mora'),
	(3, '123456789-A', 'Ivan', 'Sanchez', 'Aaaa'),
	(4, '123456789-B', 'Fran', 'Navarro', 'Flores'),
	(5, 'prueba', 'prueba', 'prueba', 'prueba');



INSERT INTO `empleado` (`idEmpleado`, `dniEmpleado`, `nombreEmpleado`, `apellido1Empleado`, `apellido2Empleado`, `idSucursalBancaria`, `loginEmpleado`, `passwordEmpleado`) VALUES
	(5, 'prueba', 'prueba', 'prueba', 'prueba', 5, 'a', 'a'),
	(1, '12345-A', 'Marti', 'Gomez', 'Fabia', 1, 'login1', 'password1'),
	(2, '67890-B', 'Jona', 'Hidalgo', 'Mora', 2, 'login2', 'password2'),
	(3, '12345-B', 'Ivan', 'Sanchez', 'Aaaa', 3, 'login3', 'password3'),
	(4, '45678-C', 'Fran', 'Navarro', 'Flores', 4, 'login4', 'password4');



INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, 'SB', 'Sabadell', '2014-10-08'),
	(2, 'ST', 'Santander', '2014-10-08'),
	(3, 'BBVA', 'Banco Bilbao', '2014-10-17'),
	(4, 'BK', 'Bankia', '2014-10-17'),
	(5, 'prueba', 'prueba', '2014-10-17');

INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
	(1, 'Susursal1', 'Valencia', 1),
	(2, 'Sucursal2', 'Madrid', 2),
	(3, 'Susursal3', 'Valencia', 1),
	(4, 'Sucursal4', 'Barcelona', 1),
	(5, 'prueba', 'prueba', 3);

INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`) VALUES
	(1, 123456789, 1, 2),
	(2, 987654321, 2, 2),
	(3, 0, 3, 2),
	(4, 789654123, 4, 3),
	(5, 444444444, 5, 2);

INSERT INTO `movimientobancario` (`idMovimientoBancario`, `idCuentaBancariaOrigen`, `cantidadMovimientoBancario`, `tipoMovimiento`, `idCuentaBancaria`) VALUES
	(1, 2, 4536.00, 'HABER', 3),
	(5, 3, 445.00, 'HABER', 3),
	(6, 2, 234.00, 'HABER', 1),
	(7, 4, 2345.00, 'HABER', 3),
	(9, 1, 432.00, 'HABER', 4);

