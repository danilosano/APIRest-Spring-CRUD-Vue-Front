package br.com.TrabalhoJorge.TrabalhoJorge.repository;

import br.com.TrabalhoJorge.TrabalhoJorge.model.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

    Optional<DisciplinaModel> findById(long id);

}
