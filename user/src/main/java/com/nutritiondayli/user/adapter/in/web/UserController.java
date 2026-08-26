package com.nutritiondayli.user.adapter.in.web;

import com.nutritiondayli.user.application.port.in.AuthenticateUserUseCase;
import com.nutritiondayli.user.application.port.in.RegisterUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegisterUserUseCase registerUserUseCase;
    private final AuthenticateUserUseCase authenticateUserUseCase;

    public UserController(
            RegisterUserUseCase registerUserUseCase,
            AuthenticateUserUseCase authenticateUserUseCase
    ) {
        this.registerUserUseCase = registerUserUseCase;
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @PostMapping
    public ResponseEntity<RegisterUserUseCase.RegisterUserResult> register(
            @RequestBody RegisterUserRequest request
    ) {

        RegisterUserUseCase.RegisterUserCommand command =
                new RegisterUserUseCase.RegisterUserCommand(
                        request.name(),
                        request.email(),
                        request.password()
                );

        RegisterUserUseCase.RegisterUserResult result =
                registerUserUseCase.registerUser(command);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticateUserUseCase.AuthenticateUserResult> login(
            @RequestBody AuthenticateUserRequest request
    ) {

        AuthenticateUserUseCase.AuthenticateUserCommand command =
                new AuthenticateUserUseCase.AuthenticateUserCommand(
                        request.email(),
                        request.password()
                );

        AuthenticateUserUseCase.AuthenticateUserResult result =
                authenticateUserUseCase.authenticate(command);

        return ResponseEntity.ok(result);
    }

    public record RegisterUserRequest(
            String name,
            String email,
            String password
    ) {
    }

    public record AuthenticateUserRequest(
            String email,
            String password
    ) {
    }
}