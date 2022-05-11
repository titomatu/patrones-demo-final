package edu.patrones.demo.centralesservice.repository;

import edu.patrones.demo.centralesservice.model.Usuario;
import edu.patrones.demo.centralesservice.model.UsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId> {
}
