package edu.patrones.demo.solicitudservice.config;

import edu.patrones.demo.event.aportes.AportesLineaEvent;
import edu.patrones.demo.event.centrales.CentralesEvent;
import edu.patrones.demo.event.rnec.RNECEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EventHandlersConfig {

    @Autowired
    private SolicitudStatusUpdateEventHandler orderEventHandler;

    @Bean
    public Consumer<RNECEvent> rnecEventConsumer(){
        return rnecEvent -> {
            orderEventHandler.updateSolicitud(rnecEvent.getRnecRequestDto().getNumeroSolicitud(), solicitud -> {
                solicitud.setRnecStatus(rnecEvent.getRnecStatus());
            });
        };
    }

    @Bean
    public Consumer<CentralesEvent> centralesEventConsumer(){
        return centralesEvent -> {
            orderEventHandler.updateSolicitud(centralesEvent.getCentralesRequestDto().getNumeroSolicitud(), solicitud -> {
                solicitud.setCentralesStatus(centralesEvent.getCentralesStatus());
            });
        };
    }

    @Bean
    public Consumer<AportesLineaEvent> aportesLineaEventConsumer(){
        return aportesLineaEvent -> {
            orderEventHandler.updateSolicitud(aportesLineaEvent.getAportesLineaDto().getNumeroSolicitud(), solicitud -> {
                solicitud.setAportesLineaStatus(aportesLineaEvent.getAportesLineaStatus());
            });
        };
    }

}
