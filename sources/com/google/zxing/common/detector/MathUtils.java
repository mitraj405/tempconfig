package com.google.zxing.common.detector;

public final class MathUtils {
    private MathUtils() {
    }

    public static float distance(float f, float f2, float f3, float f4) {
        double d = (double) (f - f3);
        double d2 = (double) (f2 - f4);
        return (float) Math.sqrt((d2 * d2) + (d * d));
    }

    public static int round(float f) {
        float f2;
        if (f < 0.0f) {
            f2 = -0.5f;
        } else {
            f2 = 0.5f;
        }
        return (int) (f + f2);
    }

    public static int sum(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static float distance(int i, int i2, int i3, int i4) {
        double d = (double) (i - i3);
        double d2 = (double) (i2 - i4);
        return (float) Math.sqrt((d2 * d2) + (d * d));
    }
}
