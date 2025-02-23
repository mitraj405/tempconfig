package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.f;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: DefaultItemAnimator */
public final class a extends n {
    public static TimeInterpolator a;
    public final ArrayList<RecyclerView.ViewHolder> b = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> c = new ArrayList<>();
    public final ArrayList<e> d = new ArrayList<>();
    public final ArrayList<d> e = new ArrayList<>();
    public final ArrayList<ArrayList<RecyclerView.ViewHolder>> f = new ArrayList<>();
    public final ArrayList<ArrayList<e>> g = new ArrayList<>();
    public final ArrayList<ArrayList<d>> h = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> i = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> j = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> k = new ArrayList<>();
    public final ArrayList<RecyclerView.ViewHolder> l = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    /* compiled from: DefaultItemAnimator */
    public class C0024a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2365a;

        public C0024a(ArrayList arrayList) {
            this.f2365a = arrayList;
        }

        public final void run() {
            ArrayList arrayList = this.f2365a;
            Iterator it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                a aVar = a.this;
                if (hasNext) {
                    e eVar = (e) it.next();
                    RecyclerView.ViewHolder viewHolder = eVar.f2370a;
                    aVar.getClass();
                    View view = viewHolder.itemView;
                    int i = eVar.c - eVar.a;
                    int i2 = eVar.d - eVar.b;
                    if (i != 0) {
                        view.animate().translationX(0.0f);
                    }
                    if (i2 != 0) {
                        view.animate().translationY(0.0f);
                    }
                    ViewPropertyAnimator animate = view.animate();
                    aVar.j.add(viewHolder);
                    animate.setDuration(aVar.c).setListener(new d(aVar, viewHolder, i, view, i2, animate)).start();
                } else {
                    arrayList.clear();
                    aVar.g.remove(arrayList);
                    return;
                }
            }
        }
    }

    /* compiled from: DefaultItemAnimator */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2366a;

        public b(ArrayList arrayList) {
            this.f2366a = arrayList;
        }

        public final void run() {
            View view;
            ArrayList arrayList = this.f2366a;
            Iterator it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                a aVar = a.this;
                if (hasNext) {
                    d dVar = (d) it.next();
                    aVar.getClass();
                    RecyclerView.ViewHolder viewHolder = dVar.f2368a;
                    View view2 = null;
                    if (viewHolder == null) {
                        view = null;
                    } else {
                        view = viewHolder.itemView;
                    }
                    RecyclerView.ViewHolder viewHolder2 = dVar.f2369b;
                    if (viewHolder2 != null) {
                        view2 = viewHolder2.itemView;
                    }
                    ArrayList<RecyclerView.ViewHolder> arrayList2 = aVar.l;
                    long j = aVar.d;
                    if (view != null) {
                        ViewPropertyAnimator duration = view.animate().setDuration(j);
                        arrayList2.add(dVar.f2368a);
                        duration.translationX((float) (dVar.c - dVar.a));
                        duration.translationY((float) (dVar.d - dVar.b));
                        duration.alpha(0.0f).setListener(new e(aVar, dVar, duration, view)).start();
                    }
                    if (view2 != null) {
                        ViewPropertyAnimator animate = view2.animate();
                        arrayList2.add(dVar.f2369b);
                        animate.translationX(0.0f).translationY(0.0f).setDuration(j).alpha(1.0f).setListener(new f(aVar, dVar, animate, view2)).start();
                    }
                } else {
                    arrayList.clear();
                    aVar.h.remove(arrayList);
                    return;
                }
            }
        }
    }

    /* compiled from: DefaultItemAnimator */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2367a;

        public c(ArrayList arrayList) {
            this.f2367a = arrayList;
        }

        public final void run() {
            ArrayList arrayList = this.f2367a;
            Iterator it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                a aVar = a.this;
                if (hasNext) {
                    RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it.next();
                    aVar.getClass();
                    View view = viewHolder.itemView;
                    ViewPropertyAnimator animate = view.animate();
                    aVar.i.add(viewHolder);
                    animate.alpha(1.0f).setDuration(aVar.a).setListener(new c(view, animate, aVar, viewHolder)).start();
                } else {
                    arrayList.clear();
                    aVar.f.remove(arrayList);
                    return;
                }
            }
        }
    }

    /* compiled from: DefaultItemAnimator */
    public static class d {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public RecyclerView.ViewHolder f2368a;
        public final int b;

        /* renamed from: b  reason: collision with other field name */
        public RecyclerView.ViewHolder f2369b;
        public final int c;
        public final int d;

        public d(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this.f2368a = viewHolder;
            this.f2369b = viewHolder2;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @SuppressLint({"UnknownNullness"})
        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.f2368a + ", newHolder=" + this.f2369b + ", fromX=" + this.a + ", fromY=" + this.b + ", toX=" + this.c + ", toY=" + this.d + '}';
        }
    }

    /* compiled from: DefaultItemAnimator */
    public static class e {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final RecyclerView.ViewHolder f2370a;
        public final int b;
        public final int c;
        public final int d;

        public e(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.f2370a = viewHolder;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public static void n(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                ((RecyclerView.ViewHolder) arrayList.get(size)).itemView.animate().cancel();
            } else {
                return;
            }
        }
    }

    public final boolean g(RecyclerView.ViewHolder viewHolder, List<Object> list) {
        if (!list.isEmpty() || f(viewHolder)) {
            return true;
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public final void i(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        ArrayList<e> arrayList = this.d;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (arrayList.get(size).f2370a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                h(viewHolder);
                arrayList.remove(size);
            }
        }
        p(viewHolder, this.e);
        if (this.b.remove(viewHolder)) {
            view.setAlpha(1.0f);
            h(viewHolder);
        }
        if (this.c.remove(viewHolder)) {
            view.setAlpha(1.0f);
            h(viewHolder);
        }
        ArrayList<ArrayList<d>> arrayList2 = this.h;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList arrayList3 = arrayList2.get(size2);
            p(viewHolder, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList<ArrayList<e>> arrayList4 = this.g;
        int size3 = arrayList4.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList arrayList5 = arrayList4.get(size3);
            int size4 = arrayList5.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (((e) arrayList5.get(size4)).f2370a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    h(viewHolder);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                }
            }
        }
        ArrayList<ArrayList<RecyclerView.ViewHolder>> arrayList6 = this.f;
        int size5 = arrayList6.size();
        while (true) {
            size5--;
            if (size5 >= 0) {
                ArrayList arrayList7 = arrayList6.get(size5);
                if (arrayList7.remove(viewHolder)) {
                    view.setAlpha(1.0f);
                    h(viewHolder);
                    if (arrayList7.isEmpty()) {
                        arrayList6.remove(size5);
                    }
                }
            } else {
                this.k.remove(viewHolder);
                this.i.remove(viewHolder);
                this.l.remove(viewHolder);
                this.j.remove(viewHolder);
                o();
                return;
            }
        }
    }

    public final void j() {
        ArrayList<e> arrayList = this.d;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            e eVar = arrayList.get(size);
            View view = eVar.f2370a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            h(eVar.f2370a);
            arrayList.remove(size);
        }
        ArrayList<RecyclerView.ViewHolder> arrayList2 = this.b;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            h(arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList<RecyclerView.ViewHolder> arrayList3 = this.c;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = arrayList3.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            h(viewHolder);
            arrayList3.remove(size3);
        }
        ArrayList<d> arrayList4 = this.e;
        int size4 = arrayList4.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            d dVar = arrayList4.get(size4);
            RecyclerView.ViewHolder viewHolder2 = dVar.f2368a;
            if (viewHolder2 != null) {
                q(dVar, viewHolder2);
            }
            RecyclerView.ViewHolder viewHolder3 = dVar.f2369b;
            if (viewHolder3 != null) {
                q(dVar, viewHolder3);
            }
        }
        arrayList4.clear();
        if (k()) {
            ArrayList<ArrayList<e>> arrayList5 = this.g;
            int size5 = arrayList5.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList arrayList6 = arrayList5.get(size5);
                int size6 = arrayList6.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        e eVar2 = (e) arrayList6.get(size6);
                        View view2 = eVar2.f2370a.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        h(eVar2.f2370a);
                        arrayList6.remove(size6);
                        if (arrayList6.isEmpty()) {
                            arrayList5.remove(arrayList6);
                        }
                    }
                }
            }
            ArrayList<ArrayList<RecyclerView.ViewHolder>> arrayList7 = this.f;
            int size7 = arrayList7.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList arrayList8 = arrayList7.get(size7);
                int size8 = arrayList8.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        RecyclerView.ViewHolder viewHolder4 = (RecyclerView.ViewHolder) arrayList8.get(size8);
                        viewHolder4.itemView.setAlpha(1.0f);
                        h(viewHolder4);
                        arrayList8.remove(size8);
                        if (arrayList8.isEmpty()) {
                            arrayList7.remove(arrayList8);
                        }
                    }
                }
            }
            ArrayList<ArrayList<d>> arrayList9 = this.h;
            int size9 = arrayList9.size();
            while (true) {
                size9--;
                if (size9 < 0) {
                    break;
                }
                ArrayList arrayList10 = arrayList9.get(size9);
                int size10 = arrayList10.size();
                while (true) {
                    size10--;
                    if (size10 >= 0) {
                        d dVar2 = (d) arrayList10.get(size10);
                        RecyclerView.ViewHolder viewHolder5 = dVar2.f2368a;
                        if (viewHolder5 != null) {
                            q(dVar2, viewHolder5);
                        }
                        RecyclerView.ViewHolder viewHolder6 = dVar2.f2369b;
                        if (viewHolder6 != null) {
                            q(dVar2, viewHolder6);
                        }
                        if (arrayList10.isEmpty()) {
                            arrayList9.remove(arrayList10);
                        }
                    }
                }
            }
            n(this.k);
            n(this.j);
            n(this.i);
            n(this.l);
            ArrayList<RecyclerView.ItemAnimator.a> arrayList11 = this.f2305a;
            int size11 = arrayList11.size();
            for (int i2 = 0; i2 < size11; i2++) {
                arrayList11.get(i2).a();
            }
            arrayList11.clear();
        }
    }

    public final boolean k() {
        if (!this.c.isEmpty() || !this.e.isEmpty() || !this.d.isEmpty() || !this.b.isEmpty() || !this.j.isEmpty() || !this.k.isEmpty() || !this.i.isEmpty() || !this.l.isEmpty() || !this.g.isEmpty() || !this.f.isEmpty() || !this.h.isEmpty()) {
            return true;
        }
        return false;
    }

    public final void l() {
        long j2;
        long j3;
        ArrayList<RecyclerView.ViewHolder> arrayList = this.b;
        boolean z = !arrayList.isEmpty();
        ArrayList<e> arrayList2 = this.d;
        boolean z2 = !arrayList2.isEmpty();
        ArrayList<d> arrayList3 = this.e;
        boolean z3 = !arrayList3.isEmpty();
        ArrayList<RecyclerView.ViewHolder> arrayList4 = this.c;
        boolean z4 = !arrayList4.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                j2 = this.b;
                if (!hasNext) {
                    break;
                }
                RecyclerView.ViewHolder next = it.next();
                View view = next.itemView;
                ViewPropertyAnimator animate = view.animate();
                this.k.add(next);
                animate.setDuration(j2).alpha(0.0f).setListener(new b(view, animate, this, next)).start();
            }
            arrayList.clear();
            if (z2) {
                ArrayList arrayList5 = new ArrayList();
                arrayList5.addAll(arrayList2);
                this.g.add(arrayList5);
                arrayList2.clear();
                C0024a aVar = new C0024a(arrayList5);
                if (z) {
                    View view2 = ((e) arrayList5.get(0)).f2370a.itemView;
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    view2.postOnAnimationDelayed(aVar, j2);
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList arrayList6 = new ArrayList();
                arrayList6.addAll(arrayList3);
                this.h.add(arrayList6);
                arrayList3.clear();
                b bVar = new b(arrayList6);
                if (z) {
                    View view3 = ((d) arrayList6.get(0)).f2368a.itemView;
                    WeakHashMap<View, GC> weakHashMap2 = f.f1839a;
                    view3.postOnAnimationDelayed(bVar, j2);
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList arrayList7 = new ArrayList();
                arrayList7.addAll(arrayList4);
                this.f.add(arrayList7);
                arrayList4.clear();
                c cVar = new c(arrayList7);
                if (z || z2 || z3) {
                    long j4 = 0;
                    if (!z) {
                        j2 = 0;
                    }
                    if (z2) {
                        j3 = this.c;
                    } else {
                        j3 = 0;
                    }
                    if (z3) {
                        j4 = this.d;
                    }
                    View view4 = ((RecyclerView.ViewHolder) arrayList7.get(0)).itemView;
                    WeakHashMap<View, GC> weakHashMap3 = f.f1839a;
                    view4.postOnAnimationDelayed(cVar, Math.max(j3, j4) + j2);
                    return;
                }
                cVar.run();
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public final boolean m(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
        r(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            h(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.d.add(new e(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    public final void o() {
        if (!k()) {
            ArrayList<RecyclerView.ItemAnimator.a> arrayList = this.f2305a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2).a();
            }
            arrayList.clear();
        }
    }

    public final void p(RecyclerView.ViewHolder viewHolder, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                d dVar = (d) arrayList.get(size);
                if (q(dVar, viewHolder) && dVar.f2368a == null && dVar.f2369b == null) {
                    arrayList.remove(dVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean q(d dVar, RecyclerView.ViewHolder viewHolder) {
        if (dVar.f2369b == viewHolder) {
            dVar.f2369b = null;
        } else if (dVar.f2368a != viewHolder) {
            return false;
        } else {
            dVar.f2368a = null;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        h(viewHolder);
        return true;
    }

    public final void r(RecyclerView.ViewHolder viewHolder) {
        if (a == null) {
            a = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(a);
        i(viewHolder);
    }
}
