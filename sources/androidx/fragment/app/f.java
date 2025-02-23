package androidx.fragment.app;

import androidx.collection.ArrayMap;
import androidx.fragment.app.s;

/* compiled from: DefaultSpecialEffectsController */
public final class f implements Runnable {
    public final /* synthetic */ ArrayMap a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ s.d f2142a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f2143a;
    public final /* synthetic */ s.d b;

    public f(s.d dVar, s.d dVar2, boolean z, ArrayMap arrayMap) {
        this.f2142a = dVar;
        this.b = dVar2;
        this.f2143a = z;
        this.a = arrayMap;
    }

    public final void run() {
        r.a(this.f2142a.a, this.b.a, this.f2143a, this.a);
    }
}
