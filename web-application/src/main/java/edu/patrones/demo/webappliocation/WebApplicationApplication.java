package edu.patrones.demo.webappliocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebApplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationApplication.class, args);
    }

}
