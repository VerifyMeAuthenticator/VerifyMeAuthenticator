package entities;

import java.time.LocalDateTime;

public class User {
    private String username;
    private String email;
    private String hashedPassword;
    private boolean accountLocked;
    private LocalDateTime passwordExpirationDate;
    private LocalDateTime lockExpirationDate;

    public User(String username, String email, String hashedPassword) {
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.accountLocked = false;
        this.passwordExpirationDate = LocalDateTime.now().plusDays(90); // Exemplo de expiração de 90 dias
        this.lockExpirationDate = null;
    }

    // Getters e setters...

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public LocalDateTime getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    public void setPasswordExpirationDate(LocalDateTime passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }

    public LocalDateTime getLockExpirationDate() {
        return lockExpirationDate;
    }

    public void setLockExpirationDate(LocalDateTime lockExpirationDate) {
        this.lockExpirationDate = lockExpirationDate;
    }
}
