package edu.patrones.demo.motorreglasservice.controller;

import edu.patrones.demo.dto.MotorReglaRequestDto;
import edu.patrones.demo.dto.MotorReglaResponseDto;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReglasNegocioController {
    private final KieContainer kieContainer;

    public ReglasNegocioController(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }


    @PostMapping("/descuento")
    private MotorReglaResponseDto getDiscountPercent(@RequestBody MotorReglaRequestDto orderRequest) {
        MotorReglaResponseDto respuesta = new  MotorReglaResponseDto();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        respuesta.setMensajeS(orderRequest.getMensajeE());
        respuesta.setCodeRespuesta(orderRequest.getCodeRespuesta());
        respuesta.setNumeroSolicitud(orderRequest.getNumeroSolicitud());
        System.out.println("Resultado: " + respuesta.getMensajeS());
        respuesta.setValorAprobado(orderRequest.getValorAprobado());
        return respuesta;
    }
}
