package defpackage;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import java.util.Iterator;

/* renamed from: Nj  reason: default package */
/* compiled from: LottieValueAnimator */
public final class Nj extends w2 implements Choreographer.FrameCallback {
    public float a = 1.0f;

    /* renamed from: a  reason: collision with other field name */
    public long f448a = 0;

    /* renamed from: a  reason: collision with other field name */
    public C0181ej f449a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f450a = false;
    public float b = 0.0f;

    /* renamed from: b  reason: collision with other field name */
    public boolean f451b = false;
    public float c = -2.14748365E9f;

    /* renamed from: c  reason: collision with other field name */
    public int f452c = 0;
    public float d = 2.14748365E9f;

    public final float c() {
        C0181ej ejVar = this.f449a;
        if (ejVar == null) {
            return 0.0f;
        }
        float f = this.d;
        if (f == 2.14748365E9f) {
            return ejVar.b;
        }
        return f;
    }

    public final void cancel() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        a(e());
        f(true);
    }

    public final float d() {
        C0181ej ejVar = this.f449a;
        if (ejVar == null) {
            return 0.0f;
        }
        float f = this.c;
        if (f == -2.14748365E9f) {
            return ejVar.a;
        }
        return f;
    }

    public final void doFrame(long j) {
        boolean z;
        float f;
        float f2;
        if (this.f451b) {
            f(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        C0181ej ejVar = this.f449a;
        if (ejVar != null && this.f451b) {
            long j2 = this.f448a;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float abs = ((float) j3) / ((1.0E9f / ejVar.c) / Math.abs(this.a));
            float f3 = this.b;
            if (e()) {
                abs = -abs;
            }
            float f4 = f3 + abs;
            this.b = f4;
            float d2 = d();
            float c2 = c();
            PointF pointF = C0308ql.a;
            if (f4 < d2 || f4 > c2) {
                z = false;
            } else {
                z = true;
            }
            boolean z2 = !z;
            this.b = C0308ql.b(this.b, d(), c());
            this.f448a = j;
            b();
            if (z2) {
                if (getRepeatCount() == -1 || this.f452c < getRepeatCount()) {
                    Iterator it = this.b.iterator();
                    while (it.hasNext()) {
                        ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
                    }
                    this.f452c++;
                    if (getRepeatMode() == 2) {
                        this.f450a = !this.f450a;
                        this.a = -this.a;
                    } else {
                        if (e()) {
                            f = c();
                        } else {
                            f = d();
                        }
                        this.b = f;
                    }
                    this.f448a = j;
                } else {
                    if (this.a < 0.0f) {
                        f2 = d();
                    } else {
                        f2 = c();
                    }
                    this.b = f2;
                    f(true);
                    a(e());
                }
            }
            if (this.f449a != null) {
                float f5 = this.b;
                if (f5 < this.c || f5 > this.d) {
                    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.c), Float.valueOf(this.d), Float.valueOf(this.b)}));
                }
            }
            C1354qp.G();
        }
    }

    public final boolean e() {
        if (this.a < 0.0f) {
            return true;
        }
        return false;
    }

    public final void f(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f451b = false;
        }
    }

    public final void g(float f) {
        if (this.b != f) {
            this.b = C0308ql.b(f, d(), c());
            this.f448a = 0;
            b();
        }
    }

    public final float getAnimatedFraction() {
        float d2;
        float c2;
        float d3;
        if (this.f449a == null) {
            return 0.0f;
        }
        if (e()) {
            d2 = c() - this.b;
            c2 = c();
            d3 = d();
        } else {
            d2 = this.b - d();
            c2 = c();
            d3 = d();
        }
        return d2 / (c2 - d3);
    }

    public final Object getAnimatedValue() {
        float f;
        C0181ej ejVar = this.f449a;
        if (ejVar == null) {
            f = 0.0f;
        } else {
            float f2 = this.b;
            float f3 = ejVar.a;
            f = (f2 - f3) / (ejVar.b - f3);
        }
        return Float.valueOf(f);
    }

    public final long getDuration() {
        C0181ej ejVar = this.f449a;
        if (ejVar == null) {
            return 0;
        }
        return (long) ejVar.b();
    }

    public final void h(float f, float f2) {
        float f3;
        float f4;
        if (f <= f2) {
            C0181ej ejVar = this.f449a;
            if (ejVar == null) {
                f3 = -3.4028235E38f;
            } else {
                f3 = ejVar.a;
            }
            if (ejVar == null) {
                f4 = Float.MAX_VALUE;
            } else {
                f4 = ejVar.b;
            }
            float b2 = C0308ql.b(f, f3, f4);
            float b3 = C0308ql.b(f2, f3, f4);
            if (b2 != this.c || b3 != this.d) {
                this.c = b2;
                this.d = b3;
                g((float) ((int) C0308ql.b(this.b, b2, b3)));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
    }

    public final boolean isRunning() {
        return this.f451b;
    }

    public final void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.f450a) {
            this.f450a = false;
            this.a = -this.a;
        }
    }
}
