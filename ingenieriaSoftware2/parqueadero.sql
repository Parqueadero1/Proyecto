CREATE database `Parqueadero`;

CREATE TABLE `Parqueadero`.`Tarifa` (
  `IdTarifa` INT  auto_increment,
  `NombreTarifa` VARCHAR(45) NULL,
  `Valor_total` double NULL,
  `Tiempo` int NULL,
  PRIMARY KEY (`IdTarifa`));


CREATE TABLE `Parqueadero`.`vehiculo` (
  `IdVehiculo` int auto_increment,
  `Placa` VARCHAR(45) NOT NULL,
  `Tipo_vehiculo` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `IdTarifa` int,
  PRIMARY KEY (`IdVehiculo`),
FOREIGN KEY (`IdTarifa`) REFERENCES `parqueadero`.`Tarifa` (`IdTarifa`)
    );