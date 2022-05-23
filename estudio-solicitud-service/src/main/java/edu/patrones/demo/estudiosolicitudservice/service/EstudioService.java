package edu.patrones.demo.estudiosolicitudservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.patrones.demo.dto.EstudioRequestDto;
import edu.patrones.demo.dto.MotorReglaRequestDto;
import edu.patrones.demo.dto.MotorReglaResponseDto;
import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.event.estudio.EstudioEvent;
import edu.patrones.demo.event.estudio.EstudioStatus;
import edu.patrones.demo.event.solicitud.SolicitudEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EstudioService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public EstudioEvent nuevaSolicitud(SolicitudEvent event) {
        SolicitudDto solicitudDto = event.getSolicitudDto();

        EstudioRequestDto estudioRequestDto = new EstudioRequestDto();
        estudioRequestDto.setSolicitudDto(solicitudDto);

        MotorReglaRequestDto motorReglaRequestDto = new MotorReglaRequestDto();

        motorReglaRequestDto.setTipoDocumento(solicitudDto.getClienteDto().getTipoDocumento());
        motorReglaRequestDto.setNumeroDocumento(solicitudDto.getClienteDto().getNumeroDocumento());
        motorReglaRequestDto.setFechaExpedicion(solicitudDto.getClienteDto().getFechaExpedicion());
        motorReglaRequestDto.setFechaNacimiento(solicitudDto.getClienteDto().getFechaNacimiento());
        motorReglaRequestDto.setSalarioMensual(solicitudDto.getClienteDto().getSalarioMensual());
        motorReglaRequestDto.setSalarioAportes(solicitudDto.getPromedioAportes());
        motorReglaRequestDto.setAprobadoCentral(solicitudDto.getReportado());
        motorReglaRequestDto.setNumeroSolicitud(solicitudDto.getNumeroSolicitud());

        producerTemplate.start();
        InputStream inputStream = producerTemplate.requestBody("direct:motor", motorReglaRequestDto, InputStream.class);
        producerTemplate.stop();

        String respuesta = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        MotorReglaResponseDto motorReglaResponseDto = new MotorReglaResponseDto();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            motorReglaResponseDto = objectMapper.readValue(respuesta, MotorReglaResponseDto.class);
        } catch(JsonProcessingException e){
            log.error("Error {}", e.getMessage());
        }

        log.warn("Respuesta Motor Reglas: " + motorReglaResponseDto);

        return new EstudioEvent(estudioRequestDto, motorReglaResponseDto, EstudioStatus.ESTUDIO_APROBADO);
    }
}
