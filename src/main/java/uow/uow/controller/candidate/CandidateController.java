package uow.uow.controller.candidate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uow.uow.domain.candidate.Candidate;
import uow.uow.service.candidate.CandidateService;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/candidate")
public class CandidateController {

     @Autowired
     private CandidateService candidateService;

    @PostMapping(value = "/register")
    public ResponseEntity<Void> RegisterUser(@RequestBody Candidate user) throws Exception {

        log.info("Request Recebido: "+user);
        candidateService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<Candidate> updateUserInfo(@RequestBody Candidate user, @PathVariable String userId){

     Candidate candidate = candidateService.update(user, userId);

        return ResponseEntity.ok().body(candidate);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<Candidate> getUserInfos(@PathVariable String userId) throws Exception {

        log.info("Recebendo request de busca: "+userId);
        Candidate candidate = candidateService.findUser(userId);

        return ResponseEntity.ok().body(candidate);
    }

    @PostMapping(value = "/{userId}/subscribe/{vacancyId}")
    public ResponseEntity<Void> subscribeInVacancy(@PathVariable String userId, @PathVariable String vacancyId){

        candidateService.SubscribeCandidaeInVacancy(userId, vacancyId);
        return ResponseEntity.ok().build();
    }


}
