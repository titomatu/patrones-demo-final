package edu.patrones.demo.estudiosolicitudservice.config;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private CamelContext camelContext;

    @Bean
    ProducerTemplate producerTemplate(){
        return camelContext.createProducerTemplate();
    }
}
