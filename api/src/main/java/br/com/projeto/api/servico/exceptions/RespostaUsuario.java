package br.com.projeto.api.servico.exceptions;


import br.com.projeto.api.modelo.UsuarioModelo;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RespostaUsuario {

    private UsuarioModelo usuario;

    public RespostaUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }
}