package defpackage;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* renamed from: Bh  reason: default package */
/* compiled from: Keyframe */
public class Bh<T> {
    public final float a;

    /* renamed from: a  reason: collision with other field name */
    public int f60a;

    /* renamed from: a  reason: collision with other field name */
    public PointF f61a;

    /* renamed from: a  reason: collision with other field name */
    public final Interpolator f62a;

    /* renamed from: a  reason: collision with other field name */
    public final C0181ej f63a;

    /* renamed from: a  reason: collision with other field name */
    public Float f64a;

    /* renamed from: a  reason: collision with other field name */
    public final T f65a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public int f66b;

    /* renamed from: b  reason: collision with other field name */
    public PointF f67b;

    /* renamed from: b  reason: collision with other field name */
    public final Interpolator f68b;

    /* renamed from: b  reason: collision with other field name */
    public T f69b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public final Interpolator f70c;
    public float d;
    public float e;

    public Bh(C0181ej ejVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.f60a = 784923401;
        this.f66b = 784923401;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f61a = null;
        this.f67b = null;
        this.f63a = ejVar;
        this.f65a = t;
        this.f69b = t2;
        this.f62a = interpolator;
        this.f68b = null;
        this.f70c = null;
        this.a = f;
        this.f64a = f2;
    }

    public final float a() {
        C0181ej ejVar = this.f63a;
        if (ejVar == null) {
            return 1.0f;
        }
        if (this.e == Float.MIN_VALUE) {
            if (this.f64a == null) {
                this.e = 1.0f;
            } else {
                this.e = ((this.f64a.floatValue() - this.a) / (ejVar.b - ejVar.a)) + b();
            }
        }
        return this.e;
    }

    public final float b() {
        C0181ej ejVar = this.f63a;
        if (ejVar == null) {
            return 0.0f;
        }
        if (this.d == Float.MIN_VALUE) {
            float f = ejVar.a;
            this.d = (this.a - f) / (ejVar.b - f);
        }
        return this.d;
    }

    public final boolean c() {
        if (this.f62a == null && this.f68b == null && this.f70c == null) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f65a + ", endValue=" + this.f69b + ", startFrame=" + this.a + ", endFrame=" + this.f64a + ", interpolator=" + this.f62a + '}';
    }

    public Bh(C0181ej ejVar, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.f60a = 784923401;
        this.f66b = 784923401;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f61a = null;
        this.f67b = null;
        this.f63a = ejVar;
        this.f65a = obj;
        this.f69b = obj2;
        this.f62a = null;
        this.f68b = interpolator;
        this.f70c = interpolator2;
        this.a = f;
        this.f64a = null;
    }

    public Bh(C0181ej ejVar, PointF pointF, PointF pointF2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.f60a = 784923401;
        this.f66b = 784923401;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f61a = null;
        this.f67b = null;
        this.f63a = ejVar;
        this.f65a = pointF;
        this.f69b = pointF2;
        this.f62a = interpolator;
        this.f68b = interpolator2;
        this.f70c = interpolator3;
        this.a = f;
        this.f64a = f2;
    }

    public Bh(T t) {
        this.b = -3987645.8f;
        this.c = -3987645.8f;
        this.f60a = 784923401;
        this.f66b = 784923401;
        this.d = Float.MIN_VALUE;
        this.e = Float.MIN_VALUE;
        this.f61a = null;
        this.f67b = null;
        this.f63a = null;
        this.f65a = t;
        this.f69b = t;
        this.f62a = null;
        this.f68b = null;
        this.f70c = null;
        this.a = Float.MIN_VALUE;
        this.f64a = Float.valueOf(Float.MAX_VALUE);
    }
}
