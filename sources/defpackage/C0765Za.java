package defpackage;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;

/* renamed from: Za  reason: default package and case insensitive filesystem */
/* compiled from: EventLoop.common.kt */
public abstract class C0765Za extends CoroutineDispatcher {
    public static final /* synthetic */ int c = 0;
    public long a;

    /* renamed from: a  reason: collision with other field name */
    public C0534I1<g<?>> f3880a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3881a;

    public final void r(boolean z) {
        long j;
        long j2 = this.a;
        if (z) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        long j3 = j2 - j;
        this.a = j3;
        if (j3 <= 0 && this.f3881a) {
            shutdown();
        }
    }

    public final void s(boolean z) {
        long j;
        long j2 = this.a;
        if (z) {
            j = 4294967296L;
        } else {
            j = 1;
        }
        this.a = j + j2;
        if (!z) {
            this.f3881a = true;
        }
    }

    public long u() {
        if (!v()) {
            return Long.MAX_VALUE;
        }
        return 0;
    }

    public final boolean v() {
        g<?> gVar;
        C0534I1<g<?>> i1 = this.f3880a;
        if (i1 == null) {
            return false;
        }
        if (i1.isEmpty()) {
            gVar = null;
        } else {
            gVar = i1.removeFirst();
        }
        g gVar2 = gVar;
        if (gVar2 == null) {
            return false;
        }
        gVar2.run();
        return true;
    }

    public void shutdown() {
    }
}
