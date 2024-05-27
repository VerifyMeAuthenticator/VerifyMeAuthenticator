package com.autenticator.Users;

import com.autenticator.User;

public class DefaultUser implements User {

    // Indica se o usuário está bloqueado
    private boolean blocked;

    // Credenciais e informações do usuário
    private final String username;
    private final String password;
    private final String role;
    private final String email;
    private final String phoneNumber;

    public DefaultUser(String username, String password, String role, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.blocked = false;  // Assume usuário desbloqueado por padrão
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

    @Override
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}