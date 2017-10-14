package me.taichangwei.messageDigest;

import me.taichangwei.base64.JDKDefault.Base64Utils;
import me.taichangwei.common.KeyUtils;
import me.taichangwei.messageDigest.jdk.HMACUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HMACUtilsTest {

    private static byte[] key;
    private static String src;

    @BeforeClass
    public static void init() {
        String keyStr =KeyUtils.initSecretKey(); //得到base64编码的密钥
        key = Base64Utils.base64Decode(keyStr).getBytes();
        src = "Hello, Word!";
        System.out.println("=========源字符串字符：" + src + "===========");
        System.out.println("=========密钥" + keyStr);
    }

    @Test
    public void getHmacOnJDK(){
        String hmacMD2 = HMACUtils.getHmacMD2(key, src, null);
        String hmacMD4 = HMACUtils.getHmacMD4(key, src, null);
        String hmacMD5 = HMACUtils.getHmacMD5(key, src);
        String hmacSHA1 = HMACUtils.getHmacSHA1(key, src);
        String hmacSHA224 = HMACUtils.getHmacSHA224(key, src, null);
        String hmacSHA256 = HMACUtils.getHmacSHA256(key,src);
        String hmacSHA384 = HMACUtils.getHmacSHA384(key, src);
        String hmacSHA512 = HMACUtils.getHmacSHA512(key, src);

        System.out.println("JDK_HmacMD2加密字符串：" + hmacMD2);
        System.out.println("JDK_HmacMD4加密字符串：" + hmacMD4);
        System.out.println("JDK_HmacMD5加密字符串：" + hmacMD5);
        System.out.println("JDK_HmacSHA1加密字符串：" + hmacSHA1);
        System.out.println("JDK_HmacSHA224加密字符串：" + hmacSHA224);
        System.out.println("JDK_HmacSHA256加密字符串：" + hmacSHA256);
        System.out.println("JDK_HmacSHA384加密字符串：" + hmacSHA384);
        System.out.println("JDK_HmacSHA512加密字符串：" + hmacSHA512);

        Assert.assertNotNull(hmacMD2);
        Assert.assertNotNull(hmacMD4);
        Assert.assertNotNull(hmacMD5);
        Assert.assertNotNull(hmacSHA1);
        Assert.assertNotNull(hmacSHA224);
        Assert.assertNotNull(hmacSHA256);
        Assert.assertNotNull(hmacSHA384);
        Assert.assertNotNull(hmacSHA512);
    }

    @Test
    public void getHmacOnBC(){
        String hmacMD2 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacMD2(key, src);
        String hmacMD4 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacMD4(key, src);
        String hmacMD5 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacMD5(key, src);

        String hmacSHA1 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacSHA1(key, src);
        String hmacSHA224 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacSHA224(key, src);
        String hmacSHA256 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacSHA256(key,src);
        String hmacSHA384 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacSHA384(key, src);
        String hmacSHA512 = me.taichangwei.messageDigest.bouncyCastle.HMACUtils.getHmacSHA512(key, src);

        System.out.println("BC_HmacMD2加密字符串" + hmacMD2);
        System.out.println("BC_HmacMD4加密字符串" + hmacMD4);
        System.out.println("BC_HmacMD5加密字符串" + hmacMD5);
        System.out.println("BC_HmacSHA1加密字符串：" + hmacSHA1);
        System.out.println("BC_HmacSHA224加密字符串：" + hmacSHA224);
        System.out.println("BC_HmacSHA256加密字符串：" + hmacSHA256);
        System.out.println("BC_HmacSHA384加密字符串：" + hmacSHA384);
        System.out.println("BC_HmacSHA512加密字符串：" + hmacSHA512);

        Assert.assertNotNull(hmacMD2);
        Assert.assertNotNull(hmacMD4);
        Assert.assertNotNull(hmacMD5);
        Assert.assertNotNull(hmacSHA1);
        Assert.assertNotNull(hmacSHA224);
        Assert.assertNotNull(hmacSHA256);
        Assert.assertNotNull(hmacSHA384);
        Assert.assertNotNull(hmacSHA512);
    }
}
