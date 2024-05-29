package com.autenticator;

import com.autenticator.Database.UserDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultAuthenticationService extends AbstractAuthenticationService {
	// Obtém uma instância de Logger para a classe DefaultAuthenticationService
    private static final Logger logger = Logger.getLogger(DefaultAuthenticationService.class.getName());
    public DefaultAuthenticationService(UserDAO userDAO, SessionManager sessionManager, PasswordEncryptor passwordEncryptor) {
        super(userDAO, sessionManager, passwordEncryptor);
    }
    
    @Override
    public boolean authenticate(String username, String password) {
        logger.log(Level.INFO, "Iniciando autenticação para o usuário: " + username);

        // Chama o método authenticate da superclasse AbstractAuthenticationService
        boolean isAuthenticated = super.authenticate(username, password);

        // Registra o resultado da autenticação
        if (isAuthenticated) {
            logger.log(Level.INFO, "Usuário autenticado com sucesso: " + username);
        } else {
            logger.log(Level.WARNING, "Falha na autenticação para o usuário: " + username);
        }

        return isAuthenticated;
    }
    
    @Override
    public PasswordEncryptor getPasswordEncryptor() { 
        return passwordEncryptor;
    }
    
}

