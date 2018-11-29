package uow.uow.repository.vacancy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uow.uow.domain.vacancy.Vacancy;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, String> {

    @Query("Select v from Vacancy v where id=?1")
    Vacancy findByCodigo(int id);

    @Query("Select v from Vacancy v where codigoEmpresa = ?1")
    List<Vacancy> findAllVacancysOfCompany(int companyId);

    @Modifying
    @Query(value = "insert into candidateVacancy values (?, ?)", nativeQuery = true)
    @Transactional(readOnly = true)
    void subscribeCandidateInVacancy(int candidateId, int vacancyId);
}
