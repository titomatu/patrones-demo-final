package edu.patrones.demo.solicitudservice.repository;

import edu.patrones.demo.solicitudservice.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface SolicitudRepository extends JpaRepository<Solicitud, String> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Solicitud> findById(String id);
}
