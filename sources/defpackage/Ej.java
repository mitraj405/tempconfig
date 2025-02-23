package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Choreographer;
import android.view.View;
import android.widget.ImageView;
import com.google.firebase.perf.util.Constants;
import defpackage.Tg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: Ej  reason: default package */
/* compiled from: LottieDrawable */
public final class Ej extends Drawable implements Drawable.Callback, Animatable {
    public Lh a;

    /* renamed from: a  reason: collision with other field name */
    public final Nj f138a;

    /* renamed from: a  reason: collision with other field name */
    public Sc f139a;

    /* renamed from: a  reason: collision with other field name */
    public Bitmap f140a;

    /* renamed from: a  reason: collision with other field name */
    public Canvas f141a;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f142a;

    /* renamed from: a  reason: collision with other field name */
    public Rect f143a;

    /* renamed from: a  reason: collision with other field name */
    public RectF f144a;

    /* renamed from: a  reason: collision with other field name */
    public C0181ej f145a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f146a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public l6 f147a;

    /* renamed from: a  reason: collision with other field name */
    public st f148a;

    /* renamed from: a  reason: collision with other field name */
    public C0343tf f149a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f150a = true;
    public Matrix b;

    /* renamed from: b  reason: collision with other field name */
    public Rect f151b;

    /* renamed from: b  reason: collision with other field name */
    public RectF f152b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f153b = false;
    public int c = 1;

    /* renamed from: c  reason: collision with other field name */
    public Matrix f154c;

    /* renamed from: c  reason: collision with other field name */
    public Rect f155c;

    /* renamed from: c  reason: collision with other field name */
    public RectF f156c;

    /* renamed from: c  reason: collision with other field name */
    public String f157c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f158c = false;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f159d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;

