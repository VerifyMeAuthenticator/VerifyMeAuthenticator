package com.autenticator.Users;

import com.autenticator.User;

public class AdminUser implements User {
    private String username;
    private String password;
    private String role;
    private String email;
    private String phoneNumber;

    public AdminUser(String username, String password, String role, String email, String phoneNumber) {
        
        this.username = username;
        this.password = password;
        this.role = role;
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