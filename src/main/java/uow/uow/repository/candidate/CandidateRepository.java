package uow.uow.repository.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uow.uow.domain.candidate.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, String> {

   @Query("Select c from Candidate c where email=?1")
   Candidate findByEmail(String email);

   @Query("Select c.codigo from Candidate c where email=?1 and senha=?2")
   Integer findByEmailAndSenha(String email, String senha);

   @Query("Select c from Candidate c where codigo=?1")
   Candidate findByCodigo(int codigo);
}
