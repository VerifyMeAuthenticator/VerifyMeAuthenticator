package com.autenticator;

/**
 * Interface para criptografia de senhas.
 */
public interface PasswordEncryptor {
    String encrypt(String password);
    boolean matches(String rawPassword, String encryptedPassword);
}


