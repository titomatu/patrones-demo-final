package edu.patrones.demo.solicitudservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class SolicitudPrestamoRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:correo")
                .routeId("direct-correo")
                .tracing()
                .marshal()
                .json(JsonLibrary.Jackson)
                .log(">>> ${body}")
                .to("http://localhost:8090/api/mail")
                .end();
    }
}
