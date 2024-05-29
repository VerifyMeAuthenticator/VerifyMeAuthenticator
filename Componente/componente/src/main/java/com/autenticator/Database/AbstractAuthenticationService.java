package com.autenticator.Database;

import com.autenticator.AuthenticationService;
import com.autenticator.Users.User;

public abstract class AbstractAuthenticationService implements AuthenticationService {

    // DAO para interagir com o armazenamento de dados do usuário
    protected UserDAO userDAO;

    // Usuário atualmente autenticado
    protected User authenticatedUser;

    // Número máximo de tentativas de login
    private final int maxAttempts = 3;

    // Número de tentativas de login do usuário na sessão atual
    private int attempts = 0;

    // Construtor com UserDAO
    public AbstractAuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Autentica um usuário com base em nome de usuário e senha
    @Override
    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            if (attempts >= maxAttempts) {
                user.setBlocked(true);
                userDAO.saveUser(user);
                return false;
            }

            authenticatedUser = user;
            attempts = 0;
            return true;
        } else {
            attempts++;
            return false;
        }
    }

    // Verifica se um usuário está autenticado
    @Override
    public boolean isAuthenticated() {
        return authenticatedUser != null;
    }

    // Desconecta o usuário autenticado
    @Override
    public void logout() {
        authenticatedUser = null;
    }

    // Retorna o usuário autenticado
    @Override
    public User getAuthenticatedUser() {
        return authenticatedUser;
    }
}