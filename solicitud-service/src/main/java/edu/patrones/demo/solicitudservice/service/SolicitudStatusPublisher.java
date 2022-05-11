package edu.patrones.demo.solicitudservice.service;

import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class SolicitudStatusPublisher {

    @Autowired
    private Sinks.Many<SolicitudEvent> solicitudSinks;

    public void publishSolicitudEvent(SolicitudDto solicitudDto, SolicitudStatus solicitudStatus){
        solicitudSinks.tryEmitNext(new SolicitudEvent(solicitudDto, solicitudStatus));
    }

}
