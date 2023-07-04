CREATE TABLE IF NOT EXISTS `lsa_eventos`.`evento` (
  `id_evento` INT NOT NULL AUTO_INCREMENT,
  `data_evento` DATE NOT NULL,
  `descricao_evento` VARCHAR(255) NOT NULL,
  `duracao_evento` VARCHAR(45) NOT NULL,
  `horario_evento` TIME NOT NULL,
  `nome_evento` VARCHAR(45) NOT NULL,
  `administrador_id_adm` INT NOT NULL,
  PRIMARY KEY (`id_evento`),
  INDEX `fk_evento_administrador_idx` (`administrador_id_adm` ASC) VISIBLE,
  CONSTRAINT `fk_evento_administrador`
    FOREIGN KEY (`administrador_id_adm`)
    REFERENCES `lsa_eventos`.`administrador` (`id_adm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;