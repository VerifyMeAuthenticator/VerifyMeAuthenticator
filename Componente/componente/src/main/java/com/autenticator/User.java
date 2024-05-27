package com.autenticator;

public interface User {

    String getUsername();

    String getPassword();

    String getRole();

    String getEmail();

    String getPhoneNumber();

    // Marca ou desmarca o usuário como bloqueado (adicionado)
    boolean isBlocked();

    void setBlocked(boolean blocked);
}