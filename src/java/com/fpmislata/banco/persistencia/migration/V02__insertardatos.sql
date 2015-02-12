
ALTER TABLE `cliente` DISABLE KEYS ;
ALTER TABLE `cuentaBancaria` DISABLE KEYS ;
ALTER TABLE `empleado` DISABLE KEYS ;
ALTER TABLE `entidadBancaria` DISABLE KEYS ;
ALTER TABLE `movimientoBancario` DISABLE KEYS ;
ALTER TABLE `sucursalBancaria` DISABLE KEYS ;


INSERT INTO `entidadbancaria` (`idEntidadBancaria`, `codigoEntidadBancaria`, `nombreEntidadBancaria`, `fechaCreacionEntidadBancaria`) VALUES
	(1, '0001', 'Sabadell', '2015-01-18'),
	(2, '0002', 'Santander', '2014-10-08'),
	(3, '0003', 'Banco Bilbao', '2014-10-17'),
	(4, '0004', 'Bankia', '2014-10-17'),
	(6, '0006', 'Bankia2', '2015-01-01');

INSERT INTO `sucursalbancaria` (`idSucursalBancaria`, `codigoSucursalBancaria`, `nombreSucursalBancaria`, `direccionSucursalBancaria`, `idEntidadBancaria`) VALUES
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
	(5, '00000005M', 'prueba', 'prueba', 'prueba', 'b', 'b', '55555555555'),
        (6, '00000000T', 'Taronja', 'Games', 'SL', 'taronja', 'taronja', '6666666666');

INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `numeroCuentaBancaria`, `idSucursalBancaria`, `idCliente`, `saldoCuentaBancaria`) VALUES
	(1, '0002-0002-0001', 2, 6, 0.00),
	(2, '0002-0002-0002', 2, 4, 0.00),
	(3, '0001-0003-0003', 3, 2, 0.00),
	(4, '0002-0004-0004', 4, 3, 0.00),
	(5, '0003-0005-0005', 5, 4, 0.00),
	(6, '0002-0002-0006', 2, 2, 0.00),
	(7, '0003-0005-0007', 5, 1, 0.00);

INSERT INTO `movimientobancario` (`idMovimientoBancario`, `conceptoMovimientoBancario`, `cantidadMovimientoBancario`, `tipoMovimiento`, `idCuentaBancaria`) VALUES
	(1, 'concepto 1', 4536.00, 'DEBE', 1),
	(5, 'concepto 2', 445.00, 'HABER', 3),
	(6, 'concepto 3', 234.00, 'HABER', 1),
	(7, 'concepto 4', 2345.00, 'DEBE', 2),
	(9, 'concepto 5', 432.00, 'HABER', 4),
	(10, 'concepto 6', 1324.00, 'DEBE', 2),
	(11, 'concepto 7', 345.00, 'DEBE', 5);

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

