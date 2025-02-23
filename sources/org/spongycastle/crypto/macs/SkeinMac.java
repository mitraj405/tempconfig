package org.spongycastle.crypto.macs;

import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.digests.SkeinEngine;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.SkeinParameters;

public class SkeinMac implements Mac {
    public final SkeinEngine a;

    public SkeinMac(int i, int i2) {
        this.a = new SkeinEngine(i, i2);
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        SkeinParameters skeinParameters;
        if (cipherParameters instanceof SkeinParameters) {
            skeinParameters = (SkeinParameters) cipherParameters;
        } else if (cipherParameters instanceof KeyParameter) {
            SkeinParameters.Builder builder = new SkeinParameters.Builder();
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            if (bArr != null) {
                Hashtable hashtable = builder.a;
                hashtable.put(0, bArr);
                skeinParameters = new SkeinParameters(hashtable);
            } else {
                throw new IllegalArgumentException("Parameter value must not be null.");
            }
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters, "Invalid parameter passed to Skein MAC init - "));
        }
        if (((byte[]) skeinParameters.a.get(0)) != null) {
            this.a.d(skeinParameters);
            return;
        }
        throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    }

    public final String b() {
        StringBuilder sb = new StringBuilder("Skein-MAC-");
        SkeinEngine skeinEngine = this.a;
        sb.append(skeinEngine.f5861a.f6057a * 8);
        sb.append("-");
        sb.append(skeinEngine.f5859a * 8);
        return sb.toString();
    }

    public final int c(int i, byte[] bArr) {
        return this.a.c(0, bArr);
    }

    public final void d(byte b) {
        SkeinEngine skeinEngine = this.a;
        byte[] bArr = skeinEngine.b;
        bArr[0] = b;
        skeinEngine.j(bArr, 0, 1);
    }

    public final int e() {
        return this.a.f5859a;
    }

    public final void reset() {
        SkeinEngine skeinEngine = this.a;
        long[] jArr = skeinEngine.f5865b;
        long[] jArr2 = skeinEngine.f5863a;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        skeinEngine.i(48);
    }

    public final void update(byte[] bArr, int i, int i2) {
        this.a.j(bArr, i, i2);
    }
}
