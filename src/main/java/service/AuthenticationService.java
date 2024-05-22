package service;

public interface AuthenticationService {
    void register(String username, String email, String password) throws IllegalArgumentException;
    boolean login(String username, String password) throws IllegalArgumentException;
}


