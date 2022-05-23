package edu.patrones.demo.emailservice.service;

import edu.patrones.demo.dto.EmailDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(EmailDto correo){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("tamatu@gmail.com");
        message.setTo(correo.getTo());
        message.setSubject(correo.getSubject());
        message.setText(correo.getText());

        this.javaMailSender.send(message);
    }
}
