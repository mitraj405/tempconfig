package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;

public class PBKDF1KeyWithParameters extends PBKDF1Key implements PBEKey {
    public final int getIterationCount() {
        return 0;
    }

    public final byte[] getSalt() {
        return null;
    }
}
