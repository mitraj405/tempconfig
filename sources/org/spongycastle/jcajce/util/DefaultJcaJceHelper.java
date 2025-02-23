package org.spongycastle.jcajce.util;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class DefaultJcaJceHelper implements JcaJceHelper {
    public final Signature a(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str);
    }
}
