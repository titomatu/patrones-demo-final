package edu.patrones.demo.authservice.controller;

import edu.patrones.demo.authservice.model.OTP;
import edu.patrones.demo.dto.OTPRequestDto;
import edu.patrones.demo.dto.OTPResponseDto;
import edu.patrones.demo.authservice.service.OTPService;
import edu.patrones.demo.dto.EmailDto;
import edu.patrones.demo.dto.SolicitudDto;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class OTPController {

    @Autowired
    private OTPService service;

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/otp")
    public ResponseEntity<?> saveOTP(@RequestBody final OTPRequestDto dto){
        OTP otp = new OTP();

        log.warn("Username {}", dto.getUsername());

        String otpGen = RandomString.make(8);

        otp.setUsername(dto.getUsername());
        otp.setPassword(otpGen);
        otp.setOtpRequestedTime(new Date());
        log.info("Usuario: {} - OTP Generada: {}", otp.getUsername(), otp.getPassword());
        service.saveOTP(otp);

        EmailDto emailDto = new EmailDto();

        emailDto.setTo(dto.getCorreo());
        emailDto.setSubject("Clave OTP Generada");
        emailDto.setText("Se ha generado la clave temporal de acceso: " + otpGen);

        producerTemplate.start();
        producerTemplate.requestBody("direct:correo", emailDto, InputStream.class);
        producerTemplate.stop();

        return ResponseEntity.ok().body(new OTPResponseDto(dto.getUsername(), ""));
    }

    @PostMapping(value = "/solicitud")
    public ResponseEntity<String> fileApplication(@RequestBody SolicitudDto solicitudDto){
        producerTemplate.start();
        InputStream inputStream = producerTemplate.requestBody("direct:solicitudPrestamo", solicitudDto, InputStream.class);
        producerTemplate.stop();

        String respuesta = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        return ResponseEntity.ok().body(respuesta);
    }
}
