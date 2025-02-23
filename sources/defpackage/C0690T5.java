package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: T5  reason: default package and case insensitive filesystem */
/* compiled from: CompletionState.kt */
public final class C0690T5 {
    public final Object a;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<Throwable, Unit> f3797a;

    public C0690T5(Object obj, Function1<? super Throwable, Unit> function1) {
        this.a = obj;
        this.f3797a = function1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0690T5)) {
            return false;
        }
        C0690T5 t5 = (C0690T5) obj;
        if (C1177ig.a(this.a, t5.a) && C1177ig.a(this.f3797a, t5.f3797a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        Object obj = this.a;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return this.f3797a.hashCode() + (i * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.f3797a + ')';
    }
}
