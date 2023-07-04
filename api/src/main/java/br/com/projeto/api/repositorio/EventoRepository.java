package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.modelo.EventoModelo;

public interface EventoRepository extends CrudRepository<EventoModelo,Long>{
    
    List<EventoModelo> findAll();

    EventoModelo findByNomeEvento(String nomeEvento);
    EventoModelo findByCodigoEvento(Long codigoEvento);

    Long countByCodigoEvento(Long codigoEvento);

}
