package br.com.projeto.api.servico;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.modelo.UsuarioModelo;
import br.com.projeto.api.repositorio.UsuarioRepository;
import br.com.projeto.api.servico.exceptions.CampoVazioException;
import br.com.projeto.api.servico.exceptions.Mensagem;
import br.com.projeto.api.servico.exceptions.MensagemErro;
import br.com.projeto.api.servico.exceptions.RespostaUsuario;
import br.com.projeto.api.servico.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuarioServico {
 
    @Autowired
    Mensagem mensagem;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<?> cadastrar (UsuarioModelo usuarioModelo) {

        try {
            validarCampos(usuarioModelo);
            UsuarioModelo usuarioSalvo = usuarioRepository.save(usuarioModelo);
            return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
        } catch (CampoVazioException ex) {
            MensagemErro mensagemErro = new MensagemErro(ex.getMessage());
            return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
        }
    }

    private void validarCampos(UsuarioModelo usuarioModelo) throws CampoVazioException {
        if (StringUtils.isBlank(usuarioModelo.getNomeUsuario())) {
            throw new CampoVazioException("O nome precisa ser preenchido");
        }if (StringUtils.isBlank(usuarioModelo.getSenhaUsuario())) {
            throw new CampoVazioException("A senha precisa ser preenchida");
        }if (StringUtils.isBlank(usuarioModelo.getCpfUsuario())) {
            throw new CampoVazioException("O CPF precisa ser preenchido");
        }if (StringUtils.isBlank(usuarioModelo.getEmailUsuario())) {
            throw new CampoVazioException("O email precisa ser preenchido");
        }if (usuarioModelo.getDataNascimentoUsuario() == null) {
            throw new CampoVazioException("A data de nascimento precisa ser preenchida");   
        }
    }



    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> selecionarPeloCodigo(Long codigo) throws UsuarioNaoEncontradoException{
        UsuarioModelo usuario = usuarioRepository.findByCodigoUsuario(codigo);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Não foi encontrado nenhum usuário.");
            
        }
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    public ResponseEntity<?> selecionarPeloNome(String nome) throws UsuarioNaoEncontradoException{
        UsuarioModelo usuario = usuarioRepository.findByNomeUsuario(nome);
        if (usuario == null) {
            throw new UsuarioNaoEncontradoException("Não foi encontrado nenhum usuário.");
        }
        return new ResponseEntity<>(new RespostaUsuario(usuario), HttpStatus.OK);
    }

    public ResponseEntity<?> alterar(UsuarioModelo usuarioModelo) throws UsuarioNaoEncontradoException{
        if (usuarioRepository.countByCodigoUsuario(usuarioModelo.getCodigoUsuario()) == 0) {
            throw new UsuarioNaoEncontradoException("O usuario informado não existe.");
        }

        try {
            validarCampos(usuarioModelo);
            UsuarioModelo usuarioSalvo = usuarioRepository.save(usuarioModelo);
            return new ResponseEntity<>(usuarioSalvo, HttpStatus.OK);
        } catch (CampoVazioException ex) {
            MensagemErro mensagemErro = new MensagemErro(ex.getMessage());
            return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
        }
    }

     public ResponseEntity<?> remover(Long codigo){
        UsuarioModelo usuario = usuarioRepository.findByCodigoUsuario(codigo);

        if(usuario == null) {
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<> (mensagem, HttpStatus.NOT_FOUND);
        }else {
            usuarioRepository.delete(usuario);

            mensagem.setMensagem("Usuario removido com sucesso!");
            return new ResponseEntity<> (mensagem, HttpStatus.OK);
        }


    }
}