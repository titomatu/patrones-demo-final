package edu.patrones.demo.solicitudservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.patrones.demo.event.aportes.AportesLineaStatus;
import edu.patrones.demo.event.centrales.CentralesStatus;
import edu.patrones.demo.event.rnec.RNECStatus;
import edu.patrones.demo.event.solicitud.SolicitudStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SOLICITUD_PRESTAMO")
public class Solicitud {

    @Id
    @Column(name = "numero_solicitud")
    private String numeroSolicitud;

    @Column(name = "valor_solicitado")
    private Double valorSolicitado;

    @Column(name = "valor_aprobado")
    private Double valorAprobado;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="cliente_tipo_documento", referencedColumnName="tipo_documento"),
            @JoinColumn(name="cliente_numero_documento", referencedColumnName="numero_documento")
    })
    @JsonIgnore
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_solicitud")
    private SolicitudStatus solicitudStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_registraduria")
    private RNECStatus rnecStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "informacion_centrales")
    private CentralesStatus centralesStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "aportes_en_linea")
    private AportesLineaStatus aportesLineaStatus;
}
