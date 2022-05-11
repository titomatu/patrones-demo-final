package edu.patrones.demo.solicitudservice.controller;

import edu.patrones.demo.dto.SolicitudDto;
import edu.patrones.demo.solicitudservice.model.Solicitud;
import edu.patrones.demo.solicitudservice.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/solicitud")
public class SolicitudController {

    private final SolicitudService solicitudService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping(value = "/radicar")
    public ResponseEntity<SolicitudDto> fileApplication(@RequestBody SolicitudDto solicitudDto){

        Solicitud solicitud = solicitudService.crearSolicitud(solicitudDto);

        return new ResponseEntity<>(solicitudDto, HttpStatus.OK);
    }

    @GetMapping
    public List<Solicitud> listarTodas(){
        return solicitudService.listarTodas();
    }
}
