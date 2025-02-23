package defpackage;

import android.app.Application;
import defpackage.Q;

/* renamed from: O  reason: default package */
/* compiled from: ActivityRecreator */
public final class O implements Runnable {
    public final /* synthetic */ Q.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Application f462a;

    public O(Application application, Q.a aVar) {
        this.f462a = application;
        this.a = aVar;
    }

    public final void run() {
        this.f462a.unregisterActivityLifecycleCallbacks(this.a);
    }
}
