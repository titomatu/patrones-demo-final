package edu.patrones.demo.authservice.service;

import edu.patrones.demo.authservice.model.OTP;
import edu.patrones.demo.authservice.model.OTPId;
import edu.patrones.demo.authservice.repository.OTPRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OTPServiceImpl implements OTPService{
    private final OTPRepository repository;

    @Override
    public OTP getOTP(String tipoDocumento, Long numeroDocumento, Integer otp) {
        return repository.getById(new OTPId(tipoDocumento, numeroDocumento, otp));
    }

    @Override
    public OTP saveOTP(OTP otp) {
        return repository.save(otp);
    }
}
