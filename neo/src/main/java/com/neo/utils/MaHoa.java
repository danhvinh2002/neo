package com.neo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MaHoa {
    public static String toSHA1(String str){
        String salt = "123456789";
        String result = null;

        str = str + salt;
        try{
            byte[] bytesOfMessage = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.getEncoder().encodeToString(md.digest(bytesOfMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(toSHA1("123456"));
    }
}
