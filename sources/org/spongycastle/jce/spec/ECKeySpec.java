package org.spongycastle.jce.spec;

import java.security.spec.KeySpec;

public class ECKeySpec implements KeySpec {
    public final ECParameterSpec a;

    public ECKeySpec(ECParameterSpec eCParameterSpec) {
        this.a = eCParameterSpec;
    }
}
