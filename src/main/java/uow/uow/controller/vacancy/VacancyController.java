package uow.uow.controller.vacancy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uow.uow.domain.vacancy.Vacancy;
import uow.uow.service.vacancy.VacancyService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    
    @GetMapping(value = "/{vacancyId}")
    public ResponseEntity getVacancyInfo(@PathVariable String vacancyId){

        Vacancy vacancy = vacancyService.getVacancy(vacancyId);

        return ResponseEntity.ok().body(vacancy);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Vacancy>> getAllOpenVacancy(){

        List<Vacancy> vacancy = vacancyService.getAllVacancys();

        return ResponseEntity.ok().body(vacancy);
    }

    @PutMapping(value = "/{vacancyId}")
    public ResponseEntity<Vacancy> updateVacancyInfo(@PathVariable String vacancyId, @RequestBody Vacancy vacancy){

        Vacancy updateVacancy = vacancyService.updateVacancy(vacancy, vacancyId);

        return ResponseEntity.ok().body(updateVacancy);
    }

}
