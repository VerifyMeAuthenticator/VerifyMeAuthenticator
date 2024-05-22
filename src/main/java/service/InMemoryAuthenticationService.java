package service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import entities.User;
import util.PasswordUtil;

public class InMemoryAuthenticationService implements AuthenticationService {
    private final Map<String, User> users = new ConcurrentHashMap<String, User>();
    private final int maxFailedAttempts = 3;
    private final long lockTimeDuration = 5 * 60 * 1000; // 5 minutos

    public void register(String username, String email, String password) throws IllegalArgumentException {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Usuário já existe.");
        }

        String hashedPassword = PasswordUtil.hashPassword(password);
        User user = new User(username, email, hashedPassword);
        users.put(username, user);
    }

    public boolean login(String username, String password) throws IllegalArgumentException {
        User user = users.get(username);
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }

        if (user.isAccountLocked() && user.getLockExpirationDate() != null &&
                user.getLockExpirationDate().isAfter(java.time.LocalDateTime.now())) {
            throw new IllegalArgumentException("Conta bloqueada. Tente novamente mais tarde.");
        }

        boolean isPasswordCorrect = PasswordUtil.checkPassword(password, user.getHashedPassword());

        if (!isPasswordCorrect) {
            int failedAttempts = user.getFailedLoginAttempts() + 1;
            user.setFailedLoginAttempts(failedAttempts);

            if (failedAttempts >= maxFailedAttempts) {
                user.setAccountLocked(true);
                user.setLockExpirationDate(java.time.LocalDateTime.now().plusMinutes(lockTimeDuration / (60 * 1000)));
            }

            throw new IllegalArgumentException("Senha inválida.");
        }

        // Reset failed login attempts on successful login
        user.setFailedLoginAttempts(0);
        user.setAccountLocked(false);
        user.setLockExpirationDate(null);
        
        return true;
    }

}



