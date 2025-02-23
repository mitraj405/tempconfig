package defpackage;

/* renamed from: E8  reason: default package */
/* compiled from: DelayedWorkTracker */
public final class E8 implements Runnable {
    public final /* synthetic */ F8 a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0214hE f131a;

    public E8(F8 f8, C0214hE hEVar) {
        this.a = f8;
        this.f131a = hEVar;
    }

    public final void run() {
        zi c = zi.c();
        int i = F8.a;
        C0214hE hEVar = this.f131a;
        String.format("Scheduling work %s", new Object[]{hEVar.f2991a});
        c.a(new Throwable[0]);
        this.a.f196a.d(hEVar);
    }
}
