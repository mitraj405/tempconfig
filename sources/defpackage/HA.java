package defpackage;

import android.graphics.Matrix;
import android.graphics.PointF;
import defpackage.C0335t2;
import java.util.Collections;

/* renamed from: HA  reason: default package */
/* compiled from: TransformKeyframeAnimation */
public final class HA {
    public C0093Gc a;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f245a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    public C0335t2<PointF, PointF> f246a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f247a;
    public C0093Gc b;

    /* renamed from: b  reason: collision with other field name */
    public final Matrix f248b;

    /* renamed from: b  reason: collision with other field name */
    public C0335t2<?, PointF> f249b;
    public final Matrix c;

    /* renamed from: c  reason: collision with other field name */
    public C0335t2<bv, bv> f250c;
    public final Matrix d;

    /* renamed from: d  reason: collision with other field name */
    public C0335t2<Float, Float> f251d;
    public C0335t2<Integer, Integer> e;
    public C0335t2<?, Float> f;
    public C0335t2<?, Float> g;

    public HA(P0 p0) {
        C0335t2<PointF, PointF> t2Var;
        C0335t2<PointF, PointF> t2Var2;
        C0335t2<bv, bv> t2Var3;
        C0335t2<Float, Float> t2Var4;
        C0093Gc gc;
        C0093Gc gc2;
        nh nhVar = p0.f477a;
        if (nhVar == null) {
            t2Var = null;
        } else {
            t2Var = nhVar.b();
        }
        this.f246a = t2Var;
        R0<PointF, PointF> r0 = p0.f476a;
        if (r0 == null) {
            t2Var2 = null;
        } else {
            t2Var2 = r0.b();
        }
        this.f249b = t2Var2;
        I0 i0 = p0.f474a;
        if (i0 == null) {
            t2Var3 = null;
        } else {
            t2Var3 = i0.b();
        }
        this.f250c = t2Var3;
        H0 h0 = p0.a;
        if (h0 == null) {
            t2Var4 = null;
        } else {
            t2Var4 = h0.b();
        }
        this.f251d = t2Var4;
        H0 h02 = p0.b;
        if (h02 == null) {
            gc = null;
        } else {
            gc = (C0093Gc) h02.b();
        }
        this.a = gc;
        if (gc != null) {
            this.f248b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.f247a = new float[9];
        } else {
            this.f248b = null;
            this.c = null;
            this.d = null;
            this.f247a = null;
        }
        H0 h03 = p0.c;
        if (h03 == null) {
            gc2 = null;
        } else {
            gc2 = (C0093Gc) h03.b();
        }
        this.b = gc2;
        J0 j0 = p0.f475a;
        if (j0 != null) {
            this.e = j0.b();
        }
        H0 h04 = p0.d;
        if (h04 != null) {
            this.f = h04.b();
        } else {
            this.f = null;
        }
        H0 h05 = p0.e;
        if (h05 != null) {
            this.g = h05.b();
        } else {
            this.g = null;
        }
    }

    public final void a(C0359v2 v2Var) {
        v2Var.g(this.e);
        v2Var.g(this.f);
        v2Var.g(this.g);
        v2Var.g(this.f246a);
        v2Var.g(this.f249b);
        v2Var.g(this.f250c);
        v2Var.g(this.f251d);
        v2Var.g(this.a);
        v2Var.g(this.b);
    }

    public final void b(C0335t2.a aVar) {
        C0335t2<Integer, Integer> t2Var = this.e;
        if (t2Var != null) {
            t2Var.a(aVar);
        }
        C0335t2<?, Float> t2Var2 = this.f;
        if (t2Var2 != null) {
            t2Var2.a(aVar);
        }
        C0335t2<?, Float> t2Var3 = this.g;
        if (t2Var3 != null) {
            t2Var3.a(aVar);
        }
        C0335t2<PointF, PointF> t2Var4 = this.f246a;
        if (t2Var4 != null) {
            t2Var4.a(aVar);
        }
        C0335t2<?, PointF> t2Var5 = this.f249b;
        if (t2Var5 != null) {
            t2Var5.a(aVar);
        }
        C0335t2<bv, bv> t2Var6 = this.f250c;
        if (t2Var6 != null) {
            t2Var6.a(aVar);
        }
        C0335t2<Float, Float> t2Var7 = this.f251d;
        if (t2Var7 != null) {
            t2Var7.a(aVar);
        }
        C0093Gc gc = this.a;
        if (gc != null) {
            gc.a(aVar);
        }
        C0093Gc gc2 = this.b;
        if (gc2 != null) {
            gc2.a(aVar);
        }
    }

