package edu.patrones.demo.solicitudservice.config;

import edu.patrones.demo.event.solicitud.SolicitudEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class SolicitudConfig {

    @Bean
    public Sinks.Many<SolicitudEvent> orderSink(){
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    public Supplier<Flux<SolicitudEvent>> solicitudSupplier(Sinks.Many<SolicitudEvent> sink){
        return sink::asFlux;
    }

}
