package org.spongycastle.crypto.digests;

import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f5842a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5843a;

    public GeneralDigest() {
        this.f5843a = new byte[4];
        this.a = 0;
    }

    public final void d(byte b) {
        int i = this.a;
        int i2 = i + 1;
        this.a = i2;
        byte[] bArr = this.f5843a;
        bArr[i] = b;
        if (i2 == bArr.length) {
            m(0, bArr);
            this.a = 0;
        }
        this.f5842a++;
    }

    public final int h() {
        return 64;
    }

    public final void i(GeneralDigest generalDigest) {
        byte[] bArr = generalDigest.f5843a;
        System.arraycopy(bArr, 0, this.f5843a, 0, bArr.length);
        this.a = generalDigest.a;
        this.f5842a = generalDigest.f5842a;
    }

    public final void j() {
        long j = this.f5842a << 3;
        d(UnsignedBytes.MAX_POWER_OF_TWO);
        while (this.a != 0) {
            d((byte) 0);
        }
        l(j);
        k();
    }

    public abstract void k();

    public abstract void l(long j);

    public abstract void m(int i, byte[] bArr);

    public void reset() {
        this.f5842a = 0;
        this.a = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f5843a;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public final void update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, i2);
        int i4 = this.a;
        byte[] bArr2 = this.f5843a;
        if (i4 != 0) {
            int i5 = 0;
            while (true) {
                if (i5 >= max) {
                    i3 = i5;
                    break;
                }
                int i6 = this.a;
                int i7 = i6 + 1;
                this.a = i7;
                int i8 = i5 + 1;
                bArr2[i6] = bArr[i5 + i];
                if (i7 == 4) {
                    m(0, bArr2);
                    this.a = 0;
                    i3 = i8;
                    break;
                }
                i5 = i8;
            }
        }
        int i9 = ((max - i3) & -4) + i3;
        while (i3 < i9) {
            m(i + i3, bArr);
            i3 += 4;
        }
        while (i3 < max) {
            int i10 = this.a;
            this.a = i10 + 1;
            bArr2[i10] = bArr[i3 + i];
            i3++;
        }
        this.f5842a += (long) max;
    }

    public GeneralDigest(GeneralDigest generalDigest) {
        this.f5843a = new byte[4];
        i(generalDigest);
    }
}
