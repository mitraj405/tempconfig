package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class MenuHostHelper {
    public final Runnable a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f1796a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final CopyOnWriteArrayList<MenuProvider> f1797a = new CopyOnWriteArrayList<>();

    public static class a {
        public final Lifecycle a;

        /* renamed from: a  reason: collision with other field name */
        public f f1798a;

        public a(Lifecycle lifecycle, f fVar) {
            this.a = lifecycle;
            this.f1798a = fVar;
            lifecycle.a(fVar);
        }
    }

    public MenuHostHelper(Runnable runnable) {
        this.a = runnable;
    }

    public final void a(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.f1797a.add(menuProvider);
        this.a.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = this.f1796a;
        a aVar = (a) hashMap.remove(menuProvider);
        if (aVar != null) {
            aVar.a.c(aVar.f1798a);
            aVar.f1798a = null;
        }
        hashMap.put(menuProvider, new a(lifecycle, new Wk(this, menuProvider)));
    }

    @SuppressLint({"LambdaLast"})
    public final void b(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = this.f1796a;
        a aVar = (a) hashMap.remove(menuProvider);
        if (aVar != null) {
            aVar.a.c(aVar.f1798a);
            aVar.f1798a = null;
        }
        hashMap.put(menuProvider, new a(lifecycle, new Xk(this, state, menuProvider)));
    }

    public final void c(MenuProvider menuProvider) {
        this.f1797a.remove(menuProvider);
        a aVar = (a) this.f1796a.remove(menuProvider);
        if (aVar != null) {
            aVar.a.c(aVar.f1798a);
            aVar.f1798a = null;
        }
        this.a.run();
    }
}
