package com.nutritiondayli.user.adapter.out.persistence;

import com.nutritiondayli.user.application.port.out.UserRepository;
import com.nutritiondayli.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPersistenceAdapter
        implements UserRepository {

    private final SpringDataUserRepository repository;

    public UserPersistenceAdapter(
            SpringDataUserRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {

        UserJpaEntity entity =
                new UserJpaEntity(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword()
                );

        UserJpaEntity saved =
                repository.save(entity);

        return toDomain(saved);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return repository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {

        return repository.existsByEmail(email);
    }

    private User toDomain(UserJpaEntity entity) {

        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}