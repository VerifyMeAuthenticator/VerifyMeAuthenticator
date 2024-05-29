package com.autenticator.Users;

/**
 * Implementação da interface User para um usuário administrador.
 */
public class AdminUser implements User {
    private boolean blocked;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phoneNumber;

    /**
     * Construtor para criar um usuário administrador com as informações fornecidas.
     *
     * @param username o nome de usuário
     * @param password a senha do usuário
     * @param role o papel do usuário
     * @param email o email do usuário
     * @param phoneNumber o número de telefone do usuário
     */
    public AdminUser(String username, String password, String role, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.blocked = false; // Inicialmente, o usuário não está bloqueado
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

    @Override
    public boolean isBlocked() {
        return blocked;
    }
}
