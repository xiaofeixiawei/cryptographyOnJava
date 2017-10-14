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
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

public class HMACUtils {

    private static String getHmac(byte[] key, String src, Digest digest){
        HMac hMac = new HMac(digest);
        byte[] hMacBytes = new byte[hMac.getMacSize()];

        hMac.init(new KeyParameter(key));
        hMac.update(src.getBytes(),0, src.getBytes().length);
        hMac.doFinal(hMacBytes, 0);

        return Hex.toHexString(hMacBytes).toUpperCase();
    }



    public static String getHmacMD2(byte[] key, String src){
        return getHmac(key, src, new MD2Digest());
    }

    public static String getHmacMD4(byte[] key, String src){
        return getHmac(key, src, new MD4Digest());
    }

    public static String getHmacMD5(byte[] key, String src){
        return getHmac(key, src, new MD5Digest());
    }

    public static String getHmacSHA1(byte[] key, String src){
        return getHmac(key, src, new SHA1Digest());
    }

    public static String getHmacSHA224(byte[] key, String src){
        return getHmac(key, src, new SHA224Digest());
    }

    public static String getHmacSHA256(byte[] key, String src){
        return getHmac(key, src, new SHA256Digest());
    }

    public static String getHmacSHA384(byte[] key, String src){
        return getHmac(key, src, new SHA384Digest());
    }

    public static String getHmacSHA512(byte[] key, String src){
        return getHmac(key, src, new SHA512Digest());
    }

}
