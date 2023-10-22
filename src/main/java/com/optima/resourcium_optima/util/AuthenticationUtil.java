package com.optima.resourcium_optima.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AuthenticationUtil {
    private static final String SALT = "this is a salt";

    public static String hashPassword(String password) {
        String saltedPassword = SALT + password;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(saltedPassword.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing the password.");
        }
    }

    public static boolean verifyPassword(String inputPassword, String hashedPassword) {
        String inputHash = hashPassword(inputPassword);
        return inputHash.equals(hashedPassword);
    }
}
