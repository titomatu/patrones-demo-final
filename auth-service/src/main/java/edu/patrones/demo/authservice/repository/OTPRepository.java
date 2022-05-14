package edu.patrones.demo.authservice.repository;

import edu.patrones.demo.authservice.model.OTP;
import edu.patrones.demo.authservice.model.OTPId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OTP, OTPId> {
}
