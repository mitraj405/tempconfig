package defpackage;

import java.util.NoSuchElementException;

/* renamed from: eg  reason: default package and case insensitive filesystem */
/* compiled from: ProgressionIterators.kt */
public final class C1091eg extends C0823cg {
    public boolean a;
    public final int c;
    public final int d;
    public int e;

    public C1091eg(int i, int i2, int i3) {
        this.c = i3;
        this.d = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.a = z;
        this.e = !z ? i2 : i;
    }

    public final boolean hasNext() {
        return this.a;
    }

    public final int nextInt() {
        int i = this.e;
        if (i != this.d) {
            this.e = this.c + i;
        } else if (this.a) {
            this.a = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
