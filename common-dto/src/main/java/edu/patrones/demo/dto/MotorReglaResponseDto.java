package edu.patrones.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MotorReglaResponseDto {
    private String numeroSolicitud;
    private long valorAprobado;
    private int codeRespuesta;
    private String mensajeS;
}
