package org.spongycastle.jcajce.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;

public class NamedJcaJceHelper implements JcaJceHelper {
    public final Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return Signature.getInstance(str, (String) null);
    }
}
