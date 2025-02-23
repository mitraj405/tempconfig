package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.HashMap;

public class ChangeBounds extends Transition {
    public static final Es a = new Es();

    /* renamed from: a  reason: collision with other field name */
    public static final a f2459a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2460a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final c f2461a = new c();

    /* renamed from: a  reason: collision with other field name */
    public static final d f2462a = new d();

    /* renamed from: a  reason: collision with other field name */
    public static final e f2463a = new e();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f2464a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: a  reason: collision with other field name */
    public boolean f2465a = false;

    public class a extends Property<i, PointF> {
        public a() {
            super(PointF.class, "topLeft");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            i iVar = (i) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            i iVar = (i) obj;
            PointF pointF = (PointF) obj2;
            iVar.getClass();
            iVar.a = Math.round(pointF.x);
            int round = Math.round(pointF.y);
            iVar.b = round;
            int i = iVar.e + 1;
            iVar.e = i;
            if (i == iVar.f) {
                TC.a(iVar.f2473a, iVar.a, round, iVar.c, iVar.d);
                iVar.e = 0;
                iVar.f = 0;
            }
        }
    }

    public class b extends Property<i, PointF> {
        public b() {
            super(PointF.class, "bottomRight");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            i iVar = (i) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            i iVar = (i) obj;
            PointF pointF = (PointF) obj2;
            iVar.getClass();
            iVar.c = Math.round(pointF.x);
            int round = Math.round(pointF.y);
            iVar.d = round;
            int i = iVar.f + 1;
            iVar.f = i;
            if (iVar.e == i) {
                TC.a(iVar.f2473a, iVar.a, iVar.b, iVar.c, round);
                iVar.e = 0;
                iVar.f = 0;
            }
        }
    }

