package androidx.transition;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    public static final AccelerateInterpolator a = new AccelerateInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public static final DecelerateInterpolator f2497a = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public static final a f2498a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2499a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final c f2500a = new c();

    /* renamed from: a  reason: collision with other field name */
    public static final d f2501a = new d();

    /* renamed from: a  reason: collision with other field name */
    public static final e f2502a = new e();

    /* renamed from: a  reason: collision with other field name */
    public static final f f2503a = new f();

    /* renamed from: a  reason: collision with other field name */
    public g f2504a = f2503a;

    public class a extends h {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    public class b extends h {
        public final float b(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (viewGroup.getLayoutDirection() != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    }

    public class c extends i {
        public final float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    }

    public class d extends h {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    public class e extends h {
        public final float b(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (viewGroup.getLayoutDirection() != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    }

    public class f extends i {
        public final float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    }

    public interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    public static abstract class h implements g {
        public final float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    public static abstract class i implements g {
        public final float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        a(80);
    }

    public final void a(int i2) {
        if (i2 == 3) {
            this.f2504a = f2498a;
        } else if (i2 == 5) {
            this.f2504a = f2501a;
        } else if (i2 == 48) {
            this.f2504a = f2500a;
        } else if (i2 == 80) {
            this.f2504a = f2503a;
        } else if (i2 == 8388611) {
            this.f2504a = f2499a;
        } else if (i2 == 8388613) {
            this.f2504a = f2502a;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        Gw gw = new Gw();
        gw.f238a = i2;
        setPropagation(gw);
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.a.getLocationOnScreen(iArr);
        transitionValues.f2517a.put("android:slide:screenPosition", iArr);
    }

    public final boolean isSeekingSupported() {
        return true;
    }

    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.f2517a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return g.a(view, transitionValues2, iArr[0], iArr[1], this.f2504a.b(viewGroup, view), this.f2504a.a(viewGroup, view), translationX, translationY, f2497a, this);
    }

    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.f2517a.get("android:slide:screenPosition");
        return g.a(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f2504a.b(viewGroup, view), this.f2504a.a(viewGroup, view), a, this);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.f);
        int c2 = SA.c(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        a(c2);
    }
}
