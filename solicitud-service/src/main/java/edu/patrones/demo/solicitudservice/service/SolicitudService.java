package edu.patrones.demo.solicitudservice.service;

import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.estudio.EstudioStatus;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import edu.patrones.demo.solicitudservice.model.Cliente;
import edu.patrones.demo.solicitudservice.model.Solicitud;
import edu.patrones.demo.solicitudservice.repository.ClienteRepository;
import edu.patrones.demo.solicitudservice.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final SolicitudStatusPublisher solicitudStatusPublisher;
    private final ClienteRepository clienteRepository;


    @Autowired
    public SolicitudService(SolicitudRepository solicitudRepository, ClienteRepository clienteRepository, SolicitudStatusPublisher solicitudStatusPublisher) {
        this.solicitudRepository = solicitudRepository;
        this.clienteRepository = clienteRepository;
        this.solicitudStatusPublisher = solicitudStatusPublisher;
    }

    @Transactional
    public Solicitud crearSolicitud(SolicitudDto solicitudDto){
        Cliente cliente = clienteRepository.save(ConvertDtoToEntity(solicitudDto).getCliente());
        Solicitud solicitud = solicitudRepository.save(ConvertDtoToEntity(solicitudDto));

        solicitudDto.setNumeroSolicitud(solicitud.getNumeroSolicitud());
        solicitudStatusPublisher.publishSolicitudEvent(solicitudDto, SolicitudStatus.SOLICITUD_CREADA);

        return solicitud;
    }

    public List<Solicitud> listarTodas(){
        return solicitudRepository.findAll();
    }

    private Solicitud ConvertDtoToEntity(SolicitudDto solicitudDto) {
        Cliente cliente = new Cliente();
        Solicitud solicitud = new Solicitud();

        cliente.getClienteId().setTipoDocumento(solicitudDto.getClienteDto().getTipoDocumento());
        cliente.getClienteId().setNumeroDocumento(solicitudDto.getClienteDto().getNumeroDocumento());

        cliente.setFechaExpedicion(solicitudDto.getClienteDto().getFechaExpedicion());
        cliente.setNombre1(solicitudDto.getClienteDto().getNombre1());
        cliente.setNombre2(solicitudDto.getClienteDto().getNombre2());
        cliente.setApellido1(solicitudDto.getClienteDto().getApellido1());
        cliente.setApellido2(solicitudDto.getClienteDto().getApellido2());
        cliente.setCelular(solicitudDto.getClienteDto().getCelular());
        cliente.setCorreoElectronico(solicitudDto.getClienteDto().getCorreoElectronico());
        cliente.setSalarioMensual(solicitudDto.getClienteDto().getSalarioMensual());
        cliente.setFechaNacimiento(solicitudDto.getClienteDto().getFechaNacimiento());
        cliente.setTotalActivos(solicitudDto.getClienteDto().getTotalActivos());
        cliente.setTotalPasivos(solicitudDto.getClienteDto().getTotalPasivos());
        cliente.setAutorizaCentrales(solicitudDto.getClienteDto().getAutorizaCentrales());
        cliente.getGenero().setId(solicitudDto.getClienteDto().getGenero());
        cliente.getTipoResidencia().setId(solicitudDto.getClienteDto().getTipoResidencia());
        cliente.getActividadEconomica().setId(solicitudDto.getClienteDto().getActividadEconomica());
        cliente.getTipoContrato().setId(solicitudDto.getClienteDto().getTipoContrato());
        cliente.getNivelEstudios().setId(solicitudDto.getClienteDto().getNivelEstudios());
        cliente.getTipoInmueble().setId(solicitudDto.getClienteDto().getTipoInmueble());
        cliente.getEstadoCivil().setId(solicitudDto.getClienteDto().getEstadoCivil());

        solicitud.setNumeroSolicitud(UUID.randomUUID().toString());
        solicitud.setCliente(cliente);
        solicitud.setValorSolicitado(solicitudDto.getValorSolicitado());
        solicitud.setSolicitudStatus(SolicitudStatus.SOLICITUD_CREADA);
        solicitud.setEstudioStatus(EstudioStatus.ESTUDIO_PENDIENTE);

        return solicitud;
    }
}
