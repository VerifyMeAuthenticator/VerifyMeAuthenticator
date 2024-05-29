package com.autenticator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;

/**
 * Implementação de PasswordEncryptor usando SHA-256.
 */
public class SHA256PasswordEncryptor implements PasswordEncryptor {
    private static final Logger LOGGER = Logger.getLogger(SHA256PasswordEncryptor.class.getName());

    @Override
    public String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);
            LOGGER.info("Senha criptografada: " + encoded);
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean matches(String rawPassword, String encryptedPassword) {
        String encryptedRawPassword = encrypt(rawPassword);
        boolean matches = encryptedRawPassword.equals(encryptedPassword);
        LOGGER.info("Senhas coincidem? " + matches);
        return matches;
    }
}

