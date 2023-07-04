package br.com.projeto.api.servico.exceptions;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Mensagem {
    
    private String mensagem;

}
