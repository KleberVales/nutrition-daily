package com.nutritiondaily.userservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

/**
 * The User class represents a user in the system.
 * It may include properties such as username, password, and other personal details,
 * and is designed to store and manage user-related information.
 *
 * This class can be used as a foundation for user authentication, authorization,
 * and other user-related features in an application.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String password;
    private String email;
    private int age;
    private String sex;


}
