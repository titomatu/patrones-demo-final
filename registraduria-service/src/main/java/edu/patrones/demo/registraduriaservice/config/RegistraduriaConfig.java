package edu.patrones.demo.registraduriaservice.config;

import edu.patrones.demo.event.rnec.RNECEvent;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import edu.patrones.demo.registraduriaservice.service.RNECService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class RegistraduriaConfig {

    @Autowired
    private RNECService service;

    @Bean
    public Function<Flux<SolicitudEvent>, Flux<RNECEvent>> registraduriaProcessor() {
        return flux -> flux.flatMap(this::procesarRNEC);
    }

    private Mono<RNECEvent> procesarRNEC(SolicitudEvent event){
        return Mono.fromSupplier(() -> this.service.nuevaSolicitud(event));
    }

}
