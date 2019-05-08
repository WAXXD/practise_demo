package com.waxxd.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * description:
 *          生成hash
 * @author waxxd
 * @date 2019-05-08 15:16
 **/
public class MD5Hash {

    /**
     * 根据提供的value值生成byte数组，采用md5加密
     * @param value
     * @return
     * @author waxxd
     **/
    public static byte[] md5(String value) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.reset();
        byte[] bytes;
        try {
            bytes = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
        md5.update(bytes);
        return md5.digest();
    }

    /**
     * 获取hash值，根据md5()方法生成的byte数组
     * @param digest md5加密生成的byte数组
     * @param number
     * @return
     * @author waxxd
     **/
    public static long getHash(byte[] digest, int number) {
        return (((long) (digest[3 + number * 4] & 0xFF) << 24)
                | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                | (digest[0 + number * 4] & 0xFF))
                & 0xFFFFFFFFL;
    }

}
