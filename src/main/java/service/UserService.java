package service;

import entities.User;
import repository.UserRepository;

public class UserService {
	 private UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public void registerUser(String username, String password) {
	        User existingUser = userRepository.getUser(username);
	        if (existingUser != null) {
	            throw new RuntimeException("O nome do usuário já existe");
	        }
	        User newUser = new User(username, password);
	        userRepository.addUser(newUser);
	    }
}
