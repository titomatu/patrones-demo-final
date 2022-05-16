package edu.patrones.demo.estudiosolicitudservice.service;

import edu.patrones.demo.dto.EstudioRequestDto;
import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.estudio.EstudioEvent;
import edu.patrones.demo.event.estudio.EstudioStatus;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import org.springframework.stereotype.Service;

@Service
public class EstudioService {
    public EstudioEvent nuevaSolicitud(SolicitudEvent event) {
        SolicitudDto solicitudDto = event.getSolicitudDto();

        EstudioRequestDto estudioRequestDto = new EstudioRequestDto();
        estudioRequestDto.setSolicitudDto(solicitudDto);

        return new EstudioEvent(estudioRequestDto, EstudioStatus.ESTUDIO_APROBADO);
    }
}
