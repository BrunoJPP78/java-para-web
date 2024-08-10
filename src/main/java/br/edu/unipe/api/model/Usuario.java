package br.edu.unipe.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //Criação de Getter
@Setter //Criação de Setter
@AllArgsConstructor //Criação de Construtor
@NoArgsConstructor
@Entity //Para dizer que a classe é uma Tabela no Banco
@Table(name="db_usuario") //Aqui é pra dizer que o nome da tabela no banco é "db_usuário"
public class Usuario {
    @Id //Annotation para definir que minha variável é uma Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Deixar a variável Auto Incremental | A estratégia seria o modelo que alguns banco utilizam para fazer a criação desses id no banco
    private Integer id;

    @Email(message = "O email não está na formatação correta")
    @Column(name = "email")
    private String email;

    private String nome;

}

