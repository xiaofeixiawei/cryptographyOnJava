package me.taichangwei.messageDigest.commonsCodec;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Commons Codec提供的消息摘要工具。Commons Codec同样没有提供MD4、SHA224算法，只是对JDK进行了封装，简化操作。
 * Created by taichangwei on 2017/8/8.
 */
public class MDUtils {

    public static String getMD2(String src){
        return DigestUtils.md2Hex(src).toUpperCase();
    }

    public static String getMD5(String src){
       return DigestUtils.md5Hex(src).toUpperCase();
    }

    public static String getSHA1(String src){
        return DigestUtils.sha1Hex(src).toUpperCase();
    }

    public static String getSHA256(String src){
        return DigestUtils.sha256Hex(src).toUpperCase();
    }

    public static String getSHA384(String src){
        return DigestUtils.sha384Hex(src).toUpperCase();
    }

    public static String getSHA512(String src){
        return DigestUtils.sha512Hex(src).toUpperCase();
    }

}
