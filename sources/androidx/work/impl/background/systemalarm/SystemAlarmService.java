package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import android.os.PowerManager;
import androidx.lifecycle.LifecycleService;
import androidx.work.impl.background.systemalarm.d;
import java.util.HashMap;
import java.util.WeakHashMap;

public class SystemAlarmService extends LifecycleService implements d.c {
    public d a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2667a;

    static {
        zi.e("SystemAlarmService");
    }

    public final void a() {
        d dVar = new d(this);
        this.a = dVar;
        if (dVar.f2682a != null) {
            zi.c().b(new Throwable[0]);
        } else {
            dVar.f2682a = this;
        }
    }

    public final void b() {
        this.f2667a = true;
        zi.c().a(new Throwable[0]);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = C0286oD.a;
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap2 = C0286oD.a;
        synchronized (weakHashMap2) {
            hashMap.putAll(weakHashMap2);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)});
                zi c = zi.c();
                WeakHashMap<PowerManager.WakeLock, String> weakHashMap3 = C0286oD.a;
                c.f(new Throwable[0]);
            }
        }
        stopSelf();
    }

    public final void onCreate() {
        super.onCreate();
        a();
        this.f2667a = false;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f2667a = true;
        this.a.c();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (this.f2667a) {
            zi.c().d(new Throwable[0]);
            this.a.c();
            a();
            this.f2667a = false;
        }
        if (intent == null) {
            return 3;
        }
        this.a.a(i2, intent);
        return 3;
    }
}
