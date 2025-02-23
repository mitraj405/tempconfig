package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;

public final class WindowInsetsAnimationCompat {
    public final d a;

    public static class b extends d {
        public static final C0102Ub a = new C0102Ub();

        /* renamed from: a  reason: collision with other field name */
        public static final DecelerateInterpolator f1802a = new DecelerateInterpolator();

        /* renamed from: a  reason: collision with other field name */
        public static final PathInterpolator f1803a = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        public static class a implements View.OnApplyWindowInsetsListener {
            public final a a;

            /* renamed from: a  reason: collision with other field name */
            public WindowInsetsCompat f1804a;

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$b$a$a  reason: collision with other inner class name */
            public class C0010a implements ValueAnimator.AnimatorUpdateListener {
                public final /* synthetic */ int a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ View f1805a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ WindowInsetsAnimationCompat f1806a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ WindowInsetsCompat f1807a;
                public final /* synthetic */ WindowInsetsCompat b;

                public C0010a(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, int i, View view) {
                    this.f1806a = windowInsetsAnimationCompat;
                    this.f1807a = windowInsetsCompat;
                    this.b = windowInsetsCompat2;
                    this.a = i;
                    this.f1805a = view;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WindowInsetsCompat.e eVar;
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.f1806a;
                    windowInsetsAnimationCompat.a.d(animatedFraction);
                    float b2 = windowInsetsAnimationCompat.a.b();
                    PathInterpolator pathInterpolator = b.f1803a;
                    int i = Build.VERSION.SDK_INT;
                    WindowInsetsCompat windowInsetsCompat = this.f1807a;
                    if (i >= 30) {
                        eVar = new WindowInsetsCompat.d(windowInsetsCompat);
                    } else if (i >= 29) {
                        eVar = new WindowInsetsCompat.c(windowInsetsCompat);
                    } else {
                        eVar = new WindowInsetsCompat.b(windowInsetsCompat);
                    }
                    for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                        if ((this.a & i2) == 0) {
                            eVar.c(i2, windowInsetsCompat.a(i2));
                        } else {
                            bg a2 = windowInsetsCompat.a(i2);
                            bg a3 = this.b.a(i2);
                            float f = 1.0f - b2;
                            eVar.c(i2, WindowInsetsCompat.f(a2, (int) (((double) (((float) (a2.f2741a - a3.f2741a)) * f)) + 0.5d), (int) (((double) (((float) (a2.b - a3.b)) * f)) + 0.5d), (int) (((double) (((float) (a2.c - a3.c)) * f)) + 0.5d), (int) (((double) (((float) (a2.d - a3.d)) * f)) + 0.5d)));
                        }
                    }
                    b.g(this.f1805a, eVar.b(), Collections.singletonList(windowInsetsAnimationCompat));
                }
            }

            /* renamed from: androidx.core.view.WindowInsetsAnimationCompat$b$a$b  reason: collision with other inner class name */
            public class C0011b extends AnimatorListenerAdapter {
                public final /* synthetic */ View a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ WindowInsetsAnimationCompat f1808a;

                public C0011b(WindowInsetsAnimationCompat windowInsetsAnimationCompat, View view) {
                    this.f1808a = windowInsetsAnimationCompat;
                    this.a = view;
                }

                public final void onAnimationEnd(Animator animator) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.f1808a;
                    windowInsetsAnimationCompat.a.d(1.0f);
                    b.e(this.a, windowInsetsAnimationCompat);
                }
            }

            public class c implements Runnable {
                public final /* synthetic */ ValueAnimator a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ View f1809a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ BoundsCompat f1810a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ WindowInsetsAnimationCompat f1811a;

                public c(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat, ValueAnimator valueAnimator) {
                    this.f1809a = view;
                    this.f1811a = windowInsetsAnimationCompat;
                    this.f1810a = boundsCompat;
                    this.a = valueAnimator;
                }

                public final void run() {
                    b.h(this.f1809a, this.f1811a, this.f1810a);
                    this.a.start();
                }
            }

