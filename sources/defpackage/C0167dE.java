package defpackage;

import androidx.work.Data;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.UUID;

/* renamed from: dE  reason: default package and case insensitive filesystem */
/* compiled from: WorkProgressUpdater */
public final class C0167dE implements Runnable {
    public final /* synthetic */ Data a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SettableFuture f2866a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0178eE f2867a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ UUID f2868a;

    public C0167dE(C0178eE eEVar, UUID uuid, Data data, SettableFuture settableFuture) {
        this.f2867a = eEVar;
        this.f2868a = uuid;
        this.a = data;
        this.f2866a = settableFuture;
    }

    public final void run() {
        Zt zt;
        SettableFuture settableFuture = this.f2866a;
        UUID uuid = this.f2868a;
        String uuid2 = uuid.toString();
        zi c = zi.c();
        int i = C0178eE.a;
        Data data = this.a;
        String.format("Updating progress for %s (%s)", new Object[]{uuid, data});
        c.a(new Throwable[0]);
        C0178eE eEVar = this.f2867a;
        WorkDatabase workDatabase = eEVar.f2881a;
        WorkDatabase workDatabase2 = eEVar.f2881a;
        workDatabase.c();
        try {
            C0214hE i2 = ((C0236jE) workDatabase2.n()).i(uuid2);
            if (i2 != null) {
                if (i2.f2989a == UD.RUNNING) {
                    C0119aE aEVar = new C0119aE(uuid2, data);
                    C0157cE cEVar = (C0157cE) workDatabase2.m();
                    zt = cEVar.a;
                    zt.b();
                    zt.c();
                    cEVar.f2753a.e(aEVar);
                    zt.h();
                    zt.f();
                } else {
                    zi c2 = zi.c();
                    String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", new Object[]{uuid2});
                    c2.f(new Throwable[0]);
                }
                settableFuture.h(null);
                workDatabase2.h();
                workDatabase2.f();
                return;
            }
            throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
        } catch (Throwable th) {
            try {
                zi c3 = zi.c();
                int i3 = C0178eE.a;
                c3.b(th);
                settableFuture.i(th);
            } catch (Throwable th2) {
                workDatabase2.f();
                throw th2;
            }
        }
    }
}
