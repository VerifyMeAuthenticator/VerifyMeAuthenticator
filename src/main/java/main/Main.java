package main;

import entities.User;
import implementation.InMemoryUserRepository;
import repository.UserRepository;
import service.UserService;

public class Main {
	public static void main(String[] args) {
        // Configuração do repositório de usuários em memória
        UserRepository userRepository = new InMemoryUserRepository();
        
        // Serviço de registro de usuários
        UserService userService = new UserService(userRepository);
        
        // Registro de um novo usuário
        userService.registerUser("user123", "password123");

        // Recuperação do usuário registrado
        User registeredUser = userRepository.getUser("user123");
        if (registeredUser != null) {
            System.out.println("Usuário registrado: " + registeredUser.getUsername());
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
