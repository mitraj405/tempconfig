package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.lifecycle.Lifecycle;

/* compiled from: LifecycleService.kt */
public class LifecycleService extends Service implements LifecycleOwner {
    public final n a = new n(this);

    public final Lifecycle getLifecycle() {
        return this.a.f2216a;
    }

    public final IBinder onBind(Intent intent) {
        C1177ig.f(intent, "intent");
        this.a.a(Lifecycle.a.ON_START);
        return null;
    }

    public void onCreate() {
        this.a.a(Lifecycle.a.ON_CREATE);
        super.onCreate();
    }

    public void onDestroy() {
        Lifecycle.a aVar = Lifecycle.a.ON_STOP;
        n nVar = this.a;
        nVar.a(aVar);
        nVar.a(Lifecycle.a.ON_DESTROY);
        super.onDestroy();
    }

    public final void onStart(Intent intent, int i) {
        this.a.a(Lifecycle.a.ON_START);
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
