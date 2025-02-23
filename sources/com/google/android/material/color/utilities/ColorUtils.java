package com.google.android.material.color.utilities;

import com.google.firebase.perf.util.Constants;

public class ColorUtils {
    static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    static final double[] WHITE_POINT_D65 = {95.047d, 100.0d, 108.883d};
    static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};

    private ColorUtils() {
    }

    public static int alphaFromArgb(int i) {
        return (i >> 24) & Constants.MAX_HOST_LENGTH;
    }

    public static int argbFromLab(double d, double d2, double d3) {
        double[] dArr = WHITE_POINT_D65;
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = d4 - (d3 / 200.0d);
        return argbFromXyz(labInvf((d2 / 500.0d) + d4) * dArr[0], labInvf(d4) * dArr[1], labInvf(d5) * dArr[2]);
    }

    public static int argbFromLinrgb(double[] dArr) {
        return argbFromRgb(delinearized(dArr[0]), delinearized(dArr[1]), delinearized(dArr[2]));
    }

    public static int argbFromLstar(double d) {
        int delinearized = delinearized(yFromLstar(d));
        return argbFromRgb(delinearized, delinearized, delinearized);
    }

    public static int argbFromRgb(int i, int i2, int i3) {
        return ((i & Constants.MAX_HOST_LENGTH) << 16) | -16777216 | ((i2 & Constants.MAX_HOST_LENGTH) << 8) | (i3 & Constants.MAX_HOST_LENGTH);
    }

    public static int argbFromXyz(double d, double d2, double d3) {
        double[][] dArr = XYZ_TO_SRGB;
        double[] dArr2 = dArr[0];
        double d4 = dArr2[1] * d2;
        double d5 = (dArr2[2] * d3) + d4 + (dArr2[0] * d);
        double[] dArr3 = dArr[1];
        double d6 = (dArr3[1] * d2) + (dArr3[0] * d);
        double[] dArr4 = dArr[2];
        return argbFromRgb(delinearized(d5), delinearized((dArr3[2] * d3) + d6), delinearized((dArr4[2] * d3) + (dArr4[1] * d2) + (dArr4[0] * d)));
    }

    public static int blueFromArgb(int i) {
        return i & Constants.MAX_HOST_LENGTH;
    }

    public static int delinearized(double d) {
        double d2;
        double d3 = d / 100.0d;
        if (d3 <= 0.0031308d) {
            d2 = d3 * 12.92d;
        } else {
            d2 = (Math.pow(d3, 0.4166666666666667d) * 1.055d) - 0.055d;
        }
        return MathUtils.clampInt(0, Constants.MAX_HOST_LENGTH, (int) Math.round(d2 * 255.0d));
    }

    public static int greenFromArgb(int i) {
        return (i >> 8) & Constants.MAX_HOST_LENGTH;
    }

    public static boolean isOpaque(int i) {
        if (alphaFromArgb(i) >= 255) {
            return true;
        }
        return false;
    }

    public static double labF(double d) {
        if (d > 0.008856451679035631d) {
            return Math.pow(d, 0.3333333333333333d);
        }
        return ((d * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] labFromArgb(int i) {
        double linearized = linearized(redFromArgb(i));
        double linearized2 = linearized(greenFromArgb(i));
        double linearized3 = linearized(blueFromArgb(i));
        double[][] dArr = SRGB_TO_XYZ;
        double[] dArr2 = dArr[0];
        double d = dArr2[1] * linearized2;
        double d2 = (dArr2[2] * linearized3) + d + (dArr2[0] * linearized);
        double[] dArr3 = dArr[1];
        double d3 = (dArr3[2] * linearized3) + (dArr3[1] * linearized2) + (dArr3[0] * linearized);
        double[] dArr4 = dArr[2];
        double d4 = dArr4[0] * linearized;
        double d5 = (dArr4[2] * linearized3) + (dArr4[1] * linearized2) + d4;
        double[] dArr5 = WHITE_POINT_D65;
        double d6 = d2 / dArr5[0];
        double d7 = d3 / dArr5[1];
        double d8 = d5 / dArr5[2];
        double labF = labF(d6);
        double labF2 = labF(d7);
        return new double[]{(116.0d * labF2) - 16.0d, (labF - labF2) * 500.0d, (labF2 - labF(d8)) * 200.0d};
    }

    public static double labInvf(double d) {
        double d2 = d * d * d;
        if (d2 > 0.008856451679035631d) {
            return d2;
        }
        return ((d * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double linearized(int i) {
        double pow;
        double d = ((double) i) / 255.0d;
        if (d <= 0.040449936d) {
            pow = d / 12.92d;
        } else {
            pow = Math.pow((d + 0.055d) / 1.055d, 2.4d);
        }
        return pow * 100.0d;
    }

    public static double lstarFromArgb(int i) {
        return (labF(xyzFromArgb(i)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double lstarFromY(double d) {
        return (labF(d / 100.0d) * 116.0d) - 16.0d;
    }

    public static int redFromArgb(int i) {
        return (i >> 16) & Constants.MAX_HOST_LENGTH;
    }

    public static double[] whitePointD65() {
        return WHITE_POINT_D65;
    }

    public static double[] xyzFromArgb(int i) {
        return MathUtils.matrixMultiply(new double[]{linearized(redFromArgb(i)), linearized(greenFromArgb(i)), linearized(blueFromArgb(i))}, SRGB_TO_XYZ);
    }

    public static double yFromLstar(double d) {
        return labInvf((d + 16.0d) / 116.0d) * 100.0d;
    }
}