    public final boolean c(C0344tk tkVar, Object obj) {
        if (obj == Kj.f352a) {
            C0335t2<PointF, PointF> t2Var = this.f246a;
            if (t2Var == null) {
                this.f246a = new WB(tkVar, new PointF());
                return true;
            }
            t2Var.k(tkVar);
            return true;
        } else if (obj == Kj.b) {
            C0335t2<?, PointF> t2Var2 = this.f249b;
            if (t2Var2 == null) {
                this.f249b = new WB(tkVar, new PointF());
                return true;
            }
            t2Var2.k(tkVar);
            return true;
        } else {
            if (obj == Kj.f355a) {
                C0335t2<?, PointF> t2Var3 = this.f249b;
                if (t2Var3 instanceof Fx) {
                    Fx fx = (Fx) t2Var3;
                    C0344tk tkVar2 = fx.f223b;
                    if (tkVar2 != null) {
                        tkVar2.b = null;
                    }
                    fx.f223b = tkVar;
                    if (tkVar == null) {
                        return true;
                    }
                    tkVar.b = fx;
                    return true;
                }
            }
            if (obj == Kj.f359b) {
                C0335t2<?, PointF> t2Var4 = this.f249b;
                if (t2Var4 instanceof Fx) {
                    Fx fx2 = (Fx) t2Var4;
                    C0344tk tkVar3 = fx2.c;
                    if (tkVar3 != null) {
                        tkVar3.b = null;
                    }
                    fx2.c = tkVar;
                    if (tkVar == null) {
                        return true;
                    }
                    tkVar.b = fx2;
                    return true;
                }
            }
            if (obj == Kj.f354a) {
                C0335t2<bv, bv> t2Var5 = this.f250c;
                if (t2Var5 == null) {
                    this.f250c = new WB(tkVar, new bv());
                    return true;
                }
                t2Var5.k(tkVar);
                return true;
            } else if (obj == Kj.f365e) {
                C0335t2<Float, Float> t2Var6 = this.f251d;
                if (t2Var6 == null) {
                    this.f251d = new WB(tkVar, Float.valueOf(0.0f));
                    return true;
                }
                t2Var6.k(tkVar);
                return true;
            } else if (obj == Kj.f362c) {
                C0335t2<Integer, Integer> t2Var7 = this.e;
                if (t2Var7 == null) {
                    this.e = new WB(tkVar, 100);
                    return true;
                }
                t2Var7.k(tkVar);
                return true;
            } else if (obj == Kj.r) {
                C0335t2<?, Float> t2Var8 = this.f;
                if (t2Var8 == null) {
                    this.f = new WB(tkVar, Float.valueOf(100.0f));
                    return true;
                }
                t2Var8.k(tkVar);
                return true;
            } else if (obj == Kj.s) {
                C0335t2<?, Float> t2Var9 = this.g;
                if (t2Var9 == null) {
                    this.g = new WB(tkVar, Float.valueOf(100.0f));
                    return true;
                }
                t2Var9.k(tkVar);
                return true;
            } else if (obj == Kj.f) {
                if (this.a == null) {
                    this.a = new C0093Gc(Collections.singletonList(new Bh(Float.valueOf(0.0f))));
                }
                this.a.k(tkVar);
                return true;
            } else if (obj != Kj.g) {
                return false;
            } else {
                if (this.b == null) {
                    this.b = new C0093Gc(Collections.singletonList(new Bh(Float.valueOf(0.0f))));
                }
                this.b.k(tkVar);
                return true;
            }
        }
    }

