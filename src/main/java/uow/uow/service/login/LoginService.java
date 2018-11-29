package uow.uow.service.login;

import uow.uow.domain.login.Login;
import uow.uow.domain.share.User;

public interface LoginService {

    public User loginUser(Login login);
}
