-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema veterinario
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `veterinario` ;

-- -----------------------------------------------------
-- Schema veterinario
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `veterinario` ;
USE `veterinario` ;

-- -----------------------------------------------------
-- Table `veterinario`.`animales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinario`.`animales` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `especie` VARCHAR(100) NULL DEFAULT NULL,
  `raza` VARCHAR(100) NULL DEFAULT NULL,
  `sexo` VARCHAR(10) NULL DEFAULT NULL,
  `edad` INT(11) NULL DEFAULT NULL,
  `peso` FLOAT NULL DEFAULT NULL,
  `primera_consulta` VARCHAR(100) NULL DEFAULT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2;


-- -----------------------------------------------------
-- Table `veterinario`.`observaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veterinario`.`observaciones` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `observacion` VARCHAR(100) NULL DEFAULT NULL,
  `id_animal` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `observaciones_animales_FK` (`id_animal` ASC) VISIBLE,
  CONSTRAINT `observaciones_animales_FK`
    FOREIGN KEY (`id_animal`)
    REFERENCES `veterinario`.`animales` (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
