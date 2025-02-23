package defpackage;

import com.google.firebase.perf.FirebasePerformance_Factory;
import javax.inject.Provider;

/* renamed from: s9  reason: default package and case insensitive filesystem */
/* compiled from: DoubleCheck */
public final class C1383s9<T> implements Provider<T> {
    public static final Object b = new Object();
    public volatile Object a = b;

    /* renamed from: a  reason: collision with other field name */
    public volatile Provider<T> f6952a;

    public C1383s9(FirebasePerformance_Factory firebasePerformance_Factory) {
        this.f6952a = firebasePerformance_Factory;
    }

    public final T get() {
        boolean z;
        T t = this.a;
        T t2 = b;
        if (t == t2) {
            synchronized (this) {
                t = this.a;
                if (t == t2) {
                    t = this.f6952a.get();
                    T t3 = this.a;
                    if (t3 != t2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (t3 != t) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + t3 + " & " + t + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.a = t;
                    this.f6952a = null;
                }
            }
        }
        return t;
    }
}
