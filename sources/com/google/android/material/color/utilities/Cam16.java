package com.google.android.material.color.utilities;

import com.google.firebase.perf.util.Constants;

public final class Cam16 {
    static final double[][] CAM16RGB_TO_XYZ = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};
    static final double[][] XYZ_TO_CAM16RGB = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};
    private final double astar;
    private final double bstar;
    private final double chroma;
    private final double hue;
    private final double j;
    private final double jstar;
    private final double m;
    private final double q;
    private final double s;
    private final double[] tempArray = {0.0d, 0.0d, 0.0d};

    private Cam16(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.hue = d;
        this.chroma = d2;
        this.j = d3;
        this.q = d4;
        this.m = d5;
        this.s = d6;
        this.jstar = d7;
        this.astar = d8;
        this.bstar = d9;
    }

    public static Cam16 fromInt(int i) {
        return fromIntInViewingConditions(i, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromIntInViewingConditions(int i, ViewingConditions viewingConditions) {
        int i2 = i;
        int i3 = i2 & Constants.MAX_HOST_LENGTH;
        double linearized = ColorUtils.linearized((16711680 & i2) >> 16);
        double linearized2 = ColorUtils.linearized((65280 & i2) >> 8);
        double linearized3 = ColorUtils.linearized(i3);
        return fromXyzInViewingConditions((0.18051042d * linearized3) + (0.35762064d * linearized2) + (0.41233895d * linearized), (0.0722d * linearized3) + (0.7152d * linearized2) + (0.2126d * linearized), (linearized3 * 0.95034478d) + (linearized2 * 0.11916382d) + (linearized * 0.01932141d), viewingConditions);
    }

    public static Cam16 fromJch(double d, double d2, double d3) {
        return fromJchInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    private static Cam16 fromJchInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double d4 = d2;
        double d5 = d3;
        double d6 = d / 100.0d;
        double aw = (viewingConditions.getAw() + 4.0d) * Math.sqrt(d6) * (4.0d / viewingConditions.getC()) * viewingConditions.getFlRoot();
        double flRoot = viewingConditions.getFlRoot() * d2;
        double c = viewingConditions.getC();
        double radians = Math.toRadians(d3);
        double d7 = (1.7000000000000002d * d) / ((0.007d * d) + 1.0d);
        double log1p = 43.859649122807014d * Math.log1p(flRoot * 0.0228d);
        return new Cam16(d5, d4, d, aw, flRoot, Math.sqrt((c * (d2 / Math.sqrt(d6))) / (viewingConditions.getAw() + 4.0d)) * 50.0d, d7, Math.cos(radians) * log1p, Math.sin(radians) * log1p);
    }

    public static Cam16 fromUcs(double d, double d2, double d3) {
        return fromUcsInViewingConditions(d, d2, d3, ViewingConditions.DEFAULT);
    }

    public static Cam16 fromUcsInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d2, d3) * 0.0228d) / 0.0228d) / viewingConditions.getFlRoot();
        double d4 = d2;
        double atan2 = Math.atan2(d3, d2) * 57.29577951308232d;
        if (atan2 < 0.0d) {
            atan2 += 360.0d;
        }
        return fromJchInViewingConditions(d / (1.0d - ((d - 100.0d) * 0.007d)), expm1, atan2, viewingConditions);
    }

    public static Cam16 fromXyzInViewingConditions(double d, double d2, double d3, ViewingConditions viewingConditions) {
        double d4;
        double[][] dArr = XYZ_TO_CAM16RGB;
        double[] dArr2 = dArr[0];
        double d5 = dArr2[1] * d2;
        double d6 = (dArr2[2] * d3) + d5 + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d7 = (dArr3[2] * d3) + (dArr3[1] * d2) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        double d8 = (dArr4[1] * d2) + (dArr4[0] * d);
        double d9 = viewingConditions.getRgbD()[0] * d6;
        double d10 = viewingConditions.getRgbD()[1] * d7;
        double d11 = viewingConditions.getRgbD()[2] * ((dArr4[2] * d3) + d8);
        double pow = Math.pow((Math.abs(d9) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double pow2 = Math.pow((Math.abs(d10) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double d12 = d11;
        double pow3 = Math.pow((Math.abs(d11) * viewingConditions.getFl()) / 100.0d, 0.42d);
        double signum = ((Math.signum(d9) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d10) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d12) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d13 = (((-12.0d * signum2) + (signum * 11.0d)) + signum3) / 11.0d;
        double d14 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d15 = signum2 * 20.0d;
        double d16 = ((21.0d * signum3) + ((signum * 20.0d) + d15)) / 20.0d;
        double d17 = (((signum * 40.0d) + d15) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d14, d13));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d18 = degrees;
        double radians = Math.toRadians(d18);
        double pow4 = Math.pow((viewingConditions.getNbb() * d17) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ()) * 100.0d;
        double d19 = pow4 / 100.0d;
        double flRoot = viewingConditions.getFlRoot() * (viewingConditions.getAw() + 4.0d) * Math.sqrt(d19) * (4.0d / viewingConditions.getC());
        if (d18 < 20.14d) {
            d4 = d18 + 360.0d;
        } else {
            d4 = d18;
        }
        double nc = viewingConditions.getNc() * (Math.cos(Math.toRadians(d4) + 2.0d) + 3.8d) * 0.25d * 3846.153846153846d;
        double hypot = Math.hypot(d13, d14);
        double pow5 = Math.pow((hypot * (viewingConditions.getNcb() * nc)) / (d16 + 0.305d), 0.9d) * Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d);
        double sqrt = Math.sqrt(d19) * pow5;
        double d20 = sqrt;
        double flRoot2 = viewingConditions.getFlRoot() * sqrt;
        double d21 = flRoot2;
        double sqrt2 = Math.sqrt((viewingConditions.getC() * pow5) / (viewingConditions.getAw() + 4.0d)) * 50.0d;
        double d22 = (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d);
        double log1p = Math.log1p(flRoot2 * 0.0228d) * 43.859649122807014d;
        return new Cam16(d18, d20, pow4, flRoot, d21, sqrt2, d22, Math.cos(radians) * log1p, Math.sin(radians) * log1p);
    }

    public double distance(Cam16 cam16) {
        double jstar2 = getJstar() - cam16.getJstar();
        double astar2 = getAstar() - cam16.getAstar();
        double bstar2 = getBstar() - cam16.getBstar();
        return Math.pow(Math.sqrt((bstar2 * bstar2) + (astar2 * astar2) + (jstar2 * jstar2)), 0.63d) * 1.41d;
    }

    public double getAstar() {
        return this.astar;
    }

    public double getBstar() {
        return this.bstar;
    }

    public double getChroma() {
        return this.chroma;
    }

    public double getHue() {
        return this.hue;
    }

    public double getJ() {
        return this.j;
    }

    public double getJstar() {
        return this.jstar;
    }

    public double getM() {
        return this.m;
    }

    public double getQ() {
        return this.q;
    }

    public double getS() {
        return this.s;
    }

    public int toInt() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public int viewed(ViewingConditions viewingConditions) {
        double[] xyzInViewingConditions = xyzInViewingConditions(viewingConditions, this.tempArray);
        return ColorUtils.argbFromXyz(xyzInViewingConditions[0], xyzInViewingConditions[1], xyzInViewingConditions[2]);
    }

    public double[] xyzInViewingConditions(ViewingConditions viewingConditions, double[] dArr) {
        double d;
        if (getChroma() == 0.0d || getJ() == 0.0d) {
            d = 0.0d;
        } else {
            d = getChroma() / Math.sqrt(getJ() / 100.0d);
        }
        double pow = Math.pow(d / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(getHue());
        double pow2 = Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()) * viewingConditions.getAw();
        double ncb = viewingConditions.getNcb() * viewingConditions.getNc() * (Math.cos(2.0d + radians) + 3.8d) * 0.25d * 3846.153846153846d;
        double nbb = pow2 / viewingConditions.getNbb();
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double d2 = (((0.305d + nbb) * 23.0d) * pow) / (((pow * 108.0d) * sin) + (((11.0d * pow) * cos) + (ncb * 23.0d)));
        double d3 = cos * d2;
        double d4 = d2 * sin;
        double d5 = nbb * 460.0d;
        double d6 = ((288.0d * d4) + ((451.0d * d3) + d5)) / 1403.0d;
        double d7 = ((d5 - (891.0d * d3)) - (261.0d * d4)) / 1403.0d;
        double d8 = ((d5 - (d3 * 220.0d)) - (d4 * 6300.0d)) / 1403.0d;
        double pow3 = Math.pow(Math.max(0.0d, (Math.abs(d6) * 27.13d) / (400.0d - Math.abs(d6))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d6);
        double max = Math.max(0.0d, (Math.abs(d7) * 27.13d) / (400.0d - Math.abs(d7)));
        double fl = (100.0d / viewingConditions.getFl()) * Math.signum(d7);
        double pow4 = Math.pow(Math.max(0.0d, (Math.abs(d8) * 27.13d) / (400.0d - Math.abs(d8))), 2.380952380952381d) * (100.0d / viewingConditions.getFl()) * Math.signum(d8);
        double d9 = pow3 / viewingConditions.getRgbD()[0];
        double pow5 = (Math.pow(max, 2.380952380952381d) * fl) / viewingConditions.getRgbD()[1];
        double d10 = pow4 / viewingConditions.getRgbD()[2];
        double[][] dArr2 = CAM16RGB_TO_XYZ;
        double[] dArr3 = dArr2[0];
        double d11 = (dArr3[2] * d10) + (dArr3[1] * pow5) + (dArr3[0] * d9);
        double[] dArr4 = dArr2[1];
        double d12 = (dArr4[2] * d10) + (dArr4[1] * pow5) + (dArr4[0] * d9);
        double[] dArr5 = dArr2[2];
        double d13 = (d10 * dArr5[2]) + (pow5 * dArr5[1]) + (d9 * dArr5[0]);
        if (dArr != null) {
            dArr[0] = d11;
            dArr[1] = d12;
            dArr[2] = d13;
            return dArr;
        }
        return new double[]{d11, d12, d13};
    }
}
