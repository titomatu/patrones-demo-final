package edu.patrones.demo.solicitudservice.repository;

import edu.patrones.demo.solicitudservice.model.Cliente;
import edu.patrones.demo.solicitudservice.model.ClienteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, ClienteId> {
}
