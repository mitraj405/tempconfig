package defpackage;

import rx.Scheduler;

/* renamed from: av  reason: default package and case insensitive filesystem */
/* compiled from: ScalarSynchronousObservable */
public final class C0789av implements C {
    public final /* synthetic */ C a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Scheduler.a f3906a;

    public C0789av(C c, Scheduler.a aVar) {
        this.a = c;
        this.f3906a = aVar;
    }

    public final void a() {
        Scheduler.a aVar = this.f3906a;
        try {
            this.a.a();
        } finally {
            aVar.unsubscribe();
        }
    }
}
