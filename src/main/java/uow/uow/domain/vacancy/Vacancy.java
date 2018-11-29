package uow.uow.domain.vacancy;

import lombok.Data;
import uow.uow.domain.share.Adress;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    int id;
    @Column(name = "titulo")
    String titulo;
    @Column(name = "descricao")
    String descricao;
    @Column(name = "salario")
    double salario;
    @Embedded
    Adress endereco;
    @Column(name = "codigoEmpresa")
    int codigoEmpresa;
}