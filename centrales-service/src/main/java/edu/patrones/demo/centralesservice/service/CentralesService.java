package edu.patrones.demo.centralesservice.service;

import edu.patrones.demo.centralesservice.model.Usuario;
import edu.patrones.demo.centralesservice.model.UsuarioId;
import edu.patrones.demo.centralesservice.repository.UsuarioRepository;
import edu.patrones.demo.dto.CentralesRequestDto;
import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.centrales.CentralesEvent;
import edu.patrones.demo.event.centrales.CentralesStatus;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CentralesService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public CentralesEvent nuevaSolicitud(SolicitudEvent solicitudEvent){
        SolicitudDto solicitudDto = solicitudEvent.getSolicitudDto();

        CentralesRequestDto centralesRequestDto = new CentralesRequestDto();

        centralesRequestDto.setNumeroSolicitud(solicitudEvent.getSolicitudDto().getNumeroSolicitud());

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(new UsuarioId(solicitudDto.getClienteDto().getTipoDocumento(), solicitudDto.getClienteDto().getNumeroDocumento()));

        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            centralesRequestDto.setReportado(usuario.getReportado());
        } else {
            centralesRequestDto.setReportado("X");
        }

        return new CentralesEvent(centralesRequestDto, CentralesStatus.CENTRALES_COMPLETADO);
    }

}
