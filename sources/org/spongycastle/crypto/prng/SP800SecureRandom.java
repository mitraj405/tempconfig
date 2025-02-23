package org.spongycastle.crypto.prng;

import java.security.SecureRandom;
import org.spongycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandom extends SecureRandom {
    public final SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public final DRBGProvider f6241a;

    /* renamed from: a  reason: collision with other field name */
    public final EntropySource f6242a;

    /* renamed from: a  reason: collision with other field name */
    public SP80090DRBG f6243a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6244a;

    public SP800SecureRandom(SecureRandom secureRandom, EntropySource entropySource, DRBGProvider dRBGProvider, boolean z) {
        this.a = secureRandom;
        this.f6242a = entropySource;
        this.f6241a = dRBGProvider;
        this.f6244a = z;
    }

    public final void a() {
        synchronized (this) {
            if (this.f6243a == null) {
                this.f6243a = this.f6241a.a(this.f6242a);
            }
            this.f6243a.a();
        }
    }

    public final byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        int i2 = i * 8;
        EntropySource entropySource = this.f6242a;
        if (i2 <= entropySource.b()) {
            System.arraycopy(entropySource.a(), 0, bArr, 0, i);
        } else {
            int b = entropySource.b() / 8;
            for (int i3 = 0; i3 < i; i3 += b) {
                byte[] a2 = entropySource.a();
                int i4 = i - i3;
                if (a2.length <= i4) {
                    System.arraycopy(a2, 0, bArr, i3, a2.length);
                } else {
                    System.arraycopy(a2, 0, bArr, i3, i4);
                }
            }
        }
        return bArr;
    }

    public final void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.f6243a == null) {
                this.f6243a = this.f6241a.a(this.f6242a);
            }
            if (this.f6243a.b(bArr, this.f6244a) < 0) {
                this.f6243a.a();
                this.f6243a.b(bArr, this.f6244a);
            }
        }
    }

    public final void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.a;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }

    public final void setSeed(long j) {
        synchronized (this) {
            SecureRandom secureRandom = this.a;
            if (secureRandom != null) {
                secureRandom.setSeed(j);
            }
        }
    }
}
