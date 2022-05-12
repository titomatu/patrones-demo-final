package edu.patrones.demo.aporteslineaservice.service;

import edu.patrones.demo.dto.AportesLineaDto;
import edu.patrones.demo.event.aportes.AportesLineaEvent;
import edu.patrones.demo.event.aportes.AportesLineaStatus;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AportesLineaService {

    @Transactional
    public AportesLineaEvent nuevaSolicitud(SolicitudEvent solicitudEvent){
        return new AportesLineaEvent(new AportesLineaDto(solicitudEvent.getSolicitudDto().getNumeroSolicitud()), AportesLineaStatus.APORTES_LINEA_VALIDADO);
    }
}
