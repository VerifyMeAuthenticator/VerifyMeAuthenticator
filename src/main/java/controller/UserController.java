package controller;

import java.util.Scanner;

import service.AuthenticationService;

public class UserController {
    private final AuthenticationService authenticationService;

    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do usuario: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        try {
            authenticationService.register(username, email, password);
            System.out.println("Usuário registrado com sucesso.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Outros métodos de interação com o usuário...
}

