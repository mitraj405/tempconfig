package defpackage;

import java.util.NoSuchElementException;

/* renamed from: Vi  reason: default package */
/* compiled from: ProgressionIterators.kt */
public final class Vi extends Ti {
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3816a;
    public final long b;
    public long c;

    public Vi(long j, long j2, long j3) {
        this.a = j3;
        this.b = j2;
        boolean z = true;
        if (j3 <= 0 ? j < j2 : j > j2) {
            z = false;
        }
        this.f3816a = z;
        this.c = !z ? j2 : j;
    }

    public final boolean hasNext() {
        return this.f3816a;
    }

    public final long nextLong() {
        long j = this.c;
        if (j != this.b) {
            this.c = this.a + j;
        } else if (this.f3816a) {
            this.f3816a = false;
        } else {
            throw new NoSuchElementException();
        }
        return j;
    }
}
