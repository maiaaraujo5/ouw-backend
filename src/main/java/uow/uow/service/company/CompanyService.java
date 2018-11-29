package uow.uow.service.company;

import uow.uow.domain.company.Company;
import uow.uow.domain.vacancy.Vacancy;

import java.util.List;


public interface CompanyService {

     Company saveCompany(Company company) throws Exception;

     Company updateCompany(Company company, String companyId) throws Exception;

     Company findCompany(String id) throws Exception;

     List<Company> findAllCompanys();

     Vacancy saveVacancy(Vacancy vacancy, String companyId);

     List<Vacancy> findAllVacancysOfCompany(String id);

}
