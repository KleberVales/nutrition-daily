package com.nutritiondaily.userservice.entity;


/**
 * The User class represents a user in the system.
 * It may include properties such as username, password, and other personal details,
 * and is designed to store and manage user-related information.
 *
 * This class can be used as a foundation for user authentication, authorization,
 * and other user-related features in an application.
 */
public class User {

    private String username;
    private String password;
    private String email;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
