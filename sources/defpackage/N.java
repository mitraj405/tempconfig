package defpackage;

import defpackage.Q;

/* renamed from: N  reason: default package */
/* compiled from: ActivityRecreator */
public final class N implements Runnable {
    public final /* synthetic */ Q.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f426a;

    public N(Q.a aVar, Object obj) {
        this.a = aVar;
        this.f426a = obj;
    }

    public final void run() {
        this.a.f486a = this.f426a;
    }
}