            public a(View view, a aVar) {
                WindowInsetsCompat windowInsetsCompat;
                WindowInsetsCompat.e eVar;
                this.a = aVar;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                WindowInsetsCompat a2 = f.e.a(view);
                if (a2 != null) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 30) {
                        eVar = new WindowInsetsCompat.d(a2);
                    } else if (i >= 29) {
                        eVar = new WindowInsetsCompat.c(a2);
                    } else {
                        eVar = new WindowInsetsCompat.b(a2);
                    }
                    windowInsetsCompat = eVar.b();
                } else {
                    windowInsetsCompat = null;
                }
                this.f1804a = windowInsetsCompat;
            }

            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                Interpolator interpolator;
                View view2 = view;
                WindowInsets windowInsets2 = windowInsets;
                if (!view.isLaidOut()) {
                    this.f1804a = WindowInsetsCompat.i(view, windowInsets);
                    return b.i(view, windowInsets);
                }
                WindowInsetsCompat i = WindowInsetsCompat.i(view, windowInsets);
                if (this.f1804a == null) {
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    this.f1804a = f.e.a(view);
                }
                if (this.f1804a == null) {
                    this.f1804a = i;
                    return b.i(view, windowInsets);
                }
                a j = b.j(view);
                if (j != null && Objects.equals(j.mDispachedInsets, windowInsets2)) {
                    return b.i(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat = this.f1804a;
                int i2 = 0;
                for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                    if (!i.a(i3).equals(windowInsetsCompat.a(i3))) {
                        i2 |= i3;
                    }
                }
                if (i2 == 0) {
                    return b.i(view, windowInsets);
                }
                WindowInsetsCompat windowInsetsCompat2 = this.f1804a;
                if ((i2 & 8) == 0) {
                    interpolator = b.f1802a;
                } else if (i.a(8).d > windowInsetsCompat2.a(8).d) {
                    interpolator = b.f1803a;
                } else {
                    interpolator = b.a;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i2, interpolator, 160);
                d dVar = windowInsetsAnimationCompat.a;
                dVar.d(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(dVar.a());
                bg a2 = i.a(i2);
                bg a3 = windowInsetsCompat2.a(i2);
                int min = Math.min(a2.f2741a, a3.f2741a);
                int i4 = a2.b;
                int i5 = a3.b;
                int min2 = Math.min(i4, i5);
                int i6 = a2.c;
                int i7 = a3.c;
                int min3 = Math.min(i6, i7);
                ValueAnimator valueAnimator = duration;
                int i8 = a2.d;
                int i9 = i2;
                int i10 = a3.d;
                BoundsCompat boundsCompat = new BoundsCompat(bg.b(min, min2, min3, Math.min(i8, i10)), bg.b(Math.max(a2.f2741a, a3.f2741a), Math.max(i4, i5), Math.max(i6, i7), Math.max(i8, i10)));
                b.f(view2, windowInsetsAnimationCompat, windowInsets2, false);
                ValueAnimator valueAnimator2 = valueAnimator;
                valueAnimator2.addUpdateListener(new C0010a(windowInsetsAnimationCompat, i, windowInsetsCompat2, i9, view));
                valueAnimator2.addListener(new C0011b(windowInsetsAnimationCompat, view2));
                C0184eo.a(view2, new c(view2, windowInsetsAnimationCompat, boundsCompat, valueAnimator2));
                this.f1804a = i;
                return b.i(view, windowInsets);
            }
        }

        public b(int i, Interpolator interpolator, long j) {
            super(i, interpolator, j);
        }

        public static void e(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            a j = j(view);
            if (j != null) {
                j.onEnd(windowInsetsAnimationCompat);
                if (j.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    e(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
                }
            }
        }

        public static void f(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            a j = j(view);
            if (j != null) {
                j.mDispachedInsets = windowInsets;
                if (!z) {
                    j.onPrepare(windowInsetsAnimationCompat);
                    if (j.getDispatchMode() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    f(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z);
                }
            }
        }

        public static void g(View view, WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            a j = j(view);
            if (j != null) {
                windowInsetsCompat = j.onProgress(windowInsetsCompat, list);
                if (j.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    g(viewGroup.getChildAt(i), windowInsetsCompat, list);
                }
            }
        }

        public static void h(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            a j = j(view);
            if (j != null) {
                j.onStart(windowInsetsAnimationCompat, boundsCompat);
                if (j.getDispatchMode() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    h(viewGroup.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        public static WindowInsets i(View view, WindowInsets windowInsets) {
            if (view.getTag(Jr.tag_on_apply_window_listener) != null) {
                return windowInsets;
            }
            return view.onApplyWindowInsets(windowInsets);
        }

        public static a j(View view) {
            Object tag = view.getTag(Jr.tag_window_insets_animation_callback);
            if (tag instanceof a) {
                return ((a) tag).a;
            }
            return null;
        }
    }

    public static class d {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public final int f1815a;

        /* renamed from: a  reason: collision with other field name */
        public final long f1816a;

        /* renamed from: a  reason: collision with other field name */
        public final Interpolator f1817a;

        public d(int i, Interpolator interpolator, long j) {
            this.f1815a = i;
            this.f1817a = interpolator;
            this.f1816a = j;
        }

        public long a() {
            return this.f1816a;
        }

        public float b() {
            Interpolator interpolator = this.f1817a;
            if (interpolator != null) {
                return interpolator.getInterpolation(this.a);
            }
            return this.a;
        }

        public int c() {
            return this.f1815a;
        }

        public void d(float f) {
            this.a = f;
        }
    }

    public WindowInsetsAnimationCompat(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new c(i, interpolator, j);
        } else {
            this.a = new b(i, interpolator, j);
        }
    }

    public static class c extends d {
        public final WindowInsetsAnimation a;

        public static class a extends WindowInsetsAnimation.Callback {
            public final a a;

            /* renamed from: a  reason: collision with other field name */
            public ArrayList<WindowInsetsAnimationCompat> f1812a;

            /* renamed from: a  reason: collision with other field name */
            public final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> f1813a = new HashMap<>();

            /* renamed from: a  reason: collision with other field name */
            public List<WindowInsetsAnimationCompat> f1814a;

            public a(a aVar) {
                super(aVar.getDispatchMode());
                this.a = aVar;
            }

            public final WindowInsetsAnimationCompat a(WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.f1813a.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = new WindowInsetsAnimationCompat(windowInsetsAnimation);
                this.f1813a.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                return windowInsetsAnimationCompat2;
            }

            public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.onEnd(a(windowInsetsAnimation));
                this.f1813a.remove(windowInsetsAnimation);
            }

            public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.onPrepare(a(windowInsetsAnimation));
            }

            public final WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.f1812a;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.f1812a = arrayList2;
                    this.f1814a = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                int size = list.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        return this.a.onProgress(WindowInsetsCompat.i((View) null, windowInsets), this.f1814a).h();
                    }
                    WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                    WindowInsetsAnimationCompat a2 = a(windowInsetsAnimation);
                    a2.a.d(windowInsetsAnimation.getFraction());
                    this.f1812a.add(a2);
                }
            }

            public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                BoundsCompat onStart = this.a.onStart(a(windowInsetsAnimation), new BoundsCompat(bounds));
                onStart.getClass();
                return c.e(onStart);
            }
        }

        public c(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, (Interpolator) null, 0);
            this.a = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds e(BoundsCompat boundsCompat) {
            return new WindowInsetsAnimation.Bounds(boundsCompat.a.d(), boundsCompat.b.d());
        }

        public final long a() {
            return this.a.getDurationMillis();
        }

        public final float b() {
            return this.a.getInterpolatedFraction();
        }

        public final int c() {
            return this.a.getTypeMask();
        }

        public final void d(float f) {
            this.a.setFraction(f);
        }

        public c(int i, Interpolator interpolator, long j) {
            this(new WindowInsetsAnimation(i, interpolator, j));
        }
    }

    public static final class BoundsCompat {
        public final bg a;
        public final bg b;

        public BoundsCompat(bg bgVar, bg bgVar2) {
            this.a = bgVar;
            this.b = bgVar2;
        }

        public final String toString() {
            return "Bounds{lower=" + this.a + " upper=" + this.b + "}";
        }

        public BoundsCompat(WindowInsetsAnimation.Bounds bounds) {
            this.a = bg.c(bounds.getLowerBound());
            this.b = bg.c(bounds.getUpperBound());
        }
    }

    public WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, (Interpolator) null, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new c(windowInsetsAnimation);
        }
    }

    public static abstract class a {
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        WindowInsets mDispachedInsets;
        private final int mDispatchMode;

        public a(int i) {
            this.mDispatchMode = i;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list);

        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }
}
