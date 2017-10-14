package me.taichangwei.base64.bouncyCastle;

import org.bouncycastle.util.encoders.Base64;

/**
 * bouncy-castle提供的base64编码工具
 * Created by taichangwei on 2017/8/6.
 */
public class Base64Utils {

    public static String base64Encode(String src) {
        byte[] encodedStr = Base64.encode(src.getBytes());
        return new String(encodedStr);
    }

    public static String base64Decode(String encodedStr){
       //byte[] decodedStr =  Base64.decode(encodedStr.getBytes());
       byte[] decodedStr =  Base64.decode(encodedStr);
       return new String(decodedStr);
    }

}
