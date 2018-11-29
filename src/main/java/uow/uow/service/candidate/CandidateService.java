package uow.uow.service.candidate;

import uow.uow.domain.candidate.Candidate;


public interface CandidateService {

    Candidate save (Candidate candidate) throws Exception;

    Candidate update (Candidate candidate, String userId);

    Candidate findUser(String id) throws Exception;

    void SubscribeCandidaeInVacancy(String candidateId, String vacancyId);
}
