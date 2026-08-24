package com.nutritiondayli.user.application.port.in;

public interface AuthenticateUserUseCase {

    AuthenticateUserResult authenticate(
            AuthenticateUserCommand command
    );

    record AuthenticateUserCommand(
            String email,
            String password
    ) {
    }

    record AuthenticateUserResult(
            Long userId,
            String name,
            String email
    ) {
    }
}