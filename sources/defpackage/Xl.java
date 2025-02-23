package defpackage;

import androidx.constraintlayout.widget.ConstraintSet;
import java.util.LinkedHashMap;

/* renamed from: Xl  reason: default package */
/* compiled from: MotionPaths */
public final class Xl implements Comparable<Xl> {
    public static final String[] a = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a  reason: collision with other field name */
    public float f679a;

    /* renamed from: a  reason: collision with other field name */
    public T9 f680a;

    /* renamed from: a  reason: collision with other field name */
    public Vl f681a = null;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashMap<String, O6> f682a = new LinkedHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public double[] f683a = new double[18];
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public double[] f684b = new double[18];
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f685c = 0;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f686d = -1;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public int f687e = -1;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public int f688f = 0;
    public float g = Float.NaN;
    public float h = Float.NaN;

    public Xl() {
    }

    public static boolean f(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            if (Float.isNaN(f2) != Float.isNaN(f3)) {
                return true;
            }
            return false;
        } else if (Math.abs(f2 - f3) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    public static void j(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f8 = (float) dArr[i];
            double d2 = dArr2[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f5 = f8;
            } else if (i2 == 2) {
                f7 = f8;
            } else if (i2 == 3) {
                f4 = f8;
            } else if (i2 == 4) {
                f6 = f8;
            }
        }
        float f9 = f5 - ((0.0f * f4) / 2.0f);
        float f10 = f7 - ((0.0f * f6) / 2.0f);
        fArr[0] = (((f4 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
        fArr[1] = (((f6 * 1.0f) + f10) * f3) + ((1.0f - f3) * f10) + 0.0f;
    }

    public final void a(ConstraintSet.a aVar) {
        boolean z;
        this.f680a = T9.c(aVar.f1666a.f1699a);
        ConstraintSet.c cVar = aVar.f1666a;
        this.f686d = cVar.f1703c;
        this.f687e = cVar.f1698a;
        this.g = cVar.b;
        this.f685c = cVar.d;
        float f2 = aVar.f1667a.b;
        this.h = aVar.f1665a.d;
        for (String next : aVar.f1670a.keySet()) {
            O6 o6 = aVar.f1670a.get(next);
            if (o6 != null) {
                int V = xx.V(o6.f463a);
                if (V == 4 || V == 5 || V == 7) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.f682a.put(next, o6);
                }
            }
        }
    }

    public final int compareTo(Object obj) {
        return Float.compare(this.b, ((Xl) obj).b);
    }

    public final void h(double d2, int[] iArr, double[] dArr, float[] fArr, int i) {
        int[] iArr2 = iArr;
        float f2 = this.c;
        float f3 = this.d;
        float f4 = this.e;
        float f5 = this.f;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f6 = (float) dArr[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f2 = f6;
            } else if (i3 == 2) {
                f3 = f6;
            } else if (i3 == 3) {
                f4 = f6;
            } else if (i3 == 4) {
                f5 = f6;
            }
        }
        Vl vl = this.f681a;
        if (vl != null) {
            float[] fArr2 = new float[2];
            vl.c(d2, fArr2, new float[2]);
            float f7 = fArr2[0];
            float f8 = fArr2[1];
            double d3 = (double) f7;
            double d4 = (double) f2;
            double d5 = (double) f3;
            f2 = (float) (((Math.sin(d5) * d4) + d3) - ((double) (f4 / 2.0f)));
            f3 = (float) ((((double) f8) - (Math.cos(d5) * d4)) - ((double) (f5 / 2.0f)));
        }
        fArr[i] = (f4 / 2.0f) + f2 + 0.0f;
        fArr[i + 1] = (f5 / 2.0f) + f3 + 0.0f;
    }

    public final void i(float f2, float f3, float f4, float f5) {
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
    }

    public final void l(Vl vl, Xl xl) {
        double d2 = (double) ((((this.e / 2.0f) + this.c) - xl.c) - (xl.e / 2.0f));
        double d3 = (double) ((((this.f / 2.0f) + this.d) - xl.d) - (xl.f / 2.0f));
        this.f681a = vl;
        this.c = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.h)) {
            this.d = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.d = (float) Math.toRadians((double) this.h);
        }
    }

    public Xl(int i, int i2, C0395xh xhVar, Xl xl, Xl xl2) {
        float f2;
        int i3;
        float f3;
        float f4;
        C0395xh xhVar2 = xhVar;
        Xl xl3 = xl;
        Xl xl4 = xl2;
        if (xl3.f687e != -1) {
            float f5 = ((float) xhVar2.a) / 100.0f;
            this.f679a = f5;
            this.f685c = xhVar2.f3413e;
            this.f688f = xhVar2.f3414f;
            float f6 = Float.isNaN(xhVar2.a) ? f5 : xhVar2.a;
            float f7 = Float.isNaN(xhVar2.b) ? f5 : xhVar2.b;
            float f8 = xl4.e;
            float f9 = xl3.e;
            float f10 = xl4.f;
            float f11 = xl3.f;
            this.b = this.f679a;
            this.e = (float) ((int) (((f8 - f9) * f6) + f9));
            this.f = (float) ((int) (((f10 - f11) * f7) + f11));
            int i4 = xhVar2.f3414f;
            if (i4 == 1) {
                float f12 = Float.isNaN(xhVar2.c) ? f5 : xhVar2.c;
                float f13 = xl4.c;
                float f14 = xl3.c;
                this.c = lf.a(f13, f14, f12, f14);
                f5 = !Float.isNaN(xhVar2.d) ? xhVar2.d : f5;
                float f15 = xl4.d;
                float f16 = xl3.d;
                this.d = lf.a(f15, f16, f5, f16);
            } else if (i4 != 2) {
                float f17 = Float.isNaN(xhVar2.c) ? f5 : xhVar2.c;
                float f18 = xl4.c;
                float f19 = xl3.c;
                this.c = lf.a(f18, f19, f17, f19);
                f5 = !Float.isNaN(xhVar2.d) ? xhVar2.d : f5;
                float f20 = xl4.d;
                float f21 = xl3.d;
                this.d = lf.a(f20, f21, f5, f21);
            } else {
                if (Float.isNaN(xhVar2.c)) {
                    float f22 = xl4.c;
                    float f23 = xl3.c;
                    f3 = lf.a(f22, f23, f5, f23);
                } else {
                    f3 = xhVar2.c * Math.min(f7, f6);
                }
                this.c = f3;
                if (Float.isNaN(xhVar2.d)) {
                    float f24 = xl4.d;
                    float f25 = xl3.d;
                    f4 = lf.a(f24, f25, f5, f25);
                } else {
                    f4 = xhVar2.d;
                }
                this.d = f4;
            }
            this.f687e = xl3.f687e;
            this.f680a = T9.c(xhVar2.f3411b);
            this.f686d = xhVar2.f3412d;
            return;
        }
        int i5 = xhVar2.f3414f;
        if (i5 == 1) {
            Xl xl5 = xl3;
            float f26 = ((float) xhVar2.a) / 100.0f;
            this.f679a = f26;
            this.f685c = xhVar2.f3413e;
            float f27 = Float.isNaN(xhVar2.a) ? f26 : xhVar2.a;
            float f28 = Float.isNaN(xhVar2.b) ? f26 : xhVar2.b;
            float f29 = xl4.e - xl5.e;
            float f30 = xl4.f - xl5.f;
            this.b = this.f679a;
            f26 = !Float.isNaN(xhVar2.c) ? xhVar2.c : f26;
            float f31 = xl5.c;
            float f32 = xl5.e;
            float f33 = xl5.d;
            float f34 = xl5.f;
            float f35 = ((xl4.e / 2.0f) + xl4.c) - ((f32 / 2.0f) + f31);
            float f36 = ((xl4.f / 2.0f) + xl4.d) - ((f34 / 2.0f) + f33);
            float f37 = f35 * f26;
            float f38 = f29 * f27;
            float f39 = f38 / 2.0f;
            this.c = (float) ((int) ((f31 + f37) - f39));
            float f40 = f26 * f36;
            float f41 = f30 * f28;
            float f42 = f41 / 2.0f;
            this.d = (float) ((int) ((f33 + f40) - f42));
            this.e = (float) ((int) (f32 + f38));
            this.f = (float) ((int) (f34 + f41));
            C0395xh xhVar3 = xhVar;
            float f43 = Float.isNaN(xhVar3.d) ? 0.0f : xhVar3.d;
            float f44 = (-f36) * f43;
            float f45 = f35 * f43;
            this.f688f = 1;
            Xl xl6 = xl;
            this.c = ((float) ((int) ((xl6.c + f37) - f39))) + f44;
            this.d = ((float) ((int) ((xl6.d + f40) - f42))) + f45;
            this.f687e = this.f687e;
            this.f680a = T9.c(xhVar3.f3411b);
            this.f686d = xhVar3.f3412d;
        } else if (i5 != 2) {
            float f46 = ((float) xhVar2.a) / 100.0f;
            this.f679a = f46;
            this.f685c = xhVar2.f3413e;
            float f47 = Float.isNaN(xhVar2.a) ? f46 : xhVar2.a;
            float f48 = Float.isNaN(xhVar2.b) ? f46 : xhVar2.b;
            float f49 = xl4.e;
            float f50 = xl3.e;
            float f51 = f49 - f50;
            float f52 = xl4.f;
            float f53 = xl3.f;
            float f54 = f52 - f53;
            this.b = this.f679a;
            float f55 = xl3.c;
            float f56 = xl3.d;
            float f57 = ((f49 / 2.0f) + xl4.c) - ((f50 / 2.0f) + f55);
            float f58 = ((f52 / 2.0f) + xl4.d) - ((f53 / 2.0f) + f56);
            float f59 = f51 * f47;
            float f60 = f59 / 2.0f;
            this.c = (float) ((int) (((f57 * f46) + f55) - f60));
            float f61 = (f58 * f46) + f56;
            float f62 = f54 * f48;
            float f63 = f62 / 2.0f;
            this.d = (float) ((int) (f61 - f63));
            this.e = (float) ((int) (f50 + f59));
            this.f = (float) ((int) (f53 + f62));
            C0395xh xhVar4 = xhVar;
            float f64 = Float.isNaN(xhVar4.c) ? f46 : xhVar4.c;
            float f65 = Float.isNaN(xhVar4.f) ? 0.0f : xhVar4.f;
            f46 = !Float.isNaN(xhVar4.d) ? xhVar4.d : f46;
            if (Float.isNaN(xhVar4.e)) {
                i3 = 0;
                f2 = 0.0f;
            } else {
                f2 = xhVar4.e;
                i3 = 0;
            }
            this.f688f = i3;
            Xl xl7 = xl;
            this.c = (float) ((int) (((f2 * f58) + ((f64 * f57) + xl7.c)) - f60));
            this.d = (float) ((int) (((f58 * f46) + ((f57 * f65) + xl7.d)) - f63));
            this.f680a = T9.c(xhVar4.f3411b);
            this.f686d = xhVar4.f3412d;
        } else {
            Xl xl8 = xl3;
            C0395xh xhVar5 = xhVar2;
            float f66 = ((float) xhVar5.a) / 100.0f;
            this.f679a = f66;
            this.f685c = xhVar5.f3413e;
            float f67 = Float.isNaN(xhVar5.a) ? f66 : xhVar5.a;
            float f68 = Float.isNaN(xhVar5.b) ? f66 : xhVar5.b;
            float f69 = xl4.e;
            float f70 = xl8.e;
            float f71 = f69 - f70;
            float f72 = xl4.f;
            float f73 = xl8.f;
            float f74 = f72 - f73;
            this.b = this.f679a;
            float f75 = xl8.c;
            float f76 = xl8.d;
            float f77 = (f69 / 2.0f) + xl4.c;
            float f78 = (f72 / 2.0f) + xl4.d;
            float f79 = f71 * f67;
            this.c = (float) ((int) ((((f77 - ((f70 / 2.0f) + f75)) * f66) + f75) - (f79 / 2.0f)));
            float f80 = f74 * f68;
            this.d = (float) ((int) ((((f78 - ((f73 / 2.0f) + f76)) * f66) + f76) - (f80 / 2.0f)));
            this.e = (float) ((int) (f70 + f79));
            this.f = (float) ((int) (f73 + f80));
            this.f688f = 2;
            C0395xh xhVar6 = xhVar;
            if (!Float.isNaN(xhVar6.c)) {
                this.c = (float) ((int) (xhVar6.c * ((float) ((int) (((float) i) - this.e)))));
            }
            if (!Float.isNaN(xhVar6.d)) {
                this.d = (float) ((int) (xhVar6.d * ((float) ((int) (((float) i2) - this.f)))));
            }
            this.f687e = this.f687e;
            this.f680a = T9.c(xhVar6.f3411b);
            this.f686d = xhVar6.f3412d;
        }
    }
}
