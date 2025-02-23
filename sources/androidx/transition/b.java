package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport */
public class b extends C0379wd {

    /* renamed from: androidx.transition.b$b  reason: collision with other inner class name */
    /* compiled from: FragmentTransitionSupport */
    public class C0025b extends d {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Object f2531a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2532a;
        public final /* synthetic */ Object b;

        /* renamed from: b  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2533b;
        public final /* synthetic */ Object c;

        /* renamed from: c  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2534c;

        public C0025b(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f2531a = obj;
            this.f2532a = arrayList;
            this.b = obj2;
            this.f2533b = arrayList2;
            this.c = obj3;
            this.f2534c = arrayList3;
        }

        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public final void onTransitionStart(Transition transition) {
            b bVar = b.this;
            Object obj = this.f2531a;
            if (obj != null) {
                bVar.v(obj, this.f2532a, (ArrayList<View>) null);
            }
            Object obj2 = this.b;
            if (obj2 != null) {
                bVar.v(obj2, this.f2533b, (ArrayList<View>) null);
            }
            Object obj3 = this.c;
            if (obj3 != null) {
                bVar.v(obj3, this.f2534c, (ArrayList<View>) null);
            }
        }
    }

    /* compiled from: FragmentTransitionSupport */
    public class c extends Transition.EpicenterCallback {
        public final /* synthetic */ Rect a;

        public c(Rect rect) {
            this.a = rect;
        }

        public final Rect a() {
            Rect rect = this.a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return rect;
        }
    }

    public static boolean u(Transition transition) {
        if (!C0379wd.h(transition.getTargetIds()) || !C0379wd.h(transition.getTargetNames()) || !C0379wd.h(transition.getTargetTypes())) {
            return true;
        }
        return false;
    }

    public final void a(View view, Object obj) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public final void b(Object obj, ArrayList<View> arrayList) {
        Transition transition;
        Transition transition2 = (Transition) obj;
        if (transition2 != null) {
            int i = 0;
            if (transition2 instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition2;
                int size = transitionSet.a.size();
                while (i < size) {
                    if (i < 0 || i >= transitionSet.a.size()) {
                        transition = null;
                    } else {
                        transition = transitionSet.a.get(i);
                    }
                    b(transition, arrayList);
                    i++;
                }
            } else if (!u(transition2) && C0379wd.h(transition2.getTargets())) {
                int size2 = arrayList.size();
                while (i < size2) {
                    transition2.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    public final void c(ViewGroup viewGroup, Object obj) {
        e.a(viewGroup, (Transition) obj);
    }

    public final boolean e(Object obj) {
        return obj instanceof Transition;
    }

    public final Object f(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public final Object i(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.a(transition);
            transitionSet.a(transition2);
            transitionSet.e(1);
            transition = transitionSet;
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet2 = new TransitionSet();
        if (transition != null) {
            transitionSet2.a(transition);
        }
        transitionSet2.a(transition3);
        return transitionSet2;
    }

    public final Object j(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.a((Transition) obj3);
        }
        return transitionSet;
    }

    public final void l(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new a(view, arrayList));
    }

    public final void m(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C0025b(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public final void n(View view, Object obj) {
        if (view != null) {
            Rect rect = new Rect();
            C0379wd.g(rect, view);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    public final void o(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new c(rect));
        }
    }

    public final void p(Object obj, A4 a4, Runnable runnable) {
        Transition transition = (Transition) obj;
        a4.b(new C0393xd(transition, runnable));
        transition.addListener(new c(runnable));
    }

    public final void r(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0379wd.d(arrayList.get(i), targets);
        }
        targets.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    public final void s(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            v(transitionSet, arrayList, arrayList2);
        }
    }

    public final Object t(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.a((Transition) obj);
        return transitionSet;
    }

    public final void v(Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        int i;
        Transition transition;
        Transition transition2 = (Transition) obj;
        int i2 = 0;
        if (transition2 instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition2;
            int size = transitionSet.a.size();
            while (i2 < size) {
                if (i2 < 0 || i2 >= transitionSet.a.size()) {
                    transition = null;
                } else {
                    transition = transitionSet.a.get(i2);
                }
                v(transition, arrayList, arrayList2);
                i2++;
            }
        } else if (!u(transition2)) {
            List<View> targets = transition2.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    transition2.addTarget(arrayList2.get(i2));
                    i2++;
                }
                int size2 = arrayList.size();
                while (true) {
                    size2--;
                    if (size2 >= 0) {
                        transition2.removeTarget(arrayList.get(size2));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: FragmentTransitionSupport */
    public class a implements Transition.TransitionListener {
        public final /* synthetic */ View a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ ArrayList f2530a;

        public a(View view, ArrayList arrayList) {
            this.a = view;
            this.f2530a = arrayList;
        }

        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.a.setVisibility(8);
            ArrayList arrayList = this.f2530a;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((View) arrayList.get(i)).setVisibility(0);
            }
        }

        public final void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionPause(Transition transition) {
        }

        public final void onTransitionResume(Transition transition) {
        }
    }
}
