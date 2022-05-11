package edu.patrones.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private String tipoDocumento;
    private Long numeroDocumento;
    private Date fechaExpedicion;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private Long celular;
    private String correoElectronico;
    private Double salarioMensual;
    private Date fechaNacimiento;
    private Double totalActivos;
    private Double totalPasivos;
    private String autorizaCentrales;

    private String genero;
    private String tipoResidencia;
    private Integer actividadEconomica;
    private String tipoContrato;
    private String nivelEstudios;
    private String tipoInmueble;
    private String estadoCivil;

}
