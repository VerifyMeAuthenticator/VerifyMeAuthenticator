package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

    public static String hashPassword(String plainTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] salt = generateSalt();
            md.update(salt);
            byte[] hashedPassword = md.digest(plainTextPassword.getBytes());
            return Base64.getEncoder().encodeToString(salt) + "$" + Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static boolean checkPassword(String plainTextPassword, String storedPassword) {
        String[] parts = storedPassword.split("\\$");
        if (parts.length != 2) {
            return false;
        }
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] storedHash = Base64.getDecoder().decode(parts[1]);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] calculatedHash = md.digest(plainTextPassword.getBytes());
            return MessageDigest.isEqual(storedHash, calculatedHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error checking password", e);
        }
    }

    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
}

