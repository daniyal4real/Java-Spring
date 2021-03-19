package com.company;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random ;


class Blowfish {
    byte[] symmetricKey = new byte[1000];
    String symmetricKeyString;
    static byte[] rawKey;
    String plainText;

    //constructor of the class Blowfish
    public Blowfish() throws Exception {
        generateSymmetricKey();
        plainText = "Daniyal Ganiuly";
        System.out.println("Plaintext: "+ plainText);
        byte[] getBytes = plainText.getBytes();
        byte[] encryptBytes = encryptData(rawKey, getBytes);
        String encryptedData = new String(encryptBytes);
        System.out.println("Encrypted data: " + encryptedData);
        byte[] decryptBytes = decryptData(rawKey,encryptBytes);
        String decryptedData = new String(decryptBytes);
        System.out.println("Decrypted data: " + decryptedData);
    }

    //method is used to generate symmetric key
    void generateSymmetricKey() throws Exception {
        Random random = new Random();
        int num = random.nextInt(10000);
        String valueOfNum = String.valueOf(num);
        byte[] bytesValueOfNum = valueOfNum.getBytes();
        symmetricKey = getRawKey(bytesValueOfNum);
        symmetricKeyString = new String(symmetricKey);
        System.out.println("Blowfish Symmetric key = " + symmetricKeyString);
    }

    //method is used to return the generated secret raw key
    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        keyGenerator.init(128, sr);
        SecretKey secretKey = keyGenerator.generateKey();
        rawKey = secretKey.getEncoded();
        return rawKey;
    }

    //method is used to encrypt
    private static byte[] encryptData(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    //method is used to decrypt
    private static byte[] decryptData(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        return decrypted;
    }

    //main method
    public static void main(String args[]) throws Exception {
        Blowfish blowfish = new Blowfish();
    }
}