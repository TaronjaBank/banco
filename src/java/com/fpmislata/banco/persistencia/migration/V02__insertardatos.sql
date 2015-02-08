
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
	(2, 'S002', 'Sucursal2', 'Valencia', 2),
	(3, 'S003', 'Sucursal3', 'Madrid', 1),
	(4, 'S004', 'Sucursal4', 'Barcelona', 2),
	(5, 'S005', 'Sucursal5', 'Zaragoza', 3),
	(6, 'S006', 'Sucursal6', 'Sevilla', 2),
	(7, 'S007', 'Sucursal7', 'Lepe', 4),
	(8, 'S008', 'Sucursal8', 'Valencia', 4);

INSERT INTO `cliente` (`idCliente`, `dniCliente`, `nombreCliente`, `apellido1Cliente`, `apellido2Cliente`, `loginCliente`, `passwordCliente`) VALUES
	(1, '00000001R', 'Marti', 'Gomez', 'Fabia', 'cliente1', 'cliente1'),
	(2, '00000002W', 'Jona', 'Hidalgo', 'Mora', 'cliente2', 'cliente2'),
	(3, '00000003A', 'Ivan', 'Sanchez', 'Aaaa', 'cliente3', 'cliente3'),
	(4, '00000004G', 'Fran', 'Navarro', 'Flores', 'cliente4', 'cliente4'),
	(5, '00000005M', 'prueba', 'prueba', 'prueba', 'b', 'b'),
        (6, '00000000T', 'Taronja', 'Games', 'SL', 'taronja', 'taronja');

INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`, `saldoCuentaBancaria`) VALUES
	(1, 'E002-S002-1', 2, 6, 0.00),
	(2, 'E002-S002-2', 2, 4, 0.00),
	(3, 'E001-S003-3', 3, 2, 0.00),
	(4, 'E002-S004-4', 4, 3, 0.00),
	(5, 'E003-S005-5', 5, 4, 0.00),
	(6, 'E002-S002-6', 2, 2, 0.00),
	(7, 'E003-S005-7', 5, 1, 0.00);

INSERT INTO `movimientobancario` (`idMovimientoBancario`, `conceptoMovimientoBancario`, `cantidadMovimientoBancario`, `tipoMovimiento`, `idCuentaBancaria`) VALUES
	(1, 'a', 4536.00, 'DEBE', 1),
	(5, 'b', 445.00, 'HABER', 3),
	(6, 'c', 234.00, 'HABER', 1),
	(7, 'd', 2345.00, 'DEBE', 2),
	(9, 'e', 432.00, 'HABER', 4),
	(10, 'f', 1324.00, 'DEBE', 2),
	(11, 'g', 345.00, 'DEBE', 5);

INSERT INTO `empleado` (`idEmpleado`, `dniEmpleado`, `nombreEmpleado`, `apellido1Empleado`, `apellido2Empleado`, `idSucursalBancaria`, `loginEmpleado`, `passwordEmpleado`) VALUES
	(5, '00000005M', 'prueba', 'prueba', 'prueba', 5, 'a', 'a'),
	(1, '00000001R', 'Marti', 'Gomez', 'Fabia', 2, 'login1', 'password1'),
	(2, '00000002W', 'Jona', 'Hidalgo', 'Mora', 2, 'login2', 'password2'),
	(3, '00000003A', 'Ivan', 'Sanchez', 'Aaaa', 3, 'login3', 'password3'),
	(4, '00000004G', 'Fran', 'Navarro', 'Flores', 4, 'login4', 'password4');


ALTER TABLE `sucursalBancaria` ENABLE KEYS ;
ALTER TABLE `cliente` ENABLE KEYS ;
ALTER TABLE `movimientoBancario` ENABLE KEYS ;
 ALTER TABLE `entidadBancaria` ENABLE KEYS ;
ALTER TABLE `empleado` ENABLE KEYS;
 ALTER TABLE `cuentaBancaria` ENABLE KEYS ;
