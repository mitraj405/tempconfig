package defpackage;

import android.annotation.SuppressLint;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* renamed from: rE  reason: default package and case insensitive filesystem */
/* compiled from: WorkerWrapper */
public final class C0315rE implements Runnable {
    public final /* synthetic */ SettableFuture a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0326sE f3219a;
    public final /* synthetic */ String c;

    public C0315rE(C0326sE sEVar, SettableFuture settableFuture, String str) {
        this.f3219a = sEVar;
        this.a = settableFuture;
        this.c = str;
    }

    @SuppressLint({"SyntheticAccessor"})
    public final void run() {
        String str = this.c;
        C0326sE sEVar = this.f3219a;
        try {
            ListenableWorker.Result result = (ListenableWorker.Result) this.a.get();
            if (result == null) {
                zi c2 = zi.c();
                int i = C0326sE.c;
                String.format("%s returned a null result. Treating it as a failure.", new Object[]{sEVar.f3261a.f2995b});
                c2.b(new Throwable[0]);
            } else {
                zi c3 = zi.c();
                int i2 = C0326sE.c;
                String.format("%s returned a %s result.", new Object[]{sEVar.f3261a.f2995b, result});
                c3.a(new Throwable[0]);
                sEVar.f3253a = result;
            }
        } catch (CancellationException e) {
            zi c4 = zi.c();
            int i3 = C0326sE.c;
            String.format("%s was cancelled", new Object[]{str});
            c4.d(e);
        } catch (InterruptedException | ExecutionException e2) {
            zi c5 = zi.c();
            int i4 = C0326sE.c;
            String.format("%s failed because it threw an exception/error", new Object[]{str});
            c5.b(e2);
        } catch (Throwable th) {
            sEVar.c();
            throw th;
        }
        sEVar.c();
    }
}
