package br.com.TrabalhoJorge.TrabalhoJorge.repository;

import br.com.TrabalhoJorge.TrabalhoJorge.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {

    Optional<ProfessorModel> findById(long id);

}
