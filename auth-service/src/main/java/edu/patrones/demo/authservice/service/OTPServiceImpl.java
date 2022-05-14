package edu.patrones.demo.authservice.service;

import edu.patrones.demo.authservice.model.OTP;
import edu.patrones.demo.authservice.repository.OTPRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OTPServiceImpl implements OTPService, UserDetailsService {
    private final OTPRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OTP getOTP(String username) {
        return repository.getById(username);
    }

    @Override
    public OTP saveOTP(OTP otp) {
        log.info("Saving User {} into the database", otp.getUsername());
        otp.setPassword(passwordEncoder.encode(otp.getPassword()));
        return repository.save(otp);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<OTP> otpOptional = repository.findById(username);

        if(!otpOptional.isPresent())
            throw new UsernameNotFoundException("Usuario No Econtrado");

        OTP otp = otpOptional.get();

        Collection< GrantedAuthority > grantedAuthorities = new ArrayList<>();

        return new User(username, otp.getPassword(), grantedAuthorities);
    }
}
