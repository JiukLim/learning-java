package com.example.demo.util;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;

// iv를 random하게 생성하여 암호문에 붙여주어 동일한 단어여도 다른 암호문이 나옴.
public class AES256CryptV2Util {

    private static final String key = "myaeskeymyaeskeym";
    private Key keySpec;

    public AES256CryptV2Util() throws UnsupportedEncodingException {
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        this.keySpec = keySpec;
    }

//    public String encrypt(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
//            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        SecureRandom random = new SecureRandom();
//        byte[] bytes = new byte[20];
//        random.nextBytes(bytes);
//        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
//        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
//        String encStr = new String(Base64.encodeBase64(encrypted));
//        return encStr;
//    }
//
//    public String decrypt(String encStr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
//            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
//        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
//        byte[] byteStr = Base64.decodeBase64(encStr.getBytes());
//        return new String(c.doFinal(byteStr), "UTF-8");
//    }
}
