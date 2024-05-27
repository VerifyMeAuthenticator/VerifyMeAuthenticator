package com.autenticator;

public interface AuthenticationService {

    // Autentica um usuário com base em nome e senha
    boolean authenticate(String username, String password);

    // Verifica se um usuário está autenticado
    boolean isAuthenticated();

    // Desconecta o usuário autenticado
    void logout();

    // Recupera o usuário atualmente autenticado (adicionado)
    User getAuthenticatedUser();
}