package com.nutritiondayli.user.application.service;

import com.nutritiondayli.user.application.port.in.AuthenticateUserUseCase;
import com.nutritiondayli.user.application.port.out.UserRepository;
import com.nutritiondayli.user.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuthenticateUserService
        implements AuthenticateUserUseCase {

    private final UserRepository userRepository;

    public AuthenticateUserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthenticateUserResult authenticate(
            AuthenticateUserCommand command
    ) {

        User user = userRepository
                .findByEmail(command.email())
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Invalid email or password"
                        )
                );

        if (!user.getPassword().equals(command.password())) {
            throw new IllegalArgumentException(
                    "Invalid email or password"
            );
        }

        return new AuthenticateUserResult(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}