package defpackage;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: E0  reason: default package */
/* compiled from: AndroidSchedulers */
public final class E0 {
    public static final AtomicReference<E0> a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    public final C0758Yi f3571a = new C0758Yi(Looper.getMainLooper());

    public E0() {
        C1334pu.a.a().getClass();
    }

    public static C0758Yi a() {
        E0 e0;
        boolean z;
        do {
            AtomicReference<E0> atomicReference = a;
            e0 = atomicReference.get();
            if (e0 == null) {
                e0 = new E0();
                while (true) {
                    if (!atomicReference.compareAndSet((Object) null, e0)) {
                        if (atomicReference.get() != null) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                break;
            }
        } while (!z);
        return e0.f3571a;
    }
}
