package uow.uow.domain.login;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;

@Data
public class Login {

    String email;
    String senha;
}
