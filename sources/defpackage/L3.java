package defpackage;

import android.graphics.Color;

/* renamed from: L3  reason: default package */
/* compiled from: CamColor */
public final class L3 {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public L3(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.d = f5;
        this.e = f6;
        this.f = f7;
    }

    public static L3 a(int i) {
        float f2;
        C0118aD aDVar = C0118aD.a;
        float D = r1.D(Color.red(i));
        float D2 = r1.D(Color.green(i));
        float D3 = r1.D(Color.blue(i));
        float[][] fArr = r1.f3216c;
        float[] fArr2 = fArr[0];
        float f3 = fArr2[1] * D2;
        float f4 = (fArr2[2] * D3) + f3 + (fArr2[0] * D);
        float[] fArr3 = fArr[1];
        float f5 = fArr3[1] * D2;
        float f6 = (fArr3[2] * D3) + f5 + (fArr3[0] * D);
        float[] fArr4 = fArr[2];
        float f7 = (D3 * fArr4[2]) + (D2 * fArr4[1]) + (D * fArr4[0]);
        float[][] fArr5 = r1.f3211a;
        float[] fArr6 = fArr5[0];
        float f8 = fArr6[1] * f6;
        float f9 = (fArr6[2] * f7) + f8 + (fArr6[0] * f4);
        float[] fArr7 = fArr5[1];
        float f10 = fArr7[1] * f6;
        float f11 = fArr7[2] * f7;
        float[] fArr8 = fArr5[2];
        float f12 = f4 * fArr8[0];
        float f13 = f7 * fArr8[2];
        float[] fArr9 = aDVar.f797a;
        float f14 = fArr9[0] * f9;
        float f15 = fArr9[1] * (f11 + f10 + (fArr7[0] * f4));
        float f16 = fArr9[2] * (f13 + (f6 * fArr8[1]) + f12);
        float abs = Math.abs(f14);
        float f17 = aDVar.g;
        float pow = (float) Math.pow(((double) (abs * f17)) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow(((double) (Math.abs(f15) * f17)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow(((double) (Math.abs(f16) * f17)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f14) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f15) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f16) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d2 = (double) signum3;
        float f18 = ((float) (((((double) signum2) * -12.0d) + (((double) signum) * 11.0d)) + d2)) / 11.0f;
        float f19 = ((float) (((double) (signum + signum2)) - (d2 * 2.0d))) / 9.0f;
        float f20 = signum2 * 20.0f;
        float f21 = ((21.0f * signum3) + ((signum * 20.0f) + f20)) / 20.0f;
        float f22 = (((signum * 40.0f) + f20) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2((double) f19, (double) f18)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f23 = atan2;
        float f24 = (3.1415927f * f23) / 180.0f;
        float f25 = f22 * aDVar.b;
        float f26 = aDVar.f796a;
        double d3 = (double) (f25 / f26);
        float f27 = aDVar.i;
        float f28 = aDVar.d;
        float pow4 = ((float) Math.pow(d3, (double) (f27 * f28))) * 100.0f;
        Math.sqrt((double) (pow4 / 100.0f));
        float f29 = f26 + 4.0f;
        if (((double) f23) < 20.14d) {
            f2 = 360.0f + f23;
        } else {
            f2 = f23;
        }
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, (double) aDVar.f), 0.73d)) * ((float) Math.pow((double) ((((((((float) (Math.cos(((((double) f2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * aDVar.e) * aDVar.c) * ((float) Math.sqrt((double) ((f19 * f19) + (f18 * f18))))) / (f21 + 0.305f)), 0.9d));
        float sqrt = ((float) Math.sqrt(((double) pow4) / 100.0d)) * pow5;
        Math.sqrt((double) ((pow5 * f28) / f29));
        float f30 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((double) ((aDVar.h * sqrt * 0.0228f) + 1.0f))) * 43.85965f;
        double d4 = (double) f24;
        return new L3(f23, sqrt, pow4, f30, ((float) Math.cos(d4)) * log, log * ((float) Math.sin(d4)));
    }

    public static L3 b(float f2, float f3, float f4) {
        C0118aD aDVar = C0118aD.a;
        float f5 = aDVar.d;
        double d2 = ((double) f2) / 100.0d;
        Math.sqrt(d2);
        Math.sqrt((double) (((f3 / ((float) Math.sqrt(d2))) * aDVar.d) / (aDVar.f796a + 4.0f)));
        float f6 = (1.7f * f2) / ((0.007f * f2) + 1.0f);
        float log = ((float) Math.log((((double) (aDVar.h * f3)) * 0.0228d) + 1.0d)) * 43.85965f;
        double d3 = (double) ((3.1415927f * f4) / 180.0f);
        return new L3(f4, f3, f2, f6, log * ((float) Math.cos(d3)), log * ((float) Math.sin(d3)));
    }

    public final int c(C0118aD aDVar) {
        float f2;
        C0118aD aDVar2 = aDVar;
        float f3 = this.b;
        int i = (((double) f3) > 0.0d ? 1 : (((double) f3) == 0.0d ? 0 : -1));
        float f4 = this.c;
        if (i != 0) {
            double d2 = (double) f4;
            if (d2 != 0.0d) {
                f2 = f3 / ((float) Math.sqrt(d2 / 100.0d));
                float pow = (float) Math.pow(((double) f2) / Math.pow(1.64d - Math.pow(0.29d, (double) aDVar2.f), 0.73d), 1.1111111111111112d);
                double d3 = (double) ((this.a * 3.1415927f) / 180.0f);
                float pow2 = aDVar2.f796a * ((float) Math.pow(((double) f4) / 100.0d, (1.0d / ((double) aDVar2.d)) / ((double) aDVar2.i)));
                float cos = ((float) (Math.cos(2.0d + d3) + 3.8d)) * 0.25f * 3846.1538f * aDVar2.e * aDVar2.c;
                float f5 = pow2 / aDVar2.b;
                float sin = (float) Math.sin(d3);
                float cos2 = (float) Math.cos(d3);
                float f6 = 11.0f * pow * cos2;
                float f7 = (((0.305f + f5) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (f6 + (cos * 23.0f)));
                float f8 = cos2 * f7;
                float f9 = f7 * sin;
                float f10 = f5 * 460.0f;
                float f11 = ((288.0f * f9) + ((451.0f * f8) + f10)) / 1403.0f;
                float f12 = ((f10 - (891.0f * f8)) - (261.0f * f9)) / 1403.0f;
                float f13 = ((f10 - (f8 * 220.0f)) - (f9 * 6300.0f)) / 1403.0f;
                float max = (float) Math.max(0.0d, (((double) Math.abs(f11)) * 27.13d) / (400.0d - ((double) Math.abs(f11))));
                float signum = Math.signum(f11);
                float f14 = 100.0f / aDVar2.g;
                float pow3 = signum * f14 * ((float) Math.pow((double) max, 2.380952380952381d));
                float signum2 = Math.signum(f12) * f14 * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f12)) * 27.13d) / (400.0d - ((double) Math.abs(f12))))), 2.380952380952381d));
                float[] fArr = aDVar2.f797a;
                float f15 = pow3 / fArr[0];
                float f16 = signum2 / fArr[1];
                float signum3 = ((Math.signum(f13) * f14) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f13)) * 27.13d) / (400.0d - ((double) Math.abs(f13))))), 2.380952380952381d))) / fArr[2];
                float[][] fArr2 = r1.f3214b;
                float[] fArr3 = fArr2[0];
                float f17 = fArr3[1] * f16;
                float f18 = (fArr3[2] * signum3) + f17 + (fArr3[0] * f15);
                float[] fArr4 = fArr2[1];
                float f19 = fArr4[1] * f16;
                float f20 = fArr4[2] * signum3;
                float[] fArr5 = fArr2[2];
                float f21 = f15 * fArr5[0];
                return A5.a((double) f18, (double) (f20 + f19 + (fArr4[0] * f15)), (double) ((signum3 * fArr5[2]) + (f16 * fArr5[1]) + f21));
            }
        }
        f2 = 0.0f;
        float pow4 = (float) Math.pow(((double) f2) / Math.pow(1.64d - Math.pow(0.29d, (double) aDVar2.f), 0.73d), 1.1111111111111112d);
        double d32 = (double) ((this.a * 3.1415927f) / 180.0f);
        float pow22 = aDVar2.f796a * ((float) Math.pow(((double) f4) / 100.0d, (1.0d / ((double) aDVar2.d)) / ((double) aDVar2.i)));
        float cos3 = ((float) (Math.cos(2.0d + d32) + 3.8d)) * 0.25f * 3846.1538f * aDVar2.e * aDVar2.c;
        float f52 = pow22 / aDVar2.b;
        float sin2 = (float) Math.sin(d32);
        float cos22 = (float) Math.cos(d32);
        float f62 = 11.0f * pow4 * cos22;
        float f72 = (((0.305f + f52) * 23.0f) * pow4) / (((pow4 * 108.0f) * sin2) + (f62 + (cos3 * 23.0f)));
        float f82 = cos22 * f72;
        float f92 = f72 * sin2;
        float f102 = f52 * 460.0f;
        float f112 = ((288.0f * f92) + ((451.0f * f82) + f102)) / 1403.0f;
        float f122 = ((f102 - (891.0f * f82)) - (261.0f * f92)) / 1403.0f;
        float f132 = ((f102 - (f82 * 220.0f)) - (f92 * 6300.0f)) / 1403.0f;
        float max2 = (float) Math.max(0.0d, (((double) Math.abs(f112)) * 27.13d) / (400.0d - ((double) Math.abs(f112))));
        float signum4 = Math.signum(f112);
        float f142 = 100.0f / aDVar2.g;
        float pow32 = signum4 * f142 * ((float) Math.pow((double) max2, 2.380952380952381d));
        float signum22 = Math.signum(f122) * f142 * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f122)) * 27.13d) / (400.0d - ((double) Math.abs(f122))))), 2.380952380952381d));
        float[] fArr6 = aDVar2.f797a;
        float f152 = pow32 / fArr6[0];
        float f162 = signum22 / fArr6[1];
        float signum32 = ((Math.signum(f132) * f142) * ((float) Math.pow((double) ((float) Math.max(0.0d, (((double) Math.abs(f132)) * 27.13d) / (400.0d - ((double) Math.abs(f132))))), 2.380952380952381d))) / fArr6[2];
        float[][] fArr22 = r1.f3214b;
        float[] fArr32 = fArr22[0];
        float f172 = fArr32[1] * f162;
        float f182 = (fArr32[2] * signum32) + f172 + (fArr32[0] * f152);
        float[] fArr42 = fArr22[1];
        float f192 = fArr42[1] * f162;
        float f202 = fArr42[2] * signum32;
        float[] fArr52 = fArr22[2];
        float f212 = f152 * fArr52[0];
        return A5.a((double) f182, (double) (f202 + f192 + (fArr42[0] * f152)), (double) ((signum32 * fArr52[2]) + (f162 * fArr52[1]) + f212));
    }
}
