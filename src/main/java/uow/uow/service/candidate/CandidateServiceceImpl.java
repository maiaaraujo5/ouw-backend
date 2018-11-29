package uow.uow.service.candidate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.uow.domain.candidate.Candidate;
import uow.uow.repository.candidate.CandidateRepository;
import uow.uow.repository.vacancy.VacancyRepository;

@Slf4j
@Service
public class CandidateServiceceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public Candidate save(Candidate candidate) throws Exception {

        log.info("Buscando usuário");
        Candidate findCandidate = candidateRepository.findByEmail(candidate.getEmail());

        if(findCandidate != null){
            throw new Exception("Usuario Já existente");
        }

        log.info("Salvando novo Usuário");
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate update(Candidate candidate, String userId) {
        Candidate findCandidate = candidateRepository.findByCodigo(Integer.parseInt(userId));

        candidate.setCodigo(Integer.parseInt(userId));

        if(findCandidate == null){
            log.error("Não existe usuário");
        }

       return candidateRepository.save(candidate);
    }

    @Override
    public Candidate findUser(String id) throws Exception {
        log.info("Buscando Usuário no banco");
        return candidateRepository.findByCodigo(Integer.parseInt(id));
    }

    @Override
    public void SubscribeCandidaeInVacancy(String candidateId, String vacancyId) {
        log.info("Inscrevendo candidato na vaga");
           vacancyRepository.subscribeCandidateInVacancy(Integer.parseInt(candidateId), Integer.parseInt(vacancyId));

    }

}
