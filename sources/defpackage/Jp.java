package defpackage;

import android.graphics.Path;
import android.graphics.PointF;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.List;

/* renamed from: Jp  reason: default package */
/* compiled from: PolystarContent */
public final class Jp implements dp, C0335t2.a, C0381wh {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Ej f307a;

    /* renamed from: a  reason: collision with other field name */
    public final C0093Gc f308a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f309a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final String f310a;

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<?, PointF> f311a;

    /* renamed from: a  reason: collision with other field name */
    public final C0422zD f312a = new C0422zD();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f313a;
    public final C0093Gc b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f314b;
    public final C0093Gc c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f315c;
    public final C0093Gc d;
    public final C0093Gc e;
    public final C0093Gc f;

    public Jp(Ej ej, C0359v2 v2Var, Kp kp) {
        this.f307a = ej;
        this.f310a = kp.f370a;
        int i = kp.a;
        this.a = i;
        this.f313a = kp.f371a;
        this.f314b = kp.f372b;
        C0335t2<Float, Float> b2 = kp.f368a.b();
        this.f308a = (C0093Gc) b2;
        C0335t2<PointF, PointF> b3 = kp.f369a.b();
        this.f311a = b3;
        C0335t2<Float, Float> b4 = kp.b.b();
        this.b = (C0093Gc) b4;
        C0335t2<Float, Float> b5 = kp.d.b();
        this.d = (C0093Gc) b5;
        C0335t2<Float, Float> b6 = kp.f.b();
        this.f = (C0093Gc) b6;
        if (i == 1) {
            this.c = (C0093Gc) kp.c.b();
            this.e = (C0093Gc) kp.e.b();
        } else {
            this.c = null;
            this.e = null;
        }
        v2Var.g(b2);
        v2Var.g(b3);
        v2Var.g(b4);
        v2Var.g(b5);
        v2Var.g(b6);
        if (i == 1) {
            v2Var.g(this.c);
            v2Var.g(this.e);
        }
        b2.a(this);
        b3.a(this);
        b4.a(this);
        b5.a(this);
        b6.a(this);
        if (i == 1) {
            this.c.a(this);
            this.e.a(this);
        }
    }

