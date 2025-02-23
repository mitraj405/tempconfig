package com.google.android.material.color.utilities;

public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;
    private final double c;
    private final double fl;
    private final double flRoot;
    private final double n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;
    private final double z;

    private ViewingConditions(double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9) {
        this.n = d;
        this.aw = d2;
        this.nbb = d3;
        this.ncb = d4;
        this.c = d5;
        this.nc = d6;
        this.rgbD = dArr;
        this.fl = d7;
        this.flRoot = d8;
        this.z = d9;
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d, 2.0d, false);
    }

    public static ViewingConditions make(double[] dArr, double d, double d2, double d3, boolean z2) {
        double d4;
        double d5;
        double d6 = d;
        double max = Math.max(0.1d, d2);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d7 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d8 = dArr[1];
        double d9 = dArr3[1] * d8;
        double d10 = dArr[2];
        double d11 = (dArr3[2] * d10) + d9 + (dArr3[0] * d7);
        double[] dArr4 = dArr2[1];
        double d12 = (dArr4[2] * d10) + (dArr4[1] * d8) + (dArr4[0] * d7);
        double[] dArr5 = dArr2[2];
        double d13 = (d10 * dArr5[2]) + (d8 * dArr5[1]) + (d7 * dArr5[0]);
        double d14 = (d3 / 10.0d) + 0.8d;
        if (d14 >= 0.9d) {
            d4 = MathUtils.lerp(0.59d, 0.69d, (d14 - 0.9d) * 10.0d);
        } else {
            d4 = MathUtils.lerp(0.525d, 0.59d, (d14 - 0.8d) * 10.0d);
        }
        double d15 = d4;
        if (z2) {
            d5 = 1.0d;
        } else {
            d5 = (1.0d - (Math.exp(((-d6) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d14;
        }
        double clampDouble = MathUtils.clampDouble(0.0d, 1.0d, d5);
        double[] dArr6 = {(((100.0d / d11) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d12) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d13) * clampDouble) + 1.0d) - clampDouble};
        double d16 = 5.0d * d6;
        double d17 = 1.0d / (d16 + 1.0d);
        double d18 = d17 * d17 * d17 * d17;
        double d19 = 1.0d - d18;
        double cbrt = (Math.cbrt(d16) * 0.1d * d19 * d19) + (d18 * d6);
        double yFromLstar = ColorUtils.yFromLstar(max) / dArr[1];
        double d20 = yFromLstar;
        double sqrt = Math.sqrt(yFromLstar) + 1.48d;
        double pow = 0.725d / Math.pow(yFromLstar, 0.2d);
        double d21 = pow;
        double d22 = pow;
        double pow2 = Math.pow(((dArr6[2] * cbrt) * d13) / 100.0d, 0.42d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d11) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d12) / 100.0d, 0.42d), pow2};
        double d23 = dArr7[0];
        double d24 = (d23 * 400.0d) / (d23 + 27.13d);
        double d25 = dArr7[1];
        return new ViewingConditions(d20, ((((400.0d * pow2) / (pow2 + 27.13d)) * 0.05d) + (d24 * 2.0d) + ((d25 * 400.0d) / (d25 + 27.13d))) * pow, d21, d22, d15, d14, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public double getAw() {
        return this.aw;
    }

    public double getC() {
        return this.c;
    }

    public double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    public double getN() {
        return this.n;
    }

    public double getNbb() {
        return this.nbb;
    }

    public double getNc() {
        return this.nc;
    }

    public double getNcb() {
        return this.ncb;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    public double getZ() {
        return this.z;
    }
}