    public class c extends Property<View, PointF> {
        public c() {
            super(PointF.class, "bottomRight");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            TC.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public class d extends Property<View, PointF> {
        public d() {
            super(PointF.class, "topLeft");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            TC.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public class e extends Property<View, PointF> {
        public e() {
            super(PointF.class, "position");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            View view = (View) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            TC.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    public class f extends AnimatorListenerAdapter {
        private final i mViewBounds;

        public f(i iVar) {
            this.mViewBounds = iVar;
        }
    }

    public static class g extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Rect f2466a;

        /* renamed from: a  reason: collision with other field name */
        public final View f2467a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2468a;
        public final int b;

        /* renamed from: b  reason: collision with other field name */
        public final Rect f2469b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f2470b;
        public final int c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f2471c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;

        public g(View view, Rect rect, boolean z, Rect rect2, boolean z2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f2467a = view;
            this.f2466a = rect;
            this.f2468a = z;
            this.f2469b = rect2;
            this.f2470b = z2;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
        }

        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        public final void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        public final void onTransitionCancel(Transition transition) {
            this.f2471c = true;
        }

        public final void onTransitionPause(Transition transition) {
            Rect rect;
            View view = this.f2467a;
            view.setTag(Br.transition_clip, view.getClipBounds());
            if (this.f2470b) {
                rect = null;
            } else {
                rect = this.f2469b;
            }
            view.setClipBounds(rect);
        }

        public final void onTransitionResume(Transition transition) {
            int i = Br.transition_clip;
            View view = this.f2467a;
            view.setTag(i, (Object) null);
            view.setClipBounds((Rect) view.getTag(i));
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            if (!this.f2471c) {
                Rect rect = null;
                if (z) {
                    if (!this.f2468a) {
                        rect = this.f2466a;
                    }
                } else if (!this.f2470b) {
                    rect = this.f2469b;
                }
                View view = this.f2467a;
                view.setClipBounds(rect);
                if (z) {
                    TC.a(view, this.a, this.b, this.c, this.d);
                    return;
                }
                TC.a(view, this.e, this.f, this.g, this.h);
            }
        }

        public final void onAnimationStart(Animator animator, boolean z) {
            int i = this.c;
            int i2 = this.a;
            int i3 = this.g;
            int i4 = this.e;
            int max = Math.max(i - i2, i3 - i4);
            int i5 = this.d;
            int i6 = this.b;
            int i7 = this.h;
            int i8 = this.f;
            int max2 = Math.max(i5 - i6, i7 - i8);
            if (z) {
                i2 = i4;
            }
            if (z) {
                i6 = i8;
            }
            View view = this.f2467a;
            TC.a(view, i2, i6, max + i2, max2 + i6);
            view.setClipBounds(z ? this.f2469b : this.f2466a);
        }

        public final void onTransitionEnd(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }
    }

    public static class h extends d {
        public final ViewGroup a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2472a = false;

        public h(ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        public final void onTransitionCancel(Transition transition) {
            C0338tC.a(this.a, false);
            this.f2472a = true;
        }

        public final void onTransitionEnd(Transition transition) {
            if (!this.f2472a) {
                C0338tC.a(this.a, false);
            }
            transition.removeListener(this);
        }

        public final void onTransitionPause(Transition transition) {
            C0338tC.a(this.a, false);
        }

        public final void onTransitionResume(Transition transition) {
            C0338tC.a(this.a, true);
        }
    }

    public static class i {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public final View f2473a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public i(View view) {
            this.f2473a = view;
        }
    }

    public ChangeBounds() {
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        Rect rect;
        captureValues(transitionValues);
        if (this.f2465a && (rect = (Rect) transitionValues.a.getTag(Br.transition_clip)) != null) {
            transitionValues.f2517a.put("android:changeBounds:clip", rect);
        }
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.a;
        if (view.isLaidOut() || view.getWidth() != 0 || view.getHeight() != 0) {
            Rect rect = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            HashMap hashMap = transitionValues.f2517a;
            hashMap.put("android:changeBounds:bounds", rect);
            hashMap.put("android:changeBounds:parent", transitionValues.a.getParent());
            if (this.f2465a) {
                hashMap.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: android.animation.AnimatorSet} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator createAnimator(android.view.ViewGroup r22, androidx.transition.TransitionValues r23, androidx.transition.TransitionValues r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            r2 = r24
            if (r1 == 0) goto L_0x01fc
            if (r2 != 0) goto L_0x000c
            goto L_0x01fc
        L_0x000c:
            java.util.HashMap r1 = r1.f2517a
            java.util.HashMap r4 = r2.f2517a
            java.lang.String r5 = "android:changeBounds:parent"
            java.lang.Object r6 = r1.get(r5)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r5 = r4.get(r5)
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            if (r6 == 0) goto L_0x01f9
            if (r5 != 0) goto L_0x0024
            goto L_0x01f9
        L_0x0024:
            android.view.View r2 = r2.a
            java.lang.String r5 = "android:changeBounds:bounds"
            java.lang.Object r6 = r1.get(r5)
            android.graphics.Rect r6 = (android.graphics.Rect) r6
            java.lang.Object r5 = r4.get(r5)
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            int r13 = r6.left
            int r15 = r5.left
            int r14 = r6.top
            int r12 = r5.top
            int r11 = r6.right
            int r10 = r5.right
            int r6 = r6.bottom
            int r5 = r5.bottom
            int r7 = r11 - r13
            int r8 = r6 - r14
            int r9 = r10 - r15
            int r3 = r5 - r12
            r23 = r2
            java.lang.String r2 = "android:changeBounds:clip"
            java.lang.Object r1 = r1.get(r2)
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            java.lang.Object r2 = r4.get(r2)
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            if (r7 == 0) goto L_0x0060
            if (r8 != 0) goto L_0x0064
        L_0x0060:
            if (r9 == 0) goto L_0x0075
            if (r3 == 0) goto L_0x0075
        L_0x0064:
            if (r13 != r15) goto L_0x006c
            if (r14 == r12) goto L_0x0069
            goto L_0x006c
        L_0x0069:
            r16 = 0
            goto L_0x006e
        L_0x006c:
            r16 = 1
        L_0x006e:
            if (r11 != r10) goto L_0x0072
            if (r6 == r5) goto L_0x0077
        L_0x0072:
            int r16 = r16 + 1
            goto L_0x0077
        L_0x0075:
            r16 = 0
        L_0x0077:
            if (r1 == 0) goto L_0x007f
            boolean r17 = r1.equals(r2)
            if (r17 == 0) goto L_0x0083
        L_0x007f:
            if (r1 != 0) goto L_0x0085
            if (r2 == 0) goto L_0x0085
        L_0x0083:
            int r16 = r16 + 1
        L_0x0085:
            r4 = r16
            if (r4 <= 0) goto L_0x01f6
            r16 = r2
            boolean r2 = r0.f2465a
            androidx.transition.ChangeBounds$e r0 = f2463a
            if (r2 != 0) goto L_0x0126
            r2 = r23
            defpackage.TC.a(r2, r13, r14, r11, r6)
            r1 = 2
            if (r4 != r1) goto L_0x00f6
            if (r7 != r9) goto L_0x00ae
            if (r8 != r3) goto L_0x00ae
            androidx.transition.PathMotion r1 = r21.getPathMotion()
            float r3 = (float) r13
            float r4 = (float) r14
            float r5 = (float) r15
            float r6 = (float) r12
            android.graphics.Path r1 = r1.getPath(r3, r4, r5, r6)
            android.animation.ObjectAnimator r0 = defpackage.rn.a(r2, r0, r1)
            goto L_0x0120
        L_0x00ae:
            androidx.transition.ChangeBounds$i r0 = new androidx.transition.ChangeBounds$i
            r0.<init>(r2)
            androidx.transition.PathMotion r1 = r21.getPathMotion()
            float r3 = (float) r13
            float r4 = (float) r14
            float r7 = (float) r15
            float r8 = (float) r12
            android.graphics.Path r1 = r1.getPath(r3, r4, r7, r8)
            androidx.transition.ChangeBounds$a r3 = f2459a
            android.animation.ObjectAnimator r1 = defpackage.rn.a(r0, r3, r1)
            androidx.transition.PathMotion r3 = r21.getPathMotion()
            float r4 = (float) r11
            float r6 = (float) r6
            float r7 = (float) r10
            float r5 = (float) r5
            android.graphics.Path r3 = r3.getPath(r4, r6, r7, r5)
            androidx.transition.ChangeBounds$b r4 = f2460a
            android.animation.ObjectAnimator r3 = defpackage.rn.a(r0, r4, r3)
            android.animation.AnimatorSet r4 = new android.animation.AnimatorSet
            r4.<init>()
            r5 = 2
            android.animation.Animator[] r5 = new android.animation.Animator[r5]
            r6 = 0
            r5[r6] = r1
            r1 = 1
            r5[r1] = r3
            r4.playTogether(r5)
            androidx.transition.ChangeBounds$f r1 = new androidx.transition.ChangeBounds$f
            r1.<init>(r0)
            r4.addListener(r1)
            r0 = 1
            r1 = r21
        L_0x00f3:
            r3 = r4
            goto L_0x01d8
        L_0x00f6:
            if (r13 != r15) goto L_0x010e
            if (r14 == r12) goto L_0x00fb
            goto L_0x010e
        L_0x00fb:
            androidx.transition.PathMotion r0 = r21.getPathMotion()
            float r1 = (float) r11
            float r3 = (float) r6
            float r4 = (float) r10
            float r5 = (float) r5
            android.graphics.Path r0 = r0.getPath(r1, r3, r4, r5)
            androidx.transition.ChangeBounds$c r1 = f2461a
            android.animation.ObjectAnimator r0 = defpackage.rn.a(r2, r1, r0)
            goto L_0x0120
        L_0x010e:
            androidx.transition.PathMotion r0 = r21.getPathMotion()
            float r1 = (float) r13
            float r3 = (float) r14
            float r4 = (float) r15
            float r5 = (float) r12
            android.graphics.Path r0 = r0.getPath(r1, r3, r4, r5)
            androidx.transition.ChangeBounds$d r1 = f2462a
            android.animation.ObjectAnimator r0 = defpackage.rn.a(r2, r1, r0)
        L_0x0120:
            r1 = r21
        L_0x0122:
            r3 = r0
        L_0x0123:
            r0 = 1
            goto L_0x01d8
        L_0x0126:
            r2 = r23
            int r4 = java.lang.Math.max(r7, r9)
            int r17 = java.lang.Math.max(r8, r3)
            int r4 = r4 + r13
            r18 = r10
            int r10 = r14 + r17
            defpackage.TC.a(r2, r13, r14, r4, r10)
            if (r13 != r15) goto L_0x0145
            if (r14 == r12) goto L_0x013d
            goto L_0x0145
        L_0x013d:
            r20 = r5
            r17 = r11
            r19 = r15
            r0 = 0
            goto L_0x015b
        L_0x0145:
            androidx.transition.PathMotion r4 = r21.getPathMotion()
            float r10 = (float) r13
            r17 = r11
            float r11 = (float) r14
            r20 = r5
            float r5 = (float) r15
            r19 = r15
            float r15 = (float) r12
            android.graphics.Path r4 = r4.getPath(r10, r11, r5, r15)
            android.animation.ObjectAnimator r0 = defpackage.rn.a(r2, r0, r4)
        L_0x015b:
            if (r1 != 0) goto L_0x015f
            r10 = 1
            goto L_0x0160
        L_0x015f:
            r10 = 0
        L_0x0160:
            if (r10 == 0) goto L_0x0169
            android.graphics.Rect r1 = new android.graphics.Rect
            r4 = 0
            r1.<init>(r4, r4, r7, r8)
            goto L_0x016a
        L_0x0169:
            r4 = 0
        L_0x016a:
            if (r16 != 0) goto L_0x016e
            r5 = 1
            goto L_0x016f
        L_0x016e:
            r5 = r4
        L_0x016f:
            if (r5 == 0) goto L_0x0178
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>(r4, r4, r9, r3)
            r11 = r7
            goto L_0x017a
        L_0x0178:
            r11 = r16
        L_0x017a:
            boolean r3 = r1.equals(r11)
            if (r3 != 0) goto L_0x01b8
            r2.setClipBounds(r1)
            r3 = 2
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r7[r4] = r1
            r4 = 1
            r7[r4] = r11
            java.lang.String r4 = "clipBounds"
            Es r8 = a
            android.animation.ObjectAnimator r4 = android.animation.ObjectAnimator.ofObject(r2, r4, r8, r7)
            androidx.transition.ChangeBounds$g r15 = new androidx.transition.ChangeBounds$g
            r7 = r15
            r8 = r2
            r9 = r1
            r1 = r18
            r16 = r17
            r18 = r12
            r12 = r5
            r3 = r15
            r5 = r19
            r15 = r16
            r16 = r6
            r17 = r5
            r19 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r4.addListener(r3)
            r5 = 2
            r1 = r21
            r1.addListener(r3)
            r3 = r4
            goto L_0x01bc
        L_0x01b8:
            r5 = 2
            r1 = r21
            r3 = 0
        L_0x01bc:
            boolean r4 = androidx.transition.f.a
            if (r0 != 0) goto L_0x01c2
            goto L_0x0123
        L_0x01c2:
            if (r3 != 0) goto L_0x01c6
            goto L_0x0122
        L_0x01c6:
            android.animation.AnimatorSet r4 = new android.animation.AnimatorSet
            r4.<init>()
            android.animation.Animator[] r5 = new android.animation.Animator[r5]
            r6 = 0
            r5[r6] = r0
            r0 = 1
            r5[r0] = r3
            r4.playTogether(r5)
            goto L_0x00f3
        L_0x01d8:
            android.view.ViewParent r4 = r2.getParent()
            boolean r4 = r4 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x01f5
            android.view.ViewParent r2 = r2.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            defpackage.C0338tC.a(r2, r0)
            androidx.transition.Transition r0 = r21.getRootTransition()
            androidx.transition.ChangeBounds$h r4 = new androidx.transition.ChangeBounds$h
            r4.<init>(r2)
            r0.addListener(r4)
        L_0x01f5:
            return r3
        L_0x01f6:
            r1 = r0
            r0 = 0
            return r0
        L_0x01f9:
            r1 = r0
            r0 = 0
            return r0
        L_0x01fc:
            r1 = r0
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public final String[] getTransitionProperties() {
        return f2464a;
    }

    public final boolean isSeekingSupported() {
        return true;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.b);
        z = SA.e((XmlResourceParser) attributeSet, "resizeClip") ? obtainStyledAttributes.getBoolean(0, false) : z;
        obtainStyledAttributes.recycle();
        this.f2465a = z;
    }
}
