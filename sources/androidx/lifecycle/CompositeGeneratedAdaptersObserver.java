package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;

/* compiled from: CompositeGeneratedAdaptersObserver.kt */
public final class CompositeGeneratedAdaptersObserver implements f {
    public final b[] a;

    public CompositeGeneratedAdaptersObserver(b[] bVarArr) {
        this.a = bVarArr;
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        new HashMap();
        b[] bVarArr = this.a;
        for (b a2 : bVarArr) {
            a2.a();
        }
        for (b a3 : bVarArr) {
            a3.a();
        }
    }
}
