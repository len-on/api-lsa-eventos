package br.com.projeto.api.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.projeto.api.modelo.ParticipanteEventoModelo;

import java.util.List;


public interface ParticipanteEventoRepository extends CrudRepository<ParticipanteEventoModelo, Long>{
    
    @Query(value = "SELECT * FROM lsa_eventos.participante_evento where participante_id_participante = :participanteModelo", nativeQuery = true)
    List<ParticipanteEventoModelo> findByParticipanteModelo(Integer participanteModelo);

    @Query(value = "SELECT * FROM lsa_eventos.participante_evento WHERE evento_id_evento = :eventoModelo", nativeQuery = true)
    List<ParticipanteEventoModelo> findByEventoModelo(@Param("eventoModelo") Integer eventoModelo);

    @Query(value = "SELECT * FROM participante_evento WHERE participante_id_participante = :participante AND evento_id_evento = :evento", nativeQuery = true)
    ParticipanteEventoModelo seleciona(@Param("participante")Integer participante, @Param("evento") Integer evento);

}
