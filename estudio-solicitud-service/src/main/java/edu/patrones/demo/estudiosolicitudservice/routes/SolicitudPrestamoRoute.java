package edu.patrones.demo.estudiosolicitudservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class SolicitudPrestamoRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:motor")
                .routeId("direct-motor")
                .tracing()
                .marshal()
                .json(JsonLibrary.Jackson)
                .log(">>> ${body}")
                .to("http://localhost:8089/api/motor")
                .end();
    }
}
