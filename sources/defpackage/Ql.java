package defpackage;

import java.lang.reflect.Array;

/* renamed from: Ql  reason: default package */
/* compiled from: MonotonicCurveFit */
public final class Ql extends H7 {
    public final double[] a;

    /* renamed from: a  reason: collision with other field name */
    public final double[][] f489a;
    public final double[] b;

    /* renamed from: b  reason: collision with other field name */
    public final double[][] f490b;

    public Ql(double[] dArr, double[][] dArr2) {
        double[] dArr3 = dArr;
        double[][] dArr4 = dArr2;
        int length = dArr3.length;
        int length2 = dArr4[0].length;
        this.b = new double[length2];
        int i = length - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = i;
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        int[] iArr2 = new int[2];
        iArr2[1] = length2;
        iArr2[0] = length;
        double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = 0;
            while (i3 < i) {
                int i4 = i3 + 1;
                double d = dArr3[i4] - dArr3[i3];
                double[] dArr7 = dArr5[i3];
                double d2 = (dArr4[i4][i2] - dArr4[i3][i2]) / d;
                dArr7[i2] = d2;
                if (i3 == 0) {
                    dArr6[i3][i2] = d2;
                } else {
                    dArr6[i3][i2] = (dArr5[i3 - 1][i2] + d2) * 0.5d;
                }
                i3 = i4;
            }
            dArr6[i][i2] = dArr5[length - 2][i2];
        }
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < length2; i6++) {
                double d3 = dArr5[i5][i6];
                if (d3 == 0.0d) {
                    dArr6[i5][i6] = 0.0d;
                    dArr6[i5 + 1][i6] = 0.0d;
                } else {
                    double d4 = dArr6[i5][i6] / d3;
                    int i7 = i5 + 1;
                    double d5 = dArr6[i7][i6] / d3;
                    double hypot = Math.hypot(d4, d5);
                    if (hypot > 9.0d) {
                        double d6 = 3.0d / hypot;
                        double[] dArr8 = dArr6[i5];
                        double[] dArr9 = dArr5[i5];
                        dArr8[i6] = d4 * d6 * dArr9[i6];
                        dArr6[i7][i6] = d6 * d5 * dArr9[i6];
                    }
                }
            }
        }
        this.a = dArr3;
        this.f489a = dArr4;
        this.f490b = dArr6;
    }

    public static double h(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d2 * 6.0d;
        double d9 = 6.0d * d7 * d3;
        double d10 = 3.0d * d;
        double d11 = d10 * d5 * d7;
        return (d * d5) + (((d11 + (((d10 * d6) * d7) + ((d9 + ((d8 * d4) + ((-6.0d * d7) * d4))) - (d8 * d3)))) - (((2.0d * d) * d6) * d2)) - (((4.0d * d) * d5) * d2));
    }

    public static double i(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 * d2;
        double d8 = d7 * d2;
        double d9 = 3.0d * d7;
        double d10 = d9 * d4;
        double d11 = d * d6;
        double d12 = d11 * d8;
        double d13 = d * d5;
        return (d13 * d2) + ((((d8 * d13) + (d12 + (((((d8 * 2.0d) * d3) + (d10 + ((-2.0d * d8) * d4))) - (d9 * d3)) + d3))) - (d11 * d7)) - (((2.0d * d) * d5) * d7));
    }

    public final double b(double d) {
        double d2;
        double d3;
        double e;
        double[] dArr = this.a;
        int length = dArr.length;
        double d4 = dArr[0];
        int i = (d > d4 ? 1 : (d == d4 ? 0 : -1));
        double[][] dArr2 = this.f489a;
        if (i <= 0) {
            d2 = dArr2[0][0];
            d3 = d - d4;
            e = e(d4);
        } else {
            int i2 = length - 1;
            double d5 = dArr[i2];
            if (d >= d5) {
                d2 = dArr2[i2][0];
                d3 = d - d5;
                e = e(d5);
            } else {
                int i3 = 0;
                while (i3 < i2) {
                    double d6 = dArr[i3];
                    if (d == d6) {
                        return dArr2[i3][0];
                    }
                    int i4 = i3 + 1;
                    double d7 = dArr[i4];
                    if (d < d7) {
                        double d8 = d7 - d6;
                        double d9 = (d - d6) / d8;
                        double d10 = dArr2[i3][0];
                        double d11 = dArr2[i4][0];
                        double[][] dArr3 = this.f490b;
                        return i(d8, d9, d10, d11, dArr3[i3][0], dArr3[i4][0]);
                    }
                    i3 = i4;
                }
                return 0.0d;
            }
        }
        return (e * d3) + d2;
    }

    public final void c(double d, double[] dArr) {
        double[] dArr2 = this.a;
        int length = dArr2.length;
        double[][] dArr3 = this.f489a;
        int i = 0;
        int length2 = dArr3[0].length;
        double d2 = dArr2[0];
        int i2 = (d > d2 ? 1 : (d == d2 ? 0 : -1));
        double[] dArr4 = this.b;
        if (i2 <= 0) {
            f(d2, dArr4);
            for (int i3 = 0; i3 < length2; i3++) {
                dArr[i3] = ((d - dArr2[0]) * dArr4[i3]) + dArr3[0][i3];
            }
            return;
        }
        int i4 = length - 1;
        double d3 = dArr2[i4];
        if (d >= d3) {
            f(d3, dArr4);
            while (i < length2) {
                dArr[i] = ((d - dArr2[i4]) * dArr4[i]) + dArr3[i4][i];
                i++;
            }
            return;
        }
        int i5 = 0;
        while (i5 < length - 1) {
            if (d == dArr2[i5]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = dArr3[i5][i6];
                }
            }
            int i7 = i5 + 1;
            double d4 = dArr2[i7];
            if (d < d4) {
                double d5 = dArr2[i5];
                double d6 = d4 - d5;
                double d7 = (d - d5) / d6;
                while (i < length2) {
                    double d8 = dArr3[i5][i];
                    double d9 = dArr3[i7][i];
                    double[][] dArr5 = this.f490b;
                    dArr[i] = i(d6, d7, d8, d9, dArr5[i5][i], dArr5[i7][i]);
                    i++;
                }
                return;
            }
            i5 = i7;
        }
    }

    public final void d(double d, float[] fArr) {
        double[] dArr = this.a;
        int length = dArr.length;
        double[][] dArr2 = this.f489a;
        int i = 0;
        int length2 = dArr2[0].length;
        double d2 = dArr[0];
        int i2 = (d > d2 ? 1 : (d == d2 ? 0 : -1));
        double[] dArr3 = this.b;
        if (i2 <= 0) {
            f(d2, dArr3);
            for (int i3 = 0; i3 < length2; i3++) {
                fArr[i3] = (float) (((d - dArr[0]) * dArr3[i3]) + dArr2[0][i3]);
            }
            return;
        }
        int i4 = length - 1;
        double d3 = dArr[i4];
        if (d >= d3) {
            f(d3, dArr3);
            while (i < length2) {
                fArr[i] = (float) (((d - dArr[i4]) * dArr3[i]) + dArr2[i4][i]);
                i++;
            }
            return;
        }
        int i5 = 0;
        while (i5 < i4) {
            if (d == dArr[i5]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) dArr2[i5][i6];
                }
            }
            int i7 = i5 + 1;
            double d4 = dArr[i7];
            if (d < d4) {
                double d5 = dArr[i5];
                double d6 = d4 - d5;
                double d7 = (d - d5) / d6;
                while (i < length2) {
                    double d8 = dArr2[i5][i];
                    double d9 = dArr2[i7][i];
                    double[][] dArr4 = this.f490b;
                    fArr[i] = (float) i(d6, d7, d8, d9, dArr4[i5][i], dArr4[i7][i]);
                    i++;
                }
                return;
            }
            i5 = i7;
        }
    }

    public final double e(double d) {
        double[] dArr = this.a;
        int length = dArr.length;
        double d2 = dArr[0];
        if (d >= d2) {
            d2 = dArr[length - 1];
            if (d < d2) {
                d2 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            int i2 = i + 1;
            double d3 = dArr[i2];
            if (d2 <= d3) {
                double d4 = dArr[i];
                double d5 = d3 - d4;
                double[][] dArr2 = this.f489a;
                double d6 = dArr2[i][0];
                double d7 = dArr2[i2][0];
                double[][] dArr3 = this.f490b;
                return h(d5, (d2 - d4) / d5, d6, d7, dArr3[i][0], dArr3[i2][0]) / d5;
            }
            i = i2;
        }
        return 0.0d;
    }

    public final void f(double d, double[] dArr) {
        double[] dArr2 = this.a;
        int length = dArr2.length;
        double[][] dArr3 = this.f489a;
        int length2 = dArr3[0].length;
        double d2 = dArr2[0];
        if (d > d2) {
            d2 = dArr2[length - 1];
            if (d < d2) {
                d2 = d;
            }
        }
        int i = 0;
        while (i < length - 1) {
            int i2 = i + 1;
            double d3 = dArr2[i2];
            if (d2 <= d3) {
                double d4 = dArr2[i];
                double d5 = d3 - d4;
                double d6 = (d2 - d4) / d5;
                for (int i3 = 0; i3 < length2; i3++) {
                    double d7 = dArr3[i][i3];
                    double d8 = dArr3[i2][i3];
                    double[][] dArr4 = this.f490b;
                    dArr[i3] = h(d5, d6, d7, d8, dArr4[i][i3], dArr4[i2][i3]) / d5;
                }
                return;
            }
            i = i2;
        }
    }

    public final double[] g() {
        return this.a;
    }
}
