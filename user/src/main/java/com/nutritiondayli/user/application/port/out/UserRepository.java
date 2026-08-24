package com.nutritiondayli.user.application.port.out;

import com.nutritiondayli.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}