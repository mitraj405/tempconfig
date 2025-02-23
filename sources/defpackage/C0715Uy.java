package defpackage;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* renamed from: Uy  reason: default package and case insensitive filesystem */
/* compiled from: LazyJVM.kt */
public final class C0715Uy<T> implements Lazy<T>, Serializable {
    public volatile Object a = r1.c;

    /* renamed from: a  reason: collision with other field name */
    public Function0<? extends T> f3814a;
    public final Object b = this;

    public C0715Uy(Function0 function0) {
        C1177ig.f(function0, "initializer");
        this.f3814a = function0;
    }

    private final Object writeReplace() {
        return new C0667Rf(getValue());
    }

    public final T getValue() {
        T t;
        T t2 = this.a;
        T t3 = r1.c;
        if (t2 != t3) {
            return t2;
        }
        synchronized (this.b) {
            t = this.a;
            if (t == t3) {
                Function0 function0 = this.f3814a;
                C1177ig.c(function0);
                t = function0.invoke();
                this.a = t;
                this.f3814a = null;
            }
        }
        return t;
    }

    public final String toString() {
        boolean z;
        if (this.a != r1.c) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
