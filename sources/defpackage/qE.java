package defpackage;

import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: qE  reason: default package */
/* compiled from: WorkerWrapper */
public final class qE implements Runnable {
    public final /* synthetic */ SettableFuture a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ListenableFuture f3185a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0326sE f3186a;

    public qE(C0326sE sEVar, SettableFuture settableFuture, SettableFuture settableFuture2) {
        this.f3186a = sEVar;
        this.f3185a = settableFuture;
        this.a = settableFuture2;
    }

    public final void run() {
        SettableFuture settableFuture = this.a;
        C0326sE sEVar = this.f3186a;
        try {
            this.f3185a.get();
            zi c = zi.c();
            int i = C0326sE.c;
            String.format("Starting work for %s", new Object[]{sEVar.f3261a.f2995b});
            c.a(new Throwable[0]);
            ListenableFuture<ListenableWorker.Result> startWork = sEVar.f3254a.startWork();
            sEVar.f3260a = startWork;
            settableFuture.j(startWork);
        } catch (Throwable th) {
            settableFuture.i(th);
        }
    }
}
