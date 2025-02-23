package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* renamed from: Le  reason: default package and case insensitive filesystem */
/* compiled from: HandlerDispatcher.kt */
public final class C0580Le extends C0593Me {
    private volatile C0580Le _immediate;
    public final C0580Le a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f3696a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3697a;
    public final String c;

    public C0580Le(Handler handler, String str, boolean z) {
        this.f3696a = handler;
        this.c = str;
        this.f3697a = z;
        this._immediate = z ? this : null;
        C0580Le le = this._immediate;
        if (le == null) {
            le = new C0580Le(handler, str, true);
            this._immediate = le;
        }
        this.a = le;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0580Le) || ((C0580Le) obj).f3696a != this.f3696a) {
            return false;
        }
        return true;
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f3696a.post(runnable)) {
            C1354qp.n(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
            C1213k9.a.h(coroutineContext, runnable);
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f3696a);
    }

    public final boolean q() {
        if (!this.f3697a || !C1177ig.a(Looper.myLooper(), this.f3696a.getLooper())) {
            return true;
        }
        return false;
    }

    public final C0682Sj r() {
        return this.a;
    }

    public final String toString() {
        String str;
        C0682Sj sj;
        C1474x8 x8Var = C1213k9.f5544a;
        C0682Sj sj2 = C0724Vj.a;
        if (this == sj2) {
            str = "Dispatchers.Main";
        } else {
            try {
                sj = sj2.r();
            } catch (UnsupportedOperationException unused) {
                sj = null;
            }
            if (this == sj) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str != null) {
            return str;
        }
        String str2 = this.c;
        if (str2 == null) {
            str2 = this.f3696a.toString();
        }
        if (this.f3697a) {
            return C1058d.z(str2, ".immediate");
        }
        return str2;
    }

    public C0580Le(Handler handler) {
        this(handler, (String) null, false);
    }
}
