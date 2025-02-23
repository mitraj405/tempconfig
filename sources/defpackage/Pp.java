package defpackage;

import androidx.core.util.Pools$Pool;

/* renamed from: Pp  reason: default package */
/* compiled from: Pools.kt */
public class Pp<T> implements Pools$Pool<T> {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final Object[] f481a;

    public Pp(int i) {
        boolean z;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f481a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0".toString());
    }

    public boolean a(T t) {
        T[] tArr;
        boolean z;
        C1177ig.f(t, "instance");
        int i = this.a;
        int i2 = 0;
        while (true) {
            tArr = this.f481a;
            if (i2 >= i) {
                z = false;
                break;
            } else if (tArr[i2] == t) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            int i3 = this.a;
            if (i3 >= tArr.length) {
                return false;
            }
            tArr[i3] = t;
            this.a = i3 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!".toString());
    }

    public T b() {
        int i = this.a;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        T[] tArr = this.f481a;
        T t = tArr[i2];
        C1177ig.d(t, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        tArr[i2] = null;
        this.a--;
        return t;
    }
}
