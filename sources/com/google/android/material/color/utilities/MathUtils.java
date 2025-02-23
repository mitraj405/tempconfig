package com.google.android.material.color.utilities;

public class MathUtils {
    private MathUtils() {
    }

    public static double clampDouble(double d, double d2, double d3) {
        if (d3 < d) {
            return d;
        }
        if (d3 > d2) {
            return d2;
        }
        return d3;
    }

    public static int clampInt(int i, int i2, int i3) {
        if (i3 < i) {
            return i;
        }
        if (i3 > i2) {
            return i2;
        }
        return i3;
    }

    public static double differenceDegrees(double d, double d2) {
        return 180.0d - Math.abs(Math.abs(d - d2) - 180.0d);
    }

    public static double lerp(double d, double d2, double d3) {
        return (d3 * d2) + ((1.0d - d3) * d);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d = dArr[0];
        double[] dArr3 = dArr2[0];
        double d2 = dArr[1];
        double d3 = dArr3[1] * d2;
        double d4 = dArr[2];
        double d5 = (dArr3[2] * d4) + d3 + (dArr3[0] * d);
        double[] dArr4 = dArr2[1];
        double d6 = (dArr4[2] * d4) + (dArr4[1] * d2) + (dArr4[0] * d);
        double[] dArr5 = dArr2[2];
        return new double[]{d5, d6, (d4 * dArr5[2]) + (d2 * dArr5[1]) + (d * dArr5[0])};
    }

    public static double rotationDirection(double d, double d2) {
        if (sanitizeDegreesDouble(d2 - d) <= 180.0d) {
            return 1.0d;
        }
        return -1.0d;
    }

    public static double sanitizeDegreesDouble(double d) {
        double d2 = d % 360.0d;
        if (d2 < 0.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    public static int sanitizeDegreesInt(int i) {
        int i2 = i % 360;
        if (i2 < 0) {
            return i2 + 360;
        }
        return i2;
    }

    public static int signum(double d) {
        if (d < 0.0d) {
            return -1;
        }
        if (d == 0.0d) {
            return 0;
        }
        return 1;
    }
}
