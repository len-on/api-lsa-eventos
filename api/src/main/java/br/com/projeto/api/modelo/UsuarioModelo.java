package br.com.projeto.api.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class UsuarioModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_usuario")
    @Column(name = "id_usuario")
    private Long codigoUsuario;

    @JsonProperty("nome_usuario")
    @Column(name = "nome_usuario")
    @NotEmpty(message = "Informe um nome.")
    private String nomeUsuario;

    @JsonProperty("senha_usuario")
    @Column(name = "senha_usuario")
    private String senhaUsuario;

    @JsonProperty("CPF_usuario")
    @Column(name = "CPF_usuario")
    private String cpfUsuario;

    @JsonProperty("email_usuario")
    @Column(name = "email_usuario")
    @Email(message = "Informe um email valido.")
    private String emailUsuario;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("data_nascimento_usuario")
    @Column(name = "data_nascimento_usuario")
    private LocalDate dataNascimentoUsuario;

    @JsonProperty("tipo_usuario")
    @Column(name = "tipo_usuario")
    private int tipoUsuario;
}
