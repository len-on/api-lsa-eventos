package br.com.projeto.api.servico.exceptions;

public class EventoNaoEncontradoException extends RuntimeException {
    public EventoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