    /* renamed from: Ej$a */
    /* compiled from: LottieDrawable */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            Ej ej = Ej.this;
            l6 l6Var = ej.f147a;
            if (l6Var != null) {
                Nj nj = ej.f138a;
                C0181ej ejVar = nj.f449a;
                if (ejVar == null) {
                    f = 0.0f;
                } else {
                    float f2 = nj.b;
                    float f3 = ejVar.a;
                    f = (f2 - f3) / (ejVar.b - f3);
                }
                l6Var.t(f);
            }
        }
    }

    /* renamed from: Ej$b */
    /* compiled from: LottieDrawable */
    public interface b {
        void run();
    }

    public Ej() {
        Nj nj = new Nj();
        this.f138a = nj;
        a aVar = new a();
        this.e = false;
        this.f = true;
        this.d = Constants.MAX_HOST_LENGTH;
        this.f148a = st.AUTOMATIC;
        this.j = false;
        this.f142a = new Matrix();
        this.k = false;
        nj.addUpdateListener(aVar);
    }

    public static void f(RectF rectF, Rect rect) {
        rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
    }

    public final <T> void a(uh uhVar, T t, C0344tk tkVar) {
        float f2;
        l6 l6Var = this.f147a;
        if (l6Var == null) {
            this.f146a.add(new uj(this, uhVar, t, tkVar));
            return;
        }
        boolean z = true;
        if (uhVar == uh.a) {
            l6Var.e(tkVar, t);
        } else {
            C0368vh vhVar = uhVar.f3322a;
            if (vhVar != null) {
                vhVar.e(tkVar, t);
            } else {
                ArrayList arrayList = new ArrayList();
                this.f147a.i(uhVar, 0, arrayList, new uh(new String[0]));
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((uh) arrayList.get(i2)).f3322a.e(tkVar, t);
                }
                z = true ^ arrayList.isEmpty();
            }
        }
        if (z) {
            invalidateSelf();
            if (t == Kj.t) {
                Nj nj = this.f138a;
                C0181ej ejVar = nj.f449a;
                if (ejVar == null) {
                    f2 = 0.0f;
                } else {
                    float f3 = nj.b;
                    float f4 = ejVar.a;
                    f2 = (f3 - f4) / (ejVar.b - f4);
                }
                x(f2);
            }
        }
    }

    public final boolean b() {
        if (this.f150a || this.f153b) {
            return true;
        }
        return false;
    }

    public final void c() {
        C0181ej ejVar = this.f145a;
        if (ejVar != null) {
            Tg.a aVar = Th.a;
            Rect rect = ejVar.f2899a;
            List emptyList = Collections.emptyList();
            List emptyList2 = Collections.emptyList();
            P0 p0 = r16;
            P0 p02 = new P0();
            Sh sh = r1;
            Rect rect2 = rect;
            Sh sh2 = new Sh(emptyList, ejVar, "__container", -1, 1, -1, (String) null, emptyList2, p0, 0, 0, 0, 0.0f, 0.0f, rect2.width(), rect2.height(), (M0) null, (N0) null, Collections.emptyList(), 1, (H0) null, false, (nh) null, (B9) null);
            C0181ej ejVar2 = ejVar;
            l6 l6Var = new l6(this, sh, ejVar2.f2907b, ejVar2);
            this.f147a = l6Var;
            if (this.h) {
                l6Var.s(true);
            }
            this.f147a.c = this.f;
        }
    }

    public final void d() {
        Nj nj = this.f138a;
        if (nj.f451b) {
            nj.cancel();
            if (!isVisible()) {
                this.c = 1;
            }
        }
        this.f145a = null;
        this.f147a = null;
        this.f149a = null;
        nj.f449a = null;
        nj.c = -2.14748365E9f;
        nj.d = 2.14748365E9f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        if (this.f158c) {
            try {
                if (this.j) {
                    j(canvas, this.f147a);
                } else {
                    g(canvas);
                }
            } catch (Throwable unused) {
                Ai.a.getClass();
            }
        } else if (this.j) {
            j(canvas, this.f147a);
        } else {
            g(canvas);
        }
        this.k = false;
        C1354qp.G();
    }

    public final void e() {
        C0181ej ejVar = this.f145a;
        if (ejVar != null) {
            st stVar = this.f148a;
            int i2 = Build.VERSION.SDK_INT;
            boolean z = ejVar.f2906a;
            int i3 = ejVar.f2898a;
            int ordinal = stVar.ordinal();
            boolean z2 = false;
            if (ordinal != 1 && (ordinal == 2 || ((z && i2 < 28) || i3 > 4))) {
                z2 = true;
            }
            this.j = z2;
        }
    }

    public final void g(Canvas canvas) {
        l6 l6Var = this.f147a;
        C0181ej ejVar = this.f145a;
        if (l6Var != null && ejVar != null) {
            Matrix matrix = this.f142a;
            matrix.reset();
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                matrix.preScale(((float) bounds.width()) / ((float) ejVar.f2899a.width()), ((float) bounds.height()) / ((float) ejVar.f2899a.height()));
            }
            l6Var.c(canvas, matrix, this.d);
        }
    }

    public final int getAlpha() {
        return this.d;
    }

    public final int getIntrinsicHeight() {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            return -1;
        }
        return ejVar.f2899a.height();
    }

    public final int getIntrinsicWidth() {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            return -1;
        }
        return ejVar.f2899a.width();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void h() {
        this.f146a.clear();
        this.f138a.f(true);
        if (!isVisible()) {
            this.c = 1;
        }
    }

    public final void i() {
        float f2;
        float f3;
        if (this.f147a == null) {
            this.f146a.add(new qj(this));
            return;
        }
        e();
        boolean b2 = b();
        Nj nj = this.f138a;
        if (b2 || nj.getRepeatCount() == 0) {
            if (isVisible()) {
                nj.f451b = true;
                boolean e2 = nj.e();
                Iterator it = nj.b.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationStart(nj, e2);
                }
                if (nj.e()) {
                    f3 = nj.c();
                } else {
                    f3 = nj.d();
                }
                nj.g((float) ((int) f3));
                nj.f448a = 0;
                nj.f452c = 0;
                if (nj.f451b) {
                    nj.f(false);
                    Choreographer.getInstance().postFrameCallback(nj);
                }
                this.c = 1;
            } else {
                this.c = 2;
            }
        }
        if (!b()) {
            if (nj.a < 0.0f) {
                f2 = nj.d();
            } else {
                f2 = nj.c();
            }
            m((int) f2);
            nj.f(true);
            nj.a(nj.e());
            if (!isVisible()) {
                this.c = 1;
            }
        }
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final void invalidateSelf() {
        if (!this.k) {
            this.k = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public final boolean isRunning() {
        Nj nj = this.f138a;
        if (nj == null) {
            return false;
        }
        return nj.f451b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(android.graphics.Canvas r10, defpackage.l6 r11) {
        /*
            r9 = this;
            ej r0 = r9.f145a
            if (r0 == 0) goto L_0x01aa
            if (r11 != 0) goto L_0x0008
            goto L_0x01aa
        L_0x0008:
            android.graphics.Canvas r0 = r9.f141a
            if (r0 == 0) goto L_0x000d
            goto L_0x0053
        L_0x000d:
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>()
            r9.f141a = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r9.f156c = r0
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r9.b = r0
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r9.f154c = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r9.f143a = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r9.f144a = r0
            Lh r0 = new Lh
            r0.<init>()
            r9.a = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r9.f151b = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r9.f155c = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r9.f152b = r0
        L_0x0053:
            android.graphics.Matrix r0 = r9.b
            r10.getMatrix(r0)
            android.graphics.Rect r0 = r9.f143a
            r10.getClipBounds(r0)
            android.graphics.Rect r0 = r9.f143a
            android.graphics.RectF r1 = r9.f144a
            int r2 = r0.left
            float r2 = (float) r2
            int r3 = r0.top
            float r3 = (float) r3
            int r4 = r0.right
            float r4 = (float) r4
            int r0 = r0.bottom
            float r0 = (float) r0
            r1.set(r2, r3, r4, r0)
            android.graphics.Matrix r0 = r9.b
            android.graphics.RectF r1 = r9.f144a
            r0.mapRect(r1)
            android.graphics.RectF r0 = r9.f144a
            android.graphics.Rect r1 = r9.f143a
            f(r0, r1)
            boolean r0 = r9.f
            r1 = 0
            if (r0 == 0) goto L_0x0094
            android.graphics.RectF r0 = r9.f156c
            int r2 = r9.getIntrinsicWidth()
            float r2 = (float) r2
            int r3 = r9.getIntrinsicHeight()
            float r3 = (float) r3
            r4 = 0
            r0.set(r4, r4, r2, r3)
            goto L_0x009a
        L_0x0094:
            android.graphics.RectF r0 = r9.f156c
            r2 = 0
            r11.a(r0, r2, r1)
        L_0x009a:
            android.graphics.Matrix r0 = r9.b
            android.graphics.RectF r2 = r9.f156c
            r0.mapRect(r2)
            android.graphics.Rect r0 = r9.getBounds()
            int r2 = r0.width()
            float r2 = (float) r2
            int r3 = r9.getIntrinsicWidth()
            float r3 = (float) r3
            float r2 = r2 / r3
            int r0 = r0.height()
            float r0 = (float) r0
            int r3 = r9.getIntrinsicHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            android.graphics.RectF r3 = r9.f156c
            float r4 = r3.left
            float r4 = r4 * r2
            float r5 = r3.top
            float r5 = r5 * r0
            float r6 = r3.right
            float r6 = r6 * r2
            float r7 = r3.bottom
            float r7 = r7 * r0
            r3.set(r4, r5, r6, r7)
            android.graphics.drawable.Drawable$Callback r3 = r9.getCallback()
            boolean r4 = r3 instanceof android.view.View
            r5 = 1
            if (r4 != 0) goto L_0x00d6
            goto L_0x00e8
        L_0x00d6:
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r3 = r3.getParent()
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x00e8
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            boolean r3 = r3.getClipChildren()
            r3 = r3 ^ r5
            goto L_0x00e9
        L_0x00e8:
            r3 = r1
        L_0x00e9:
            if (r3 != 0) goto L_0x00fe
            android.graphics.RectF r3 = r9.f156c
            android.graphics.Rect r4 = r9.f143a
            int r6 = r4.left
            float r6 = (float) r6
            int r7 = r4.top
            float r7 = (float) r7
            int r8 = r4.right
            float r8 = (float) r8
            int r4 = r4.bottom
            float r4 = (float) r4
            r3.intersect(r6, r7, r8, r4)
        L_0x00fe:
            android.graphics.RectF r3 = r9.f156c
            float r3 = r3.width()
            double r3 = (double) r3
            double r3 = java.lang.Math.ceil(r3)
            int r3 = (int) r3
            android.graphics.RectF r4 = r9.f156c
            float r4 = r4.height()
            double r6 = (double) r4
            double r6 = java.lang.Math.ceil(r6)
            int r4 = (int) r6
            if (r3 == 0) goto L_0x01aa
            if (r4 != 0) goto L_0x011c
            goto L_0x01aa
        L_0x011c:
            android.graphics.Bitmap r6 = r9.f140a
            if (r6 == 0) goto L_0x014f
            int r6 = r6.getWidth()
            if (r6 < r3) goto L_0x014f
            android.graphics.Bitmap r6 = r9.f140a
            int r6 = r6.getHeight()
            if (r6 >= r4) goto L_0x012f
            goto L_0x014f
        L_0x012f:
            android.graphics.Bitmap r6 = r9.f140a
            int r6 = r6.getWidth()
            if (r6 > r3) goto L_0x013f
            android.graphics.Bitmap r6 = r9.f140a
            int r6 = r6.getHeight()
            if (r6 <= r4) goto L_0x015e
        L_0x013f:
            android.graphics.Bitmap r6 = r9.f140a
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6, r1, r1, r3, r4)
            r9.f140a = r6
            android.graphics.Canvas r7 = r9.f141a
            r7.setBitmap(r6)
            r9.k = r5
            goto L_0x015e
        L_0x014f:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r3, r4, r6)
            r9.f140a = r6
            android.graphics.Canvas r7 = r9.f141a
            r7.setBitmap(r6)
            r9.k = r5
        L_0x015e:
            boolean r5 = r9.k
            if (r5 == 0) goto L_0x019a
            android.graphics.Matrix r5 = r9.f142a
            android.graphics.Matrix r6 = r9.b
            r5.set(r6)
            r5.preScale(r2, r0)
            android.graphics.RectF r0 = r9.f156c
            float r2 = r0.left
            float r2 = -r2
            float r0 = r0.top
            float r0 = -r0
            r5.postTranslate(r2, r0)
            android.graphics.Bitmap r0 = r9.f140a
            r0.eraseColor(r1)
            android.graphics.Canvas r0 = r9.f141a
            int r2 = r9.d
            r11.c(r0, r5, r2)
            android.graphics.Matrix r11 = r9.b
            android.graphics.Matrix r0 = r9.f154c
            r11.invert(r0)
            android.graphics.Matrix r11 = r9.f154c
            android.graphics.RectF r0 = r9.f152b
            android.graphics.RectF r2 = r9.f156c
            r11.mapRect(r0, r2)
            android.graphics.RectF r11 = r9.f152b
            android.graphics.Rect r0 = r9.f155c
            f(r11, r0)
        L_0x019a:
            android.graphics.Rect r11 = r9.f151b
            r11.set(r1, r1, r3, r4)
            android.graphics.Bitmap r11 = r9.f140a
            android.graphics.Rect r0 = r9.f151b
            android.graphics.Rect r1 = r9.f155c
            Lh r2 = r9.a
            r10.drawBitmap(r11, r0, r1, r2)
        L_0x01aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ej.j(android.graphics.Canvas, l6):void");
    }

    public final void k() {
        float f2;
        if (this.f147a == null) {
            this.f146a.add(new zj(this));
            return;
        }
        e();
        boolean b2 = b();
        Nj nj = this.f138a;
        if (b2 || nj.getRepeatCount() == 0) {
            if (isVisible()) {
                nj.f451b = true;
                nj.f(false);
                Choreographer.getInstance().postFrameCallback(nj);
                nj.f448a = 0;
                if (nj.e() && nj.b == nj.d()) {
                    nj.b = nj.c();
                } else if (!nj.e() && nj.b == nj.c()) {
                    nj.b = nj.d();
                }
                this.c = 1;
            } else {
                this.c = 3;
            }
        }
        if (!b()) {
            if (nj.a < 0.0f) {
                f2 = nj.d();
            } else {
                f2 = nj.c();
            }
            m((int) f2);
            nj.f(true);
            nj.a(nj.e());
            if (!isVisible()) {
                this.c = 1;
            }
        }
    }

    public final boolean l(C0181ej ejVar) {
        boolean z = false;
        if (this.f145a == ejVar) {
            return false;
        }
        this.k = true;
        d();
        this.f145a = ejVar;
        c();
        Nj nj = this.f138a;
        if (nj.f449a == null) {
            z = true;
        }
        nj.f449a = ejVar;
        if (z) {
            nj.h(Math.max(nj.c, ejVar.a), Math.min(nj.d, ejVar.b));
        } else {
            nj.h((float) ((int) ejVar.a), (float) ((int) ejVar.b));
        }
        float f2 = nj.b;
        nj.b = 0.0f;
        nj.g((float) ((int) f2));
        nj.b();
        x(nj.getAnimatedFraction());
        ArrayList<b> arrayList = this.f146a;
        Iterator it = new ArrayList(arrayList).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.run();
            }
            it.remove();
        }
        arrayList.clear();
        ejVar.f2905a.f3327a = this.g;
        e();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable((Drawable) null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public final void m(int i2) {
        if (this.f145a == null) {
            this.f146a.add(new rj(this, i2));
        } else {
            this.f138a.g((float) i2);
        }
    }

    public final void n(int i2) {
        if (this.f145a == null) {
            this.f146a.add(new yj(this, i2));
            return;
        }
        Nj nj = this.f138a;
        nj.h(nj.c, ((float) i2) + 0.99f);
    }

    public final void o(String str) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new Aj(this, str));
            return;
        }
        C0307qk c2 = ejVar.c(str);
        if (c2 != null) {
            n((int) (c2.a + c2.b));
            return;
        }
        throw new IllegalArgumentException(lf.j("Cannot find marker with name ", str, "."));
    }

    public final void p(float f2) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new Dj(this, f2));
            return;
        }
        float f3 = ejVar.a;
        float f4 = ejVar.b;
        PointF pointF = C0308ql.a;
        float a2 = lf.a(f4, f3, f2, f3);
        Nj nj = this.f138a;
        nj.h(nj.c, a2);
    }

    public final void q(int i2, int i3) {
        if (this.f145a == null) {
            this.f146a.add(new sj(this, i2, i3));
            return;
        }
        this.f138a.h((float) i2, ((float) i3) + 0.99f);
    }

    public final void r(String str) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new tj(this, str));
            return;
        }
        C0307qk c2 = ejVar.c(str);
        if (c2 != null) {
            int i2 = (int) c2.a;
            q(i2, ((int) c2.b) + i2);
            return;
        }
        throw new IllegalArgumentException(lf.j("Cannot find marker with name ", str, "."));
    }

    public final void s(String str, String str2, boolean z) {
        float f2;
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new Bj(this, str, str2, z));
            return;
        }
        C0307qk c2 = ejVar.c(str);
        if (c2 != null) {
            int i2 = (int) c2.a;
            C0307qk c3 = this.f145a.c(str2);
            if (c3 != null) {
                if (z) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                q(i2, (int) (c3.a + f2));
                return;
            }
            throw new IllegalArgumentException(lf.j("Cannot find marker with name ", str2, "."));
        }
        throw new IllegalArgumentException(lf.j("Cannot find marker with name ", str, "."));
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public final void setAlpha(int i2) {
        this.d = i2;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Ai.b("Use addColorFilter instead.");
    }

    public final boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            int i2 = this.c;
            if (i2 == 2) {
                i();
            } else if (i2 == 3) {
                k();
            }
        } else if (this.f138a.f451b) {
            h();
            this.c = 3;
        } else if (!z3) {
            this.c = 1;
        }
        return visible;
    }

    public final void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || !((View) callback).isInEditMode()) {
            i();
        }
    }

    public final void stop() {
        this.f146a.clear();
        Nj nj = this.f138a;
        nj.f(true);
        nj.a(nj.e());
        if (!isVisible()) {
            this.c = 1;
        }
    }

    public final void t(float f2, float f3) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new vj(this, f2, f3));
            return;
        }
        float f4 = ejVar.a;
        float f5 = ejVar.b;
        PointF pointF = C0308ql.a;
        q((int) lf.a(f5, f4, f2, f4), (int) lf.a(f5, f4, f3, f4));
    }

    public final void u(int i2) {
        if (this.f145a == null) {
            this.f146a.add(new wj(this, i2));
            return;
        }
        Nj nj = this.f138a;
        nj.h((float) i2, (float) ((int) nj.d));
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v(String str) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new Cj(this, str));
            return;
        }
        C0307qk c2 = ejVar.c(str);
        if (c2 != null) {
            u((int) c2.a);
            return;
        }
        throw new IllegalArgumentException(lf.j("Cannot find marker with name ", str, "."));
    }

    public final void w(float f2) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new xj(this, f2));
            return;
        }
        float f3 = ejVar.a;
        float f4 = ejVar.b;
        PointF pointF = C0308ql.a;
        u((int) lf.a(f4, f3, f2, f3));
    }

    public final void x(float f2) {
        C0181ej ejVar = this.f145a;
        if (ejVar == null) {
            this.f146a.add(new pj(this, f2));
            return;
        }
        float f3 = ejVar.a;
        float f4 = ejVar.b;
        PointF pointF = C0308ql.a;
        this.f138a.g(lf.a(f4, f3, f2, f3));
        C1354qp.G();
    }
}
