package me.taichangwei.messageDigest.bouncyCastle;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.util.encoders.Hex;

/**
 * Bouncy Castle提供的消息摘要工具。Bouncy Castle是在JDK基础上做了扩展，并实现了JDK未提供的MD4、SHA-224算法
 * Created by taichangwei on 2017/8/8.
 */
public class MDUtils {

    private static String getDigest(String src, Digest digest) {
        byte[] digestBytes = new byte[digest.getDigestSize()];//大小为本摘要算法的长度(bit)
        digest.update(src.getBytes(), 0, src.getBytes().length);
        digest.doFinal(digestBytes, 0); //从digestBytes的0位开始填充摘要内容
        return Hex.toHexString(digestBytes).toUpperCase(); //使用Bouncy Castle提供的Hex类把字节数组转为十六进制表示的字符串

    }

    //=======================MD相关======================
    public static String getMD2(String src) {
        return getDigest(src, new MD2Digest());
    }

    public static String getMD4(String src) {
        return getDigest(src, new MD4Digest());
    }

    public static String getMD5(String src) {
        return getDigest(src, new MD5Digest());
    }

    public static String getSHA1(String src) {
        return getDigest(src, new SHA1Digest());
    }

    public static String getSHA224(String src) {
        return getDigest(src, new SHA224Digest());
    }

    public static String getSHA256(String src) {
        return getDigest(src, new SHA256Digest());
    }

    public static String getSHA384(String src) {
        return getDigest(src, new SHA384Digest());
    }

    public static String getSHA512(String src) {
        return getDigest(src, new SHA512Digest());
    }


}
