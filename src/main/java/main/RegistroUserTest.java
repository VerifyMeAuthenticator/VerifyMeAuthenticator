package main;

import controller.UserController;
import service.AuthenticationService;
import service.InMemoryAuthenticationService;

public class RegistroUserTest {

	public static void main(String[] args) {
		AuthenticationService authenticationService = new InMemoryAuthenticationService();
        UserController userController = new UserController(authenticationService);

        // Simular o registro de um usuário
        userController.registerUser();
	}

}
