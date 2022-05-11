package edu.patrones.demo.solicitudservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    @EmbeddedId
    private ClienteId clienteId;

    @Column(name = "fecha_expedicion")
    private Date fechaExpedicion;

    @Column(name = "nombre_1")
    private String nombre1;

    @Column(name = "nombre_2")
    private String nombre2;

    @Column(name = "apellido_1")
    private String apellido1;

    @Column(name = "apellido_2")
    private String apellido2;

    @Column(name = "numero_celular")
    private Long celular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "salario_mensual")
    private Double salarioMensual;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "total_activos")
    private Double totalActivos;

    @Column(name = "total_pasivos")
    private Double totalPasivos;

    @Column(name = "autoriza_consulta")
    private String autorizaCentrales;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "tipo_residencia_id")
    private TipoResidencia tipoResidencia;

    @ManyToOne
    @JoinColumn(name = "actividad_economica_id")
    private ActividadEconomica actividadEconomica;

    @ManyToOne
    @JoinColumn(name = "tipo_contrato_id")
    private TipoContrato tipoContrato;

    @ManyToOne
    @JoinColumn(name = "nivel_estudios_id")
    private NivelEstudios nivelEstudios;

    @ManyToOne
    @JoinColumn(name = "tipo_inmueble_id")
    private TipoInmueble tipoInmueble;

    @ManyToOne@JoinColumn(name = "estado_civil_id")
    private EstadoCivil estadoCivil;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Solicitud> solicitudes;

    //
    public Cliente() {
        this.clienteId = new ClienteId();
        this.genero = new Genero();
        this.tipoResidencia = new TipoResidencia();
        this.actividadEconomica = new ActividadEconomica();
        this.tipoContrato = new TipoContrato();
        this.nivelEstudios = new NivelEstudios();
        this.tipoInmueble = new TipoInmueble();
        this.estadoCivil = new EstadoCivil();
    }
}
