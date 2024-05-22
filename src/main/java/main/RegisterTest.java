package main;

import java.util.Scanner;

import controller.UserController;
import service.AuthenticationService;
import service.InMemoryAuthenticationService;

public class RegisterTest {
    public static void main(String[] args) {
        AuthenticationService authenticationService = new InMemoryAuthenticationService();
        UserController userController = new UserController(authenticationService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    userController.registerUser();
                    break;
                case 2:
                    userController.loginUser();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

