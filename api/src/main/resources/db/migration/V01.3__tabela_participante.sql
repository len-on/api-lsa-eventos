CREATE TABLE IF NOT EXISTS `lsa_eventos`.`participante` (
  `id_participante` INT NOT NULL AUTO_INCREMENT,
  `turma_participante` VARCHAR(45) NULL,
  `usuario_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_participante`),
  INDEX `fk_participante_usuario_idx` (`usuario_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_participante_usuario`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `lsa_eventos`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;