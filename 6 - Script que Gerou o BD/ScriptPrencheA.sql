SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Paises`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Paises` (
  `idPais` INT NOT NULL ,
  `Nome` VARCHAR(45) NULL ,
  `Sigla` VARCHAR(3) NULL ,
  `Capital` VARCHAR(45) NULL ,
  `Bandeira` BLOB NULL ,
  PRIMARY KEY (`idPais`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Integrantes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Integrantes` (
  `idIntegrantes` INT NOT NULL ,
  `Nome` VARCHAR(45) NULL ,
  `Nacionalidade` VARCHAR(45) NULL ,
  `Pais_Nasc` VARCHAR(45) NULL ,
  `Foto` BLOB NULL ,
  PRIMARY KEY (`idIntegrantes`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Copa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Copa` (
  `Ano` INT NOT NULL ,
  `Data_Ini` DATE NULL ,
  `Data_Fim` DATE NULL ,
  `Paises_idPais` INT NOT NULL ,
  PRIMARY KEY (`Ano`) ,
  INDEX `fk_Copa_Paises1_idx` (`Paises_idPais` ASC) ,
  CONSTRAINT `fk_Copa_Paises1`
    FOREIGN KEY (`Paises_idPais` )
    REFERENCES `mydb`.`Paises` (`idPais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipe`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Equipe` (
  `idEquipe` INT NOT NULL ,
  `idTreinador` INT NULL ,
  `Paises_idPais` INT NOT NULL ,
  `Copa_Ano` INT NOT NULL ,
  `idCamp` INT NOT NULL ,
  PRIMARY KEY (`idEquipe`) ,
  INDEX `fk_Equipe_Paises1_idx` (`Paises_idPais` ASC) ,
  INDEX `fk_Equipe_Copa1_idx` (`Copa_Ano` ASC) ,
  CONSTRAINT `fk_Equipe_Paises1`
    FOREIGN KEY (`Paises_idPais` )
    REFERENCES `mydb`.`Paises` (`idPais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipe_Copa1`
    FOREIGN KEY (`Copa_Ano` )
    REFERENCES `mydb`.`Copa` (`Ano` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jogos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Jogos` (
  `idJogos` INT NOT NULL ,
  `Data` DATE NULL ,
  `Copa_Ano` INT NOT NULL ,
  `Equipe_idEquipe` INT NOT NULL ,
  `Equipe_idEquipe1` INT NOT NULL ,
  PRIMARY KEY (`idJogos`) ,
  INDEX `fk_Jogos_Copa1_idx` (`Copa_Ano` ASC) ,
  INDEX `fk_Jogos_Equipe1_idx` (`Equipe_idEquipe` ASC) ,
  INDEX `fk_Jogos_Equipe2_idx` (`Equipe_idEquipe1` ASC) ,
  CONSTRAINT `fk_Jogos_Copa1`
    FOREIGN KEY (`Copa_Ano` )
    REFERENCES `mydb`.`Copa` (`Ano` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogos_Equipe1`
    FOREIGN KEY (`Equipe_idEquipe` )
    REFERENCES `mydb`.`Equipe` (`idEquipe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogos_Equipe2`
    FOREIGN KEY (`Equipe_idEquipe1` )
    REFERENCES `mydb`.`Equipe` (`idEquipe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cartao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Cartao` (
  `idCartao` INT NOT NULL ,
  `Tipo` CHAR NULL ,
  `Relogio` TIME NULL ,
  `Jogos_idJogos` INT NOT NULL ,
  PRIMARY KEY (`idCartao`) ,
  INDEX `fk_Cartao_Jogos1_idx` (`Jogos_idJogos` ASC) ,
  CONSTRAINT `fk_Cartao_Jogos1`
    FOREIGN KEY (`Jogos_idJogos` )
    REFERENCES `mydb`.`Jogos` (`idJogos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Gols`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Gols` (
  `idGols` INT NOT NULL ,
  `Relógio` TIME NULL ,
  `Jogos_idJogos` INT NOT NULL ,
  `Integrantes_idIntegrantes` INT NOT NULL ,
  PRIMARY KEY (`idGols`) ,
  INDEX `fk_Gols_Jogos1_idx` (`Jogos_idJogos` ASC) ,
  INDEX `fk_Gols_Integrantes1_idx` (`Integrantes_idIntegrantes` ASC) ,
  CONSTRAINT `fk_Gols_Jogos1`
    FOREIGN KEY (`Jogos_idJogos` )
    REFERENCES `mydb`.`Jogos` (`idJogos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Gols_Integrantes1`
    FOREIGN KEY (`Integrantes_idIntegrantes` )
    REFERENCES `mydb`.`Integrantes` (`idIntegrantes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Estadio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Estadio` (
  `idEstadio` INT NOT NULL ,
  `Cidade` VARCHAR(45) NULL ,
  `Capacidade` BIGINT NULL ,
  `Nome` VARCHAR(45) NULL ,
  `Paises_idPais` INT NOT NULL ,
  PRIMARY KEY (`idEstadio`) ,
  INDEX `fk_Estadio_Paises1_idx` (`Paises_idPais` ASC) ,
  CONSTRAINT `fk_Estadio_Paises1`
    FOREIGN KEY (`Paises_idPais` )
    REFERENCES `mydb`.`Paises` (`idPais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Pessoas` (
  `idPessoas` INT NOT NULL ,
  `Nome` VARCHAR(45) NULL ,
  `Nacionalidade` VARCHAR(45) NULL ,
  `Data_Nasc` DATE NULL ,
  PRIMARY KEY (`idPessoas`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Torcida`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Torcida` (
  `Presidente` VARCHAR(45) NULL ,
  `Fotos` BLOB NULL ,
  `idTorcida` INT NOT NULL ,
  `Paises_idPais` INT NOT NULL ,
  PRIMARY KEY (`idTorcida`) ,
  INDEX `fk_Torcida_Paises1_idx` (`Paises_idPais` ASC) ,
  CONSTRAINT `fk_Torcida_Paises1`
    FOREIGN KEY (`Paises_idPais` )
    REFERENCES `mydb`.`Paises` (`idPais` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bolao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Bolao` (
  `idBolao` INT NOT NULL ,
  `Aposta` VARCHAR(45) NULL ,
  `Data` DATE NULL ,
  PRIMARY KEY (`idBolao`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Integrantes_has_Cartao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Integrantes_has_Cartao` (
  `Integrantes_idIntegrantes` INT NOT NULL ,
  `Cartao_idCartao` INT NOT NULL ,
  PRIMARY KEY (`Integrantes_idIntegrantes`, `Cartao_idCartao`) ,
  INDEX `fk_Integrantes_has_Cartao_Cartao1_idx` (`Cartao_idCartao` ASC) ,
  INDEX `fk_Integrantes_has_Cartao_Integrantes1_idx` (`Integrantes_idIntegrantes` ASC) ,
  CONSTRAINT `fk_Integrantes_has_Cartao_Integrantes1`
    FOREIGN KEY (`Integrantes_idIntegrantes` )
    REFERENCES `mydb`.`Integrantes` (`idIntegrantes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Integrantes_has_Cartao_Cartao1`
    FOREIGN KEY (`Cartao_idCartao` )
    REFERENCES `mydb`.`Cartao` (`idCartao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Integrantes_has_Gols`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Integrantes_has_Gols` (
  `Integrantes_idIntegrantes` INT NOT NULL ,
  `Gols_idGols` INT NOT NULL ,
  PRIMARY KEY (`Integrantes_idIntegrantes`, `Gols_idGols`) ,
  INDEX `fk_Integrantes_has_Gols_Gols1_idx` (`Gols_idGols` ASC) ,
  INDEX `fk_Integrantes_has_Gols_Integrantes1_idx` (`Integrantes_idIntegrantes` ASC) ,
  CONSTRAINT `fk_Integrantes_has_Gols_Integrantes1`
    FOREIGN KEY (`Integrantes_idIntegrantes` )
    REFERENCES `mydb`.`Integrantes` (`idIntegrantes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Integrantes_has_Gols_Gols1`
    FOREIGN KEY (`Gols_idGols` )
    REFERENCES `mydb`.`Gols` (`idGols` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipe_has_Integrantes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Equipe_has_Integrantes` (
  `Equipe_idEquipe` INT NOT NULL ,
  `Integrantes_idIntegrantes` INT NOT NULL ,
  PRIMARY KEY (`Equipe_idEquipe`, `Integrantes_idIntegrantes`) ,
  INDEX `fk_Equipe_has_Integrantes_Integrantes1_idx` (`Integrantes_idIntegrantes` ASC) ,
  INDEX `fk_Equipe_has_Integrantes_Equipe1_idx` (`Equipe_idEquipe` ASC) ,
  CONSTRAINT `fk_Equipe_has_Integrantes_Equipe1`
    FOREIGN KEY (`Equipe_idEquipe` )
    REFERENCES `mydb`.`Equipe` (`idEquipe` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipe_has_Integrantes_Integrantes1`
    FOREIGN KEY (`Integrantes_idIntegrantes` )
    REFERENCES `mydb`.`Integrantes` (`idIntegrantes` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jogos_has_Bolao`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Jogos_has_Bolao` (
  `Jogos_idJogos` INT NOT NULL ,
  `Bolao_idBolao` INT NOT NULL ,
  PRIMARY KEY (`Jogos_idJogos`, `Bolao_idBolao`) ,
  INDEX `fk_Jogos_has_Bolao_Bolao1_idx` (`Bolao_idBolao` ASC) ,
  INDEX `fk_Jogos_has_Bolao_Jogos1_idx` (`Jogos_idJogos` ASC) ,
  CONSTRAINT `fk_Jogos_has_Bolao_Jogos1`
    FOREIGN KEY (`Jogos_idJogos` )
    REFERENCES `mydb`.`Jogos` (`idJogos` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogos_has_Bolao_Bolao1`
    FOREIGN KEY (`Bolao_idBolao` )
    REFERENCES `mydb`.`Bolao` (`idBolao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bolao_has_Pessoas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Bolao_has_Pessoas` (
  `Bolao_idBolao` INT NOT NULL ,
  `Pessoas_idPessoas` INT NOT NULL ,
  PRIMARY KEY (`Bolao_idBolao`, `Pessoas_idPessoas`) ,
  INDEX `fk_Bolao_has_Pessoas_Pessoas1_idx` (`Pessoas_idPessoas` ASC) ,
  INDEX `fk_Bolao_has_Pessoas_Bolao1_idx` (`Bolao_idBolao` ASC) ,
  CONSTRAINT `fk_Bolao_has_Pessoas_Bolao1`
    FOREIGN KEY (`Bolao_idBolao` )
    REFERENCES `mydb`.`Bolao` (`idBolao` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bolao_has_Pessoas_Pessoas1`
    FOREIGN KEY (`Pessoas_idPessoas` )
    REFERENCES `mydb`.`Pessoas` (`idPessoas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Torcida_has_Copa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Torcida_has_Copa` (
  `Torcida_idTorcida` INT NOT NULL ,
  `Torcida_Paises_idPais` INT NOT NULL ,
  `Copa_Ano` INT NOT NULL ,
  `Copa_Paises_idPais` INT NOT NULL ,
  PRIMARY KEY (`Torcida_idTorcida`, `Torcida_Paises_idPais`, `Copa_Ano`, `Copa_Paises_idPais`) ,
  INDEX `fk_Torcida_has_Copa_Copa1_idx` (`Copa_Ano` ASC, `Copa_Paises_idPais` ASC) ,
  INDEX `fk_Torcida_has_Copa_Torcida1_idx` (`Torcida_idTorcida` ASC, `Torcida_Paises_idPais` ASC) ,
  CONSTRAINT `fk_Torcida_has_Copa_Torcida1`
    FOREIGN KEY (`Torcida_idTorcida` )
    REFERENCES `mydb`.`Torcida` (`idTorcida` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Torcida_has_Copa_Copa1`
    FOREIGN KEY (`Copa_Ano` )
    REFERENCES `mydb`.`Copa` (`Ano` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoas_has_Torcida`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Pessoas_has_Torcida` (
  `Pessoas_idPessoas` INT NOT NULL ,
  `Torcida_idTorcida` INT NOT NULL ,
  `Torcida_Paises_idPais` INT NOT NULL ,
  PRIMARY KEY (`Pessoas_idPessoas`, `Torcida_idTorcida`, `Torcida_Paises_idPais`) ,
  INDEX `fk_Pessoas_has_Torcida_Torcida1_idx` (`Torcida_idTorcida` ASC, `Torcida_Paises_idPais` ASC) ,
  INDEX `fk_Pessoas_has_Torcida_Pessoas1_idx` (`Pessoas_idPessoas` ASC) ,
  CONSTRAINT `fk_Pessoas_has_Torcida_Pessoas1`
    FOREIGN KEY (`Pessoas_idPessoas` )
    REFERENCES `mydb`.`Pessoas` (`idPessoas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoas_has_Torcida_Torcida1`
    FOREIGN KEY (`Torcida_idTorcida` )
    REFERENCES `mydb`.`Torcida` (`idTorcida` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoas_has_Torcida1`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Pessoas_has_Torcida1` (
  `Pessoas_idPessoas` INT NOT NULL ,
  `Torcida_idTorcida` INT NOT NULL ,
  PRIMARY KEY (`Pessoas_idPessoas`, `Torcida_idTorcida`) ,
  INDEX `fk_Pessoas_has_Torcida1_Torcida1_idx` (`Torcida_idTorcida` ASC) ,
  INDEX `fk_Pessoas_has_Torcida1_Pessoas1_idx` (`Pessoas_idPessoas` ASC) ,
  CONSTRAINT `fk_Pessoas_has_Torcida1_Pessoas1`
    FOREIGN KEY (`Pessoas_idPessoas` )
    REFERENCES `mydb`.`Pessoas` (`idPessoas` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoas_has_Torcida1_Torcida1`
    FOREIGN KEY (`Torcida_idTorcida` )
    REFERENCES `mydb`.`Torcida` (`idTorcida` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Torcida_has_Copa1`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Torcida_has_Copa1` (
  `Torcida_idTorcida` INT NOT NULL ,
  `Copa_Ano` INT NOT NULL ,
  PRIMARY KEY (`Torcida_idTorcida`, `Copa_Ano`) ,
  INDEX `fk_Torcida_has_Copa1_Copa1_idx` (`Copa_Ano` ASC) ,
  INDEX `fk_Torcida_has_Copa1_Torcida1_idx` (`Torcida_idTorcida` ASC) ,
  CONSTRAINT `fk_Torcida_has_Copa1_Torcida1`
    FOREIGN KEY (`Torcida_idTorcida` )
    REFERENCES `mydb`.`Torcida` (`idTorcida` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Torcida_has_Copa1_Copa1`
    FOREIGN KEY (`Copa_Ano` )
    REFERENCES `mydb`.`Copa` (`Ano` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
