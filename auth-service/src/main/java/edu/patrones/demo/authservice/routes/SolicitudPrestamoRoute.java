package edu.patrones.demo.authservice.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class SolicitudPrestamoRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:solicitudPrestamo")
                .routeId("direct-solicitudPrestamo")
                .tracing()
                .marshal()
                .json(JsonLibrary.Jackson)
                .log(">>> ${body}")
                .to("http://localhost:8085/solicitud/radicar")
                .end();


        from("direct:correo")
                .routeId("direct-correo")
                .tracing()
                .marshal()
                .json(JsonLibrary.Jackson)
                .log(">>> ${body}")
                .to("http://localhost:8087/api/otp")
                .end();
    }
}
