package org.spongycastle.jcajce.util;

import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;

public class ProviderJcaJceHelper implements JcaJceHelper {
    public final Provider a;

    public ProviderJcaJceHelper(Provider provider) {
        this.a = provider;
    }

    public final Signature a(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str, this.a);
    }

    public final AlgorithmParameters b(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str, this.a);
    }

    public final KeyFactory c(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str, this.a);
    }
}
