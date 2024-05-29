package com.autenticator.Users;

import com.autenticator.Users.User;

public class AdminUser implements User {

    // Credenciais e informações do usuário administrador
    private final String username;
    private final String password;
    private final String role;
    private final String email;
    private final String phoneNumber;

    public AdminUser(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.role = "admin";  // Atribui a função "admin" automaticamente
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}