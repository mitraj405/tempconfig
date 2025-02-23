package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.d;
import defpackage.nE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: DelayMetCommandHandler */
public final class c implements LD, rb, nE.b {
    public final MD a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2672a;

    /* renamed from: a  reason: collision with other field name */
    public PowerManager.WakeLock f2673a;

    /* renamed from: a  reason: collision with other field name */
    public final d f2674a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f2675a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2676a = false;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f2677c;
    public int d = 0;

    static {
        zi.e("DelayMetCommandHandler");
    }

    public c(Context context, int i, String str, d dVar) {
        this.f2672a = context;
        this.c = i;
        this.f2674a = dVar;
        this.f2677c = str;
        this.a = new MD(context, dVar.f2683a, this);
    }

    public final void a(List<String> list) {
        if (list.contains(this.f2677c)) {
            synchronized (this.f2675a) {
                if (this.d == 0) {
                    this.d = 1;
                    zi c2 = zi.c();
                    String.format("onAllConstraintsMet for %s", new Object[]{this.f2677c});
                    c2.a(new Throwable[0]);
                    if (this.f2674a.f2686a.f(this.f2677c, (WorkerParameters.a) null)) {
                        this.f2674a.f2685a.a(this.f2677c, this);
                    } else {
                        c();
                    }
                } else {
                    zi c3 = zi.c();
                    String.format("Already started work for %s", new Object[]{this.f2677c});
                    c3.a(new Throwable[0]);
                }
            }
        }
    }

    public final void b(String str) {
        zi c2 = zi.c();
        String.format("Exceeded time limits on execution for %s", new Object[]{str});
        c2.a(new Throwable[0]);
        g();
    }

    public final void c() {
        synchronized (this.f2675a) {
            this.a.c();
            this.f2674a.f2685a.b(this.f2677c);
            PowerManager.WakeLock wakeLock = this.f2673a;
            if (wakeLock != null && wakeLock.isHeld()) {
                zi c2 = zi.c();
                String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.f2673a, this.f2677c});
                c2.a(new Throwable[0]);
                this.f2673a.release();
            }
        }
    }

    public final void d() {
        String str = this.f2677c;
        this.f2673a = C0286oD.a(this.f2672a, String.format("%s (%s)", new Object[]{str, Integer.valueOf(this.c)}));
        zi c2 = zi.c();
        String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.f2673a, str});
        c2.a(new Throwable[0]);
        this.f2673a.acquire();
        C0214hE i = ((C0236jE) this.f2674a.a.f594a.n()).i(str);
        if (i == null) {
            g();
            return;
        }
        boolean b = i.b();
        this.f2676a = b;
        if (!b) {
            zi c3 = zi.c();
            String.format("No constraints for %s", new Object[]{str});
            c3.a(new Throwable[0]);
            a(Collections.singletonList(str));
            return;
        }
        this.a.b(Collections.singletonList(i));
    }

    public final void e(String str, boolean z) {
        zi c2 = zi.c();
        String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z)});
        c2.a(new Throwable[0]);
        c();
        int i = this.c;
        d dVar = this.f2674a;
        Context context = this.f2672a;
        if (z) {
            dVar.d(new d.b(i, a.b(context, this.f2677c), dVar));
        }
        if (this.f2676a) {
            Intent intent = new Intent(context, SystemAlarmService.class);
            intent.setAction("ACTION_CONSTRAINTS_CHANGED");
            dVar.d(new d.b(i, intent, dVar));
        }
    }

    public final void f(ArrayList arrayList) {
        g();
    }

    public final void g() {
        synchronized (this.f2675a) {
            if (this.d < 2) {
                this.d = 2;
                zi c2 = zi.c();
                String.format("Stopping work for WorkSpec %s", new Object[]{this.f2677c});
                c2.a(new Throwable[0]);
                Context context = this.f2672a;
                String str = this.f2677c;
                Intent intent = new Intent(context, SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str);
                d dVar = this.f2674a;
                dVar.d(new d.b(this.c, intent, dVar));
                if (this.f2674a.f2686a.c(this.f2677c)) {
                    zi c3 = zi.c();
                    String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.f2677c});
                    c3.a(new Throwable[0]);
                    Intent b = a.b(this.f2672a, this.f2677c);
                    d dVar2 = this.f2674a;
                    dVar2.d(new d.b(this.c, b, dVar2));
                } else {
                    zi c4 = zi.c();
                    String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.f2677c});
                    c4.a(new Throwable[0]);
                }
            } else {
                zi c5 = zi.c();
                String.format("Already stopped work for %s", new Object[]{this.f2677c});
                c5.a(new Throwable[0]);
            }
        }
    }
}
