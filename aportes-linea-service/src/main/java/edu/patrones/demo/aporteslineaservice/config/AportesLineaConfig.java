package edu.patrones.demo.aporteslineaservice.config;

import edu.patrones.demo.aporteslineaservice.service.AportesLineaService;
import edu.patrones.demo.event.aportes.AportesLineaEvent;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class AportesLineaConfig {

    @Autowired
    AportesLineaService service;

    @Bean
    Function<Flux<SolicitudEvent>, Flux<AportesLineaEvent>> aportesLineaProcessor(){
        return flux -> flux.flatMap(this::procesarAportesLinea);
    }

    Mono<AportesLineaEvent> procesarAportesLinea(SolicitudEvent event){
        if(event.getSolicitudStatus().equals(SolicitudStatus.SOLICITUD_CREADA)){
            return Mono.fromSupplier(() -> this.service.nuevaSolicitud(event));
        }

        return Mono.fromRunnable(() -> this.service.nuevaSolicitud(event));
    }
}
