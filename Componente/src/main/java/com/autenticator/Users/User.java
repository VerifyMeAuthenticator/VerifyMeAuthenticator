package com.autenticator.Users;
/**
 * Interface que representa um usuário no sistema de autenticação.
 */
public interface User {
    String getUsername();
    String getPassword();
    String getRole();
    String getEmail();
    String getPhoneNumber();
    boolean isBlocked();
    void setBlocked(boolean blocked); // adicionado método setBlocked
}