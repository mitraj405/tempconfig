package defpackage;

import defpackage.V4;
import defpackage.Ww;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* renamed from: Lw  reason: default package */
/* compiled from: SimpleActor.kt */
public final class Lw<T> {
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public final Function2<T, Continuation<? super Unit>, Object> f388a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineScope f389a;

    /* renamed from: a  reason: collision with other field name */
    public final C1296o3 f390a = C0703U4.a(Integer.MAX_VALUE, 0, 6);

    public Lw(CoroutineScope coroutineScope, Xw xw, Yw yw, Zw zw) {
        C1177ig.f(yw, "onUndeliveredElement");
        this.f389a = coroutineScope;
        this.f388a = zw;
        Job job = (Job) coroutineScope.r().b(Job.b.a);
        if (job != null) {
            job.W(new Jw(xw, this, yw));
        }
    }

    public final void a(Ww.a aVar) {
        V4.a aVar2;
        Object d = this.f390a.d(aVar);
        boolean z = d instanceof V4.a;
        Throwable th = null;
        if (z) {
            if (z) {
                aVar2 = (V4.a) d;
            } else {
                aVar2 = null;
            }
            if (aVar2 != null) {
                th = aVar2.a;
            }
            if (th == null) {
                th = new C1362r5("Channel was closed normally");
            }
            throw th;
        } else if (!(!(d instanceof V4.b))) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.a.getAndIncrement() == 0) {
            C1354qp.c0(this.f389a, new Kw(this, (Continuation<? super Kw>) null));
        }
    }
}
