package br.com.projeto.api.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "evento")
@Getter
@Setter
@NoArgsConstructor
public class EventoModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_evento")
    @Column(name = "id_evento")
    private Long codigoEvento;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("data_evento")
    @NotNull
    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @JsonProperty("descricao_evento")
    @Column(name = "descricao_evento")
    private String descricaoEvento;

    @JsonFormat(pattern = "HH:mm:ss")
    @JsonProperty("horario_evento")
    @NotNull
    @Column(name = "horario_evento")
    private LocalTime horarioEvento;

    @JsonProperty("duracao_evento")
    @Column(name = "duracao_evento")
    private String duracaoEvento;

    @JsonProperty("nome_evento")
    @Column(name = "nome_evento")
    private String nomeEvento;

    @ManyToOne
    @JoinColumn(name = "administrador_id_adm")
    @JsonProperty("administrador_id_adm")
    private AdministradorModelo idAdm;

}
