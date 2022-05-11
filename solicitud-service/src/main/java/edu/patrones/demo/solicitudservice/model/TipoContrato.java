package edu.patrones.demo.solicitudservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TIPO_CONTRATO")
public class TipoContrato {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "descripcion")
    String descripcion;
}
