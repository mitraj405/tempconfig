package defpackage;

/* renamed from: Cm  reason: default package */
/* compiled from: NetworkState */
public final class Cm {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public Cm(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cm)) {
            return false;
        }
        Cm cm = (Cm) obj;
        if (this.a == cm.a && this.b == cm.b && this.c == cm.c && this.d == cm.d) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.b;
        int i = this.a;
        if (z) {
            i += 16;
        }
        if (this.c) {
            i += 256;
        }
        if (this.d) {
            return i + 4096;
        }
        return i;
    }

    public final String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.a), Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d)});
    }
}
