package com.example.demo.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AES256CryptUtil {
    // TODO: 이건 아무 글자나 16자 이상 입력하면 되는 것인지...
    private static final String key = "myaeskeymyaeskeym";
    private String iv;
    private Key keySpec;

    public AES256CryptUtil() throws UnsupportedEncodingException {
        this.iv = key.substring(0, 16); // 16자... substring은 시작인덱스 ~ 종료인덱스-1까지의 데이터를 스트링을 추출..
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

    public String encrypt(String str) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String encStr = new String(Base64.encodeBase64(encrypted));
        return encStr;
    }

    public String decrypt(String encStr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
        byte[] byteStr = Base64.decodeBase64(encStr.getBytes());
        return new String(c.doFinal(byteStr), "UTF-8");
    }
}
