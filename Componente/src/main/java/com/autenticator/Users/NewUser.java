package com.autenticator.Users;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.autenticator.AuthenticationService;
import com.autenticator.Database.UserDAO;

/**
 * Classe responsável por registrar novos usuários.
 */
public class NewUser {

    private UserDAO userDAO;
	private AuthenticationService authService;
    private static final Logger LOGGER = Logger.getLogger(NewUser.class.getName());

    /**
     * Construtor para a classe NewUser.
     *
     * @param userDAO o DAO de usuários
     * @param authenticationService o serviço de autenticação
     */
   

    public NewUser(UserDAO userDAO, AuthenticationService authService) {
        this.userDAO = userDAO;
        this.authService = authService;
    }

    /**
     * Método para registrar um novo usuário.
     *
     * @param login o nome de usuário
     * @param password a senha do usuário
     * @param email o email do usuário
     * @param phoneNumber o número de telefone do usuário
     * @param role o papel do usuário
     */
    public void registerUser(String username, String password, String email, String phoneNumber, String role) {
        // Verifica se o usuário autenticado é um administrador
        User authenticatedUser = authService.getAuthenticatedUser();
        if (authenticatedUser == null || !authenticatedUser.getRole().equals("admin")) {
            throw new RuntimeException("Somente administradores podem registrar novos usuários.");
        }

        // Criptografa a senha antes de salvar o usuário
        String encryptedPassword = authService.getPasswordEncryptor().encrypt(password);

        // Cria um novo usuário com a senha criptografada
        User newUser = new DefaultUser(username, encryptedPassword, email, phoneNumber, role);

        // Salva o novo usuário no banco de dados
        userDAO.saveUser(newUser);
    }

    /**
     * Método para registrar um novo usuário com função de administrador.
     *
     * @param login o nome de usuário
     * @param password a senha do usuário
     * @param email o email do usuário
     * @param phoneNumber o número de telefone do usuário
     */
    public void registerAdminUser(String login, String password, String email, String phoneNumber) {
        registerUser(login, password, email, phoneNumber, "admin");
    }

    /**
     * Verifica se um administrador está autenticado.
     *
     * @return true se um administrador estiver autenticado, false caso contrário
     */
    private boolean isAdminAuthenticated() {
        return authService.isAuthenticated() && authService.getAuthenticatedUser().getRole().equals("admin");
    }
}
