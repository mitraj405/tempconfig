package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Buffer;
import okio.ByteString;

/* renamed from: Rv  reason: default package */
/* compiled from: SegmentedByteString */
public final class Rv extends ByteString {
    public final transient int[] a;

    /* renamed from: a  reason: collision with other field name */
    public final transient byte[][] f3785a;

    public Rv(Buffer buffer, int i) {
        super((byte[]) null);
        C0663RB.a(buffer.f5623a, 0, (long) i);
        Ov ov = buffer.f5624a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = ov.b;
            int i6 = ov.a;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                ov = ov.f3743a;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f3785a = new byte[i4][];
        this.a = new int[(i4 * 2)];
        Ov ov2 = buffer.f5624a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f3785a;
            bArr[i7] = ov2.f3745a;
            int i8 = ov2.b;
            int i9 = ov2.a;
            int i10 = (i8 - i9) + i2;
            if (i10 > i) {
                i2 = i;
            } else {
                i2 = i10;
            }
            int[] iArr = this.a;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            ov2.f3744a = true;
            i7++;
            ov2 = ov2.f3743a;
        }
    }

    private Object writeReplace() {
        return H();
    }

    public final int A() {
        return this.a[this.f3785a.length - 1];
    }

    public final ByteString B() {
        return H().B();
    }

    public final ByteString C() {
        return H().C();
    }

    public final byte[] D() {
        byte[][] bArr = this.f3785a;
        int[] iArr = this.a;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            System.arraycopy(bArr[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    public final String E() {
        return H().E();
    }

    public final void F(Buffer buffer) {
        byte[][] bArr = this.f3785a;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.a;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Ov ov = new Ov(bArr[i], i3, (i3 + i4) - i2, true, false);
            Ov ov2 = buffer.f5624a;
            if (ov2 == null) {
                ov.f3746b = ov;
                ov.f3743a = ov;
                buffer.f5624a = ov;
            } else {
                ov2.f3746b.b(ov);
            }
            i++;
            i2 = i4;
        }
        buffer.f5623a += (long) i2;
    }

    public final int G(int i) {
        int binarySearch = Arrays.binarySearch(this.a, 0, this.f3785a.length, i + 1);
        if (binarySearch >= 0) {
            return binarySearch;
        }
        return ~binarySearch;
    }

    public final ByteString H() {
        return new ByteString(D());
    }

    public final String a() {
        return H().a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.A() != A() || !z(byteString, A())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.f3785a;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr2 = bArr[i2];
            int[] iArr = this.a;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.c = i3;
        return i3;
    }

    public final byte n(int i) {
        int i2;
        byte[][] bArr = this.f3785a;
        int[] iArr = this.a;
        C0663RB.a((long) iArr[bArr.length - 1], (long) i, 1);
        int G = G(i);
        if (G == 0) {
            i2 = 0;
        } else {
            i2 = iArr[G - 1];
        }
        return bArr[G][(i - i2) + iArr[bArr.length + G]];
    }

    public final String o() {
        return H().o();
    }

    public final byte[] p() {
        return D();
    }

    public final String toString() {
        return H().toString();
    }

    public final boolean x(int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i < 0 || i > A() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int G = G(i);
        while (true) {
            boolean z = true;
            if (i3 <= 0) {
                return true;
            }
            int[] iArr = this.a;
            if (G == 0) {
                i4 = 0;
            } else {
                i4 = iArr[G - 1];
            }
            int min = Math.min(i3, ((iArr[G] - i4) + i4) - i);
            byte[][] bArr2 = this.f3785a;
            int i5 = (i - i4) + iArr[bArr2.length + G];
            byte[] bArr3 = bArr2[G];
            Charset charset = C0663RB.a;
            int i6 = 0;
            while (true) {
                if (i6 >= min) {
                    break;
                } else if (bArr3[i6 + i5] != bArr[i6 + i2]) {
                    z = false;
                    break;
                } else {
                    i6++;
                }
            }
            if (!z) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            G++;
        }
    }

    public final boolean z(ByteString byteString, int i) {
        int i2;
        if (A() - i < 0) {
            return false;
        }
        int G = G(0);
        int i3 = 0;
        int i4 = 0;
        while (i > 0) {
            int[] iArr = this.a;
            if (G == 0) {
                i2 = 0;
            } else {
                i2 = iArr[G - 1];
            }
            int min = Math.min(i, ((iArr[G] - i2) + i2) - i3);
            byte[][] bArr = this.f3785a;
            if (!byteString.x(i4, (i3 - i2) + iArr[bArr.length + G], bArr[G], min)) {
                return false;
            }
            i3 += min;
            i4 += min;
            i -= min;
            G++;
        }
        return true;
    }
}
