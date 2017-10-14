package me.taichangwei.messageDigest.jdk;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import me.taichangwei.common.ProviderManager;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

/**
 * JDK提供的消息摘要工具。JDK只包含了MD2、MD5、SHA1、SHA256、SHA384、SHA512算法的实现，MD4、SHA224算法由Bouncy Castle扩展提供.
 * Created by taichangwei on 2017/8/8.
 */
public class MDUtils {

    private static String getMD(String src, String algorithm){
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] mdBytes = md.digest(src.getBytes());
            return HexBin.encode(mdBytes); //把字节数组转为十六进制表示的字符串，HexBin由JDK提供
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getMD2(String src) {
        return getMD(src, "MD2");
    }

    //动态加载第三方提供者，来实现MD4算法
    public static String getMD4(String src, Provider provider) {
        ProviderManager.addThirdPartyProvider(provider);
        return getMD(src, "MD4");
    }

    public static String getMD5(String src) {
        return getMD(src, "MD5");
    }

    public static String getSHA1(String src){
        return getMD(src,"SHA-1");
    }

    public static String getSHA224(String src){
        return getMD(src,"SHA-224");
    }

    public static String getSHA256(String src){
        return getMD(src,"SHA-256");
    }

    public static String getSHA384(String src){
        return getMD(src,"SHA-384");
    }
    public static String getSHA512(String src){
        return getMD(src,"SHA-512");
    }

}
