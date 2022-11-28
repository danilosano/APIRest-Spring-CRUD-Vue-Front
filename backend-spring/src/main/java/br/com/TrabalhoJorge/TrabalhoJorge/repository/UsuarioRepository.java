package br.com.TrabalhoJorge.TrabalhoJorge.repository;


import br.com.TrabalhoJorge.TrabalhoJorge.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Optional<UsuarioModel> findByEmailUsuario(String emailUsuario);
}
