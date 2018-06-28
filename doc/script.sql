/*
-- BASE DATOS: MySQL
-- Date: Junio 2018
-- autor: wlopera
*/
usuario:  root
clave:    admin
puerto:   3306
hostname: localhost
Base datos: robotic


/*
-- Table: product
-- Date: Junio 2018
-- autor: wlopera
*/
CREATE TABLE 'product' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'nombre' varchar(45) NOT NULL,
  'cantidad' float NOT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Querys BD - Utilities:
--------------------------------------------------------
-- Saber el maximo valor incremental
SELECT * FROM robotic.product ORDER BY id DESC LIMIT 0,1

-- Definir el maximo incremental actual
ALTER TABLE robotic.product AUTO_INCREMENT = 2

-- Consultar productos
SELECT * FROM robotic.product;

