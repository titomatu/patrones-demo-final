package edu.patrones.demo.aporteslineaservice.repository;

import edu.patrones.demo.aporteslineaservice.model.InformacionAportes;
import edu.patrones.demo.aporteslineaservice.model.InformacionAportesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AportesLineaRepository extends JpaRepository<InformacionAportes, InformacionAportesId> {

    List<InformacionAportes> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, Long numeroDocumento);
}
