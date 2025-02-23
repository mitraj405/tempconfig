package org.spongycastle.crypto.prng;

import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA1Digest;

public class DigestRandomGenerator implements RandomGenerator {
    public long a = 1;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6238a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6239a = new byte[20];
    public long b = 1;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6240b = new byte[20];

    public DigestRandomGenerator(SHA1Digest sHA1Digest) {
        this.f6238a = sHA1Digest;
    }

    public final void a(byte[] bArr) {
        synchronized (this) {
            this.f6238a.update(bArr, 0, bArr.length);
            byte[] bArr2 = this.f6240b;
            this.f6238a.update(bArr2, 0, bArr2.length);
            this.f6238a.c(0, this.f6240b);
        }
    }

    public final void b() {
        Digest digest;
        long j = this.a;
        this.a = j + 1;
        int i = 0;
        while (true) {
            digest = this.f6238a;
            if (i == 8) {
                break;
            }
            digest.d((byte) ((int) j));
            j >>>= 8;
            i++;
        }
        byte[] bArr = this.f6239a;
        digest.update(bArr, 0, bArr.length);
        byte[] bArr2 = this.f6240b;
        digest.update(bArr2, 0, bArr2.length);
        digest.c(0, bArr);
        if (this.a % 10 == 0) {
            digest.update(bArr2, 0, bArr2.length);
            long j2 = this.b;
            this.b = 1 + j2;
            for (int i2 = 0; i2 != 8; i2++) {
                digest.d((byte) ((int) j2));
                j2 >>>= 8;
            }
            digest.c(0, bArr2);
        }
    }

    public final void c(byte[] bArr, int i) {
        synchronized (this) {
            b();
            int i2 = i + 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 != i2) {
                if (i4 == this.f6239a.length) {
                    b();
                    i4 = 0;
                }
                bArr[i3] = this.f6239a[i4];
                i3++;
                i4++;
            }
        }
    }
}
