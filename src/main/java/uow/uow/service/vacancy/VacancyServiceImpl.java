package uow.uow.service.vacancy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.uow.domain.vacancy.Vacancy;
import uow.uow.repository.vacancy.VacancyRepository;

import java.util.List;

@Service
@Slf4j
public class VacancyServiceImpl implements VacancyService{

    @Autowired
    VacancyRepository vacancyRepository;

    @Override
    public Vacancy getVacancy(String id) {
        return vacancyRepository.findByCodigo(Integer.parseInt(id));
    }

    @Override
    public List<Vacancy> getAllVacancys() {
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy updateVacancy(Vacancy vacancy, String vacancyId) {

        vacancy.setId(Integer.parseInt(vacancyId));

        return vacancyRepository.save(vacancy);

    }
}
