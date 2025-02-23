package defpackage;

import android.content.Context;
import androidx.work.ForegroundInfo;
import androidx.work.impl.foreground.a;
import androidx.work.impl.utils.futures.SettableFuture;
import defpackage.C0283o;
import java.util.UUID;

/* renamed from: SD  reason: default package */
/* compiled from: WorkForegroundUpdater */
public final class SD implements Runnable {
    public final /* synthetic */ TD a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f512a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ForegroundInfo f513a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SettableFuture f514a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ UUID f515a;

    public SD(TD td, SettableFuture settableFuture, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
        this.a = td;
        this.f514a = settableFuture;
        this.f515a = uuid;
        this.f513a = foregroundInfo;
        this.f512a = context;
    }

    public final void run() {
        try {
            if (!(this.f514a.f3124a instanceof C0283o.b)) {
                String uuid = this.f515a.toString();
                UD f = ((C0236jE) this.a.f550a).f(uuid);
                if (f == null || f.a()) {
                    throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                }
                ((wq) this.a.f549a).d(uuid, this.f513a);
                this.f512a.startService(a.b(this.f512a, uuid, this.f513a));
            }
            this.f514a.h(null);
        } catch (Throwable th) {
            this.f514a.i(th);
        }
    }
}
