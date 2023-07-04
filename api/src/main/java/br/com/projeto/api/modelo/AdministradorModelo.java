package br.com.projeto.api.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrador")
@Getter
@Setter
public class AdministradorModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_adm")
    private Long idAdm;

    @OneToOne
    @JoinColumn(name = "usuario_id_usuario")
    @JsonProperty("usuario_id_usuario")
    private UsuarioModelo idUsuarioModelo;
}
