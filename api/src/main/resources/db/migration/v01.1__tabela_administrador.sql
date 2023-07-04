CREATE TABLE IF NOT EXISTS `lsa_eventos`.`administrador` (
  `id_adm` INT NOT NULL AUTO_INCREMENT,
  `usuario_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_adm`),
  INDEX `fk_administrador_usuario_idx` (`usuario_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_administrador_usuario`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `lsa_eventos`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;