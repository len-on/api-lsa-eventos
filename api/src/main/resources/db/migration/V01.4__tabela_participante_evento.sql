CREATE TABLE IF NOT EXISTS `lsa_eventos`.`participante_evento` (
  `id_participante_evento` INT NOT NULL AUTO_INCREMENT,
  `participante_id_participante` INT NOT NULL,
  `evento_id_evento` INT NOT NULL,
  PRIMARY KEY (`id_participante_evento`),
  INDEX `fk_participante_has_evento_evento_idx` (`evento_id_evento` ASC) VISIBLE,
  INDEX `fk_participante_has_evento_participante_idx` (`participante_id_participante` ASC) VISIBLE,
  CONSTRAINT `fk_participante_has_evento_participante`
    FOREIGN KEY (`participante_id_participante`)
    REFERENCES `lsa_eventos`.`participante` (`id_participante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participante_has_evento_evento`
    FOREIGN KEY (`evento_id_evento`)
    REFERENCES `lsa_eventos`.`evento` (`id_evento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;