package br.com.projeto.api.controle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.ParticipanteEventoModelo;
import br.com.projeto.api.repositorio.ParticipanteEventoRepository;

@RestController
@RequestMapping("/participanteEvento")
@CrossOrigin(origins = "*")
public class ParticipanteEventoControle {
    
    
    @Autowired
    private ParticipanteEventoRepository participanteEventoRepository;

    @GetMapping("listarParticipante/{codigo}")
    public List<ParticipanteEventoModelo> listarParticipantes(@PathVariable Integer codigo){
        return participanteEventoRepository.findByParticipanteModelo(codigo);
    }

    @GetMapping("listarEventos/{codigo}")
    public List<ParticipanteEventoModelo> buscarParticipantesPorEvento(@PathVariable Integer codigo) {
        return participanteEventoRepository.findByEventoModelo(codigo);
    }

    @GetMapping("/listar")
    public Iterable<ParticipanteEventoModelo> listar(){
        return participanteEventoRepository.findAll();
    }

    @PostMapping("/inscrever")
    public ParticipanteEventoModelo inscrever(@RequestBody ParticipanteEventoModelo participante){
        return participanteEventoRepository.save(participante);
    }

    @DeleteMapping("/cancelar/{participante}/{evento}")
    public void remover(@PathVariable Integer participante, @PathVariable Integer evento){
        ParticipanteEventoModelo participanteEvento = participanteEventoRepository.seleciona(participante, evento);
        participanteEventoRepository.delete(participanteEvento);;
    }
}
