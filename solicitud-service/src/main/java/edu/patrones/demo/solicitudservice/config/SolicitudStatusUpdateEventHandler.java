package edu.patrones.demo.solicitudservice.config;

import edu.patrones.demo.event.centrales.CentralesStatus;
import edu.patrones.demo.event.rnec.RNECStatus;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import edu.patrones.demo.solicitudservice.model.Solicitud;
import edu.patrones.demo.solicitudservice.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.function.Consumer;

@Service
public class SolicitudStatusUpdateEventHandler {

    @Autowired
    private SolicitudRepository repository;

    @Transactional
    public void updateOrder(final String id, Consumer<Solicitud> consumer){
        this.repository
                .findById(id)
                .ifPresent(consumer.andThen(this::updateSolicitud));

    }

    private void updateSolicitud(Solicitud solicitud){
        if(Objects.isNull(solicitud.getCentralesStatus()) || Objects.isNull(solicitud.getRnecStatus()))
            return;
        var isComplete = RNECStatus.RNEC_COMPLETADO.equals(solicitud.getRnecStatus()) && CentralesStatus.CENTRALES_COMPLETADO.equals(solicitud.getCentralesStatus());
        var solicitudStatus = isComplete ? SolicitudStatus.SOLICITUD_COMPLETA : SolicitudStatus.SOLICITUD_RECHAZADA;
        solicitud.setSolicitudStatus(solicitudStatus);
    }

}
