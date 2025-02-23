package defpackage;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.core.view.f;
import java.util.WeakHashMap;

/* renamed from: b2  reason: default package and case insensitive filesystem */
/* compiled from: AutoScrollHelper */
public abstract class C0139b2 implements View.OnTouchListener {
    public static final int e = ViewConfiguration.getTapTimeout();
    public final View a;

    /* renamed from: a  reason: collision with other field name */
    public final AccelerateInterpolator f2712a = new AccelerateInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public final a f2713a;

    /* renamed from: a  reason: collision with other field name */
    public b f2714a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2715a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f2716a;
    public boolean b;

    /* renamed from: b  reason: collision with other field name */
    public final float[] f2717b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2718c;

    /* renamed from: c  reason: collision with other field name */
    public final float[] f2719c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2720d;

    /* renamed from: d  reason: collision with other field name */
    public final float[] f2721d;

    /* renamed from: e  reason: collision with other field name */
    public boolean f2722e;

    /* renamed from: e  reason: collision with other field name */
    public final float[] f2723e;

    /* renamed from: b2$a */
    /* compiled from: AutoScrollHelper */
    public static class a {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public int f2724a;

        /* renamed from: a  reason: collision with other field name */
        public long f2725a = Long.MIN_VALUE;
        public float b;

        /* renamed from: b  reason: collision with other field name */
        public int f2726b;

        /* renamed from: b  reason: collision with other field name */
        public long f2727b = 0;
        public float c;

        /* renamed from: c  reason: collision with other field name */
        public int f2728c;

        /* renamed from: c  reason: collision with other field name */
        public long f2729c = -1;

        public final float a(long j) {
            long j2 = this.f2725a;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.f2729c;
            if (j3 < 0 || j < j3) {
                return C0139b2.b(((float) (j - j2)) / ((float) this.f2724a), 0.0f, 1.0f) * 0.5f;
            }
            float f = this.c;
            return (C0139b2.b(((float) (j - j3)) / ((float) this.f2728c), 0.0f, 1.0f) * f) + (1.0f - f);
        }
    }

    /* renamed from: b2$b */
    /* compiled from: AutoScrollHelper */
    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            boolean z;
            C0139b2 b2Var = C0139b2.this;
            if (b2Var.f2720d) {
                boolean z2 = b2Var.b;
                a aVar = b2Var.f2713a;
                if (z2) {
                    b2Var.b = false;
                    aVar.getClass();
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar.f2725a = currentAnimationTimeMillis;
                    aVar.f2729c = -1;
                    aVar.f2727b = currentAnimationTimeMillis;
                    aVar.c = 0.5f;
                }
                if (aVar.f2729c <= 0 || AnimationUtils.currentAnimationTimeMillis() <= aVar.f2729c + ((long) aVar.f2728c)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || !b2Var.e()) {
                    b2Var.f2720d = false;
                    return;
                }
                boolean z3 = b2Var.f2718c;
                View view = b2Var.a;
                if (z3) {
                    b2Var.f2718c = false;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar.f2727b != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a2 = aVar.a(currentAnimationTimeMillis2);
                    aVar.f2727b = currentAnimationTimeMillis2;
                    ((hi) b2Var).a.scrollListBy((int) (((float) (currentAnimationTimeMillis2 - aVar.f2727b)) * ((a2 * 4.0f) + (-4.0f * a2 * a2)) * aVar.b));
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    view.postOnAnimation(this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public C0139b2(View view) {
        a aVar = new a();
        this.f2713a = aVar;
        float[] fArr = {0.0f, 0.0f};
        this.f2716a = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2717b = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f2719c = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f2721d = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2723e = fArr5;
        this.a = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((float) ((int) ((1575.0f * f) + 0.5f))) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((float) ((int) ((f * 315.0f) + 0.5f))) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.c = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.d = e;
        aVar.f2724a = 500;
        aVar.f2726b = 500;
    }

    public static float b(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f2716a
            r0 = r0[r7]
            float[] r1 = r3.f2717b
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f2712a
            if (r5 >= 0) goto L_0x0025
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L_0x002d
        L_0x0025:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x0036
            float r4 = r0.getInterpolation(r4)
        L_0x002d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L_0x0037
        L_0x0036:
            r4 = r2
        L_0x0037:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x003c
            return r2
        L_0x003c:
            float[] r0 = r3.f2719c
            r0 = r0[r7]
            float[] r1 = r3.f2721d
            r1 = r1[r7]
            float[] r2 = r3.f2723e
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L_0x0051
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            return r4
        L_0x0051:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = b(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0139b2.a(float, float, float, int):float");
    }

    public final float c(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.c;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (!this.f2720d || i != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.b) {
            this.f2720d = false;
            return;
        }
        a aVar = this.f2713a;
        aVar.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - aVar.f2725a);
        int i3 = aVar.f2726b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        aVar.f2728c = i;
        aVar.c = aVar.a(currentAnimationTimeMillis);
        aVar.f2729c = currentAnimationTimeMillis;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e() {
        /*
            r9 = this;
            b2$a r0 = r9.f2713a
            float r1 = r0.b
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.a
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 0
            if (r1 == 0) goto L_0x0055
            r3 = r9
            hi r3 = (defpackage.hi) r3
            android.widget.ListView r3 = r3.a
            int r4 = r3.getCount()
            r5 = 1
            if (r4 != 0) goto L_0x0023
        L_0x0021:
            r1 = r2
            goto L_0x0051
        L_0x0023:
            int r6 = r3.getChildCount()
            int r7 = r3.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L_0x0041
            if (r8 < r4) goto L_0x0050
            int r6 = r6 - r5
            android.view.View r1 = r3.getChildAt(r6)
            int r1 = r1.getBottom()
            int r3 = r3.getHeight()
            if (r1 > r3) goto L_0x0050
            goto L_0x0021
        L_0x0041:
            if (r1 >= 0) goto L_0x0021
            if (r7 > 0) goto L_0x0050
            android.view.View r1 = r3.getChildAt(r2)
            int r1 = r1.getTop()
            if (r1 < 0) goto L_0x0050
            goto L_0x0021
        L_0x0050:
            r1 = r5
        L_0x0051:
            if (r1 != 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r2 = r5
        L_0x0055:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0139b2.e():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f2722e
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r8 = 3
            if (r0 == r8) goto L_0x0016
            goto L_0x007b
        L_0x0016:
            r7.d()
            goto L_0x007b
        L_0x001a:
            r7.f2718c = r2
            r7.f2715a = r1
        L_0x001e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.a
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            b2$a r9 = r7.f2713a
            r9.a = r0
            r9.b = r8
            boolean r8 = r7.f2720d
            if (r8 != 0) goto L_0x007b
            boolean r8 = r7.e()
            if (r8 == 0) goto L_0x007b
            b2$b r8 = r7.f2714a
            if (r8 != 0) goto L_0x005f
            b2$b r8 = new b2$b
            r8.<init>()
            r7.f2714a = r8
        L_0x005f:
            r7.f2720d = r2
            r7.b = r2
            boolean r8 = r7.f2715a
            if (r8 != 0) goto L_0x0074
            int r8 = r7.d
            if (r8 <= 0) goto L_0x0074
            b2$b r9 = r7.f2714a
            long r5 = (long) r8
            java.util.WeakHashMap<android.view.View, GC> r8 = androidx.core.view.f.f1839a
            r4.postOnAnimationDelayed(r9, r5)
            goto L_0x0079
        L_0x0074:
            b2$b r8 = r7.f2714a
            r8.run()
        L_0x0079:
            r7.f2715a = r2
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0139b2.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
