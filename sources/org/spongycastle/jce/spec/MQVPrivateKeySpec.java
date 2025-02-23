package org.spongycastle.jce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.jce.interfaces.MQVPrivateKey;

public class MQVPrivateKeySpec implements KeySpec, MQVPrivateKey {
    public final String getAlgorithm() {
        return "ECMQV";
    }

    public final byte[] getEncoded() {
        return null;
    }

    public final String getFormat() {
        return null;
    }

    public final void h() {
    }

    public final void r() {
    }

    public final void s() {
    }
}
