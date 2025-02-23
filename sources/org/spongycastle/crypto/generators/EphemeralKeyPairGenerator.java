package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyEncoder;

public class EphemeralKeyPairGenerator {
    public final AsymmetricCipherKeyPairGenerator a;

    /* renamed from: a  reason: collision with other field name */
    public final KeyEncoder f6083a;

    public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator asymmetricCipherKeyPairGenerator, KeyEncoder keyEncoder) {
        this.a = asymmetricCipherKeyPairGenerator;
        this.f6083a = keyEncoder;
    }
}
