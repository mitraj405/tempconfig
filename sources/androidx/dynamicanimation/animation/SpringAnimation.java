package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    public SpringForce a = null;
    public boolean c = false;
    public float e = Float.MAX_VALUE;

    public <K> SpringAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
    }

    public final void c() {
        boolean z;
        if (this.a.b > 0.0d) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f1993b) {
            this.c = true;
        }
    }
}
