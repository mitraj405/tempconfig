package androidx.work.impl.foreground;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.foreground.a;
import java.util.UUID;

public class SystemForegroundService extends LifecycleService implements a.C0030a {
    public NotificationManager a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f2689a;

    /* renamed from: a  reason: collision with other field name */
    public a f2690a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2691a;

    static {
        zi.e("SystemFgService");
    }

    public final void a() {
        this.f2689a = new Handler(Looper.getMainLooper());
        this.a = (NotificationManager) getApplicationContext().getSystemService("notification");
        a aVar = new a(getApplicationContext());
        this.f2690a = aVar;
        if (aVar.f2694a != null) {
            zi.c().b(new Throwable[0]);
        } else {
            aVar.f2694a = this;
        }
    }

    public final void onCreate() {
        super.onCreate();
        a();
    }

    public final void onDestroy() {
        super.onDestroy();
        a aVar = this.f2690a;
        aVar.f2694a = null;
        synchronized (aVar.f2696a) {
            aVar.a.c();
        }
        wq wqVar = aVar.f2692a.f598a;
        synchronized (wqVar.f3398a) {
            wqVar.f3399a.remove(aVar);
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f2691a) {
            zi.c().d(new Throwable[0]);
            a aVar = this.f2690a;
            aVar.f2694a = null;
            synchronized (aVar.f2696a) {
                aVar.a.c();
            }
            wq wqVar = aVar.f2692a.f598a;
            synchronized (wqVar.f3398a) {
                wqVar.f3399a.remove(aVar);
            }
            a();
            this.f2691a = false;
        }
        if (intent == null) {
            return 3;
        }
        a aVar2 = this.f2690a;
        aVar2.getClass();
        String action = intent.getAction();
        boolean equals = "ACTION_START_FOREGROUND".equals(action);
        int i3 = a.c;
        VD vd = aVar2.f2692a;
        if (equals) {
            zi c = zi.c();
            String.format("Started foreground service %s", new Object[]{intent});
            c.d(new Throwable[0]);
            aVar2.f2695a.c(new Vy(aVar2, vd.f594a, intent.getStringExtra("KEY_WORKSPEC_ID")));
            aVar2.d(intent);
            return 3;
        } else if ("ACTION_NOTIFY".equals(action)) {
            aVar2.d(intent);
            return 3;
        } else if ("ACTION_CANCEL_WORK".equals(action)) {
            zi c2 = zi.c();
            String.format("Stopping foreground work for %s", new Object[]{intent});
            c2.d(new Throwable[0]);
            String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
            if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
                return 3;
            }
            UUID fromString = UUID.fromString(stringExtra);
            vd.getClass();
            vd.f595a.c(new q4(vd, fromString));
            return 3;
        } else if (!"ACTION_STOP_FOREGROUND".equals(action)) {
            return 3;
        } else {
            zi.c().d(new Throwable[0]);
            a.C0030a aVar3 = aVar2.f2694a;
            if (aVar3 == null) {
                return 3;
            }
            SystemForegroundService systemForegroundService = (SystemForegroundService) aVar3;
            systemForegroundService.f2691a = true;
            zi.c().a(new Throwable[0]);
            systemForegroundService.stopForeground(true);
            systemForegroundService.stopSelf();
            return 3;
        }
    }
}
