package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.j;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LifecycleDispatcher.kt */
public final class e {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.kt */
    public static final class a extends C0352ua {
        public void onActivityCreated(Activity activity, Bundle bundle) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            j.b.b(activity);
        }
    }
}
