package defpackage;

import defpackage.Uz;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.h;

/* renamed from: Tz  reason: default package and case insensitive filesystem */
/* compiled from: ThreadSafeHeap.kt */
public class C0700Tz<T extends Uz & Comparable<? super T>> {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(C0700Tz.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with other field name */
    public T[] f3799a;

    public final void a(h.a aVar) {
        aVar.i((h.b) this);
        T[] tArr = this.f3799a;
        if (tArr == null) {
            tArr = new Uz[4];
            this.f3799a = tArr;
        } else if (b() >= tArr.length) {
            T[] copyOf = Arrays.copyOf(tArr, b() * 2);
            C1177ig.e(copyOf, "copyOf(this, newSize)");
            tArr = (Uz[]) copyOf;
            this.f3799a = tArr;
        }
        int b = b();
        a.set(this, b + 1);
        tArr[b] = aVar;
        aVar.c = b;
        d(b);
    }

    public final int b() {
        return a.get(this);
    }

    public final T c(int i) {
        T[] tArr = this.f3799a;
        C1177ig.c(tArr);
        a.set(this, b() - 1);
        if (i < b()) {
            e(i, b());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                C1177ig.c(t);
                T t2 = tArr[i2];
                C1177ig.c(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    e(i, i2);
                    d(i2);
                }
            }
            while (true) {
                int i3 = (i * 2) + 1;
                if (i3 >= b()) {
                    break;
                }
                T[] tArr2 = this.f3799a;
                C1177ig.c(tArr2);
                int i4 = i3 + 1;
                if (i4 < b()) {
                    T t3 = tArr2[i4];
                    C1177ig.c(t3);
                    T t4 = tArr2[i3];
                    C1177ig.c(t4);
                    if (((Comparable) t3).compareTo(t4) < 0) {
                        i3 = i4;
                    }
                }
                T t5 = tArr2[i];
                C1177ig.c(t5);
                T t6 = tArr2[i3];
                C1177ig.c(t6);
                if (((Comparable) t5).compareTo(t6) <= 0) {
                    break;
                }
                e(i, i3);
                i = i3;
            }
        }
        T t7 = tArr[b()];
        C1177ig.c(t7);
        t7.i((h.b) null);
        t7.j(-1);
        tArr[b()] = null;
        return t7;
    }

    public final void d(int i) {
        while (i > 0) {
            T[] tArr = this.f3799a;
            C1177ig.c(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            C1177ig.c(t);
            T t2 = tArr[i];
            C1177ig.c(t2);
            if (((Comparable) t).compareTo(t2) > 0) {
                e(i, i2);
                i = i2;
            } else {
                return;
            }
        }
    }

    public final void e(int i, int i2) {
        T[] tArr = this.f3799a;
        C1177ig.c(tArr);
        T t = tArr[i2];
        C1177ig.c(t);
        T t2 = tArr[i];
        C1177ig.c(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.j(i);
        t2.j(i2);
    }
}
