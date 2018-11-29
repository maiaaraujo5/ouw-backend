package uow.uow.domain.candidate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uow.uow.domain.share.Adress;
import uow.uow.domain.share.User;

import javax.persistence.Column;
import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Entity
public class Candidate extends User {
    @Column(name = "cpf")
    String cpf;
    @Column(name = "sexo")
    String sexo;

    public Candidate(){}

    public Candidate(String nome, String email, String senha, String telefone, Adress adress, int status, String cpf){
        super(nome, email, senha, telefone, adress, status);
        this.cpf = cpf;
    }
}
