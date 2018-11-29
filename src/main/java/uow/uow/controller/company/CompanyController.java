package uow.uow.controller.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uow.uow.domain.company.Company;
import uow.uow.domain.vacancy.Vacancy;
import uow.uow.service.company.CompanyService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/register")
    public ResponseEntity<Company> RegisterCompany(@RequestBody Company company) throws Exception {

       Company companyBody =  companyService.saveCompany(company);

        return ResponseEntity.status(HttpStatus.CREATED).body(companyBody);
    }

    @PutMapping(value = "/{companyId}")
    public ResponseEntity<Company> updateCompanyInfo(@RequestBody Company companyUpdate, @PathVariable String companyId) throws Exception {

      Company company =companyService.updateCompany(companyUpdate, companyId);

        return ResponseEntity.ok().body(company);
    }

    @GetMapping(value = "/{companyId}")
    public ResponseEntity<Company> getCompanyInfos(@PathVariable String companyId) throws Exception {

       Company findCompany = companyService.findCompany(companyId);

        return ResponseEntity.ok().body(findCompany);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanys(){

        List<Company> companies = companyService.findAllCompanys();

        return ResponseEntity.ok(companies);
    }

    @PostMapping(value = "/{companyId}/vacancy")
    public ResponseEntity registerVacancy(@PathVariable String companyId, @RequestBody Vacancy vacancy){

      Vacancy vacancy1 = companyService.saveVacancy(vacancy, companyId);

        return ResponseEntity.status(HttpStatus.CREATED).body(vacancy1);
    }

    @GetMapping(value = "/{companyId}/vacancys")
    public ResponseEntity<List<Vacancy>> getVacancys(@PathVariable String companyId){

       List<Vacancy> vacancyList =  companyService.findAllVacancysOfCompany(companyId);

       return ResponseEntity.ok(vacancyList);
    }

}
