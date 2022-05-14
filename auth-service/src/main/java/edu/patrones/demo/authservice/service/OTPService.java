package edu.patrones.demo.authservice.service;

import edu.patrones.demo.authservice.model.OTP;

public interface OTPService {

    OTP getOTP(String tipoDocumento, Long numeroDocumento, Integer otp);

    OTP saveOTP(OTP otp);
}
