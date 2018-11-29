package uow.uow.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uow.uow.domain.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{

    @Query("Select c from Company c where email=?1")
    Company findByEmail(String emailAddress);

    @Query("Select c.codigo from Company c where email=?1 and senha=?2")
    Integer findByEmailAndSenha(String email, String senha);

    @Query("Select c from Company c where codigo=?1")
    Company findByCodigo(int codigo);
}
