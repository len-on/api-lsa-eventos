package br.com.projeto.api.controle;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.ParticipanteModelo;
import br.com.projeto.api.repositorio.ParticipanteRepository;

@RestController
@RequestMapping("/participante")
public class ParticipanteControle {
    
    @Autowired
    private ParticipanteRepository participanteRepository;

    @PostMapping("/cadastrar")
    public ParticipanteModelo cadastrar(@Valid @RequestBody ParticipanteModelo participanteModelo) {
        return participanteRepository.save(participanteModelo);
    }

    @PutMapping("alterar")
    public ParticipanteModelo alterar(@Valid @RequestBody ParticipanteModelo participanteModelo) {
        return participanteRepository.save(participanteModelo);
    }

    @GetMapping("buscar/{codigo}")
    public Optional<ParticipanteModelo> buscarPeloCodigo(@PathVariable Long codigo){
        return participanteRepository.findById(codigo);
    }

    @DeleteMapping("remover/{codigo}")
    public void remover(@PathVariable Long codigo){
        ParticipanteModelo participanteModelo = participanteRepository.findByCodigoParticipante(codigo);

        participanteRepository.delete(participanteModelo);
    }
}