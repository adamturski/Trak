SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `trak` ;
CREATE SCHEMA IF NOT EXISTS `trak` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `trak` ;

-- -----------------------------------------------------
-- Table `trak`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`role` ;

CREATE TABLE IF NOT EXISTS `trak`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `trak`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`address` ;

CREATE TABLE IF NOT EXISTS `trak`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(255) NOT NULL,
  `house` VARCHAR(255) NOT NULL,
  `flat` VARCHAR(255) NULL,
  `postcode` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NULL,
  `country` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `trak`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`user` ;

CREATE TABLE IF NOT EXISTS `trak`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `enabled` TINYINT(1) NOT NULL,
  `role_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  INDEX `fk_user_authority1_idx` (`role_id` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `trak`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_authority1`
    FOREIGN KEY (`role_id`)
    REFERENCES `trak`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `trak`.`shipment_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`shipment_status` ;

CREATE TABLE IF NOT EXISTS `trak`.`shipment_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `trak`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`customer` ;

CREATE TABLE IF NOT EXISTS `trak`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(255) NULL,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_customer_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_customer_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `trak`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `trak`.`shipment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`shipment` ;

CREATE TABLE IF NOT EXISTS `trak`.`shipment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `shipment_status_id` INT NOT NULL,
  `recipient_id` INT NOT NULL,
  `sender_id` INT NOT NULL,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shipped_date` TIMESTAMP NULL,
  `creator_id` INT NOT NULL,
  `deliverer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_shipment_customer1_idx` (`recipient_id` ASC),
  INDEX `fk_shipment_customer2_idx` (`sender_id` ASC),
  INDEX `fk_shipment_user1_idx` (`creator_id` ASC),
  INDEX `fk_shipment_shipment_status1_idx` (`shipment_status_id` ASC),
  INDEX `fk_shipment_user2_idx` (`deliverer_id` ASC),
  CONSTRAINT `fk_shipment_customer1`
    FOREIGN KEY (`recipient_id`)
    REFERENCES `trak`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_customer2`
    FOREIGN KEY (`sender_id`)
    REFERENCES `trak`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_user1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `trak`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_shipment_status1`
    FOREIGN KEY (`shipment_status_id`)
    REFERENCES `trak`.`shipment_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_user2`
    FOREIGN KEY (`deliverer_id`)
    REFERENCES `trak`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `trak`.`station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`station` ;

CREATE TABLE IF NOT EXISTS `trak`.`station` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  `address_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_station_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_station_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `trak`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `trak`.`gate_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`gate_type` ;

CREATE TABLE IF NOT EXISTS `trak`.`gate_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `trak`.`gate`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`gate` ;

CREATE TABLE IF NOT EXISTS `trak`.`gate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `station_id` INT NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `gate_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_gate_station1_idx` (`station_id` ASC),
  INDEX `fk_gate_gate_type1_idx` (`gate_type_id` ASC),
  CONSTRAINT `fk_gate_station1`
    FOREIGN KEY (`station_id`)
    REFERENCES `trak`.`station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gate_gate_type1`
    FOREIGN KEY (`gate_type_id`)
    REFERENCES `trak`.`gate_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `trak`.`vehicle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `trak`.`vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `trak`.`movement_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`movement_type` ;

CREATE TABLE IF NOT EXISTS `trak`.`movement_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `trak`.`shipment_movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`shipment_movement` ;

CREATE TABLE IF NOT EXISTS `trak`.`shipment_movement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shipment_id` INT NOT NULL,
  `gate_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  `movement_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_shipment_status_shipment1_idx` (`shipment_id` ASC),
  INDEX `fk_shipment_movement_gate1_idx` (`gate_id` ASC),
  INDEX `fk_shipment_movement_vehicle2_idx` (`vehicle_id` ASC),
  INDEX `fk_shipment_movement_movement_type1_idx` (`movement_type_id` ASC),
  CONSTRAINT `fk_shipment_status_shipment1`
    FOREIGN KEY (`shipment_id`)
    REFERENCES `trak`.`shipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_movement_gate1`
    FOREIGN KEY (`gate_id`)
    REFERENCES `trak`.`gate` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_movement_vehicle2`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `trak`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shipment_movement_movement_type1`
    FOREIGN KEY (`movement_type_id`)
    REFERENCES `trak`.`movement_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `trak`.`geo_location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trak`.`geo_location` ;

CREATE TABLE IF NOT EXISTS `trak`.`geo_location` (
  `id` INT NOT NULL,
  `latitude` INT NOT NULL,
  `longitude` INT NOT NULL,
  `created_date` TIMESTAMP NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_geo_location_vehicle1_idx` (`vehicle_id` ASC),
  CONSTRAINT `fk_geo_location_vehicle1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `trak`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
