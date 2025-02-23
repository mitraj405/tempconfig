package org.spongycastle.jce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.IESKey;

public class IEKeySpec implements KeySpec, IESKey {
    public final String getAlgorithm() {
        return "IES";
    }

    public final byte[] getEncoded() {
        return null;
    }

    public final String getFormat() {
        return null;
    }

    public final void N() {
    }

    public final void q() {
    }
}
