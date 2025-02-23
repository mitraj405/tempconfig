package org.spongycastle.crypto.tls;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

public class ByteQueue {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6303a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6304a = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
    public int b = 0;

    public final void a(int i, byte[] bArr, int i2) {
        if (!this.f6303a) {
            int i3 = this.a;
            int i4 = this.b;
            int i5 = i3 + i4 + i2;
            byte[] bArr2 = this.f6304a;
            if (i5 > bArr2.length) {
                int i6 = i4 + i2;
                int i7 = i6 | (i6 >> 1);
                int i8 = i7 | (i7 >> 2);
                int i9 = i8 | (i8 >> 4);
                int i10 = i9 | (i9 >> 8);
                int i11 = (i10 | (i10 >> 16)) + 1;
                if (i11 > bArr2.length) {
                    byte[] bArr3 = new byte[i11];
                    System.arraycopy(bArr2, i3, bArr3, 0, i4);
                    this.f6304a = bArr3;
                } else {
                    System.arraycopy(bArr2, i3, bArr2, 0, i4);
                }
                this.a = 0;
            }
            System.arraycopy(bArr, i, this.f6304a, this.a + this.b, i2);
            this.b += i2;
            return;
        }
        throw new IllegalStateException("Cannot add data to read-only buffer");
    }

    public final void b(int i, int i2, byte[] bArr) {
        if (bArr.length - i < i2) {
            throw new IllegalArgumentException("Buffer size of " + bArr.length + " is too small for a read of " + i2 + " bytes");
        } else if (this.b + 0 >= i2) {
            System.arraycopy(this.f6304a, this.a + 0, bArr, i, i2);
        } else {
            throw new IllegalStateException("Not enough data to read");
        }
    }

    public final void c(int i) {
        int i2 = this.b;
        if (i <= i2) {
            this.b = i2 - i;
            this.a += i;
            return;
        }
        StringBuilder m = lf.m("Cannot remove ", i, " bytes, only got ");
        m.append(this.b);
        throw new IllegalStateException(m.toString());
    }
}
