package me.taichangwei.messageDigest;

import me.taichangwei.messageDigest.jdk.MDUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by taichangwei on 2017/8/8.
 */
public class MessageDigestUtilsTest {

    private String src;

    @Before
    public void init() {
        src = "Hello, Word!";
        System.out.println("=========源字符串字符：" + src);
    }

    @Test
    public void getMDOnJDK(){
        String md2Str = MDUtils.getMD2(src);
        System.out.println("JDK_MD2摘要字符串：" + md2Str);

        String md5Str = MDUtils.getMD5(src);
        System.out.println("JDK_MD5摘要字符串：" + md5Str);

        String sha1Str = MDUtils.getSHA1(src);
        System.out.println("JDK_SHA1摘要字符串：" + sha1Str);

        String sha256Str = MDUtils.getSHA256(src);
        System.out.println("JDK_SHA256摘要字符串：" + sha256Str);

        String sha384Str = MDUtils.getSHA384(src);
        System.out.println("JDK_SHA384摘要字符串：" + sha384Str);

        String sha512Str = MDUtils.getSHA512(src);
        System.out.println("JDK_SHA512摘要字符串：" + sha512Str);

        String md4Str = MDUtils.getMD4(src, null);
        System.out.println("JDK_MD4摘要字符串：" + md4Str);

        String sha224Str = MDUtils.getSHA224(src, null);
        System.out.println("JDK_SHA224摘要字符串：" + sha224Str);


        Assert.assertNotNull(md2Str);
        Assert.assertNotNull(md5Str);
        Assert.assertNotNull(sha1Str);
        Assert.assertNotNull(sha256Str);
        Assert.assertNotNull(sha384Str);
        Assert.assertNotNull(sha512Str);
        Assert.assertNotNull(md4Str);
        Assert.assertNotNull(sha224Str);
    }

    @Test
    public void getMDOnBC(){
        String md2Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getMD2(src);
        System.out.println("BC_MD2摘要字符串：" + md2Str);

        String md4Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getMD4(src);
        System.out.println("BC_MD4摘要字符串：" + md4Str);

        String md5Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getMD5(src);
        System.out.println("BC_MD5摘要字符串：" + md5Str);

        String sha1Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getSHA1(src);
        System.out.println("BC_SHA1摘要字符串：" + sha1Str);

        String sha224Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getSHA224(src);
        System.out.println("BC_SHA224摘要字符串：" + sha224Str);

        String sha256Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getSHA256(src);
        System.out.println("BC_SHA256摘要字符串：" + sha256Str);

        String sha384Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getSHA384(src);
        System.out.println("BC_SHA384摘要字符串：" + sha384Str);

        String sha512Str = me.taichangwei.messageDigest.bouncyCastle.MDUtils.getSHA512(src);
        System.out.println("BC_SHA512摘要字符串：" + sha512Str);

        Assert.assertNotNull(md2Str);
        Assert.assertNotNull(md4Str);
        Assert.assertNotNull(md5Str);
        Assert.assertNotNull(sha1Str);
        Assert.assertNotNull(sha224Str);
        Assert.assertNotNull(sha256Str);
        Assert.assertNotNull(sha384Str);
        Assert.assertNotNull(sha512Str);
    }

    @Test
    public void getMDOnCC(){
        String md2Str = me.taichangwei.messageDigest.commonsCodec.MDUtils.getMD2(src);
        System.out.println("CC_MD2摘要字符串：" + md2Str);

        String md5Str = me.taichangwei.messageDigest.commonsCodec.MDUtils.getMD5(src);
        System.out.println("CC_MD5摘要字符串：" + md5Str);

        String sha1Str = me.taichangwei.messageDigest.commonsCodec.MDUtils.getSHA1(src);
        System.out.println("CC_SHA1摘要字符串：" + sha1Str);

        String sha256Str = me.taichangwei.messageDigest.commonsCodec.MDUtils.getSHA256(src);
        System.out.println("CC_SHA256摘要字符串：" + sha256Str);

        String sha384Str = me.taichangwei.messageDigest.commonsCodec.MDUtils.getSHA384(src);
        System.out.println("CC_SHA384摘要字符串：" + sha384Str);

        String sha512Str = me.taichangwei.messageDigest.commonsCodec.MDUtils.getSHA512(src);
        System.out.println("CC_SHA512摘要字符串：" + sha512Str);


        Assert.assertNotNull(md2Str);
        Assert.assertNotNull(md5Str);
        Assert.assertNotNull(sha1Str);
        Assert.assertNotNull(sha256Str);
        Assert.assertNotNull(sha384Str);
        Assert.assertNotNull(sha512Str);
    }

}