    public final Matrix d() {
        float f2;
        float f3;
        float[] fArr;
        float f4;
        PointF f5;
        Matrix matrix = this.f245a;
        matrix.reset();
        C0335t2<?, PointF> t2Var = this.f249b;
        if (!(t2Var == null || (f5 = t2Var.f()) == null)) {
            float f6 = f5.x;
            if (!(f6 == 0.0f && f5.y == 0.0f)) {
                matrix.preTranslate(f6, f5.y);
            }
        }
        C0335t2<Float, Float> t2Var2 = this.f251d;
        if (t2Var2 != null) {
            if (t2Var2 instanceof WB) {
                f4 = t2Var2.f().floatValue();
            } else {
                f4 = ((C0093Gc) t2Var2).l();
            }
            if (f4 != 0.0f) {
                matrix.preRotate(f4);
            }
        }
        C0093Gc gc = this.a;
        if (gc != null) {
            C0093Gc gc2 = this.b;
            if (gc2 == null) {
                f2 = 0.0f;
            } else {
                f2 = (float) Math.cos(Math.toRadians((double) ((-gc2.l()) + 90.0f)));
            }
            C0093Gc gc3 = this.b;
            if (gc3 == null) {
                f3 = 1.0f;
            } else {
                f3 = (float) Math.sin(Math.toRadians((double) ((-gc3.l()) + 90.0f)));
            }
            float tan = (float) Math.tan(Math.toRadians((double) gc.l()));
            int i = 0;
            while (true) {
                fArr = this.f247a;
                if (i >= 9) {
                    break;
                }
                fArr[i] = 0.0f;
                i++;
            }
            fArr[0] = f2;
            fArr[1] = f3;
            float f7 = -f3;
            fArr[3] = f7;
            fArr[4] = f2;
            fArr[8] = 1.0f;
            Matrix matrix2 = this.f248b;
            matrix2.setValues(fArr);
            for (int i2 = 0; i2 < 9; i2++) {
                fArr[i2] = 0.0f;
            }
            fArr[0] = 1.0f;
            fArr[3] = tan;
            fArr[4] = 1.0f;
            fArr[8] = 1.0f;
            Matrix matrix3 = this.c;
            matrix3.setValues(fArr);
            for (int i3 = 0; i3 < 9; i3++) {
                fArr[i3] = 0.0f;
            }
            fArr[0] = f2;
            fArr[1] = f7;
            fArr[3] = f3;
            fArr[4] = f2;
            fArr[8] = 1.0f;
            Matrix matrix4 = this.d;
            matrix4.setValues(fArr);
            matrix3.preConcat(matrix2);
            matrix4.preConcat(matrix3);
            matrix.preConcat(matrix4);
        }
        C0335t2<bv, bv> t2Var3 = this.f250c;
        if (t2Var3 != null) {
            bv f8 = t2Var3.f();
            float f9 = f8.a;
            if (!(f9 == 1.0f && f8.b == 1.0f)) {
                matrix.preScale(f9, f8.b);
            }
        }
        C0335t2<PointF, PointF> t2Var4 = this.f246a;
        if (t2Var4 != null) {
            PointF f10 = t2Var4.f();
            float f11 = f10.x;
            if (!(f11 == 0.0f && f10.y == 0.0f)) {
                matrix.preTranslate(-f11, -f10.y);
            }
        }
        return matrix;
    }

    public final Matrix e(float f2) {
        PointF pointF;
        bv bvVar;
        float f3;
        C0335t2<?, PointF> t2Var = this.f249b;
        PointF pointF2 = null;
        if (t2Var == null) {
            pointF = null;
        } else {
            pointF = t2Var.f();
        }
        C0335t2<bv, bv> t2Var2 = this.f250c;
        if (t2Var2 == null) {
            bvVar = null;
        } else {
            bvVar = t2Var2.f();
        }
        Matrix matrix = this.f245a;
        matrix.reset();
        if (pointF != null) {
            matrix.preTranslate(pointF.x * f2, pointF.y * f2);
        }
        if (bvVar != null) {
            double d2 = (double) f2;
            matrix.preScale((float) Math.pow((double) bvVar.a, d2), (float) Math.pow((double) bvVar.b, d2));
        }
        C0335t2<Float, Float> t2Var3 = this.f251d;
        if (t2Var3 != null) {
            float floatValue = t2Var3.f().floatValue();
            C0335t2<PointF, PointF> t2Var4 = this.f246a;
            if (t2Var4 != null) {
                pointF2 = t2Var4.f();
            }
            float f4 = floatValue * f2;
            float f5 = 0.0f;
            if (pointF2 == null) {
                f3 = 0.0f;
            } else {
                f3 = pointF2.x;
            }
            if (pointF2 != null) {
                f5 = pointF2.y;
            }
            matrix.preRotate(f4, f3, f5);
        }
        return matrix;
    }
}
