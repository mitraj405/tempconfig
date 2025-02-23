package defpackage;

/* renamed from: jx  reason: default package and case insensitive filesystem */
/* compiled from: Size */
public final class C1205jx implements Comparable<C1205jx> {
    public final int c;
    public final int d;

    public C1205jx(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public final C1205jx a(C1205jx jxVar) {
        int i = jxVar.d;
        int i2 = this.c;
        int i3 = i2 * i;
        int i4 = jxVar.c;
        int i5 = this.d;
        if (i3 <= i4 * i5) {
            return new C1205jx(i4, (i5 * i4) / i2);
        }
        return new C1205jx((i2 * i) / i5, i);
    }

    public final int compareTo(Object obj) {
        C1205jx jxVar = (C1205jx) obj;
        int i = this.d * this.c;
        int i2 = jxVar.d * jxVar.c;
        if (i2 < i) {
            return 1;
        }
        if (i2 > i) {
            return -1;
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1205jx.class != obj.getClass()) {
            return false;
        }
        C1205jx jxVar = (C1205jx) obj;
        if (this.c == jxVar.c && this.d == jxVar.d) {
            return true;
        }
        return false;
    }

    public final C1205jx f(C1205jx jxVar) {
        int i = jxVar.d;
        int i2 = this.c;
        int i3 = i2 * i;
        int i4 = jxVar.c;
        int i5 = this.d;
        if (i3 >= i4 * i5) {
            return new C1205jx(i4, (i5 * i4) / i2);
        }
        return new C1205jx((i2 * i) / i5, i);
    }

    public final int hashCode() {
        return (this.c * 31) + this.d;
    }

    public final String toString() {
        return this.c + "x" + this.d;
    }
}
