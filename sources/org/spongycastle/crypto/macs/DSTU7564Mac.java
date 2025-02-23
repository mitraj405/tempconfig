package org.spongycastle.crypto.macs;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.digests.DSTU7564Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Pack;

public class DSTU7564Mac implements Mac {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public long f6100a;

    /* renamed from: a  reason: collision with other field name */
    public final DSTU7564Digest f6101a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6102a = null;
    public byte[] b = null;

    public DSTU7564Mac(int i) {
        this.f6101a = new DSTU7564Digest(i);
        this.a = i / 8;
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArr = ((KeyParameter) cipherParameters).a;
            this.b = new byte[bArr.length];
            int length = bArr.length;
            DSTU7564Digest dSTU7564Digest = this.f6101a;
            int i = dSTU7564Digest.b;
            int i2 = (((length + i) - 1) / i) * i;
            if (i - (bArr.length % i) < 13) {
                i2 += i;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[bArr.length] = UnsignedBytes.MAX_POWER_OF_TWO;
            Pack.e(bArr.length * 8, bArr2, i2 - 12);
            this.f6102a = bArr2;
            int i3 = 0;
            while (true) {
                byte[] bArr3 = this.b;
                if (i3 < bArr3.length) {
                    bArr3[i3] = (byte) (~bArr[i3]);
                    i3++;
                } else {
                    byte[] bArr4 = this.f6102a;
                    dSTU7564Digest.update(bArr4, 0, bArr4.length);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Bad parameter passed");
        }
    }

    public final String b() {
        return "DSTU7564Mac";
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        if (this.f6102a == null) {
            throw new IllegalStateException("DSTU7564Mac not initialised");
        } else if (bArr.length - 0 >= this.a) {
            DSTU7564Digest dSTU7564Digest = this.f6101a;
            int i2 = dSTU7564Digest.b;
            long j = this.f6100a;
            int i3 = i2 - ((int) (j % ((long) i2)));
            if (i3 < 13) {
                i3 += i2;
            }
            byte[] bArr2 = new byte[i3];
            bArr2[0] = UnsignedBytes.MAX_POWER_OF_TWO;
            Pack.l(j * 8, bArr2, i3 - 12);
            dSTU7564Digest.update(bArr2, 0, i3);
            byte[] bArr3 = this.b;
            dSTU7564Digest.update(bArr3, 0, bArr3.length);
            this.f6100a = 0;
            return dSTU7564Digest.c(0, bArr);
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public final void d(byte b2) throws IllegalStateException {
        this.f6101a.d(b2);
        this.f6100a++;
    }

    public final int e() {
        return this.a;
    }

    public final void reset() {
        this.f6100a = 0;
        DSTU7564Digest dSTU7564Digest = this.f6101a;
        dSTU7564Digest.reset();
        byte[] bArr = this.f6102a;
        if (bArr != null) {
            dSTU7564Digest.update(bArr, 0, bArr.length);
        }
    }

    public final void update(byte[] bArr, int i, int i2) throws DataLengthException, IllegalStateException {
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        } else if (this.f6102a != null) {
            this.f6101a.update(bArr, i, i2);
            this.f6100a += (long) i2;
        } else {
            throw new IllegalStateException("DSTU7564Mac not initialised");
        }
    }
}
