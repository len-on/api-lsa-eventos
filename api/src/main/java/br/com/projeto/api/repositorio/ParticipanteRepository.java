package br.com.projeto.api.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.modelo.ParticipanteModelo;

public interface ParticipanteRepository extends CrudRepository<ParticipanteModelo,Long>{
 
    ParticipanteModelo findByCodigoParticipante(Long codigoParticipante);

}
