package me.taichangwei.base64;

import me.taichangwei.base64.JDKDefault.Base64Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by taichangwei on 2017/7/25.
 */
public class Base64UtilsTest {

    private String src;

    @Before
    public void init() {
        src = "Hello, Word!";
        System.out.println("=========源字符串字符：" + src);
    }

    @Test
    public void base64OnJDK() {
        String encodedStr = Base64Utils.base64Encode(src);
        String decodedStr = Base64Utils.base64Decode(encodedStr);

        System.out.println("JDK编码字符串：" + encodedStr);
        System.out.println("JDK解码字符串：" + decodedStr);

        Assert.assertEquals(src, decodedStr);
    }

    @Test
    public void base64OnCC() {
        String encodedStr = me.taichangwei.base64.commonsCodec.Base64Utils.base64Encode(src);
        String decodedStr = me.taichangwei.base64.commonsCodec.Base64Utils.base64Decode(encodedStr);

        System.out.println("CC编码字符串：" + encodedStr);
        System.out.println("CC解码字符串：" + decodedStr);

        Assert.assertEquals(src, decodedStr);
    }

    @Test
    public void baseOnBC(){
        String encodedStr = me.taichangwei.base64.bouncyCastle.Base64Utils.base64Encode(src);
        String decodedStr = me.taichangwei.base64.bouncyCastle.Base64Utils.base64Decode(encodedStr);

        System.out.println("BC编码字符串：" + encodedStr);
        System.out.println("BC解码字符串：" + decodedStr);

        Assert.assertEquals(src, decodedStr);
    }

}
