package me.taichangwei.base64.commonsCodec;

import org.apache.commons.codec.binary.Base64;

/**
 * commons-codec提供的Base64编码工具
 * Created by taichangwei on 2017/8/6.
 */
public class Base64Utils {

    public static String base64Encode(String src) {
        //第一种方式，返回编码后的字节数组
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        return new String(encodeBytes);

        //第二种方式，直接返回编码后的字符串
//        return Base64.encodeBase64String(src.getBytes());
    }

    public static String base64Decode(String encodedStr){
        //第一种方式，传入编码后的字节数组
        byte[] decodedBytes = Base64.decodeBase64(encodedStr.getBytes());
        return new String(decodedBytes);

    }
}
