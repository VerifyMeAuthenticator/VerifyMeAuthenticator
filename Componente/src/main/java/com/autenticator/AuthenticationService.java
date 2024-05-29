package com.autenticator;

import com.autenticator.Users.User;

/**
 * Interface para o serviço de autenticação.
 */
public interface AuthenticationService {
	/**
     * Autentica um usuário com o nome de usuário e a senha fornecidos.
     *
     * @param username o nome do usuário
     * @param password a senha do usuário
     * @return true se a autenticação foi bem-sucedida, false caso contrário
     */
    boolean authenticate(String username, String password);
    boolean isAuthenticated();
    void logout();
    User getAuthenticatedUser(); // adicionado método getAuthenticatedUser()
    PasswordEncryptor getPasswordEncryptor();
}