package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.f;
import java.util.HashMap;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2480a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f2481a = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final boolean c = true;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f2482a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2483a = true;
    public final boolean b = true;

    public class a extends Property<e, float[]> {
        public a() {
            super(float[].class, "nonTranslations");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            e eVar = (e) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            e eVar = (e) obj;
            float[] fArr = (float[]) obj2;
            eVar.getClass();
            System.arraycopy(fArr, 0, eVar.f2492a, 0, fArr.length);
            eVar.a();
        }
    }

    public class b extends Property<e, PointF> {
        public b() {
            super(PointF.class, "translations");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            e eVar = (e) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            e eVar = (e) obj;
            PointF pointF = (PointF) obj2;
            eVar.getClass();
            eVar.a = pointF.x;
            eVar.b = pointF.y;
            eVar.a();
        }
    }

    public static class c extends d {
        public final View a;

        /* renamed from: a  reason: collision with other field name */
        public final C0290oe f2484a;

        public c(View view, C0290oe oeVar) {
            this.a = view;
            this.f2484a = oeVar;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onTransitionEnd(androidx.transition.Transition r8) {
            /*
                r7 = this;
                r8.removeListener(r7)
                int r8 = android.os.Build.VERSION.SDK_INT
                r0 = 28
                r1 = 0
                android.view.View r2 = r7.a
                if (r8 != r0) goto L_0x004c
                boolean r8 = defpackage.C0306qe.c
                r0 = 1
                r3 = 0
                if (r8 != 0) goto L_0x0035
                boolean r8 = defpackage.C0306qe.f3190a     // Catch:{ NoSuchMethodException -> 0x0033 }
                if (r8 != 0) goto L_0x0020
                java.lang.String r8 = "android.view.GhostView"
                java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x001e }
                defpackage.C0306qe.a = r8     // Catch:{ ClassNotFoundException -> 0x001e }
            L_0x001e:
                defpackage.C0306qe.f3190a = r0     // Catch:{ NoSuchMethodException -> 0x0033 }
            L_0x0020:
                java.lang.Class<?> r8 = defpackage.C0306qe.a     // Catch:{ NoSuchMethodException -> 0x0033 }
                java.lang.String r4 = "removeGhost"
                java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x0033 }
                java.lang.Class<android.view.View> r6 = android.view.View.class
                r5[r3] = r6     // Catch:{ NoSuchMethodException -> 0x0033 }
                java.lang.reflect.Method r8 = r8.getDeclaredMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x0033 }
                defpackage.C0306qe.b = r8     // Catch:{ NoSuchMethodException -> 0x0033 }
                r8.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x0033 }
            L_0x0033:
                defpackage.C0306qe.c = r0
            L_0x0035:
                java.lang.reflect.Method r8 = defpackage.C0306qe.b
                if (r8 == 0) goto L_0x0069
                java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0041 }
                r0[r3] = r2     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0041 }
                r8.invoke(r1, r0)     // Catch:{ IllegalAccessException -> 0x0069, InvocationTargetException -> 0x0041 }
                goto L_0x0069
            L_0x0041:
                r8 = move-exception
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                java.lang.Throwable r8 = r8.getCause()
                r0.<init>(r8)
                throw r0
            L_0x004c:
                int r8 = defpackage.C0319re.d
                int r8 = defpackage.Br.ghost_view
                java.lang.Object r8 = r2.getTag(r8)
                re r8 = (defpackage.C0319re) r8
                if (r8 == 0) goto L_0x0069
                int r0 = r8.c
                int r0 = r0 + -1
                r8.c = r0
                if (r0 > 0) goto L_0x0069
                android.view.ViewParent r0 = r8.getParent()
                pe r0 = (defpackage.C0298pe) r0
                r0.removeView(r8)
            L_0x0069:
                int r8 = defpackage.Br.transition_transform
                r2.setTag(r8, r1)
                int r8 = defpackage.Br.parent_matrix
                r2.setTag(r8, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.c.onTransitionEnd(androidx.transition.Transition):void");
        }

        public final void onTransitionPause(Transition transition) {
            this.f2484a.setVisibility(4);
        }

        public final void onTransitionResume(Transition transition) {
            this.f2484a.setVisibility(0);
        }
    }

    public static class d extends AnimatorListenerAdapter {
        public final Matrix a = new Matrix();

        /* renamed from: a  reason: collision with other field name */
        public final View f2485a;

        /* renamed from: a  reason: collision with other field name */
        public final e f2486a;

        /* renamed from: a  reason: collision with other field name */
        public final f f2487a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2488a;
        public final Matrix b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f2489b;
        public final boolean c;

        public d(View view, f fVar, e eVar, Matrix matrix, boolean z, boolean z2) {
            this.f2489b = z;
            this.c = z2;
            this.f2485a = view;
            this.f2487a = fVar;
            this.f2486a = eVar;
            this.b = matrix;
        }

        public final void onAnimationCancel(Animator animator) {
            this.f2488a = true;
        }

        public final void onAnimationEnd(Animator animator) {
            boolean z = this.f2488a;
            f fVar = this.f2487a;
            View view = this.f2485a;
            if (!z) {
                if (!this.f2489b || !this.c) {
                    view.setTag(Br.transition_transform, (Object) null);
                    view.setTag(Br.parent_matrix, (Object) null);
                } else {
                    Matrix matrix = this.a;
                    matrix.set(this.b);
                    view.setTag(Br.transition_transform, matrix);
                    fVar.getClass();
                    String[] strArr = ChangeTransform.f2481a;
                    view.setTranslationX(fVar.a);
                    view.setTranslationY(fVar.b);
                    WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                    f.d.w(view, fVar.c);
                    view.setScaleX(fVar.d);
                    view.setScaleY(fVar.e);
                    view.setRotationX(fVar.f);
                    view.setRotationY(fVar.g);
                    view.setRotation(fVar.h);
                }
            }
            TC.f548a.d(view, (Matrix) null);
            fVar.getClass();
            String[] strArr2 = ChangeTransform.f2481a;
            view.setTranslationX(fVar.a);
            view.setTranslationY(fVar.b);
            WeakHashMap<View, GC> weakHashMap2 = androidx.core.view.f.f1839a;
            f.d.w(view, fVar.c);
            view.setScaleX(fVar.d);
            view.setScaleY(fVar.e);
            view.setRotationX(fVar.f);
            view.setRotationY(fVar.g);
            view.setRotation(fVar.h);
        }

        public final void onAnimationPause(Animator animator) {
            Matrix matrix = this.f2486a.f2490a;
            Matrix matrix2 = this.a;
            matrix2.set(matrix);
            int i = Br.transition_transform;
            View view = this.f2485a;
            view.setTag(i, matrix2);
            f fVar = this.f2487a;
            fVar.getClass();
            String[] strArr = ChangeTransform.f2481a;
            view.setTranslationX(fVar.a);
            view.setTranslationY(fVar.b);
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.d.w(view, fVar.c);
            view.setScaleX(fVar.d);
            view.setScaleY(fVar.e);
            view.setRotationX(fVar.f);
            view.setRotationY(fVar.g);
            view.setRotation(fVar.h);
        }

        public final void onAnimationResume(Animator animator) {
            String[] strArr = ChangeTransform.f2481a;
            View view = this.f2485a;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.d.w(view, 0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotationX(0.0f);
            view.setRotationY(0.0f);
            view.setRotation(0.0f);
        }
    }

    public static class e {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public final Matrix f2490a = new Matrix();

        /* renamed from: a  reason: collision with other field name */
        public final View f2491a;

        /* renamed from: a  reason: collision with other field name */
        public final float[] f2492a;
        public float b;

        public e(View view, float[] fArr) {
            this.f2491a = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f2492a = fArr2;
            this.a = fArr2[2];
            this.b = fArr2[5];
            a();
        }

        public final void a() {
            float f = this.a;
            float[] fArr = this.f2492a;
            fArr[2] = f;
            fArr[5] = this.b;
            Matrix matrix = this.f2490a;
            matrix.setValues(fArr);
            TC.f548a.d(this.f2491a, matrix);
        }
    }

    public static class f {
        public final float a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final float f;
        public final float g;
        public final float h;

        public f(View view) {
            this.a = view.getTranslationX();
            this.b = view.getTranslationY();
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            this.c = f.d.l(view);
            this.d = view.getScaleX();
            this.e = view.getScaleY();
            this.f = view.getRotationX();
            this.g = view.getRotationY();
            this.h = view.getRotation();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (fVar.a == this.a && fVar.b == this.b && fVar.c == this.c && fVar.d == this.d && fVar.e == this.e && fVar.f == this.f && fVar.g == this.g && fVar.h == this.h) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            float f2 = this.a;
            int i8 = 0;
            if (f2 != 0.0f) {
                i = Float.floatToIntBits(f2);
            } else {
                i = 0;
            }
            int i9 = i * 31;
            float f3 = this.b;
            if (f3 != 0.0f) {
                i2 = Float.floatToIntBits(f3);
            } else {
                i2 = 0;
            }
            int i10 = (i9 + i2) * 31;
            float f4 = this.c;
            if (f4 != 0.0f) {
                i3 = Float.floatToIntBits(f4);
            } else {
                i3 = 0;
            }
            int i11 = (i10 + i3) * 31;
            float f5 = this.d;
            if (f5 != 0.0f) {
                i4 = Float.floatToIntBits(f5);
            } else {
                i4 = 0;
            }
            int i12 = (i11 + i4) * 31;
            float f6 = this.e;
            if (f6 != 0.0f) {
                i5 = Float.floatToIntBits(f6);
            } else {
                i5 = 0;
            }
            int i13 = (i12 + i5) * 31;
            float f7 = this.f;
            if (f7 != 0.0f) {
                i6 = Float.floatToIntBits(f7);
            } else {
                i6 = 0;
            }
            int i14 = (i13 + i6) * 31;
            float f8 = this.g;
            if (f8 != 0.0f) {
                i7 = Float.floatToIntBits(f8);
            } else {
                i7 = 0;
            }
            int i15 = (i14 + i7) * 31;
            float f9 = this.h;
            if (f9 != 0.0f) {
                i8 = Float.floatToIntBits(f9);
            }
            return i15 + i8;
        }
    }

    public ChangeTransform() {
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        if (!c) {
            ((ViewGroup) transitionValues.a.getParent()).startViewTransition(transitionValues.a);
        }
    }

    public final void captureValues(TransitionValues transitionValues) {
        Matrix matrix;
        View view = transitionValues.a;
        if (view.getVisibility() != 8) {
            HashMap hashMap = transitionValues.f2517a;
            hashMap.put("android:changeTransform:parent", view.getParent());
            hashMap.put("android:changeTransform:transforms", new f(view));
            Matrix matrix2 = view.getMatrix();
            if (matrix2 == null || matrix2.isIdentity()) {
                matrix = null;
            } else {
                matrix = new Matrix(matrix2);
            }
            hashMap.put("android:changeTransform:matrix", matrix);
            if (this.b) {
                Matrix matrix3 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                TC.f548a.e(viewGroup, matrix3);
                matrix3.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                hashMap.put("android:changeTransform:parentMatrix", matrix3);
                hashMap.put("android:changeTransform:intermediateMatrix", view.getTag(Br.transition_transform));
                hashMap.put("android:changeTransform:intermediateParentMatrix", view.getTag(Br.parent_matrix));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: android.view.View} */
    /* JADX WARNING: type inference failed for: r12v19, types: [qe] */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0391, code lost:
        if (r9.size() == r1) goto L_0x03a5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.animation.Animator createAnimator(android.view.ViewGroup r27, androidx.transition.TransitionValues r28, androidx.transition.TransitionValues r29) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            r3 = r29
            if (r2 == 0) goto L_0x0448
            if (r3 == 0) goto L_0x0448
            java.util.HashMap r5 = r2.f2517a
            java.lang.String r6 = "android:changeTransform:parent"
            boolean r7 = r5.containsKey(r6)
            if (r7 == 0) goto L_0x0448
            java.util.HashMap r7 = r3.f2517a
            boolean r8 = r7.containsKey(r6)
            if (r8 != 0) goto L_0x0020
            goto L_0x0448
        L_0x0020:
            java.lang.Object r8 = r5.get(r6)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            java.lang.Object r9 = r7.get(r6)
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            boolean r10 = r1.b
            r12 = 1
            if (r10 == 0) goto L_0x0052
            boolean r10 = r1.isValidTarget(r8)
            if (r10 == 0) goto L_0x0049
            boolean r10 = r1.isValidTarget(r9)
            if (r10 != 0) goto L_0x003e
            goto L_0x0049
        L_0x003e:
            androidx.transition.TransitionValues r10 = r1.getMatchedTransitionValues(r8, r12)
            if (r10 == 0) goto L_0x004d
            android.view.View r10 = r10.a
            if (r9 != r10) goto L_0x004d
            goto L_0x004b
        L_0x0049:
            if (r8 != r9) goto L_0x004d
        L_0x004b:
            r9 = r12
            goto L_0x004e
        L_0x004d:
            r9 = 0
        L_0x004e:
            if (r9 != 0) goto L_0x0052
            r9 = r12
            goto L_0x0053
        L_0x0052:
            r9 = 0
        L_0x0053:
            java.lang.String r10 = "android:changeTransform:intermediateMatrix"
            java.lang.Object r10 = r5.get(r10)
            android.graphics.Matrix r10 = (android.graphics.Matrix) r10
            java.lang.String r13 = "android:changeTransform:matrix"
            if (r10 == 0) goto L_0x0062
            r5.put(r13, r10)
        L_0x0062:
            java.lang.String r10 = "android:changeTransform:intermediateParentMatrix"
            java.lang.Object r10 = r5.get(r10)
            android.graphics.Matrix r10 = (android.graphics.Matrix) r10
            java.lang.String r15 = "android:changeTransform:parentMatrix"
            if (r10 == 0) goto L_0x0071
            r5.put(r15, r10)
        L_0x0071:
            if (r9 == 0) goto L_0x00a4
            java.lang.Object r10 = r7.get(r15)
            android.graphics.Matrix r10 = (android.graphics.Matrix) r10
            android.view.View r14 = r3.a
            int r4 = defpackage.Br.parent_matrix
            r14.setTag(r4, r10)
            android.graphics.Matrix r4 = r1.f2482a
            r4.reset()
            r10.invert(r4)
            java.lang.Object r10 = r5.get(r13)
            android.graphics.Matrix r10 = (android.graphics.Matrix) r10
            if (r10 != 0) goto L_0x0098
            android.graphics.Matrix r10 = new android.graphics.Matrix
            r10.<init>()
            r5.put(r13, r10)
        L_0x0098:
            java.lang.Object r14 = r5.get(r15)
            android.graphics.Matrix r14 = (android.graphics.Matrix) r14
            r10.postConcat(r14)
            r10.postConcat(r4)
        L_0x00a4:
            java.lang.Object r4 = r5.get(r13)
            android.graphics.Matrix r4 = (android.graphics.Matrix) r4
            java.lang.Object r10 = r7.get(r13)
            android.graphics.Matrix r10 = (android.graphics.Matrix) r10
            if (r4 != 0) goto L_0x00b4
            Kk$a r4 = defpackage.Kk.a
        L_0x00b4:
            if (r10 != 0) goto L_0x00b8
            Kk$a r10 = defpackage.Kk.a
        L_0x00b8:
            boolean r13 = r4.equals(r10)
            r14 = 1065353216(0x3f800000, float:1.0)
            r12 = 0
            if (r13 == 0) goto L_0x00c7
            r24 = r8
            r12 = r15
            r2 = 0
            goto L_0x0160
        L_0x00c7:
            java.lang.String r13 = "android:changeTransform:transforms"
            java.lang.Object r13 = r7.get(r13)
            r16 = r13
            androidx.transition.ChangeTransform$f r16 = (androidx.transition.ChangeTransform.f) r16
            android.view.View r13 = r3.a
            r13.setTranslationX(r12)
            r13.setTranslationY(r12)
            java.util.WeakHashMap<android.view.View, GC> r17 = androidx.core.view.f.f1839a
            androidx.core.view.f.d.w(r13, r12)
            r13.setScaleX(r14)
            r13.setScaleY(r14)
            r13.setRotationX(r12)
            r13.setRotationY(r12)
            r13.setRotation(r12)
            r14 = 9
            float[] r12 = new float[r14]
            r4.getValues(r12)
            float[] r4 = new float[r14]
            r10.getValues(r4)
            androidx.transition.ChangeTransform$e r11 = new androidx.transition.ChangeTransform$e
            r11.<init>(r13, r12)
            r18 = r13
            Fc r13 = new Fc
            float[] r14 = new float[r14]
            r13.<init>(r14)
            r19 = r15
            r14 = 2
            float[][] r15 = new float[r14][]
            r22 = 0
            r15[r22] = r12
            r21 = 1
            r15[r21] = r4
            androidx.transition.ChangeTransform$a r14 = a
            android.animation.PropertyValuesHolder r13 = android.animation.PropertyValuesHolder.ofObject(r14, r13, r15)
            androidx.transition.PathMotion r14 = r26.getPathMotion()
            r24 = r8
            r15 = 2
            r8 = r12[r15]
            r23 = 5
            r12 = r12[r23]
            r2 = r4[r15]
            r4 = r4[r23]
            android.graphics.Path r2 = r14.getPath(r8, r12, r2, r4)
            androidx.transition.ChangeTransform$b r4 = f2480a
            android.animation.PropertyValuesHolder r2 = defpackage.Lq.a(r4, r2)
            android.animation.PropertyValuesHolder[] r4 = new android.animation.PropertyValuesHolder[r15]
            r8 = 0
            r4[r8] = r13
            r8 = 1
            r4[r8] = r2
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofPropertyValuesHolder(r11, r4)
            androidx.transition.ChangeTransform$d r4 = new androidx.transition.ChangeTransform$d
            boolean r8 = r1.f2483a
            r12 = r18
            r13 = r4
            r15 = 1065353216(0x3f800000, float:1.0)
            r14 = r12
            r12 = r19
            r15 = r16
            r16 = r11
            r17 = r10
            r18 = r9
            r19 = r8
            r13.<init>(r14, r15, r16, r17, r18, r19)
            r2.addListener(r4)
            r2.addPauseListener(r4)
        L_0x0160:
            boolean r4 = c
            if (r9 == 0) goto L_0x0438
            if (r2 == 0) goto L_0x0438
            boolean r8 = r1.f2483a
            if (r8 == 0) goto L_0x0438
            android.view.View r8 = r3.a
            java.lang.Object r7 = r7.get(r12)
            android.graphics.Matrix r7 = (android.graphics.Matrix) r7
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>(r7)
            YC r7 = defpackage.TC.f548a
            r7.f(r0, r9)
            int r7 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            java.lang.Class<android.view.ViewGroup> r11 = android.view.ViewGroup.class
            if (r7 != r10) goto L_0x01ea
            boolean r7 = defpackage.C0306qe.f3191b
            r10 = 3
            if (r7 != 0) goto L_0x01b8
            boolean r7 = defpackage.C0306qe.f3190a     // Catch:{ NoSuchMethodException -> 0x01b4 }
            if (r7 != 0) goto L_0x0198
            java.lang.String r7 = "android.view.GhostView"
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0195 }
            defpackage.C0306qe.a = r7     // Catch:{ ClassNotFoundException -> 0x0195 }
        L_0x0195:
            r7 = 1
            defpackage.C0306qe.f3190a = r7     // Catch:{ NoSuchMethodException -> 0x01b4 }
        L_0x0198:
            java.lang.Class<?> r7 = defpackage.C0306qe.a     // Catch:{ NoSuchMethodException -> 0x01b4 }
            java.lang.String r12 = "addGhost"
            java.lang.Class[] r13 = new java.lang.Class[r10]     // Catch:{ NoSuchMethodException -> 0x01b4 }
            java.lang.Class<android.view.View> r14 = android.view.View.class
            r15 = 0
            r13[r15] = r14     // Catch:{ NoSuchMethodException -> 0x01b4 }
            r14 = 1
            r13[r14] = r11     // Catch:{ NoSuchMethodException -> 0x01b4 }
            java.lang.Class<android.graphics.Matrix> r11 = android.graphics.Matrix.class
            r15 = 2
            r13[r15] = r11     // Catch:{ NoSuchMethodException -> 0x01b4 }
            java.lang.reflect.Method r7 = r7.getDeclaredMethod(r12, r13)     // Catch:{ NoSuchMethodException -> 0x01b4 }
            defpackage.C0306qe.f3189a = r7     // Catch:{ NoSuchMethodException -> 0x01b4 }
            r7.setAccessible(r14)     // Catch:{ NoSuchMethodException -> 0x01b4 }
        L_0x01b4:
            r7 = 1
            defpackage.C0306qe.f3191b = r7
            goto L_0x01b9
        L_0x01b8:
            r7 = 1
        L_0x01b9:
            java.lang.reflect.Method r11 = defpackage.C0306qe.f3189a
            if (r11 == 0) goto L_0x01df
            qe r12 = new qe     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            r13 = 0
            r10[r13] = r8     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            r10[r7] = r0     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            r0 = 2
            r10[r0] = r9     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            r0 = 0
            java.lang.Object r7 = r11.invoke(r0, r10)     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            android.view.View r7 = (android.view.View) r7     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            r12.<init>(r7)     // Catch:{ IllegalAccessException -> 0x01df, InvocationTargetException -> 0x01d4 }
            goto L_0x01e0
        L_0x01d4:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.Throwable r0 = r0.getCause()
            r2.<init>(r0)
            throw r2
        L_0x01df:
            r12 = 0
        L_0x01e0:
            r17 = r2
            r19 = r4
            r25 = r5
            r24 = r8
            goto L_0x03f8
        L_0x01ea:
            int r7 = defpackage.C0319re.d
            android.view.ViewParent r7 = r8.getParent()
            boolean r7 = r7 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x0430
            int r7 = defpackage.C0298pe.c
            int r7 = defpackage.Br.ghost_view_holder
            java.lang.Object r7 = r0.getTag(r7)
            pe r7 = (defpackage.C0298pe) r7
            int r10 = defpackage.Br.ghost_view
            java.lang.Object r10 = r8.getTag(r10)
            re r10 = (defpackage.C0319re) r10
            if (r10 == 0) goto L_0x0217
            android.view.ViewParent r12 = r10.getParent()
            pe r12 = (defpackage.C0298pe) r12
            if (r12 == r7) goto L_0x0217
            int r13 = r10.c
            r12.removeView(r10)
            r10 = 0
            goto L_0x0218
        L_0x0217:
            r13 = 0
        L_0x0218:
            if (r10 != 0) goto L_0x03e7
            re r10 = new re
            r10.<init>(r8)
            r10.a = r9
            if (r7 != 0) goto L_0x0229
            pe r7 = new pe
            r7.<init>(r0)
            goto L_0x023d
        L_0x0229:
            boolean r9 = r7.f3174a
            if (r9 == 0) goto L_0x03df
            android.view.ViewGroup r9 = r7.a
            android.view.ViewGroupOverlay r12 = r9.getOverlay()
            r12.remove(r7)
            android.view.ViewGroupOverlay r9 = r9.getOverlay()
            r9.add(r7)
        L_0x023d:
            defpackage.C0319re.b(r0, r7)
            defpackage.C0319re.b(r0, r10)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.view.View r9 = r10.b
            defpackage.C0298pe.a(r9, r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            int r12 = r7.getChildCount()
            r14 = 1
            int r12 = r12 - r14
            r14 = 0
        L_0x0259:
            if (r14 > r12) goto L_0x03c4
            int r15 = r14 + r12
            r16 = 2
            int r15 = r15 / 2
            android.view.View r16 = r7.getChildAt(r15)
            r1 = r16
            re r1 = (defpackage.C0319re) r1
            android.view.View r1 = r1.b
            defpackage.C0298pe.a(r1, r9)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0397
            boolean r1 = r9.isEmpty()
            if (r1 != 0) goto L_0x0397
            r16 = r12
            r1 = 0
            java.lang.Object r12 = r0.get(r1)
            r17 = r2
            java.lang.Object r2 = r9.get(r1)
            if (r12 == r2) goto L_0x028c
            r27 = r0
            goto L_0x02cf
        L_0x028c:
            int r1 = r0.size()
            int r2 = r9.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 1
        L_0x0299:
            if (r2 >= r1) goto L_0x0382
            java.lang.Object r12 = r0.get(r2)
            android.view.View r12 = (android.view.View) r12
            java.lang.Object r18 = r9.get(r2)
            r27 = r0
            r0 = r18
            android.view.View r0 = (android.view.View) r0
            if (r12 == r0) goto L_0x036f
            android.view.ViewParent r1 = r12.getParent()
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.getChildCount()
            float r18 = defpackage.C0298pe.a.a(r12)
            float r19 = defpackage.C0298pe.a.a(r0)
            int r18 = (r18 > r19 ? 1 : (r18 == r19 ? 0 : -1))
            if (r18 == 0) goto L_0x02e5
            float r1 = defpackage.C0298pe.a.a(r12)
            float r0 = defpackage.C0298pe.a.a(r0)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x02da
        L_0x02cf:
            r19 = r4
            r25 = r5
            r24 = r8
        L_0x02d5:
            r4 = 2
            r22 = 0
            goto L_0x03a5
        L_0x02da:
            r19 = r4
            r25 = r5
            r24 = r8
            r4 = 2
            r22 = 0
            goto L_0x0394
        L_0x02e5:
            r3 = 0
        L_0x02e6:
            if (r3 >= r2) goto L_0x02cf
            r18 = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r19 = r4
            r4 = 29
            if (r2 < r4) goto L_0x02fe
            int r2 = defpackage.C0338tC.a.a(r1, r3)
            r25 = r5
            r24 = r8
            r4 = 2
            r22 = 0
            goto L_0x0359
        L_0x02fe:
            boolean r2 = defpackage.C0338tC.b
            if (r2 != 0) goto L_0x032b
            java.lang.String r2 = "getChildDrawingOrder"
            r24 = r8
            r4 = 2
            java.lang.Class[] r8 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0320 }
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0320 }
            r20 = 0
            r8[r20] = r4     // Catch:{ NoSuchMethodException -> 0x0320 }
            r25 = r5
            r5 = 1
            r8[r5] = r4     // Catch:{ NoSuchMethodException -> 0x031e }
            java.lang.reflect.Method r2 = r11.getDeclaredMethod(r2, r8)     // Catch:{ NoSuchMethodException -> 0x031e }
            defpackage.C0338tC.a = r2     // Catch:{ NoSuchMethodException -> 0x031e }
            r2.setAccessible(r5)     // Catch:{ NoSuchMethodException -> 0x031e }
            goto L_0x0327
        L_0x031e:
            r2 = r5
            goto L_0x0328
        L_0x0320:
            r25 = r5
            goto L_0x0327
        L_0x0323:
            r25 = r5
            r24 = r8
        L_0x0327:
            r2 = 1
        L_0x0328:
            defpackage.C0338tC.b = r2
            goto L_0x032f
        L_0x032b:
            r25 = r5
            r24 = r8
        L_0x032f:
            java.lang.reflect.Method r2 = defpackage.C0338tC.a
            if (r2 == 0) goto L_0x0355
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0356 }
            int r8 = r1.getChildCount()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0356 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0356 }
            r22 = 0
            r5[r22] = r8     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0358 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0358 }
            r20 = 1
            r5[r20] = r8     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0358 }
            java.lang.Object r2 = r2.invoke(r1, r5)     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0358 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0358 }
            int r2 = r2.intValue()     // Catch:{ IllegalAccessException | InvocationTargetException -> 0x0358 }
            goto L_0x0359
        L_0x0355:
            r4 = 2
        L_0x0356:
            r22 = 0
        L_0x0358:
            r2 = r3
        L_0x0359:
            android.view.View r2 = r1.getChildAt(r2)
            if (r2 != r12) goto L_0x0360
            goto L_0x0394
        L_0x0360:
            if (r2 != r0) goto L_0x0363
            goto L_0x03a5
        L_0x0363:
            int r3 = r3 + 1
            r2 = r18
            r4 = r19
            r8 = r24
            r5 = r25
            goto L_0x02e6
        L_0x036f:
            r19 = r4
            r25 = r5
            r24 = r8
            r4 = 2
            r22 = 0
            int r2 = r2 + 1
            r0 = r27
            r3 = r29
            r4 = r19
            goto L_0x0299
        L_0x0382:
            r27 = r0
            r19 = r4
            r25 = r5
            r24 = r8
            r4 = 2
            r22 = 0
            int r0 = r9.size()
            if (r0 != r1) goto L_0x0394
            goto L_0x03a5
        L_0x0394:
            r0 = r22
            goto L_0x03a6
        L_0x0397:
            r27 = r0
            r17 = r2
            r19 = r4
            r25 = r5
            r24 = r8
            r16 = r12
            goto L_0x02d5
        L_0x03a5:
            r0 = 1
        L_0x03a6:
            if (r0 == 0) goto L_0x03ae
            int r15 = r15 + 1
            r14 = r15
            r12 = r16
            goto L_0x03b1
        L_0x03ae:
            int r15 = r15 + -1
            r12 = r15
        L_0x03b1:
            r9.clear()
            r1 = r26
            r0 = r27
            r3 = r29
            r2 = r17
            r4 = r19
            r8 = r24
            r5 = r25
            goto L_0x0259
        L_0x03c4:
            r17 = r2
            r19 = r4
            r25 = r5
            r24 = r8
            if (r14 < 0) goto L_0x03d9
            int r0 = r7.getChildCount()
            if (r14 < r0) goto L_0x03d5
            goto L_0x03d9
        L_0x03d5:
            r7.addView(r10, r14)
            goto L_0x03dc
        L_0x03d9:
            r7.addView(r10)
        L_0x03dc:
            r10.c = r13
            goto L_0x03f1
        L_0x03df:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "This GhostViewHolder is detached!"
            r0.<init>(r1)
            throw r0
        L_0x03e7:
            r17 = r2
            r19 = r4
            r25 = r5
            r24 = r8
            r10.a = r9
        L_0x03f1:
            r12 = r10
            int r0 = r12.c
            r1 = 1
            int r0 = r0 + r1
            r12.c = r0
        L_0x03f8:
            if (r12 != 0) goto L_0x03fb
            goto L_0x0447
        L_0x03fb:
            r0 = r25
            java.lang.Object r0 = r0.get(r6)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r1 = r28
            android.view.View r2 = r1.a
            r12.a(r0, r2)
            r0 = r26
        L_0x040c:
            androidx.transition.TransitionSet r2 = r0.mParent
            if (r2 == 0) goto L_0x0412
            r0 = r2
            goto L_0x040c
        L_0x0412:
            androidx.transition.ChangeTransform$c r2 = new androidx.transition.ChangeTransform$c
            r3 = r24
            r2.<init>(r3, r12)
            r0.addListener(r2)
            if (r19 == 0) goto L_0x0447
            android.view.View r0 = r1.a
            r1 = r29
            android.view.View r1 = r1.a
            if (r0 == r1) goto L_0x042a
            r1 = 0
            defpackage.TC.b(r0, r1)
        L_0x042a:
            r0 = 1065353216(0x3f800000, float:1.0)
            defpackage.TC.b(r3, r0)
            goto L_0x0447
        L_0x0430:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Ghosted views must be parented by a ViewGroup"
            r0.<init>(r1)
            throw r0
        L_0x0438:
            r1 = r28
            r17 = r2
            r19 = r4
            if (r19 != 0) goto L_0x0447
            android.view.View r0 = r1.a
            r8 = r24
            r8.endViewTransition(r0)
        L_0x0447:
            return r17
        L_0x0448:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public final String[] getTransitionProperties() {
        return f2481a;
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z;
        boolean z2 = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.e);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        if (!SA.e(xmlPullParser, "reparentWithOverlay")) {
            z = true;
        } else {
            z = obtainStyledAttributes.getBoolean(1, true);
        }
        this.f2483a = z;
        this.b = SA.e(xmlPullParser, "reparent") ? obtainStyledAttributes.getBoolean(0, true) : z2;
        obtainStyledAttributes.recycle();
    }
}
