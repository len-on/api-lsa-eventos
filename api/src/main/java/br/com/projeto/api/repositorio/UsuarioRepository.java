package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.modelo.UsuarioModelo;

public interface UsuarioRepository extends CrudRepository<UsuarioModelo, Long>{
    
    List<UsuarioModelo> findAll();

    UsuarioModelo findByNomeUsuario(String nomeUsuario);
    UsuarioModelo findByCodigoUsuario(Long codigoUsuario);

    Long countByCodigoUsuario(Long codigoUsuario);
}
