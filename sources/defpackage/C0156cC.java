package defpackage;

import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: cC  reason: default package and case insensitive filesystem */
/* compiled from: VelocityTrackerCompat */
public final class C0156cC {
    public static final Map<VelocityTracker, C0166dC> a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: cC$a */
    /* compiled from: VelocityTrackerCompat */
    public static class a {
        public static float a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getAxisVelocity(i);
        }

        public static float b(VelocityTracker velocityTracker, int i, int i2) {
            return velocityTracker.getAxisVelocity(i, i2);
        }

        public static boolean c(VelocityTracker velocityTracker, int i) {
            return velocityTracker.isAxisSupported(i);
        }
    }
}
