package edu.patrones.demo.aporteslineaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InformacionAportesId implements Serializable {

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private Long numeroDocumento;

    @Column(name = "fecha_pago")
    private Date fecha_pago;

}
