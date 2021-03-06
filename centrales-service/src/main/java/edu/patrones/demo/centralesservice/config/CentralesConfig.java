package edu.patrones.demo.centralesservice.config;

import edu.patrones.demo.centralesservice.service.CentralesService;
import edu.patrones.demo.event.centrales.CentralesEvent;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class CentralesConfig {

    @Autowired
    private CentralesService service;

    @Bean
    public Function<Flux<SolicitudEvent>, Flux<CentralesEvent>> centralesProcessor() {
        return flux -> flux.flatMap(this::procesarCentrales);
    }

    private Mono<CentralesEvent> procesarCentrales(SolicitudEvent event){
        if(event.getSolicitudStatus().equals(SolicitudStatus.SOLICITUD_CREADA)){
            return Mono.fromSupplier(() -> this.service.nuevaSolicitud(event));
        } else {
            return Mono.fromRunnable(() -> Mono.empty());
        }
    }

}

