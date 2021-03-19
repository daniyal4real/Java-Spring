package com.company;
import java.util.*;
public class Main {
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // method to randomize the key
// the randomizer of key is used instead of writing the definite key, it adds more security
    public static String randomize(int length){
        Random random = new Random();
        String key = "";
        //key will have the same length as the plaintext
        // adding symbols to key string
        for(int i=0; i<length;i++)
            key += (char) (random.nextInt(26) + 'A');
        return key;
    }
    // method to encrypt the plaintext
    public static String encryptData(String plainText,String key){
        String encryptedText = "";
        // adding letters to encrypted text by looping through the letters of plaintext
        for(int i=0; i<plainText.length(); i++){
            char getCharacter = plainText.charAt(i);
            char getKey = key.charAt(i);
            // checking alphabet character or not
            if(Character.isAlphabetic(getCharacter)){
                int index = alphabet.indexOf(getCharacter);
                int keyIndex = alphabet.indexOf(Character.toString(getKey));
                // the sum of the indexes of plaintext letters and key letters
                int total = (index + keyIndex) % 26;
                encryptedText += alphabet.charAt(total);
            } else{
                encryptedText += getCharacter;
            }
        }
        return encryptedText;
    }
    // method to decrypt the encrypted text
    public static String decryptData(String encryptedText,String key){
        String decryptedText = "";
        // decrypted text will have the same length as the encrypted text
        for(int i=0; i<encryptedText.length(); i++){
            char get = encryptedText.charAt(i);
            char getKey = key.charAt(i);
            if(Character.isAlphabetic(get)){
                int index = alphabet.indexOf(get);
                int keyIndex = alphabet.indexOf(Character.toString(getKey));
                int total = (index - keyIndex) % 26;
                // checking the sum is less than 0, if so, then subtract 26 from sum
                if (total < 0){
                    total += 26;
                }
                decryptedText += alphabet.charAt(total);
            } else{
                decryptedText += get;
            }
        }
        return decryptedText;
    }
    // the main function that starts the process
    public static void main(String[] args){
        String plainText = "DANIYAL GANIULY";
        String key = randomize(plainText.length());
        String encryptedText = encryptData(plainText, key);
        System.out.println("Plaintext : " + plainText);
        System.out.println("Encrypted text: " + encryptedText);
        System.out.println("Decrypted text: " + decryptData(encryptedText, key));
    }
}