package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.a;
import java.util.HashMap;
import java.util.List;

@Deprecated
class ReflectiveGenericLifecycleObserver implements f {
    public final a.C0021a a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f2195a;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2195a = obj;
        this.a = a.a.b(obj.getClass());
    }

    public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
        HashMap hashMap = this.a.a;
        Object obj = this.f2195a;
        a.C0021a.a((List) hashMap.get(aVar), lifecycleOwner, aVar, obj);
        a.C0021a.a((List) hashMap.get(Lifecycle.a.ON_ANY), lifecycleOwner, aVar, obj);
    }
}
