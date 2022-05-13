package edu.patrones.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentralesRequestDto {
    private String numeroSolicitud;
    private String reportado;
}
