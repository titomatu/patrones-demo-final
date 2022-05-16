package edu.patrones.demo.estudiosolicitudservice.config;

import edu.patrones.demo.estudiosolicitudservice.service.EstudioService;
import edu.patrones.demo.event.estudio.EstudioEvent;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class EstudioConfig {

    @Autowired
    private EstudioService service;

    @Bean
    public Function<Flux<SolicitudEvent>, Flux<EstudioEvent>> estudioProcessor() {
        return flux -> flux.flatMap(this::procesarEstudio);
    }

    private Mono<EstudioEvent> procesarEstudio(SolicitudEvent event){
        if(event.getSolicitudStatus().equals(SolicitudStatus.SOLICITUD_COMPLETA)){
            return Mono.fromSupplier(() -> this.service.nuevaSolicitud(event));
        } else {
            return Mono.fromRunnable(() -> Mono.empty());
        }
    }

}
