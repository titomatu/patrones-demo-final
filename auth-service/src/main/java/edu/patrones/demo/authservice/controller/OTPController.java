package edu.patrones.demo.authservice.controller;

import edu.patrones.demo.authservice.model.OTP;
import edu.patrones.demo.authservice.model.dto.OTPRequestDto;
import edu.patrones.demo.authservice.model.dto.OTPResponseDto;
import edu.patrones.demo.authservice.service.OTPService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class OTPController {
    private final OTPService service;

    @PostMapping("/otp")
    public ResponseEntity<?> saveOTP(@RequestBody final OTPRequestDto dto){
        OTP otp = new OTP();

        otp.setUsername(dto.getUsername());
        otp.setPassword(RandomString.make(8));
        otp.setOtpRequestedTime(new Date());
        log.info("Usuario: {} - OTP Generada: {}", otp.getUsername(), otp.getPassword());
        service.saveOTP(otp);

        return ResponseEntity.ok().body(new OTPResponseDto(dto.getUsername(), ""));
    }

}
