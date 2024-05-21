package service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import entities.User;
import util.PasswordUtil;

public class InMemoryAuthenticationService implements AuthenticationService {
    private Map<String, User> users = new ConcurrentHashMap<String, User>();

    public void register(String username, String email, String password) throws IllegalArgumentException {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists.");
        }

        String hashedPassword = PasswordUtil.hashPassword(password);
        User user = new User(username, email, hashedPassword);
        users.put(username, user);
    }

    
}


