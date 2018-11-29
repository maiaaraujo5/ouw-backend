package uow.uow.controller.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uow.uow.domain.login.Login;
import uow.uow.domain.share.User;
import uow.uow.service.login.LoginService;

@RestController(value = "/login")
@CrossOrigin
@Slf4j
public class LoginController {

     @Autowired
     LoginService loginService;

     @PostMapping
     public ResponseEntity<User> login(@RequestBody Login login){

         log.info("Recebendo request de login: "+login);

         User user = loginService.loginUser(login);

         return ResponseEntity.ok().body(user);
     }
}
