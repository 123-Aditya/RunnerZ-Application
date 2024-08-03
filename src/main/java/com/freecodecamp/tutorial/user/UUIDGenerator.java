package com.freecodecamp.tutorial.user;

import java.math.BigInteger;
import java.security.SecureRandom;

public class UUIDGenerator {

    private static final SecureRandom random = new SecureRandom();
    
    public String generateUUID(String[] args) {
        // Generate a random string of length 16
        String randomString = generateRandomString(16);
        
        // Ensure it's exactly 16 characters long
        randomString = randomString.substring(0, 16);
        return randomString;
    }
    
    public String generateRandomString(int length) {
        return new BigInteger(length * 5, random).toString(32); // Base-32 encoding
    }

}
