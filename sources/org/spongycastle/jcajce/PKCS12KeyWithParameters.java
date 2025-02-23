package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;

public class PKCS12KeyWithParameters extends PKCS12Key implements PBEKey {
    public final int getIterationCount() {
        return 0;
    }

    public final byte[] getSalt() {
        return null;
    }
}
