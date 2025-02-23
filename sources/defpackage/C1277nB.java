package defpackage;

import defpackage.C0575LC;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* renamed from: nB  reason: default package and case insensitive filesystem */
/* compiled from: Lazy.kt */
public final class C1277nB<T> implements Lazy<T>, Serializable {
    public Object a = r1.c;

    /* renamed from: a  reason: collision with other field name */
    public Function0<? extends T> f5600a;

    public C1277nB(C0575LC.b bVar) {
        this.f5600a = bVar;
    }

    private final Object writeReplace() {
        return new C0667Rf(getValue());
    }

    public final T getValue() {
        if (this.a == r1.c) {
            Function0<? extends T> function0 = this.f5600a;
            C1177ig.c(function0);
            this.a = function0.invoke();
            this.f5600a = null;
        }
        return this.a;
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
