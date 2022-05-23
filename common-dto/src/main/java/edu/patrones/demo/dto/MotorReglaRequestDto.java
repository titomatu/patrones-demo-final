package edu.patrones.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorReglaRequestDto {
    private	String	tipoDocumento;
    private	long	numeroDocumento;
    private	Date	fechaExpedicion;
    private	String	nombre1;
    private	String	nombre2;
    private	String	apellido1;
    private	String	apellido2;
    private	long	celular;
    private	String	correoElectronico;
    private	Double	salarioMensual;
    private	Date	fechaNacimiento;
    private	long	totalActivos;
    private	long	totalPasivos;
    private	String	autorizaCentrales;
    private	String	genero;
    private	String	tipoResidencia;
    private	String	actividadEconomica;
    private	String	tipoContrato;
    private	String	nivelEstudios;
    private	String	tipoInmueble;
    private	String	estadoCivil;
    private String  aprobadoCentral;
    private Double  salarioAportes;
    private long    valorAprobado;
    private String  numeroSolicitud;
    private int     codeRespuesta;
    private String  mensajeE;
}
