package defpackage;

import android.view.View;
import androidx.core.view.f;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: vd  reason: default package and case insensitive filesystem */
/* compiled from: FragmentTransitionImpl */
public final class C0365vd implements Runnable {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ ArrayList f3371c;
    public final /* synthetic */ ArrayList d;

    public C0365vd(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.c = i;
        this.a = arrayList;
        this.b = arrayList2;
        this.f3371c = arrayList3;
        this.d = arrayList4;
    }

    public final void run() {
        for (int i = 0; i < this.c; i++) {
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            f.d.v((View) this.a.get(i), (String) this.b.get(i));
            f.d.v((View) this.f3371c.get(i), (String) this.d.get(i));
        }
    }
}
