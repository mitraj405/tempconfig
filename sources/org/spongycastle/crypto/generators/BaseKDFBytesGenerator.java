package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.ISO18033KDFParameters;
import org.spongycastle.crypto.params.KDFParameters;
import org.spongycastle.util.Pack;

public class BaseKDFBytesGenerator implements DigestDerivationFunction {
    public final int a = 1;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6072a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6073a;
    public byte[] b;

    public BaseKDFBytesGenerator(Digest digest) {
        this.f6072a = digest;
    }

    public final void a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.f6073a = kDFParameters.b;
            this.b = kDFParameters.a;
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            ISO18033KDFParameters iSO18033KDFParameters = (ISO18033KDFParameters) derivationParameters;
            this.f6073a = null;
            this.b = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i2 = i;
        if (bArr2.length - i2 >= 0) {
            long j = (long) i2;
            Digest digest = this.f6072a;
            int f = digest.f();
            if (j <= 8589934591L) {
                long j2 = (long) f;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr3 = new byte[digest.f()];
                byte[] bArr4 = new byte[4];
                int i4 = this.a;
                Pack.c(i4, bArr4, 0);
                int i5 = i4 & -256;
                int i6 = 0;
                int i7 = 0;
                while (i6 < i3) {
                    byte[] bArr5 = this.f6073a;
                    int i8 = i3;
                    digest.update(bArr5, 0, bArr5.length);
                    digest.update(bArr4, 0, 4);
                    byte[] bArr6 = this.b;
                    if (bArr6 != null) {
                        digest.update(bArr6, 0, bArr6.length);
                    }
                    digest.c(0, bArr3);
                    if (i2 > f) {
                        System.arraycopy(bArr3, 0, bArr2, i7, f);
                        i7 += f;
                        i2 -= f;
                    } else {
                        System.arraycopy(bArr3, 0, bArr2, i7, i2);
                    }
                    byte b2 = (byte) (bArr4[3] + 1);
                    bArr4[3] = b2;
                    if (b2 == 0) {
                        i5 += 256;
                        Pack.c(i5, bArr4, 0);
                    }
                    i6++;
                    i3 = i8;
                }
                digest.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }
}
