package com.google.android.material.math;

public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f, float f2, float f3, float f4) {
        return (float) Math.hypot((double) (f3 - f), (double) (f4 - f2));
    }

    public static float distanceToFurthestCorner(float f, float f2, float f3, float f4, float f5, float f6) {
        return max(dist(f, f2, f3, f4), dist(f, f2, f5, f4), dist(f, f2, f5, f6), dist(f, f2, f3, f6));
    }

    public static float floorMod(float f, int i) {
        float f2 = (float) i;
        int i2 = (int) (f / f2);
        if (Math.signum(f) * f2 < 0.0f && ((float) (i2 * i)) != f) {
            i2--;
        }
        return f - ((float) (i2 * i));
    }

    public static boolean geq(float f, float f2, float f3) {
        if (f + f3 >= f2) {
            return true;
        }
        return false;
    }

    public static float lerp(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    private static float max(float f, float f2, float f3, float f4) {
        if (f > f2 && f > f3 && f > f4) {
            return f;
        }
        if (f2 > f3 && f2 > f4) {
            return f2;
        }
        if (f3 > f4) {
            return f3;
        }
        return f4;
    }

    public static int floorMod(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i3 * i2 != i) {
            i3--;
        }
        return i - (i3 * i2);
    }
}
