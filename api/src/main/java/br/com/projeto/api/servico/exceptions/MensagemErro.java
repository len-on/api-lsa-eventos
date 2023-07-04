package br.com.projeto.api.servico.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemErro {
    
    private String mensagem;

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
    }

    
}
