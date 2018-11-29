package uow.uow.domain.share;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@Embeddable
public class Adress {
    int cep;
    String estado;
    String cidade;
    String bairro;
    String numero;
    String complemento;
}
