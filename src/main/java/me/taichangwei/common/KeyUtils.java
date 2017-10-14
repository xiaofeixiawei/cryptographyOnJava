package me.taichangwei.common;

import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class KeyUtils {

    /**
     * 初始化密钥
     * @return 返回一个Base64编码的密钥，实际应用中会将此密钥保存在项目的某个地方
     */
    public static String initSecretKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] key = secretKey.getEncoded(); //获取密钥，为字节数组的形式
            return new BASE64Encoder().encode(key); //对密钥进行base64编码方便传输
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
