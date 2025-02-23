package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: ViewModelStore.kt */
public final class ViewModelStore {
    public final LinkedHashMap a = new LinkedHashMap();

    public final void a() {
        for (C0404yC yCVar : this.a.values()) {
            yCVar.f3429a = true;
            HashMap hashMap = yCVar.a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    for (Object a2 : yCVar.a.values()) {
                        C0404yC.a(a2);
                    }
                }
            }
            LinkedHashSet linkedHashSet = yCVar.f3428a;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    for (Closeable a3 : yCVar.f3428a) {
                        C0404yC.a(a3);
                    }
                }
            }
            yCVar.b();
        }
        this.a.clear();
    }
}
