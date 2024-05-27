package com.autenticador.Database;

import com.autenticador.AuthenticationService;
import com.autenticador.Users.DefaultUser;

public class NewUser {

    // DAO para interagir com dados do usuário
    private UserDAO userDAO;

    // Serviço para autenticação do usuário
    private AuthenticationService authenticationService;

    public NewUser(UserDAO userDAO, AuthenticationService authenticationService) {
        this.userDAO = userDAO;
        this.authenticationService = authenticationService;
    }

    public void registrarUsuario(String login, String senha, String email, String telefone, String funcao) {
        // Apenas administradores podem registrar usuários
        if (!estaAutenticadoAdmin()) {
            throw new RuntimeException("Apenas administradores podem registrar novos usuários.");
        }

        DefaultUser usuario = new DefaultUser(login, senha, funcao, email, telefone);
        userDAO.salvarUsuario(usuario);
    }

    // Registra um usuário admin com atribuição de função simplificada
    public void registrarUsuarioAdmin(String login, String senha, String email, String telefone) {
        registrarUsuario(login, senha, email, telefone, "admin");
    }

    // Método auxiliar para verificar o status de admin autenticado
    private boolean estaAutenticadoAdmin() {
        return authenticationService.estaAutenticado() &&
                authenticationService.getUsuarioAutenticado().getFuncao().equals("admin");
    }
}