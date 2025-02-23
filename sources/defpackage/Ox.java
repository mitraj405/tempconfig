package defpackage;

import androidx.work.WorkerParameters;

/* renamed from: Ox  reason: default package */
/* compiled from: StartWorkRunnable */
public final class Ox implements Runnable {
    public final VD a;

    /* renamed from: a  reason: collision with other field name */
    public final WorkerParameters.a f472a;
    public final String c;

    public Ox(VD vd, String str, WorkerParameters.a aVar) {
        this.a = vd;
        this.c = str;
        this.f472a = aVar;
    }

    public final void run() {
        this.a.f598a.f(this.c, this.f472a);
    }
}
