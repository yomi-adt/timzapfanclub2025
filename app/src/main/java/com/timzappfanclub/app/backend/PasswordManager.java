
package com.timzappfanclub.app.backend;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import lombok.Getter;
import lombok.Setter;


// package com.timzappfanclub.app.backend;

// import java.security.NoSuchAlgorithmException;
// import java.security.spec.InvalidKeySpecException;
// import java.util.Base64;

// import javax.crypto.SecretKeyFactory;
// import javax.crypto.spec.PBEKeySpec;

@Getter
@Setter
public class PasswordManager {
    private byte[] salt;
    private String hashed_pass;

    public PasswordManager(String unhashedPass){
        salt = generateSalt();
        hashed_pass = hash(unhashedPass, salt);
        System.out.println(unhashedPass);
        System.out.println(hashed_pass);
        System.out.println("Verify: " + checkPassword(unhashedPass, hashed_pass, salt));
        
    }

    // ================Testing the Hashing + Salting================
    public static void main(String[] args){
        new PasswordManager("hi");
    }

    public static byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[64];
        random.nextBytes(salt);
        return salt;
    }

    public static String hash(String string, byte[] salt) {
        try {
            int iterations = 10000;
            int keyLength = 256;

            PBEKeySpec spec = new PBEKeySpec(string.toCharArray(), salt, iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = skf.generateSecret(spec).getEncoded();

            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error while hashing password", e);
        }
    }


    public static boolean checkPassword(String input, String hash, byte[] salt) {
        String newHash = hash(input, salt); 
        return newHash.equals(hash); 
    }
}