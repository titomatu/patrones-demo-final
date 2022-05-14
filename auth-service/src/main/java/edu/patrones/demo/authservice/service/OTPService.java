package edu.patrones.demo.authservice.service;

import edu.patrones.demo.authservice.model.OTP;

public interface OTPService {

    OTP getOTP(String username);

    OTP saveOTP(OTP otp);
}
