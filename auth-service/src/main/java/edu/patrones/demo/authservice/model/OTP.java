package edu.patrones.demo.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "otp")
public class OTP {

    @EmbeddedId
    private OTPId id;

    @Column(name = "expires_in")
    private Date expires_in;

    @Column(name = "vigente")
    private Boolean vigente;
}
