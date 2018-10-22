-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BasketballPlayerDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BasketballPlayerDB` ;

-- -----------------------------------------------------
-- Schema BasketballPlayerDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BasketballPlayerDB` DEFAULT CHARACTER SET utf8 ;
USE `BasketballPlayerDB` ;

-- -----------------------------------------------------
-- Table `player`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `player` ;

CREATE TABLE IF NOT EXISTS `player` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NULL,
  `age` INT NOT NULL,
  `team` VARCHAR(45) NULL,
  `nationality` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS bbuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'bbuser'@'localhost' IDENTIFIED BY 'student';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'bbuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `player`
-- -----------------------------------------------------
START TRANSACTION;
USE `BasketballPlayerDB`;
INSERT INTO `player` (`id`, `first_name`, `last_name`, `position`, `age`, `team`, `nationality`) VALUES (1, 'Boban', 'Marjanovic', 'C', 30, 'LA Clippers', 'Serbia');
INSERT INTO `player` (`id`, `first_name`, `last_name`, `position`, `age`, `team`, `nationality`) VALUES (2, 'Nikola', 'Jokic', 'C', 22, 'Denver Nuggets', 'Serbia');

COMMIT;

