package com.boor.javautils.utils;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 描述
 *
 * @author 周林
 * @version 1.0
 * @date 2021/1/5 16:23
 */
public class Base64Utils {
    /**
     * 使用Base64压缩字符串
     * @param str 要压缩的字符串
     * @return
     */
    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return Base64.encodeBase64String(str.getBytes());
    }

    /**
     * 使用Base64解压缩
     * @param compressedStr 压缩字符串
     * @return
     */
    public static String uncompress(String compressedStr) {
        if (compressedStr == null) {
            return null;
        }
        byte[] bytes = Base64.decodeBase64(compressedStr);
        return null;
    }
}
