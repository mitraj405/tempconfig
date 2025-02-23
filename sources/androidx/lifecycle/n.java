package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

/* compiled from: ServiceLifecycleDispatcher.kt */
public final class n {
    public final Handler a = new Handler();

    /* renamed from: a  reason: collision with other field name */
    public final LifecycleRegistry f2216a;

    /* renamed from: a  reason: collision with other field name */
    public a f2217a;

    /* compiled from: ServiceLifecycleDispatcher.kt */
    public static final class a implements Runnable {
        public final Lifecycle.a a;

        /* renamed from: a  reason: collision with other field name */
        public final LifecycleRegistry f2218a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2219a;

        public a(LifecycleRegistry lifecycleRegistry, Lifecycle.a aVar) {
            C1177ig.f(lifecycleRegistry, "registry");
            C1177ig.f(aVar, "event");
            this.f2218a = lifecycleRegistry;
            this.a = aVar;
        }

        public final void run() {
            if (!this.f2219a) {
                this.f2218a.f(this.a);
                this.f2219a = true;
            }
        }
    }

    public n(LifecycleOwner lifecycleOwner) {
        C1177ig.f(lifecycleOwner, "provider");
        this.f2216a = new LifecycleRegistry(lifecycleOwner);
    }

    public final void a(Lifecycle.a aVar) {
        a aVar2 = this.f2217a;
        if (aVar2 != null) {
            aVar2.run();
        }
        a aVar3 = new a(this.f2216a, aVar);
        this.f2217a = aVar3;
        this.a.postAtFrontOfQueue(aVar3);
    }
}
