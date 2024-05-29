package com.autenticator;

import com.autenticator.Database.UserDAO;
import com.autenticator.Users.User;

import java.util.Optional;

/**
 * Classe abstrata para o serviço de autenticação.
 */
public abstract class AbstractAuthenticationService implements AuthenticationService {
    protected UserDAO userDAO;
    protected SessionManager sessionManager;
    protected PasswordEncryptor passwordEncryptor;
    private int maxAttempts = 3;
    private int attempts = 0;

    /**
     * Construtor para AbstractAuthenticationService com as dependências especificadas.
     *
     * @param userDAO o repositório de usuários
     * @param sessionManager o gerenciador de sessão
     * @param passwordEncryptor o serviço de criptografia de senhas
     */
    public AbstractAuthenticationService(UserDAO userDAO, SessionManager sessionManager, PasswordEncryptor passwordEncryptor) {
        this.userDAO = userDAO;
        this.sessionManager = sessionManager;
        this.passwordEncryptor = passwordEncryptor;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = userDAO.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncryptor.matches(password, user.getPassword())) {
                if (attempts >= maxAttempts) {
                    user.setBlocked(true); // bloquear a conta do usuário
                    userDAO.saveUser(user);
                    return false;
                }
                sessionManager.setAuthenticatedUser(user);
                attempts = 0;
                return true;
            }
        }

        attempts++;
        return false;
    }

    @Override
    public boolean isAuthenticated() {
        return sessionManager.getAuthenticatedUser() != null;
    }

    @Override
    public void logout() {
        sessionManager.clear();
    }

    @Override
    public User getAuthenticatedUser() {
        return sessionManager.getAuthenticatedUser();
    }
}
