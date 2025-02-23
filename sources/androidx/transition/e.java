package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager */
public final class e {
    public static final AutoTransition a = new AutoTransition();

    /* renamed from: a  reason: collision with other field name */
    public static final ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f2535a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<ViewGroup> f2536a = new ArrayList<>();

    public static void a(ViewGroup viewGroup, Transition transition) {
        ArrayList<ViewGroup> arrayList = f2536a;
        if (!arrayList.contains(viewGroup) && viewGroup.isLaidOut()) {
            arrayList.add(viewGroup);
            if (transition == null) {
                transition = a;
            }
            Transition clone = transition.clone();
            ArrayList orDefault = b().getOrDefault(viewGroup, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator it = orDefault.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).pause(viewGroup);
                }
            }
            if (clone != null) {
                clone.captureValues(viewGroup, true);
            }
            int i = Br.transition_current_scene;
            if (((dv) viewGroup.getTag(i)) == null) {
                viewGroup.setTag(i, (Object) null);
                if (clone != null) {
                    a aVar = new a(viewGroup, clone);
                    viewGroup.addOnAttachStateChangeListener(aVar);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> b() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> threadLocal = f2535a;
        WeakReference weakReference = threadLocal.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        threadLocal.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    /* compiled from: TransitionManager */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public final ViewGroup a;

        /* renamed from: a  reason: collision with other field name */
        public final Transition f2537a;

        /* renamed from: androidx.transition.e$a$a  reason: collision with other inner class name */
        /* compiled from: TransitionManager */
        public class C0026a extends d {
            public final /* synthetic */ ArrayMap a;

            public C0026a(ArrayMap arrayMap) {
                this.a = arrayMap;
            }

            public final void onTransitionEnd(Transition transition) {
                ((ArrayList) this.a.getOrDefault(a.this.a, null)).remove(transition);
                transition.removeListener(this);
            }
        }

        public a(ViewGroup viewGroup, Transition transition) {
            this.f2537a = transition;
            this.a = viewGroup;
        }

        public final boolean onPreDraw() {
            ViewGroup viewGroup = this.a;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            if (!e.f2536a.remove(viewGroup)) {
                return true;
            }
            ArrayMap<ViewGroup, ArrayList<Transition>> b = e.b();
            ArrayList arrayList = null;
            ArrayList orDefault = b.getOrDefault(viewGroup, null);
            if (orDefault == null) {
                orDefault = new ArrayList();
                b.put(viewGroup, orDefault);
            } else if (orDefault.size() > 0) {
                arrayList = new ArrayList(orDefault);
            }
            Transition transition = this.f2537a;
            orDefault.add(transition);
            transition.addListener(new C0026a(b));
            transition.captureValues(viewGroup, false);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(viewGroup);
                }
            }
            transition.playTransition(viewGroup);
            return true;
        }

        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.a;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            e.f2536a.remove(viewGroup);
            ArrayList orDefault = e.b().getOrDefault(viewGroup, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator it = orDefault.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(viewGroup);
                }
            }
            this.f2537a.clearValues(true);
        }

        public final void onViewAttachedToWindow(View view) {
        }
    }
}
