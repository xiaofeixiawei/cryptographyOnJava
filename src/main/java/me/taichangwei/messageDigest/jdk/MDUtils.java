package me.taichangwei.messageDigest.jdk;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import me.taichangwei.common.ProviderManager;
import me.taichangwei.constant.AlgorithmConstant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * JDK提供的消息摘要工具。JDK只包含了MD2、MD5、SHA1、SHA256、SHA384、SHA512算法的实现，MD4、SHA224算法由Bouncy Castle扩展提供.
 * Created by taichangwei on 2017/8/8.
 */
public class MDUtils {

    private static String getMD(String src, String algorithm) {
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
        return getMD(src, AlgorithmConstant.DIGEST_MD2);
    }

    //动态加载第三方提供者，来实现MD4算法
    public static String getMD4(String src, Provider provider) {
        ProviderManager.addThirdPartyProvider(provider);
        return getMD(src, AlgorithmConstant.DIGEST_MD4_BC);
    }

    public static String getMD5(String src) {
        return getMD(src, AlgorithmConstant.DIGEST_MD5);
    }

    public static String getSHA1(String src) {
        return getMD(src, AlgorithmConstant.DIGEST_SHA1);
    }

    public static String getSHA224(String src, Provider provider) {
        ProviderManager.addThirdPartyProvider(provider); //TODO:这里测试发现，此算法如果不加载第三方提供者也行
        return getMD(src, AlgorithmConstant.DIGEST_SHA224_BC);
    }

    public static String getSHA256(String src) {
        return getMD(src, AlgorithmConstant.DIGEST_SHA256);
    }

    public static String getSHA384(String src) {
        return getMD(src, AlgorithmConstant.DIGEST_SHA384);
    }

    public static String getSHA512(String src) {
        return getMD(src, AlgorithmConstant.DIGEST_SHA512);
    }

}
