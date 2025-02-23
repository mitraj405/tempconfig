package androidx.fragment.app;

import androidx.fragment.app.s;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultSpecialEffectsController */
public final class b implements Runnable {
    public final /* synthetic */ j a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ s.d f2132a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f2133a;

    public b(j jVar, ArrayList arrayList, s.d dVar) {
        this.a = jVar;
        this.f2133a = arrayList;
        this.f2132a = dVar;
    }

    public final void run() {
        List list = this.f2133a;
        s.d dVar = this.f2132a;
        if (list.contains(dVar)) {
            list.remove(dVar);
            this.a.getClass();
            dVar.f2171a.a(dVar.a.mView);
        }
    }
}
