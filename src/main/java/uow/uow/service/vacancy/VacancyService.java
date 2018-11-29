package uow.uow.service.vacancy;

import uow.uow.domain.vacancy.Vacancy;

import java.util.List;

public interface VacancyService {

    Vacancy getVacancy(String id);

    List<Vacancy> getAllVacancys();

    Vacancy updateVacancy(Vacancy vacancy, String vacancyId);
}
