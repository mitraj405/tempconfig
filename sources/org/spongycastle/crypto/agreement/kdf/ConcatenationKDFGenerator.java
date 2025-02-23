package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KDFParameters;

public class ConcatenationKDFGenerator implements DerivationFunction {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f5804a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5805a;
    public byte[] b;

    public ConcatenationKDFGenerator(Digest digest) {
        this.f5804a = digest;
        this.a = digest.f();
    }

    public final void a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.f5805a = kDFParameters.b;
            this.b = kDFParameters.a;
            return;
        }
        throw new IllegalArgumentException("KDF parameters required for generator");
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        int i2;
        int i3;
        if (bArr.length - i >= 0) {
            int i4 = this.a;
            byte[] bArr2 = new byte[i4];
            byte[] bArr3 = new byte[4];
            Digest digest = this.f5804a;
            digest.reset();
            if (i > i4) {
                int i5 = 1;
                i3 = 0;
                while (true) {
                    bArr3[0] = (byte) (i5 >>> 24);
                    bArr3[1] = (byte) (i5 >>> 16);
                    bArr3[2] = (byte) (i5 >>> 8);
                    bArr3[3] = (byte) (i5 >>> 0);
                    digest.update(bArr3, 0, 4);
                    byte[] bArr4 = this.f5805a;
                    digest.update(bArr4, 0, bArr4.length);
                    byte[] bArr5 = this.b;
                    digest.update(bArr5, 0, bArr5.length);
                    digest.c(0, bArr2);
                    System.arraycopy(bArr2, 0, bArr, 0 + i3, i4);
                    i3 += i4;
                    i2 = i5 + 1;
                    if (i5 >= i / i4) {
                        break;
                    }
                    i5 = i2;
                }
            } else {
                i2 = 1;
                i3 = 0;
            }
            if (i3 < i) {
                bArr3[0] = (byte) (i2 >>> 24);
                bArr3[1] = (byte) (i2 >>> 16);
                bArr3[2] = (byte) (i2 >>> 8);
                bArr3[3] = (byte) (i2 >>> 0);
                digest.update(bArr3, 0, 4);
                byte[] bArr6 = this.f5805a;
                digest.update(bArr6, 0, bArr6.length);
                byte[] bArr7 = this.b;
                digest.update(bArr7, 0, bArr7.length);
                digest.c(0, bArr2);
                System.arraycopy(bArr2, 0, bArr, 0 + i3, i - i3);
            }
            return i;
        }
        throw new OutputLengthException("output buffer too small");
    }
}
