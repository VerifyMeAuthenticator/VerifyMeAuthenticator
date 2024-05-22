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

        System.out.print("Usuário: ");
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

    public void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Usuário: ");
        String username = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();

        try {
            boolean success = authenticationService.login(username, password);
            if (success) {
                System.out.println("Login feito com sucesso.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
