package edu.patrones.demo.solicitudservice.config;

import edu.patrones.demo.dto.ClienteDto;
import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.centrales.CentralesEvent;
import edu.patrones.demo.event.centrales.CentralesStatus;
import edu.patrones.demo.event.rnec.RNECEvent;
import edu.patrones.demo.event.rnec.RNECStatus;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import edu.patrones.demo.solicitudservice.model.Solicitud;
import edu.patrones.demo.solicitudservice.repository.SolicitudRepository;
import edu.patrones.demo.solicitudservice.service.SolicitudStatusPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.function.Consumer;

@Service
public class SolicitudStatusUpdateEventHandler {

    @Autowired
    private SolicitudRepository repository;

    @Autowired
    private SolicitudStatusPublisher publisher;

    @Transactional
    public void updateSolicitud(final String id, Consumer<Solicitud> consumer){
        this.repository
                .findById(id)
                .ifPresent(consumer.andThen(this::updateSolicitud));

    }

    private void updateSolicitud(Solicitud solicitud){
        System.out.println(">>>>>>>>>>>>>>>>>>> update solicitud " + solicitud.getCentralesStatus() + "/" + solicitud.getRnecStatus());
        if(Objects.isNull(solicitud.getCentralesStatus()) || Objects.isNull(solicitud.getRnecStatus()))
            return;

        var isComplete = RNECStatus.RNEC_COMPLETADO.equals(solicitud.getRnecStatus()) && CentralesStatus.CENTRALES_COMPLETADO.equals(solicitud.getCentralesStatus());
        var solicitudStatus = isComplete ? SolicitudStatus.SOLICITUD_COMPLETA : SolicitudStatus.SOLICITUD_RECHAZADA;
        solicitud.setSolicitudStatus(solicitudStatus);

        if (!isComplete){
            this.publisher.publishSolicitudEvent(convertEntityToDto(solicitud), solicitudStatus);
        }
    }

    private SolicitudDto convertEntityToDto(Solicitud solicitud) {
        ClienteDto clienteDto = new ClienteDto();
        SolicitudDto solicitudDto = new SolicitudDto();

        clienteDto.setNumeroDocumento(solicitud.getCliente().getClienteId().getNumeroDocumento());
        clienteDto.setTipoDocumento(solicitud.getCliente().getClienteId().getTipoDocumento());
        solicitudDto.setClienteDto(clienteDto);
        solicitudDto.setNumeroSolicitud(solicitud.getNumeroSolicitud());

        return solicitudDto;
    }

}
