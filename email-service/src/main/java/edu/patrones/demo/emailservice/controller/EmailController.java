package edu.patrones.demo.emailservice.controller;

import edu.patrones.demo.dto.EmailDto;
import edu.patrones.demo.emailservice.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    private final EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping(value = "/mail")
    public EmailDto sendMail(@RequestBody final EmailDto mail){
        this.service.sendEmail(mail);
        return mail;
    }
}
