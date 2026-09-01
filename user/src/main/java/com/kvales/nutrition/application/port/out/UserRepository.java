package com.kvales.nutrition.application.port.out;

import com.kvales.nutrition.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}