    public final Path b() {
        Path path;
        float f2;
        float f3;
        float f4;
        double d2;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        Path path2;
        float f14;
        float f15;
        C0335t2<?, PointF> t2Var;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        double d3;
        int i;
        double d4;
        float f21;
        double d5;
        C0335t2<?, PointF> t2Var2;
        boolean z = this.f315c;
        Path path3 = this.f309a;
        if (z) {
            return path3;
        }
        path3.reset();
        if (this.f313a) {
            this.f315c = true;
            return path3;
        }
        int V = xx.V(this.a);
        C0335t2<?, PointF> t2Var3 = this.f311a;
        C0093Gc gc = this.f;
        C0093Gc gc2 = this.d;
        double d6 = 0.0d;
        C0093Gc gc3 = this.b;
        C0093Gc gc4 = this.f308a;
        if (V != 0) {
            if (V == 1) {
                int floor = (int) Math.floor((double) ((Float) gc4.f()).floatValue());
                if (gc3 != null) {
                    d6 = (double) ((Float) gc3.f()).floatValue();
                }
                double radians = Math.toRadians(d6 - 90.0d);
                double d7 = (double) floor;
                float floatValue = ((Float) gc.f()).floatValue() / 100.0f;
                float floatValue2 = ((Float) gc2.f()).floatValue();
                double d8 = (double) floatValue2;
                float cos = (float) (Math.cos(radians) * d8);
                float sin = (float) (Math.sin(radians) * d8);
                path3.moveTo(cos, sin);
                double d9 = (double) ((float) (6.283185307179586d / d7));
                double d10 = radians + d9;
                double ceil = Math.ceil(d7);
                int i2 = 0;
                double d11 = d9;
                while (((double) i2) < ceil) {
                    float cos2 = (float) (Math.cos(d10) * d8);
                    float sin2 = (float) (Math.sin(d10) * d8);
                    if (floatValue != 0.0f) {
                        double d12 = d8;
                        i = i2;
                        double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                        float cos3 = (float) Math.cos(atan2);
                        t2Var2 = t2Var3;
                        d3 = d10;
                        double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                        float f22 = floatValue2 * floatValue * 0.25f;
                        d5 = d11;
                        f21 = sin2;
                        d4 = d12;
                        path3.cubicTo(cos - (cos3 * f22), sin - (((float) Math.sin(atan2)) * f22), (((float) Math.cos(atan22)) * f22) + cos2, (f22 * ((float) Math.sin(atan22))) + sin2, cos2, f21);
                    } else {
                        i = i2;
                        t2Var2 = t2Var3;
                        d3 = d10;
                        d5 = d11;
                        f21 = sin2;
                        d4 = d8;
                        path3.lineTo(cos2, f21);
                    }
                    double d13 = d3 + d5;
                    sin = f21;
                    d8 = d4;
                    d11 = d5;
                    t2Var3 = t2Var2;
                    d10 = d13;
                    cos = cos2;
                    i2 = i + 1;
                }
                PointF f23 = t2Var3.f();
                path3.offset(f23.x, f23.y);
                path3.close();
            }
            path = path3;
        } else {
            C0335t2<?, PointF> t2Var4 = t2Var3;
            float floatValue3 = ((Float) gc4.f()).floatValue();
            if (gc3 != null) {
                d6 = (double) ((Float) gc3.f()).floatValue();
            }
            double radians2 = Math.toRadians(d6 - 90.0d);
            double d14 = (double) floatValue3;
            float f24 = (float) (6.283185307179586d / d14);
            if (this.f314b) {
                f24 *= -1.0f;
            }
            float f25 = f24;
            float f26 = f25 / 2.0f;
            float f27 = floatValue3 - ((float) ((int) floatValue3));
            int i3 = (f27 > 0.0f ? 1 : (f27 == 0.0f ? 0 : -1));
            if (i3 != 0) {
                radians2 += (double) ((1.0f - f27) * f26);
            }
            float floatValue4 = ((Float) gc2.f()).floatValue();
            float floatValue5 = ((Float) this.c.f()).floatValue();
            C0093Gc gc5 = this.e;
            if (gc5 != null) {
                f2 = ((Float) gc5.f()).floatValue() / 100.0f;
            } else {
                f2 = 0.0f;
            }
            if (gc != null) {
                f3 = ((Float) gc.f()).floatValue() / 100.0f;
            } else {
                f3 = 0.0f;
            }
            if (i3 != 0) {
                float a2 = lf.a(floatValue4, floatValue5, f27, floatValue5);
                double d15 = (double) a2;
                f4 = a2;
                f6 = (float) (Math.cos(radians2) * d15);
                f5 = (float) (Math.sin(radians2) * d15);
                path3.moveTo(f6, f5);
                d2 = radians2 + ((double) ((f25 * f27) / 2.0f));
            } else {
                double d16 = (double) floatValue4;
                float cos4 = (float) (Math.cos(radians2) * d16);
                float sin3 = (float) (d16 * Math.sin(radians2));
                path3.moveTo(cos4, sin3);
                d2 = radians2 + ((double) f26);
                f6 = cos4;
                f5 = sin3;
                f4 = 0.0f;
            }
            double ceil2 = Math.ceil(d14);
            double d17 = 2.0d;
            double d18 = ceil2 * 2.0d;
            double d19 = d2;
            int i4 = 0;
            boolean z2 = false;
            while (true) {
                double d20 = (double) i4;
                if (d20 >= d18) {
                    break;
                }
                if (z2) {
                    f7 = floatValue4;
                } else {
                    f7 = floatValue5;
                }
                int i5 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                if (i5 == 0 || d20 != d18 - d17) {
                    f8 = f26;
                } else {
                    f8 = (f25 * f27) / 2.0f;
                }
                if (i5 == 0 || d20 != d18 - 1.0d) {
                    f9 = floatValue5;
                    f11 = f7;
                    f10 = floatValue4;
                } else {
                    f9 = floatValue5;
                    f10 = floatValue4;
                    f11 = f4;
                }
                double d21 = (double) f11;
                float cos5 = (float) (Math.cos(d19) * d21);
                float sin4 = (float) (d21 * Math.sin(d19));
                if (f2 == 0.0f && f3 == 0.0f) {
                    path3.lineTo(cos5, sin4);
                    path2 = path3;
                    f12 = sin4;
                    f13 = f25;
                    f15 = f10;
                    t2Var = t2Var4;
                    f14 = f26;
                    f16 = f9;
                } else {
                    float f28 = f26;
                    path2 = path3;
                    double atan23 = (double) ((float) (Math.atan2((double) f5, (double) f6) - 1.5707963267948966d));
                    float cos6 = (float) Math.cos(atan23);
                    float sin5 = (float) Math.sin(atan23);
                    t2Var = t2Var4;
                    float f29 = f6;
                    f12 = sin4;
                    f13 = f25;
                    double atan24 = (double) ((float) (Math.atan2((double) sin4, (double) cos5) - 1.5707963267948966d));
                    float cos7 = (float) Math.cos(atan24);
                    float sin6 = (float) Math.sin(atan24);
                    if (z2) {
                        f17 = f2;
                    } else {
                        f17 = f3;
                    }
                    if (z2) {
                        f18 = f3;
                    } else {
                        f18 = f2;
                    }
                    if (z2) {
                        f19 = f9;
                    } else {
                        f19 = f10;
                    }
                    if (z2) {
                        f20 = f10;
                    } else {
                        f20 = f9;
                    }
                    float f30 = f19 * f17 * 0.47829f;
                    float f31 = cos6 * f30;
                    float f32 = f30 * sin5;
                    float f33 = f20 * f18 * 0.47829f;
                    float f34 = cos7 * f33;
                    float f35 = f33 * sin6;
                    if (i3 != 0) {
                        if (i4 == 0) {
                            f31 *= f27;
                            f32 *= f27;
                        } else if (d20 == d18 - 1.0d) {
                            f34 *= f27;
                            f35 *= f27;
                        }
                    }
                    f16 = f9;
                    f15 = f10;
                    f14 = f28;
                    path2.cubicTo(f29 - f31, f5 - f32, cos5 + f34, f12 + f35, cos5, f12);
                }
                d19 += (double) f8;
                z2 = !z2;
                i4++;
                floatValue5 = f16;
                t2Var4 = t2Var;
                f6 = cos5;
                floatValue4 = f15;
                f26 = f14;
                path3 = path2;
                f25 = f13;
                f5 = f12;
                d17 = 2.0d;
            }
            PointF f36 = t2Var4.f();
            path = path3;
            path.offset(f36.x, f36.y);
            path.close();
        }
        path.close();
        this.f312a.b(path);
        this.f315c = true;
        return path;
    }

    public final void d(List<V6> list, List<V6> list2) {
        int i = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i < arrayList.size()) {
                V6 v6 = (V6) arrayList.get(i);
                if (v6 instanceof MA) {
                    MA ma = (MA) v6;
                    if (ma.a == 1) {
                        ((List) this.f312a.f3457a).add(ma);
                        ma.e(this);
                    }
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        C0093Gc gc;
        C0093Gc gc2;
        if (obj == Kj.l) {
            this.f308a.k(tkVar);
        } else if (obj == Kj.m) {
            this.b.k(tkVar);
        } else if (obj == Kj.e) {
            this.f311a.k(tkVar);
        } else if (obj == Kj.n && (gc2 = this.c) != null) {
            gc2.k(tkVar);
        } else if (obj == Kj.o) {
            this.d.k(tkVar);
        } else if (obj == Kj.p && (gc = this.e) != null) {
            gc.k(tkVar);
        } else if (obj == Kj.q) {
            this.f.k(tkVar);
        }
    }

    public final void f() {
        this.f315c = false;
        this.f307a.invalidateSelf();
    }

    public final String getName() {
        return this.f310a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0308ql.d(uhVar, i, arrayList, uhVar2, this);
    }
}
