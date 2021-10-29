package com.yash.foodie.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//import java.security.spec.KeySpec;
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESedeKeySpec;
//import org.apache.commons.codec.binary.Base64;
import org.jasypt.util.text.AES256TextEncryptor;

public class TrippleDes {

//    private static final String UNICODE_FORMAT = "UTF8";
//    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
//    private KeySpec ks;
//    private SecretKeyFactory skf;
//    private Cipher cipher;
//    byte[] arrayBytes;
//    private String myEncryptionKey;
//    private String myEncryptionScheme;
//    SecretKey key;
//
//    public TrippleDes() throws Exception {
//        myEncryptionKey = "ThisIsSpartaThisIsSparta";
//        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
//        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
//        ks = new DESedeKeySpec(arrayBytes);
//        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
//        cipher = Cipher.getInstance(myEncryptionScheme);
//        key = skf.generateSecret(ks);
//    }
//
//
//    public String encrypt(String unencryptedString) {
//        String encryptedString = null;
//        try {
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
//            byte[] encryptedText = cipher.doFinal(plainText);
//            encryptedString = new String(Base64.encodeBase64(encryptedText));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encryptedString;
//    }
//
//
//    public String decrypt(String encryptedString) {
//        String decryptedText=null;
//        try {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] encryptedText = Base64.decodeBase64(encryptedString);
//            byte[] plainText = cipher.doFinal(encryptedText);
//            decryptedText= new String(plainText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptedText;
//    }
	private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
//	public String EncryptPassword(String password)
//	{   
//	    AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
//	    aesEncryptor.setPassword("mypassword");
//	    String myEncryptedPassword = aesEncryptor.encrypt(password);
//	    System.out.println(myEncryptedPassword );  
//	    
//	    return myEncryptedPassword;
//	}
//	public String DecryptPassword(String passwordFromConfigFile)
//	{           
//	    AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
//	    aesEncryptor.setPassword("mypassword");
//	    String decryptedPassword = aesEncryptor.decrypt(passwordFromConfigFile);
//	    System.out.println(decryptedPassword);
//	    return decryptedPassword;   
//	}

    public static void main(String args []) throws Exception
    {
        TrippleDes td= new TrippleDes();
        
        String en = td.encrypt("Abdeali","asd");
        System.out.println(en);
        String de = td.decrypt(en, "asd");
        System.out.println(de);

//        String target="imparator";
//        String encrypted=td.encrypt(target);
//        String decrypted=td.decrypt(encrypted);
//        System.out.println(td.decrypt("AwKZ1gc4j4lPrxuY5adavxhAjAcjVoinbjicOrMXYHg="));

//        System.out.println("String To Encrypt: "+ target);
//        System.out.println("Encrypted String:" + encrypted);
//        System.out.println("Decrypted String:" + decrypted);

    }

}
