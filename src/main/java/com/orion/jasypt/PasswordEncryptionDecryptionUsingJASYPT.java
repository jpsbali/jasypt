package com.orion.jasypt;

import org.jasypt.iv.RandomIvGenerator;
import org.jasypt.util.text.StrongTextEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordEncryptionDecryptionUsingJASYPT {

    private static String mpCryptoPassword = "BornToFight";

    public static void main(String[] args) {
        try {
            System.out.println("Using StrongTextEncryptor");
            String value1 = "JASYPT - 1";
            System.out.println("Original Value : " + value1);
            StrongTextEncryptor encryptor1 = new StrongTextEncryptor();
            encryptor1.setPassword(mpCryptoPassword);
            String encryptedPassword1 = encryptor1.encrypt(value1);
            System.out.println("Encrypted Value : " + encryptedPassword1);
            StrongTextEncryptor decryptor1 = new StrongTextEncryptor();
            decryptor1.setPassword(mpCryptoPassword);
            String decryptedPassword = decryptor1.decrypt(encryptedPassword1);
            System.out.println("Decrypted Value :" + decryptedPassword);
            System.out.println();

            System.out.println("Using StandardPBEStringEncryptor with PBEWithHMACSHA512AndAES_256");
            String value2 = "JASYPT - 1";
            System.out.println("Original Value : " + value2);
            StandardPBEStringEncryptor encryptor2 = new StandardPBEStringEncryptor();
            encryptor2.setPassword(mpCryptoPassword);
            encryptor2.setAlgorithm("PBEWithHMACSHA512AndAES_256");
            encryptor2.setIvGenerator(new RandomIvGenerator());
            String encryptedPassword2 = encryptor2.encrypt(value2);
            System.out.println("Encrypted Value : " + encryptedPassword2);
            StandardPBEStringEncryptor decryptor2 = new StandardPBEStringEncryptor();
            decryptor2.setPassword(mpCryptoPassword);
            decryptor2.setAlgorithm("PBEWithHMACSHA512AndAES_256");
            decryptor2.setIvGenerator(new RandomIvGenerator());
            System.out.println("Decrypted Value : " + decryptor2.decrypt(encryptedPassword2));
            System.out.println();

            System.out.println("Using StrongPasswordEncryptor ... Is a Digest");
            String value3 = "JASYPT - 1";
            System.out.println("Original Value : " + value3);
            StrongPasswordEncryptor encryptor3 = new StrongPasswordEncryptor();
            String encryptedPassword3 = encryptor3.encryptPassword(value3);
            System.out.println("Encrypted Value : " + encryptedPassword3);
            System.out.println("Decrypted Result : " + encryptor3.checkPassword(value3, encryptedPassword3));
            System.out.println();

            System.out.println("Using StrongTextEncryptor for Decryption");
            String encryptedPassword4 = "UjiYBCjo9lzWG4XM2cDy7dmjNdYBOoyl";
            System.out.println("Encrypted Value : " + encryptedPassword4);
            StrongTextEncryptor decryptor4 = new StrongTextEncryptor();
            decryptor4.setPassword(mpCryptoPassword);
            String decryptedPassword4 = decryptor4.decrypt(encryptedPassword4);
            System.out.println("Decrypted Value : " + decryptedPassword4);
            System.out.println();

            System.out.println("Using StandardPBEStringEncryptor for Decryption using PBEWithHMACSHA512AndAES_256");
            String encryptedPassword5 = "D3ujrRy/c+kvfmkS9D4+bSIxHG1SiGgv0LTRs7tBbKfQq/+YeZSHvHaJVc4BTZ47";
            System.out.println("Encrypted Value : " + encryptedPassword5);
            StandardPBEStringEncryptor decryptor5 = new StandardPBEStringEncryptor();
            decryptor5.setPassword(mpCryptoPassword);
            decryptor5.setAlgorithm("PBEWithHMACSHA512AndAES_256");
            decryptor5.setIvGenerator(new RandomIvGenerator());
            String decryptedPassword5 = decryptor5.decrypt(encryptedPassword5);
            System.out.println("Decrypted Value : " + decryptedPassword5);
            System.out.println();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}