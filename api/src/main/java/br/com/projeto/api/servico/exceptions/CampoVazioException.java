package br.com.projeto.api.servico.exceptions;

public class CampoVazioException extends Exception {
    public CampoVazioException(String mensagem) {
        super(mensagem);
    }
}
