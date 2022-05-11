package edu.patrones.demo.registraduriaservice.service;

import edu.patrones.demo.dto.RNECRequestDto;
import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.rnec.RNECEvent;
import edu.patrones.demo.event.rnec.RNECStatus;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import edu.patrones.demo.registraduriaservice.model.RNECId;
import edu.patrones.demo.registraduriaservice.repository.RNECRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RNECService {

    @Autowired
    private RNECRepository rnecRepository;

    @Transactional
    public RNECEvent nuevaSolicitud(SolicitudEvent solicitudEvent){
        SolicitudDto solicitudDto = solicitudEvent.getSolicitudDto();

        RNECRequestDto rnecRequestDto = new RNECRequestDto(solicitudDto.getNumeroSolicitud());

        if(rnecRepository.findById(new RNECId(solicitudDto.getClienteDto().getTipoDocumento(), solicitudDto.getClienteDto().getNumeroDocumento()))
                .isPresent())
            return new RNECEvent(rnecRequestDto, RNECStatus.RNEC_COMPLETADO);
        else
            return new RNECEvent(rnecRequestDto, RNECStatus.RNEC_NO_EXITOSO);
    }
}
