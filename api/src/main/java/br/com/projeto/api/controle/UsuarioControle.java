package br.com.projeto.api.controle;

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

import br.com.projeto.api.modelo.UsuarioModelo;
import br.com.projeto.api.repositorio.UsuarioRepository;
import br.com.projeto.api.servico.UsuarioServico;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServico usuarioServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioModelo usuarioModelo){
        return usuarioServico.cadastrar(usuarioModelo);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar(){
        return usuarioServico.listar();
    }

    @GetMapping("/listarPeloNome/{nome}")
    public ResponseEntity<?> selecionarPeloNome(@PathVariable String nome){
        return usuarioServico.selecionarPeloNome(nome);
    }

    @GetMapping("/listarPeloCodigo/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable Long codigo){
        return usuarioServico.selecionarPeloCodigo(codigo);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody UsuarioModelo usuarioModelo) {
        return usuarioServico.alterar(usuarioModelo);
    }

    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<?> remover(@PathVariable Long codigo){
       return usuarioServico.remover(codigo);

       // UsuarioModelo usuarioModelo = selecionarPeloCodigo(codigo);

        //usuarioRepository.delete(usuarioModelo);
    }

    @GetMapping("/contador")
    public Long contador(){
        return usuarioRepository.count();
    }
}
