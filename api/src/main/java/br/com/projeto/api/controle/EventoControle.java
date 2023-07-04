package br.com.projeto.api.controle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.EventoModelo;
import br.com.projeto.api.repositorio.EventoRepository;
import br.com.projeto.api.servico.EventoServico;

@RestController
@RequestMapping("/evento")
public class EventoControle {
    
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoServico eventoServico;



   @PostMapping("/criar")
    public ResponseEntity<?> criar(@Valid @RequestBody EventoModelo eventoModelo){
        return eventoServico.criar(eventoModelo);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar () {
        return eventoServico.listar();
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@Valid @RequestBody EventoModelo eventoModelo) {
        return eventoServico.alterar(eventoModelo);
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<?> remover(@Valid @PathVariable Long codigo){
       return eventoServico.remover(codigo);
    }

    @GetMapping("/contador")
    public Long contador(){
        return eventoRepository.count();
    }

}
