package me.taichangwei.base64.JDKDefault;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * JDK提供的默认Base64编码工具
 * Created by taichangwei on 2017/7/25.
 */
public class Base64Utils {

    public static String base64Encode(String src){
       BASE64Encoder encoder = new BASE64Encoder();
       return encoder.encode(src.getBytes());
    }

    public static String base64Decode(String encodedStr){
        BASE64Decoder decoder =  new BASE64Decoder();
        try {
            return  new String(decoder.decodeBuffer(encodedStr));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
