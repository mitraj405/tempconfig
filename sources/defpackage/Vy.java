package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.a;

/* renamed from: Vy  reason: default package */
/* compiled from: SystemForegroundDispatcher */
public final class Vy implements Runnable {
    public final /* synthetic */ WorkDatabase a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ a f630a;
    public final /* synthetic */ String c;

    public Vy(a aVar, WorkDatabase workDatabase, String str) {
        this.f630a = aVar;
        this.a = workDatabase;
        this.c = str;
    }

    public final void run() {
        C0214hE i = ((C0236jE) this.a.n()).i(this.c);
        if (i != null && i.b()) {
            synchronized (this.f630a.f2696a) {
                this.f630a.f2697a.put(this.c, i);
                this.f630a.f2698a.add(i);
                a aVar = this.f630a;
                aVar.a.b(aVar.f2698a);
            }
        }
    }
}
