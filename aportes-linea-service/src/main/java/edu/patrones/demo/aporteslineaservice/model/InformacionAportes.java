package edu.patrones.demo.aporteslineaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Aportes_Linea")
public class InformacionAportes {

    @Id
    @Column(name = "id")
    private Long aportesId;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private Long numeroDocumento;

    @Column(name = "fecha_pago")
    private Date fecha_pago;

    @Column(name = "pago_realizado")
    private Double pagoRealizado;
}
