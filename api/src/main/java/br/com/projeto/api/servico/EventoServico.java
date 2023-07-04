package br.com.projeto.api.servico;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.modelo.EventoModelo;
import br.com.projeto.api.repositorio.EventoRepository;
import br.com.projeto.api.servico.exceptions.CampoVazioException;
import br.com.projeto.api.servico.exceptions.EventoNaoEncontradoException;
import br.com.projeto.api.servico.exceptions.Mensagem;
import br.com.projeto.api.servico.exceptions.MensagemErro;

@Service
public class EventoServico {
    
    @Autowired
    Mensagem mensagem;

    @Autowired
    private EventoRepository eventoRepository;

    public ResponseEntity<?> criar (EventoModelo eventoModelo) {

        try {
            validarCampos(eventoModelo);
            EventoModelo eventoSalvo = eventoRepository.save(eventoModelo);
            return new ResponseEntity<>(eventoSalvo, HttpStatus.CREATED);
        } catch (CampoVazioException ex) {
            MensagemErro mensagemErro = new MensagemErro(ex.getMessage());
            return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
        }
    }

    private void validarCampos(EventoModelo eventoModelo) throws CampoVazioException {
        if (StringUtils.isBlank(eventoModelo.getDescricaoEvento())) {
            throw new CampoVazioException("A descrição precisa ser preenchida");
        }if (StringUtils.isBlank(eventoModelo.getDuracaoEvento())) {
            throw new CampoVazioException("A duração precisa ser preenchida");
        }if (StringUtils.isBlank(eventoModelo.getNomeEvento())) {
            throw new CampoVazioException("O nome precisa ser preenchido");
        }if (eventoModelo.getDataEvento() == null) {
            throw new CampoVazioException("A data de precisa ser preenchida");   
        }
        if (eventoModelo.getHorarioEvento() == null) {
            throw new CampoVazioException("O horario precisa ser preenchido");   
        }
    }

    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(eventoRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> alterar(EventoModelo eventoModelo) throws EventoNaoEncontradoException{
        if (eventoRepository.countByCodigoEvento(eventoModelo.getCodigoEvento()) == 0) {
            throw new EventoNaoEncontradoException("O evento informado não existe.");
        }

        try {
            validarCampos(eventoModelo);
            EventoModelo eventoSalvo = eventoRepository.save(eventoModelo);
            return new ResponseEntity<>(eventoSalvo, HttpStatus.OK);
        } catch (CampoVazioException ex) {
            MensagemErro mensagemErro = new MensagemErro(ex.getMessage());
            return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> remover(Long codigo){
        EventoModelo evento = eventoRepository.findByCodigoEvento(codigo);

        if(evento == null) {
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<> (mensagem, HttpStatus.NOT_FOUND);
        }else {
            eventoRepository.delete(evento);

            mensagem.setMensagem("Evento removido com sucesso!");
            return new ResponseEntity<> (mensagem, HttpStatus.OK);
        }


    }

}
