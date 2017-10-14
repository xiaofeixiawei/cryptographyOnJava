package me.taichangwei.common;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Provider;
import java.security.Security;

public class ProviderManager {
    public static void addThirdPartyProvider(Provider provider){
        provider = provider != null ? provider : new BouncyCastleProvider(); //如果不传参，默认添加BouncyCastle第三方提供者
        Security.addProvider(provider);
    }

}
