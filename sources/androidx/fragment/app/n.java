package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.perf.application.FragmentStateMonitor;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentLifecycleCallbacksDispatcher */
public final class n {
    public final FragmentManager a;

    /* renamed from: a  reason: collision with other field name */
    public final CopyOnWriteArrayList<a> f2153a = new CopyOnWriteArrayList<>();

    /* compiled from: FragmentLifecycleCallbacksDispatcher */
    public static final class a {
        public final FragmentManager.l a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2154a = true;

        public a(FragmentStateMonitor fragmentStateMonitor) {
            this.a = fragmentStateMonitor;
        }
    }

    public n(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    public final void a(Fragment fragment, Bundle bundle, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.a(fragment, bundle, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentActivityCreated(fragmentManager, fragment, bundle);
            }
        }
    }

    public final void b(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Context context = fragmentManager.f2073a.f2066a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.b(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentAttached(fragmentManager, fragment, context);
            }
        }
    }

    public final void c(Fragment fragment, Bundle bundle, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.c(fragment, bundle, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentCreated(fragmentManager, fragment, bundle);
            }
        }
    }

    public final void d(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.d(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentDestroyed(fragmentManager, fragment);
            }
        }
    }

    public final void e(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.e(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentDetached(fragmentManager, fragment);
            }
        }
    }

    public final void f(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.f(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentPaused(fragmentManager, fragment);
            }
        }
    }

    public final void g(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Context context = fragmentManager.f2073a.f2066a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.g(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentPreAttached(fragmentManager, fragment, context);
            }
        }
    }

    public final void h(Fragment fragment, Bundle bundle, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.h(fragment, bundle, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentPreCreated(fragmentManager, fragment, bundle);
            }
        }
    }

    public final void i(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.i(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentResumed(fragmentManager, fragment);
            }
        }
    }

    public final void j(Fragment fragment, Bundle bundle, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.j(fragment, bundle, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentSaveInstanceState(fragmentManager, fragment, bundle);
            }
        }
    }

    public final void k(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.k(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentStarted(fragmentManager, fragment);
            }
        }
    }

    public final void l(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.l(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentStopped(fragmentManager, fragment);
            }
        }
    }

    public final void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
            }
        }
    }

    public final void n(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.a;
        Fragment fragment2 = fragmentManager.f2071a;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().f2079a.n(fragment, true);
        }
        Iterator<a> it = this.f2153a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f2154a) {
                next.a.onFragmentViewDestroyed(fragmentManager, fragment);
            }
        }
    }
}
