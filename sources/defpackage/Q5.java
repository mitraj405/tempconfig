package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Q5  reason: default package */
/* compiled from: CancellableContinuationImpl.kt */
public final class Q5 {
    public final C0688T3 a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3761a;

    /* renamed from: a  reason: collision with other field name */
    public final Throwable f3762a;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<Throwable, Unit> f3763a;
    public final Object b;

    public Q5(Object obj, C0688T3 t3, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f3761a = obj;
        this.a = t3;
        this.f3763a = function1;
        this.b = obj2;
        this.f3762a = th;
    }

    public static Q5 a(Q5 q5, C0688T3 t3, CancellationException cancellationException, int i) {
        Object obj;
        Function1<Throwable, Unit> function1;
        Object obj2 = null;
        if ((i & 1) != 0) {
            obj = q5.f3761a;
        } else {
            obj = null;
        }
        if ((i & 2) != 0) {
            t3 = q5.a;
        }
        C0688T3 t32 = t3;
        if ((i & 4) != 0) {
            function1 = q5.f3763a;
        } else {
            function1 = null;
        }
        if ((i & 8) != 0) {
            obj2 = q5.b;
        }
        Object obj3 = obj2;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = q5.f3762a;
        }
        q5.getClass();
        return new Q5(obj, t32, (Function1<? super Throwable, Unit>) function1, obj3, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q5)) {
            return false;
        }
        Q5 q5 = (Q5) obj;
        if (C1177ig.a(this.f3761a, q5.f3761a) && C1177ig.a(this.a, q5.a) && C1177ig.a(this.f3763a, q5.f3763a) && C1177ig.a(this.b, q5.b) && C1177ig.a(this.f3762a, q5.f3762a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        Object obj = this.f3761a;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        int i6 = i * 31;
        C0688T3 t3 = this.a;
        if (t3 == null) {
            i2 = 0;
        } else {
            i2 = t3.hashCode();
        }
        int i7 = (i6 + i2) * 31;
        Function1<Throwable, Unit> function1 = this.f3763a;
        if (function1 == null) {
            i3 = 0;
        } else {
            i3 = function1.hashCode();
        }
        int i8 = (i7 + i3) * 31;
        Object obj2 = this.b;
        if (obj2 == null) {
            i4 = 0;
        } else {
            i4 = obj2.hashCode();
        }
        int i9 = (i8 + i4) * 31;
        Throwable th = this.f3762a;
        if (th != null) {
            i5 = th.hashCode();
        }
        return i9 + i5;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f3761a + ", cancelHandler=" + this.a + ", onCancellation=" + this.f3763a + ", idempotentResume=" + this.b + ", cancelCause=" + this.f3762a + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Q5(Object obj, C0688T3 t3, Function1 function1, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : t3, (Function1<? super Throwable, Unit>) (i & 4) != 0 ? null : function1, (Object) null, (Throwable) (i & 16) != 0 ? null : cancellationException);
    }
}
