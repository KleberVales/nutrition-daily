package com.kvales.nutrition.application.service;

import com.kvales.nutrition.application.port.out.UserRepository;
import com.kvales.nutrition.application.port.in.RegisterUserUseCase;
import com.kvales.nutrition.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterUserService
        implements RegisterUserUseCase {

    private final UserRepository userRepository;

    public RegisterUserService(
            UserRepository userRepository

    ) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResult registerUser(
            RegisterUserCommand command
    ) {

        if (userRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException(
                    "Email already registered"
            );
        }



        User user = new User(
                null,
                command.name(),
                command.email(),
                command.password()
        );

        User savedUser =
                userRepository.save(user);

        return new RegisterUserResult(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
}