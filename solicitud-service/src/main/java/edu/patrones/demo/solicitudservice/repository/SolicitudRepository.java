package edu.patrones.demo.solicitudservice.repository;

import edu.patrones.demo.solicitudservice.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, String> {
}
