package com.company;

import java.util.*;

class Main{
    public static String alphabetCapitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String alphabetLowLetters = "abcdefghijklmnopqrstuvwxyz";

    public static String keyGenerator(int length){
        Random random = new Random();
        String key = "";
        for(int i=0; i<length; i++)
            key += (char) (random.nextInt(26) + 'Z');
        return key;
    }

    public static String encryptData(String text,String key){
        String line = "";
        for(int i=0; i<text.length(); i++){
            char get = text.charAt(i);
            char keyget = key.charAt(i);
            if(Character.isUpperCase(get)){
                int index = alphabetCapitals.indexOf(get);
                int keydex = alphabetCapitals.indexOf(Character.toUpperCase(keyget));

                int total = (index + keydex) % 26;

                line +=  alphabetCapitals.charAt(total);
            }
            else if(Character.isLowerCase(get)){
                int index = alphabetLowLetters.indexOf(get);
                int keydex = alphabetCapitals.indexOf(Character.toLowerCase(keyget));

                int total = (index + keydex) % 26;

                line += alphabetLowLetters.charAt(total);
            }
            else{
                line += get;
            }
        }
        return line;
    }
    public static String decryptData(String text,String key){

        String sb = "";
        for(int x=0;x<text.length();x++){
            char get = text.charAt(x);
            char keyget = key.charAt(x);
            if(Character.isUpperCase(get)){
                int index = alphabetCapitals.indexOf(get);
                int keydex = alphabetCapitals.indexOf(Character.toUpperCase(keyget));

                int total = (index - keydex) % 26;
                total = (total<0)? total + 26 : total;

                sb = sb+ alphabetCapitals.charAt(total);
            }
            else if(Character.isLowerCase(get)){
                int index = alphabetLowLetters.indexOf(get);
                int keydex = alphabetCapitals.indexOf(Character.toLowerCase(keyget));

                int total = (index - keydex) % 26;
                total = (total<0)? total + 26 : total;

                sb = sb+ alphabetLowLetters.charAt(total);
            }
            else{
                sb = sb + get;
            }
        }

        return sb;
    }

    public static void main(String[] args){
        String text = "DANIYAL GANIULY";
        String key = keyGenerator(text.length());

        String enc = encryptData(text,key);
        System.out.println("Plaintext : "+text);
        System.out.println("Encrypted : "+enc);
        System.out.println("Decrypted : "+decryptData(enc,key));
    }

}