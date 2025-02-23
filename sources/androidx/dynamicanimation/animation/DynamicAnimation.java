package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.core.view.f;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.a;
import java.util.ArrayList;
import java.util.WeakHashMap;

public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements a.b {
    public static final c a = new c();

    /* renamed from: a  reason: collision with other field name */
    public static final i f1981a = new i();

    /* renamed from: a  reason: collision with other field name */
    public static final j f1982a = new j();

    /* renamed from: a  reason: collision with other field name */
    public static final k f1983a = new k();

    /* renamed from: a  reason: collision with other field name */
    public static final l f1984a = new l();

    /* renamed from: a  reason: collision with other field name */
    public static final m f1985a = new m();

    /* renamed from: a  reason: collision with other field name */
    public float f1986a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public long f1987a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final FloatPropertyCompat f1988a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f1989a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<OnAnimationEndListener> f1990a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1991a = false;
    public float b = Float.MAX_VALUE;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<p> f1992b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f1993b = false;
    public final float c = -3.4028235E38f;
    public final float d;

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public static class a extends q {
        public a() {
            super("y");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getY();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setY(f);
        }
    }

    public static class b extends q {
        public b() {
            super("z");
        }

        public final float getValue(Object obj) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            return f.d.m((View) obj);
        }

        public final void setValue(Object obj, float f) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.d.x((View) obj, f);
        }
    }

    public static class c extends q {
        public c() {
            super("alpha");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getAlpha();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setAlpha(f);
        }
    }

    public static class d extends q {
        public d() {
            super("scrollX");
        }

        public final float getValue(Object obj) {
            return (float) ((View) obj).getScrollX();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setScrollX((int) f);
        }
    }

    public static class e extends q {
        public e() {
            super("scrollY");
        }

        public final float getValue(Object obj) {
            return (float) ((View) obj).getScrollY();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setScrollY((int) f);
        }
    }

    public static class f extends q {
        public f() {
            super("translationX");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getTranslationX();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setTranslationX(f);
        }
    }

    public static class g extends q {
        public g() {
            super("translationY");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getTranslationY();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setTranslationY(f);
        }
    }

    public static class h extends q {
        public h() {
            super("translationZ");
        }

        public final float getValue(Object obj) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            return f.d.l((View) obj);
        }

        public final void setValue(Object obj, float f) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.d.w((View) obj, f);
        }
    }

    public static class i extends q {
        public i() {
            super("scaleX");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getScaleX();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setScaleX(f);
        }
    }

    public static class j extends q {
        public j() {
            super("scaleY");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getScaleY();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setScaleY(f);
        }
    }

    public static class k extends q {
        public k() {
            super("rotation");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getRotation();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setRotation(f);
        }
    }

    public static class l extends q {
        public l() {
            super("rotationX");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getRotationX();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setRotationX(f);
        }
    }

    public static class m extends q {
        public m() {
            super("rotationY");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getRotationY();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setRotationY(f);
        }
    }

    public static class n extends q {
        public n() {
            super("x");
        }

        public final float getValue(Object obj) {
            return ((View) obj).getX();
        }

        public final void setValue(Object obj, float f) {
            ((View) obj).setX(f);
        }
    }

    public static class o {
        public float a;
        public float b;
    }

    public interface p {
        void a(float f);
    }

    public static abstract class q extends FloatPropertyCompat<View> {
        public q(String str) {
            super(str);
        }
    }

    static {
        new f();
        new g();
        new h();
        new n();
        new a();
        new b();
        new d();
        new e();
    }

    public <K> DynamicAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        this.f1989a = k2;
        this.f1988a = floatPropertyCompat;
        if (floatPropertyCompat == f1983a || floatPropertyCompat == f1984a || floatPropertyCompat == f1985a) {
            this.d = 0.1f;
        } else if (floatPropertyCompat == a) {
            this.d = 0.00390625f;
        } else if (floatPropertyCompat == f1981a || floatPropertyCompat == f1982a) {
            this.d = 0.00390625f;
        } else {
            this.d = 1.0f;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            long r3 = r0.f1987a
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r8 = 0
            if (r7 != 0) goto L_0x0015
            r0.f1987a = r1
            float r1 = r0.b
            r0.b(r1)
            return r8
        L_0x0015:
            long r14 = r1 - r3
            r0.f1987a = r1
            r1 = r0
            androidx.dynamicanimation.animation.SpringAnimation r1 = (androidx.dynamicanimation.animation.SpringAnimation) r1
            boolean r2 = r1.c
            r3 = 1
            r4 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r7 = 0
            if (r2 == 0) goto L_0x003f
            float r2 = r1.e
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0032
            androidx.dynamicanimation.animation.SpringForce r9 = r1.a
            double r10 = (double) r2
            r9.h = r10
            r1.e = r4
        L_0x0032:
            androidx.dynamicanimation.animation.SpringForce r2 = r1.a
            double r9 = r2.h
            float r2 = (float) r9
            r1.b = r2
            r1.f1986a = r7
            r1.c = r8
            goto L_0x00d4
        L_0x003f:
            float r2 = r1.e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0081
            androidx.dynamicanimation.animation.SpringForce r2 = r1.a
            double r9 = r2.h
            float r9 = r1.b
            double r9 = (double) r9
            float r11 = r1.f1986a
            double r11 = (double) r11
            r16 = 2
            long r23 = r14 / r16
            r16 = r2
            r17 = r9
            r19 = r11
            r21 = r23
            androidx.dynamicanimation.animation.DynamicAnimation$o r2 = r16.a(r17, r19, r21)
            androidx.dynamicanimation.animation.SpringForce r9 = r1.a
            float r10 = r1.e
            double r10 = (double) r10
            r9.h = r10
            r1.e = r4
            float r10 = r2.a
            double r10 = (double) r10
            float r2 = r2.b
            double r12 = (double) r2
            r18 = r9
            r19 = r10
            r21 = r12
            androidx.dynamicanimation.animation.DynamicAnimation$o r2 = r18.a(r19, r21, r23)
            float r9 = r2.a
            r1.b = r9
            float r2 = r2.b
            r1.f1986a = r2
            goto L_0x0095
        L_0x0081:
            androidx.dynamicanimation.animation.SpringForce r9 = r1.a
            float r2 = r1.b
            double r10 = (double) r2
            float r2 = r1.f1986a
            double r12 = (double) r2
            androidx.dynamicanimation.animation.DynamicAnimation$o r2 = r9.a(r10, r12, r14)
            float r9 = r2.a
            r1.b = r9
            float r2 = r2.b
            r1.f1986a = r2
        L_0x0095:
            float r2 = r1.b
            float r9 = r1.c
            float r2 = java.lang.Math.max(r2, r9)
            r1.b = r2
            float r2 = java.lang.Math.min(r2, r4)
            r1.b = r2
            float r9 = r1.f1986a
            androidx.dynamicanimation.animation.SpringForce r10 = r1.a
            r10.getClass()
            float r9 = java.lang.Math.abs(r9)
            double r11 = (double) r9
            double r13 = r10.d
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 >= 0) goto L_0x00c8
            double r11 = r10.h
            float r9 = (float) r11
            float r2 = r2 - r9
            float r2 = java.lang.Math.abs(r2)
            double r11 = (double) r2
            double r9 = r10.c
            int r2 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c8
            r2 = r3
            goto L_0x00c9
        L_0x00c8:
            r2 = r8
        L_0x00c9:
            if (r2 == 0) goto L_0x00d6
            androidx.dynamicanimation.animation.SpringForce r2 = r1.a
            double r9 = r2.h
            float r2 = (float) r9
            r1.b = r2
            r1.f1986a = r7
        L_0x00d4:
            r1 = r3
            goto L_0x00d7
        L_0x00d6:
            r1 = r8
        L_0x00d7:
            float r2 = r0.b
            float r2 = java.lang.Math.min(r2, r4)
            r0.b = r2
            float r4 = r0.c
            float r2 = java.lang.Math.max(r2, r4)
            r0.b = r2
            r0.b(r2)
            if (r1 == 0) goto L_0x0147
            r0.f1993b = r8
            java.lang.ThreadLocal<androidx.dynamicanimation.animation.a> r2 = androidx.dynamicanimation.animation.a.a
            java.lang.Object r4 = r2.get()
            if (r4 != 0) goto L_0x00fe
            androidx.dynamicanimation.animation.a r4 = new androidx.dynamicanimation.animation.a
            r4.<init>()
            r2.set(r4)
        L_0x00fe:
            java.lang.Object r2 = r2.get()
            androidx.dynamicanimation.animation.a r2 = (androidx.dynamicanimation.animation.a) r2
            androidx.collection.SimpleArrayMap<androidx.dynamicanimation.animation.a$b, java.lang.Long> r4 = r2.f1996a
            r4.remove(r0)
            java.util.ArrayList<androidx.dynamicanimation.animation.a$b> r4 = r2.f1999a
            int r7 = r4.indexOf(r0)
            if (r7 < 0) goto L_0x0117
            r9 = 0
            r4.set(r7, r9)
            r2.f2000a = r3
        L_0x0117:
            r0.f1987a = r5
            r0.f1991a = r8
        L_0x011b:
            java.util.ArrayList<androidx.dynamicanimation.animation.DynamicAnimation$OnAnimationEndListener> r2 = r0.f1990a
            int r3 = r2.size()
            if (r8 >= r3) goto L_0x0135
            java.lang.Object r3 = r2.get(r8)
            if (r3 == 0) goto L_0x0132
            java.lang.Object r2 = r2.get(r8)
            androidx.dynamicanimation.animation.DynamicAnimation$OnAnimationEndListener r2 = (androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener) r2
            r2.onAnimationEnd()
        L_0x0132:
            int r8 = r8 + 1
            goto L_0x011b
        L_0x0135:
            int r3 = r2.size()
        L_0x0139:
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0147
            java.lang.Object r4 = r2.get(r3)
            if (r4 != 0) goto L_0x0139
            r2.remove(r3)
            goto L_0x0139
        L_0x0147:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.dynamicanimation.animation.DynamicAnimation.a(long):boolean");
    }

    public final void b(float f2) {
        ArrayList<p> arrayList;
        this.f1988a.setValue(this.f1989a, f2);
        int i2 = 0;
        while (true) {
            arrayList = this.f1992b;
            if (i2 >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i2) != null) {
                arrayList.get(i2).a(this.b);
            }
            i2++;
        }
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }
}
