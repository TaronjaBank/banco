

INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`) VALUES
	(1, '123456789-R', 'Marti', 'Gomez', 'Fabia'),
	(2, '987654321-Q', 'Jona', 'Hidalgo', 'Mora'),
	(3, '123456789-A', 'Ivan', 'Sanchez', 'Aaaa'),
	(4, '123456789-B', 'Fran', 'Navarro', 'Flores'),
	(5, 'prueba', 'prueba', 'prueba', 'prueba');

INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idEntidadBancaria`, `idCliente`) VALUES
	(1, 123456789, 1, 2),
	(2, 987654321, 2, 2),
	(3, 0, 3, 2),
	(4, 789654123, 4, 3),
	(5, 444444444, 5, 2);

INSERT INTO `empleado` (`idEmpleado`, `dniEmpleado`, `nombreEmpleado`, `apellido1Empleado`, `apellido2Empleado`, `idSucursalBancaria`) VALUES
	(1, '12345-A', 'Marti', 'Gomez', 'Fabia', 1),
	(2, '67890-B', 'Jona', 'Hidalgo', 'Mora', 2),
	(3, '12345-B', 'Ivan', 'Sanchez', 'Aaaa', 3),
	(4, '45678-C', 'Fran', 'Navarro', 'Flores', 4),
	(5, 'prueba', 'prueba', 'prueba', 'prueba', 5);

INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, 'SB', 'Sabadell', '2014-10-08'),
	(2, 'ST', 'Santander', '2014-10-08'),
	(3, 'BBVA', 'Banco Bilbao', '2014-10-17'),
	(4, 'BK', 'Bankia', '2014-10-17'),
	(5, 'prueba', 'prueba', '2014-10-17');

INSERT INTO `movimientobancario` (`idMovimientoBancario`, `idCuentaBancariaOrigen`, `idCuentaBancariaDestino`, `cantidadMovimientoBancario`, `conceptoMovimientoBancario`) VALUES
	(1, 1, 2, 500.00, 'AAAAA'),
	(2, 1, 3, 500.00, 'BBBBB'),
	(3, 1, 4, 500.00, 'CCCCC'),
	(4, 2, 3, 500.00, 'DDDDD');

INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
	(1, 'Susursal1', 'Valencia', 1),
	(2, 'Sucursal2', 'Madrid', 2),
	(3, 'Susursal3', 'Valencia', 1),
	(4, 'Sucursal4', 'Barcelona', 1),
	(5, 'prueba', 'prueba', 3);
