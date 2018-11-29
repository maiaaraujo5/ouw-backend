package uow.uow.service.company;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.uow.domain.company.Company;
import uow.uow.domain.vacancy.Vacancy;
import uow.uow.repository.company.CompanyRepository;
import uow.uow.repository.vacancy.VacancyRepository;

import java.util.List;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private VacancyRepository vacancyRepository;


    @Override
    public Company saveCompany(Company company) throws Exception {

        Company findCompany = companyRepository.findByEmail(company.getEmail());

        if(findCompany != null){
            throw new Exception("Empresa Já existente");
        }

       return companyRepository.save(company);

    }

    @Override
    public Company updateCompany(Company company, String companyId) throws Exception {

        Company findCompany = companyRepository.findByCodigo(Integer.parseInt(companyId));

        if(findCompany == null){
            throw new Exception("Empresa não encontrada");
        }

        company.setCodigo(Integer.parseInt(companyId));


       return companyRepository.save(company);
    }

    @Override
    public Company findCompany(String id) throws Exception {
        return companyRepository.findByCodigo(Integer.parseInt(id));
    }

    @Override
    public List<Company> findAllCompanys() {
        return companyRepository.findAll();
    }

    @Override
    public Vacancy saveVacancy(Vacancy vacancy, String companyId) {
        vacancy.setCodigoEmpresa(Integer.parseInt(companyId));
       return vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> findAllVacancysOfCompany(String id) {
        return vacancyRepository.findAllVacancysOfCompany(Integer.parseInt(id));
    }


}
