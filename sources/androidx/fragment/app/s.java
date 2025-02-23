package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.f;
import androidx.fragment.app.FragmentManager;
import defpackage.A4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: SpecialEffectsController */
public abstract class s {
    public final ViewGroup a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<d> f2165a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2166a = false;
    public final ArrayList<d> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f2167b = false;

    /* compiled from: SpecialEffectsController */
    public class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public final void run() {
            ArrayList<d> arrayList = s.this.f2165a;
            c cVar = this.a;
            if (arrayList.contains(cVar)) {
                cVar.f2171a.a(cVar.a.mView);
            }
        }
    }

    /* compiled from: SpecialEffectsController */
    public class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c cVar) {
            this.a = cVar;
        }

        public final void run() {
            s sVar = s.this;
            ArrayList<d> arrayList = sVar.f2165a;
            c cVar = this.a;
            arrayList.remove(cVar);
            sVar.b.remove(cVar);
        }
    }

    /* compiled from: SpecialEffectsController */
    public static class c extends d {
        public final p a;

        public c(d.c cVar, d.b bVar, p pVar, A4 a4) {
            super(cVar, bVar, pVar.f2158a, a4);
            this.a = pVar;
        }

        public final void b() {
            super.b();
            this.a.j();
        }

        public final void d() {
            if (this.f2170a == d.b.ADDING) {
                p pVar = this.a;
                Fragment fragment = pVar.f2158a;
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (FragmentManager.K(2)) {
                        findFocus.toString();
                        fragment.toString();
                    }
                }
                View requireView = this.a.requireView();
                if (requireView.getParent() == null) {
                    pVar.a();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            }
        }
    }

    public s(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static s f(ViewGroup viewGroup, Dx dx) {
        int i = Lr.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i);
        if (tag instanceof s) {
            return (s) tag;
        }
        ((FragmentManager.f) dx).getClass();
        j jVar = new j(viewGroup);
        viewGroup.setTag(i, jVar);
        return jVar;
    }

    public static s g(ViewGroup viewGroup, FragmentManager fragmentManager) {
        return f(viewGroup, fragmentManager.J());
    }

    public final void a(d.c cVar, d.b bVar, p pVar) {
        synchronized (this.f2165a) {
            A4 a4 = new A4();
            d d2 = d(pVar.f2158a);
            if (d2 != null) {
                d2.c(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, pVar, a4);
            this.f2165a.add(cVar2);
            cVar2.f2172a.add(new a(cVar2));
            cVar2.f2172a.add(new b(cVar2));
        }
    }

    public abstract void b(ArrayList arrayList, boolean z);

    public final void c() {
        if (!this.f2167b) {
            ViewGroup viewGroup = this.a;
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            if (!viewGroup.isAttachedToWindow()) {
                e();
                this.f2166a = false;
                return;
            }
            synchronized (this.f2165a) {
                if (!this.f2165a.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.b);
                    this.b.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        if (FragmentManager.K(2)) {
                            Objects.toString(dVar);
                        }
                        dVar.a();
                        if (!dVar.b) {
                            this.b.add(dVar);
                        }
                    }
                    i();
                    ArrayList arrayList2 = new ArrayList(this.f2165a);
                    this.f2165a.clear();
                    this.b.addAll(arrayList2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((d) it2.next()).d();
                    }
                    b(arrayList2, this.f2166a);
                    this.f2166a = false;
                }
            }
        }
    }

    public final d d(Fragment fragment) {
        Iterator<d> it = this.f2165a.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.a.equals(fragment) && !next.f2174a) {
                return next;
            }
        }
        return null;
    }

    public final void e() {
        ViewGroup viewGroup = this.a;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.f2165a) {
            i();
            Iterator<d> it = this.f2165a.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.b).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (FragmentManager.K(2)) {
                    if (!isAttachedToWindow) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Container ");
                        sb.append(this.a);
                        sb.append(" is not attached to window. ");
                    }
                    Objects.toString(dVar);
                }
                dVar.a();
            }
            Iterator it3 = new ArrayList(this.f2165a).iterator();
            while (it3.hasNext()) {
                d dVar2 = (d) it3.next();
                if (FragmentManager.K(2)) {
                    if (!isAttachedToWindow) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Container ");
                        sb2.append(this.a);
                        sb2.append(" is not attached to window. ");
                    }
                    Objects.toString(dVar2);
                }
                dVar2.a();
            }
        }
    }

    public final void h() {
        synchronized (this.f2165a) {
            i();
            this.f2167b = false;
            int size = this.f2165a.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.f2165a.get(size);
                d.c i = d.c.i(dVar.a.mView);
                d.c cVar = dVar.f2171a;
                d.c cVar2 = d.c.VISIBLE;
                if (cVar == cVar2 && i != cVar2) {
                    this.f2167b = dVar.a.isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public final void i() {
        Iterator<d> it = this.f2165a.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f2170a == d.b.ADDING) {
                next.c(d.c.f(next.a.requireView().getVisibility()), d.b.NONE);
            }
        }
    }

    /* compiled from: SpecialEffectsController */
    public static class d {
        public final Fragment a;

        /* renamed from: a  reason: collision with other field name */
        public b f2170a;

        /* renamed from: a  reason: collision with other field name */
        public c f2171a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList f2172a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        public final HashSet<A4> f2173a = new HashSet<>();

        /* renamed from: a  reason: collision with other field name */
        public boolean f2174a = false;
        public boolean b = false;

        /* compiled from: SpecialEffectsController */
        public class a implements A4.a {
            public a() {
            }

            public final void onCancel() {
                d.this.a();
            }
        }

        /* compiled from: SpecialEffectsController */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* compiled from: SpecialEffectsController */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c f(int i) {
                if (i == 0) {
                    return VISIBLE;
                }
                if (i == 4) {
                    return INVISIBLE;
                }
                if (i == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException(lf.h("Unknown visibility ", i));
            }

            public static c i(View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return f(view.getVisibility());
            }

            public final void a(View view) {
                int ordinal = ordinal();
                if (ordinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.K(2)) {
                            view.toString();
                            viewGroup.toString();
                        }
                        viewGroup.removeView(view);
                    }
                } else if (ordinal == 1) {
                    if (FragmentManager.K(2)) {
                        Objects.toString(view);
                    }
                    view.setVisibility(0);
                } else if (ordinal == 2) {
                    if (FragmentManager.K(2)) {
                        Objects.toString(view);
                    }
                    view.setVisibility(8);
                } else if (ordinal == 3) {
                    if (FragmentManager.K(2)) {
                        Objects.toString(view);
                    }
                    view.setVisibility(4);
                }
            }
        }

        public d(c cVar, b bVar, Fragment fragment, A4 a4) {
            this.f2171a = cVar;
            this.f2170a = bVar;
            this.a = fragment;
            a4.b(new a());
        }

        public final void a() {
            if (!this.f2174a) {
                this.f2174a = true;
                HashSet<A4> hashSet = this.f2173a;
                if (hashSet.isEmpty()) {
                    b();
                    return;
                }
                Iterator it = new ArrayList(hashSet).iterator();
                while (it.hasNext()) {
                    ((A4) it.next()).a();
                }
            }
        }

        public void b() {
            if (!this.b) {
                if (FragmentManager.K(2)) {
                    toString();
                }
                this.b = true;
                Iterator it = this.f2172a.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }

        public final void c(c cVar, b bVar) {
            int ordinal = bVar.ordinal();
            c cVar2 = c.REMOVED;
            Fragment fragment = this.a;
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        if (FragmentManager.K(2)) {
                            Objects.toString(fragment);
                            Objects.toString(this.f2171a);
                            Objects.toString(this.f2170a);
                        }
                        this.f2171a = cVar2;
                        this.f2170a = b.REMOVING;
                    }
                } else if (this.f2171a == cVar2) {
                    if (FragmentManager.K(2)) {
                        Objects.toString(fragment);
                        Objects.toString(this.f2170a);
                    }
                    this.f2171a = c.VISIBLE;
                    this.f2170a = b.ADDING;
                }
            } else if (this.f2171a != cVar2) {
                if (FragmentManager.K(2)) {
                    Objects.toString(fragment);
                    Objects.toString(this.f2171a);
                    Objects.toString(cVar);
                }
                this.f2171a = cVar;
            }
        }

        public final String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2171a + "} {mLifecycleImpact = " + this.f2170a + "} {mFragment = " + this.a + "}";
        }

        public void d() {
        }
    }
}
