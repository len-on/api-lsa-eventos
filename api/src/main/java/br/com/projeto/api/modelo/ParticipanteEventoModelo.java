package br.com.projeto.api.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "participante_evento")
@Getter
@Setter
public class ParticipanteEventoModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_participante_evento")
    @Column(name = "id_participante_evento")
    private Long codigoParticipanteEvento;

    @ManyToOne
    @JoinColumn(name = "participante_id_participante")
    @JsonProperty("participante_id_participante")
    private ParticipanteModelo participanteModelo;

    @ManyToOne
    @JoinColumn(name = "evento_id_evento")
    @JsonProperty("evento_id_evento")
    private EventoModelo eventoModelo;

}
