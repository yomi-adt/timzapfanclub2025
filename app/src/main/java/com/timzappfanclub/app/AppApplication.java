package com.timzappfanclub.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@SpringBootApplication
public class AppApplication {

	//private static String masterPassword;
    public static void main(String[] args){


		// ================Testing the Hashing + Salting================

        // SecureRandom random = new SecureRandom();
        // Scanner scanner = new Scanner(System.in);

        // byte[] salt = new byte[64];
        // do{
        //     System.out.println("Please enter a master password (no whitespace):");
        //     masterPassword = scanner.nextLine();
        // }while(!validateMasterPassword(masterPassword));

        // random.nextBytes(salt);

        // System.out.println("Test Password before: " + masterPassword);

        // String hashedPassword = hash(masterPassword, salt);

        // System.out.println("Test Password after: " + hashedPassword);

        // System.out.println("Verify: " + checkPassword(masterPassword, hashedPassword, salt));

        // System.out.println(salt);
    }

    private static boolean validateMasterPassword(String password){
        boolean valid = true;
        if(password != null){
            if(password.indexOf(" ") > -1){
                valid = false;
            }
        }

        return(valid);
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
