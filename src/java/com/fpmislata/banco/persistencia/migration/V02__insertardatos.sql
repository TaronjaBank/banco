



INSERT INTO `entidadBancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, '0001', 'Sabadell', '2015-01-18'),
	(2, '0002', 'Santander', '2014-10-08'),
	(3, '0003', 'Banco Bilbao', '2014-10-17'),
	(4, '0004', 'Bankia', '2014-10-17'),
	(6, '0006', 'Bankia2', '2015-01-01');

INSERT INTO `sucursalBancaria` (`idSucursalBancaria`, `codigoSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
	(2, '0002', 'Sucursal2', 'Valencia', 2),
	(3, '0003', 'Sucursal3', 'Madrid', 1),
	(4, '0004', 'Sucursal4', 'Barcelona', 2),
	(5, '0005', 'Sucursal5', 'Zaragoza', 3),
	(6, '0006', 'Sucursal6', 'Sevilla', 2),
	(7, '0007', 'Sucursal7', 'Lepe', 4),
	(8, '0008', 'Sucursal8', 'Valencia', 4);

INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`, `loginCliente`, `passwordCliente`, `apiKey`) VALUES
	(1, '00000001R', 'Marti', 'Gomez', 'Fabia', 'cliente1', 'cliente1', '1111111111'),
	(2, '00000002W', 'Jona', 'Hidalgo', 'Mora', 'cliente2', 'cliente2', '2222222222'),
	(3, '00000003A', 'Ivan', 'Sanchez', 'Aaaa', 'cliente3', 'cliente3', '3333333333'),
	(4, '00000004G', 'Fran', 'Navarro', 'Flores', 'cliente4', 'cliente4', '4444444444'),
	(5, '00000005M', 'prueba', 'prueba', 'prueba', 'b', 'b', '5555555555'),
        (6, '00000000Y', 'Taronja', 'Games', 'SL', 'taronja', 'taronja', '6666666666');

INSERT INTO `cuentaBancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`, `saldoCuentaBancaria`) VALUES
	(1, '0002-0002-0001', 2, 6, 10000),
	(2, '0002-0002-0002', 2, 4, 10000),
	(3, '0001-0003-0003', 3, 2, 10000),
	(4, '0002-0004-0004', 4, 3, 10000),
	(5, '0003-0005-0005', 5, 4, 10000),
	(6, '0002-0002-0006', 2, 2, 10000),
	(7, '0003-0005-0007', 5, 1, 10000);

INSERT INTO `movimientoBancario` (`idMovimientoBancario`, `conceptoMovimientoBancario`, `cantidadMovimientoBancario`, `tipoMovimiento`, `idCuentaBancaria`) VALUES
	(1, 'Ingreso Inicial', 0, 'HABER', 1),
	(5, 'Ingreso Inicial', 0, 'HABER', 2),
	(6, 'Ingreso Inicial', 0, 'HABER', 3),
	(7, 'Ingreso Inicial', 0, 'HABER', 4),
	(9, 'Ingreso Inicial', 0, 'HABER', 5),
	(10, 'Ingreso Inicial', 0, 'HABER', 6),
	(11, 'Ingreso Inicial', 0, 'HABER', 7);

INSERT INTO `empleado` (`idEmpleado`, `dniEmpleado`, `nombreEmpleado`, `apellido1Empleado`, `apellido2Empleado`, `idSucursalBancaria`, `loginEmpleado`, `passwordEmpleado`) VALUES
	(5, '00000005M', 'prueba', 'prueba', 'prueba', 5, 'a', 'a'),
	(1, '00000001R', 'Marti', 'Gomez', 'Fabia', 2, 'login1', 'password1'),
	(2, '00000002W', 'Jona', 'Hidalgo', 'Mora', 2, 'login2', 'password2'),
	(3, '00000003A', 'Ivan', 'Sanchez', 'Aaaa', 3, 'login3', 'password3'),
	(4, '00000004G', 'Fran', 'Navarro', 'Flores', 4, 'login4', 'password4');



