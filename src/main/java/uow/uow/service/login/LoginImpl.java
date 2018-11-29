package uow.uow.service.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.uow.domain.login.Login;
import uow.uow.domain.share.User;
import uow.uow.repository.candidate.CandidateRepository;
import uow.uow.repository.company.CompanyRepository;

@Slf4j
@Service
public class LoginImpl implements LoginService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public User loginUser(Login login) {

        User user = new User();

        Integer userId;

         log.info("Buscando candidato...");
         userId = candidateRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());

        if(userId == 0){
          log.info("Candidato não encontrado. Buscando empresa...");
          userId = companyRepository.findByEmailAndSenha(login.getEmail(), login.getSenha());
        }

        user.setCodigo(userId);
        return user;
    }
}
