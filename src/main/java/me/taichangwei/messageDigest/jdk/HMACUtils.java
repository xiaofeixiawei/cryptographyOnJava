package me.taichangwei.messageDigest.jdk;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import me.taichangwei.common.ProviderManager;
import me.taichangwei.constant.AlgorithmConstant;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Provider;

/**
 * JDK默认没有提供HmacMD2、HmacMD4、HmacSHA224算法，需要加载第三方提供者
 */
public class HMACUtils {


    private static String getHmac(byte[] key, String src, String algorithm){
        try {
            SecretKey restoreSecretKey = new SecretKeySpec(key, algorithm);//还原密钥
            Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
            mac.init(restoreSecretKey);
            byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());

            return HexBin.encode(hmacMD5Bytes).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHmacMD2(byte[] key, String src, Provider provider){
        ProviderManager.addThirdPartyProvider(provider);
        return getHmac(key, src, AlgorithmConstant.MAC_MD2_BC);
    }

    public static String getHmacMD4(byte[] key, String src, Provider provider){
        ProviderManager.addThirdPartyProvider(provider);
        return getHmac(key, src, AlgorithmConstant.MAC_MD4_BC);
    }

    public static String getHmacMD5(byte[] key, String src){
        return getHmac(key,src,AlgorithmConstant.MAC_MD5);
    }

    public static String getHmacSHA1(byte[] key, String src){
        return getHmac(key, src, AlgorithmConstant.MAC_SHA1);
    }

    public static String getHmacSHA224(byte[] key, String src, Provider provider){
        ProviderManager.addThirdPartyProvider(provider);
        return getHmac(key, src, AlgorithmConstant.MAC_SHA224_BC);
    }

    public static String getHmacSHA256(byte[] key, String src){
        return getHmac(key, src, AlgorithmConstant.MAC_SHA256);
    }

    public static String getHmacSHA384(byte[] key, String src){
        return getHmac(key, src, AlgorithmConstant.MAC_SHA384);
    }

    public static String getHmacSHA512(byte[] key, String src){
        return getHmac(key, src, AlgorithmConstant.MAC_SHA512);
    }

}
