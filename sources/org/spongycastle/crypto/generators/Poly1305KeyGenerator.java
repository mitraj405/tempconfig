package org.spongycastle.crypto.generators;

import com.google.common.base.Ascii;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;

public class Poly1305KeyGenerator extends CipherKeyGenerator {
    public final byte[] a() {
        byte[] a = super.a();
        if (a.length == 32) {
            a[3] = (byte) (a[3] & Ascii.SI);
            a[7] = (byte) (a[7] & Ascii.SI);
            a[11] = (byte) (a[11] & Ascii.SI);
            a[15] = (byte) (a[15] & Ascii.SI);
            a[4] = (byte) (a[4] & -4);
            a[8] = (byte) (a[8] & -4);
            a[12] = (byte) (a[12] & -4);
            return a;
        }
        throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
    }

    public final void b(KeyGenerationParameters keyGenerationParameters) {
        super.b(new KeyGenerationParameters(256, keyGenerationParameters.a));
    }
}
