package edu.patrones.demo.registraduriaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RNEC")
public class RNEC {

    @EmbeddedId
    private RNECId rnecId;

    @Column(name = "fecha_expedicion")
    private Date fechaExpedicion;

}
