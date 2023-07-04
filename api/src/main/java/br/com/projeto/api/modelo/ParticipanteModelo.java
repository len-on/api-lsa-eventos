package br.com.projeto.api.modelo;

import javax.persistence.Column;
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
@Table(name = "participante")
@Getter
@Setter
public class ParticipanteModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_participante")
    @Column(name = "id_participante")
    private Long codigoParticipante;

    @JsonProperty("turma_participante")
    private String turmaParticipante;

    @OneToOne
    @JoinColumn(name = "usuario_id_usuario")
    @JsonProperty("usuario_id_usuario")
    private UsuarioModelo usuarioModelo;

}
