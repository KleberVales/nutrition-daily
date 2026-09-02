package com.nutritiondayli.auth.adapter.out.security;

import com.nutritiondayli.user.application.port.out.PasswordEncoderPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderAdapter
        implements PasswordEncoderPort {

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }
}