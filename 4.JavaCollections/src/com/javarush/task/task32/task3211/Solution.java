package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(byteArrayOutputStream.toByteArray());

        byte[] b = digest.digest();

        StringBuilder builder = new StringBuilder();
        for (byte bt:b)
            builder.append(String.format("%02x",bt));
        String md5Hex = builder.toString();
        System.out.println(md5Hex);

//        BigInteger tmp = new BigInteger(1, b);
//        String md5Hex = tmp.toString(16);
//        while (md5Hex.length() < 32)
//            md5Hex = "0" + md5Hex;
        return md5Hex.equals(md5);
    }
}
