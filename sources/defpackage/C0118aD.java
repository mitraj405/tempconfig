package defpackage;

/* renamed from: aD  reason: default package and case insensitive filesystem */
/* compiled from: ViewingConditions */
public final class C0118aD {
    public static final C0118aD a;

    /* renamed from: a  reason: collision with other field name */
    public final float f796a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f797a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    static {
        float f2;
        float f3;
        float[] fArr = r1.f3209a;
        float V = (float) ((((double) r1.V()) * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = r1.f3211a;
        float f4 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f5 = fArr[1];
        float f6 = fArr3[1] * f5;
        float f7 = fArr[2];
        float f8 = (fArr3[2] * f7) + f6 + (fArr3[0] * f4);
        float[] fArr4 = fArr2[1];
        float f9 = (fArr4[2] * f7) + (fArr4[1] * f5) + (fArr4[0] * f4);
        float[] fArr5 = fArr2[2];
        float f10 = (f7 * fArr5[2]) + (f5 * fArr5[1]) + (f4 * fArr5[0]);
        if (((double) 1.0f) >= 0.9d) {
            f3 = 0.100000046f;
            f2 = 0.59f;
        } else {
            f3 = 0.12999998f;
            f2 = 0.525f;
        }
        float f11 = f3 + f2;
        float exp = (1.0f - (((float) Math.exp((double) (((-V) - 42.0f) / 92.0f))) * 0.2777778f)) * 1.0f;
        double d2 = (double) exp;
        if (d2 > 1.0d) {
            exp = 1.0f;
        } else if (d2 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f8) * exp) + 1.0f) - exp, (((100.0f / f9) * exp) + 1.0f) - exp, (((100.0f / f10) * exp) + 1.0f) - exp};
        float f12 = 1.0f / ((5.0f * V) + 1.0f);
        float f13 = f12 * f12 * f12 * f12;
        float f14 = 1.0f - f13;
        float cbrt = (0.1f * f14 * f14 * ((float) Math.cbrt(((double) V) * 5.0d))) + (f13 * V);
        float V2 = r1.V() / fArr[1];
        double d3 = (double) V2;
        float sqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float pow2 = (float) Math.pow(((double) ((fArr6[2] * cbrt) * f10)) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((double) ((fArr6[0] * cbrt) * f8)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr6[1] * cbrt) * f9)) / 100.0d, 0.42d), pow2};
        float f15 = fArr7[0];
        float f16 = fArr7[1];
        a = new C0118aD(V2, ((((400.0f * pow2) / (pow2 + 27.13f)) * 0.05f) + (((f15 * 400.0f) / (f15 + 27.13f)) * 2.0f) + ((f16 * 400.0f) / (f16 + 27.13f))) * pow, pow, pow, f11, 1.0f, fArr6, cbrt, (float) Math.pow((double) cbrt, 0.25d), sqrt);
    }

    public C0118aD(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f = f2;
        this.f796a = f3;
        this.b = f4;
        this.c = f5;
        this.d = f6;
        this.e = f7;
        this.f797a = fArr;
        this.g = f8;
        this.h = f9;
        this.i = f10;
    }
}
