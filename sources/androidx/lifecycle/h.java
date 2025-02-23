package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.j;

/* compiled from: ProcessLifecycleOwner.kt */
public final class h implements LifecycleOwner {
    public static final h a = new h();

    /* renamed from: a  reason: collision with other field name */
    public Handler f2203a;

    /* renamed from: a  reason: collision with other field name */
    public final LifecycleRegistry f2204a = new LifecycleRegistry(this);

    /* renamed from: a  reason: collision with other field name */
    public final b f2205a = new b(this);

    /* renamed from: a  reason: collision with other field name */
    public final C0140b6 f2206a = new C0140b6(this, 4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f2207a = true;
    public boolean b = true;
    public int c;
    public int d;

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class a {
        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            C1177ig.f(activity, "activity");
            C1177ig.f(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public final void a() {
        int i = this.d + 1;
        this.d = i;
        if (i != 1) {
            return;
        }
        if (this.f2207a) {
            this.f2204a.f(Lifecycle.a.ON_RESUME);
            this.f2207a = false;
            return;
        }
        Handler handler = this.f2203a;
        C1177ig.c(handler);
        handler.removeCallbacks(this.f2206a);
    }

    public final Lifecycle getLifecycle() {
        return this.f2204a;
    }

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class b implements j.a {
        public final /* synthetic */ h a;

        public b(h hVar) {
            this.a = hVar;
        }

        public final void onResume() {
            this.a.a();
        }

        public final void onStart() {
            h hVar = this.a;
            int i = hVar.c + 1;
            hVar.c = i;
            if (i == 1 && hVar.b) {
                hVar.f2204a.f(Lifecycle.a.ON_START);
                hVar.b = false;
            }
        }

        public final void onCreate() {
        }
    }
}
