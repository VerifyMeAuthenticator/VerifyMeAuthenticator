package com.autenticador.Main;

import com.autenticator.AuthenticationService;
import com.autenticator.Database.DatabaseUserDAO;
import com.autenticator.Database.UserDAO;
import com.autenticator.Users.NewUser;
import com.autenticator.DefaultAuthenticationService;
import com.autenticator.DefaultSessionManager;
import com.autenticator.PasswordEncryptor;
import com.autenticator.SHA256PasswordEncryptor;
import com.autenticator.SessionManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    // Obtém uma instância de Logger para a classe Main
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Criando uma instância do DatabaseUserDAO
        UserDAO userDAO = new DatabaseUserDAO();
        
        // Criando uma instância de SessionManager
        SessionManager sessionManager = new DefaultSessionManager();

        // Criando uma instância de PasswordEncryptor
        PasswordEncryptor passwordEncryptor = new SHA256PasswordEncryptor();

        // Criando uma instância do AuthenticationService com o DatabaseUserDAO
        AuthenticationService authService = new DefaultAuthenticationService(userDAO, sessionManager, passwordEncryptor);

        // Logando início do método main
        logger.log(Level.INFO, "Iniciando o método main.");

        // Autenticando como administrador
        boolean authenticated = authService.authenticate("admin", "adminpassword");
        if (!authenticated) {
            // Log de falha na autenticação do administrador
            logger.log(Level.SEVERE, "Falha na autenticação do administrador.");
            return;
        } else {
            // Log de sucesso na autenticação do administrador
            logger.log(Level.INFO, "Administrador autenticado com sucesso.");
        }

        // Logando registro de novos usuários
        logger.log(Level.INFO, "Registrando novos usuários.");

        // Criando uma instância de NewUser
        NewUser newUser = new NewUser(userDAO, authService);

        // Registrando novos usuários
        newUser.registerUser("novousuario1", "novasenha1", "usuario1@example.com", "123456789", "user");
        logger.log(Level.INFO, "Novo usuário 1 registrado com sucesso.");
        newUser.registerUser("novousuario2", "novasenha2", "usuario2@example.com", "987654321", "user");
        logger.log(Level.INFO, "Novo usuário 2 registrado com sucesso.");

        // Encerrando a sessão do administrador
        authService.logout();
        logger.log(Level.INFO, "Sessão do administrador encerrada.");

        // Logando fim do método main
        logger.log(Level.INFO, "Fim do método main.");
    }
}
