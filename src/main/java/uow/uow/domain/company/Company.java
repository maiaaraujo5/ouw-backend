package uow.uow.domain.company;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uow.uow.domain.share.Adress;
import uow.uow.domain.share.User;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Company extends User {
    @Column(name = "cnpj")
    String cnpj;

    @Column(name = "imagem")
    String imagem;

    @Column(name = "descricao")
    String descricao;

    @Column (name = "videoYoutube")
    String videoYoutube;

    public Company(){}

    public Company(String nome, String email, String senha, String telefone, Adress endereco, int status, String cnpj, String imagem, String descricao, String videoYoutube) {
        super(nome, email, senha, telefone, endereco, status);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.imagem = imagem;
        this.videoYoutube = videoYoutube;
    }
}
