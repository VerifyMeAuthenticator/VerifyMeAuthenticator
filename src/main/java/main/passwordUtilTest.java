package main;

import controller.UserController;
import service.AuthenticationService;
import service.InMemoryAuthenticationService;
import util.PasswordUtil;

public class passwordUtilTest {
	
	public static void main(String[] args) {
        testHashPassword();
        testCheckPassword();
    }

	private static void testHashPassword() {
		// TODO Auto-generated method stub
		 String password = "senhaSegura123";
	        String hashedPassword = PasswordUtil.hashPassword(password);

	        if (hashedPassword == null || hashedPassword.isEmpty()) {
	            System.out.println("testHashPassword Falhou");
	        } else {
	            System.out.println("testHashPassword Passou");
	        }
	}

	private static void testCheckPassword() {
		// TODO Auto-generated method stub
		String password = "senhaSegura123";
        String hashedPassword = PasswordUtil.hashPassword(password);

        boolean isPasswordCorrect = PasswordUtil.checkPassword(password, hashedPassword);
        boolean isPasswordIncorrect = PasswordUtil.checkPassword("SenhaErrada", hashedPassword);

        if (isPasswordCorrect && !isPasswordIncorrect) {
            System.out.println("testCheckPassword Passou");
        } else {
            System.out.println("testCheckPassword Falhou");
        }
	}

}



