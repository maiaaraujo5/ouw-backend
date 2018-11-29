package uow.uow.domain.share;

import lombok.Data;
import uow.uow.domain.share.Adress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int codigo;
    @Column(name = "nome")
     protected String nome;
    @Column(name = "email")
    protected String Email;
    @Column(name = "senha")
    protected String senha;
    @Column(name = "telefone")
    protected String telefone;
    @Embedded
    protected Adress endereco;
    @Column(name = "status")
    protected int status;

    public User(){}

    public User(String nome, String email, String senha, String telefone, Adress endereco, int status) {
        this.nome = nome;
        this.Email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = status;
    }


}
