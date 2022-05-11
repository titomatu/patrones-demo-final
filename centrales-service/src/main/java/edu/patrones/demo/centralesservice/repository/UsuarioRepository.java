package edu.patrones.demo.centralesservice.repository;

import edu.patrones.demo.centralesservice.model.Usuario;
import edu.patrones.demo.centralesservice.model.UsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId> {
}
