package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: UnknownFieldSetLite */
public final class L {
    public static final L a = new L(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with other field name */
    public int f1922a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1923a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f1924a;

    /* renamed from: a  reason: collision with other field name */
    public Object[] f1925a;
    public int b;

    public L() {
        this(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int i;
        int i2 = this.b;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1922a; i4++) {
            int i5 = this.f1924a[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = s5.y(i6, ((Long) this.f1925a[i4]).longValue());
            } else if (i7 == 1) {
                ((Long) this.f1925a[i4]).longValue();
                i = s5.i(i6);
            } else if (i7 == 2) {
                i = s5.e(i6, (x3) this.f1925a[i4]);
            } else if (i7 == 3) {
                i3 = ((L) this.f1925a[i4]).a() + (s5.v(i6) * 2) + i3;
            } else if (i7 == 5) {
                ((Integer) this.f1925a[i4]).intValue();
                i = s5.h(i6);
            } else {
                int i8 = q.c;
                throw new IllegalStateException(new q.a());
            }
            i3 = i + i3;
        }
        this.b = i3;
        return i3;
    }

    public final void b(int i, Object obj) {
        int i2;
        if (this.f1923a) {
            int i3 = this.f1922a;
            int[] iArr = this.f1924a;
            if (i3 == iArr.length) {
                if (i3 < 4) {
                    i2 = 8;
                } else {
                    i2 = i3 >> 1;
                }
                int i4 = i3 + i2;
                this.f1924a = Arrays.copyOf(iArr, i4);
                this.f1925a = Arrays.copyOf(this.f1925a, i4);
            }
            int[] iArr2 = this.f1924a;
            int i5 = this.f1922a;
            iArr2[i5] = i;
            this.f1925a[i5] = obj;
            this.f1922a = i5 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void c(C0130g gVar) throws IOException {
        if (this.f1922a != 0) {
            gVar.getClass();
            for (int i = 0; i < this.f1922a; i++) {
                int i2 = this.f1924a[i];
                Object obj = this.f1925a[i];
                int i3 = i2 >>> 3;
                int i4 = i2 & 7;
                if (i4 == 0) {
                    gVar.j(i3, ((Long) obj).longValue());
                } else if (i4 == 1) {
                    gVar.f(i3, ((Long) obj).longValue());
                } else if (i4 == 2) {
                    gVar.b(i3, (x3) obj);
                } else if (i4 == 3) {
                    s5 s5Var = gVar.a;
                    s5Var.S(i3, 3);
                    ((L) obj).c(gVar);
                    s5Var.S(i3, 4);
                } else if (i4 == 5) {
                    gVar.e(i3, ((Integer) obj).intValue());
                } else {
                    int i5 = q.c;
                    throw new RuntimeException(new q.a());
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof L)) {
            return false;
        }
        L l = (L) obj;
        int i = this.f1922a;
        if (i == l.f1922a) {
            int[] iArr = this.f1924a;
            int[] iArr2 = l.f1924a;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.f1925a;
                Object[] objArr2 = l.f1925a;
                int i3 = this.f1922a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z2) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f1922a;
        int i2 = (527 + i) * 31;
        int[] iArr = this.f1924a;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f1925a;
        int i7 = this.f1922a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public L(int i, int[] iArr, Object[] objArr, boolean z) {
        this.b = -1;
        this.f1922a = i;
        this.f1924a = iArr;
        this.f1925a = objArr;
        this.f1923a = z;
    }
}
