package defpackage;

/* renamed from: dB  reason: default package and case insensitive filesystem */
/* compiled from: UIUpdater */
public final class C1064dB implements Runnable {
    public final /* synthetic */ C0816cB a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Runnable f5432a;
    public final /* synthetic */ int c = 1;

    public C1064dB(C0816cB cBVar, Runnable runnable) {
        this.a = cBVar;
        this.f5432a = runnable;
    }

    public final void run() {
        C0816cB cBVar = this.a;
        if (cBVar.b > 0) {
            this.f5432a.run();
        }
        int i = cBVar.b;
        if (this.c != i) {
            cBVar.b = i + 1;
            cBVar.f3931a.postDelayed(this, (long) cBVar.a);
        }
    }
}
