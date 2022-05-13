package edu.patrones.demo.aporteslineaservice.service;

import edu.patrones.demo.aporteslineaservice.model.InformacionAportes;
import edu.patrones.demo.aporteslineaservice.repository.AportesLineaRepository;
import edu.patrones.demo.dto.AportesLineaDto;
import edu.patrones.demo.event.aportes.AportesLineaEvent;
import edu.patrones.demo.event.aportes.AportesLineaStatus;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
public class AportesLineaService {

    @Autowired
    AportesLineaRepository repository;

    @Transactional
    public AportesLineaEvent nuevaSolicitud(SolicitudEvent solicitudEvent){
        AportesLineaDto dto = new AportesLineaDto();

        dto.setNumeroSolicitud(solicitudEvent.getSolicitudDto().getNumeroSolicitud());
        dto.setPromedioAportes(
                repository.findByTipoDocumentoAndNumeroDocumento(solicitudEvent.getSolicitudDto().getClienteDto().getTipoDocumento(),
                        solicitudEvent.getSolicitudDto().getClienteDto().getNumeroDocumento()
                ).stream().collect(Collectors.averagingDouble(InformacionAportes::getPagoRealizado))
        );

        return new AportesLineaEvent(dto, AportesLineaStatus.APORTES_LINEA_VALIDADO);
    }
}
