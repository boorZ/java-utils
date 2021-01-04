package com.boor.javautils.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author zhou lin
 * @description Gzip
 * @create 2021-01-04 22:16
 */
public class GzipUtils {

    /**
     * 使用gzip压缩字符串
     *
     * @param str 要压缩的字符串
     * @return
     */
    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(gzip);
        }
        return new sun.misc.BASE64Encoder().encode(out.toByteArray());
    }

    /**
     * 使用gzip解压缩
     *
     * @param str 压缩字符串
     * @return
     */
    public static String uncompress(String str) {
        if (str == null) {
            return null;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed;
        String decompressed = null;
        try {
            compressed = new sun.misc.BASE64Decoder().decodeBuffer(str);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(ginzip, in, out);
        }
        return decompressed;
    }

    private static void close(GZIPInputStream ginzip, ByteArrayInputStream in, ByteArrayOutputStream out) {
        if (ginzip != null) {
            try {
                ginzip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close(GZIPOutputStream gzip) {
        if (gzip != null) {
            try {
                gzip.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String str = "123123dsfasdfasdfasdfADFasd*……&……*《》fdsafddsfasdfasdfasdfasdfdsafddsfasdfasdfasdfasdfdsafddsfasdfasdfasdfasdfdsafddsfasdfasdfasdfasdfdsafddsfasdfasdfasdfasdfdsafddsfasdfasdfasdfasdfdsafd";
        System.out.println("原文: " + str);
        String compress = compress(str);
        System.out.println("压缩: " + compress);
        System.out.println("压缩后长度: " + compress.length());
        String uncompress = uncompress(compress);
        System.out.println("解压缩: " + uncompress);
    }
}
