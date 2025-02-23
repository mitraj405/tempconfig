package defpackage;

import android.graphics.Color;
import com.google.firebase.perf.util.Constants;

/* renamed from: A5  reason: default package */
/* compiled from: ColorUtils */
public final class A5 {
    public static final ThreadLocal<double[]> a = new ThreadLocal<>();

    public static int a(double d, double d2, double d3) {
        double d4;
        double d5;
        double d6;
        int i;
        int i2;
        double d7 = ((-0.4986d * d3) + ((-1.5372d * d2) + (3.2406d * d))) / 100.0d;
        double d8 = ((0.0415d * d3) + ((1.8758d * d2) + (-0.9689d * d))) / 100.0d;
        double d9 = ((1.057d * d3) + ((-0.204d * d2) + (0.0557d * d))) / 100.0d;
        if (d7 > 0.0031308d) {
            d4 = (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d4 = d7 * 12.92d;
        }
        if (d8 > 0.0031308d) {
            d5 = (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d5 = d8 * 12.92d;
        }
        if (d9 > 0.0031308d) {
            d6 = (Math.pow(d9, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d6 = d9 * 12.92d;
        }
        int round = (int) Math.round(d4 * 255.0d);
        int i3 = 0;
        if (round < 0) {
            i = 0;
        } else {
            i = Math.min(round, Constants.MAX_HOST_LENGTH);
        }
        int round2 = (int) Math.round(d5 * 255.0d);
        if (round2 < 0) {
            i2 = 0;
        } else {
            i2 = Math.min(round2, Constants.MAX_HOST_LENGTH);
        }
        int round3 = (int) Math.round(d6 * 255.0d);
        if (round3 >= 0) {
            i3 = Math.min(round3, Constants.MAX_HOST_LENGTH);
        }
        return Color.rgb(i, i2, i3);
    }

    public static int b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f) + (((float) Color.alpha(i)) * f2)), (int) ((((float) Color.red(i2)) * f) + (((float) Color.red(i)) * f2)), (int) ((((float) Color.green(i2)) * f) + (((float) Color.green(i)) * f2)), (int) ((((float) Color.blue(i2)) * f) + (((float) Color.blue(i)) * f2)));
    }

    public static int c(int i, int i2) {
        int i3;
        int i4;
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i5 = 255 - alpha2;
        int i6 = 255 - (((255 - alpha) * i5) / Constants.MAX_HOST_LENGTH);
        int red = Color.red(i);
        int red2 = Color.red(i2);
        int i7 = 0;
        if (i6 == 0) {
            i3 = 0;
        } else {
            i3 = (((red2 * alpha) * i5) + ((red * Constants.MAX_HOST_LENGTH) * alpha2)) / (i6 * Constants.MAX_HOST_LENGTH);
        }
        int green = Color.green(i);
        int green2 = Color.green(i2);
        if (i6 == 0) {
            i4 = 0;
        } else {
            i4 = (((green2 * alpha) * i5) + ((green * Constants.MAX_HOST_LENGTH) * alpha2)) / (i6 * Constants.MAX_HOST_LENGTH);
        }
        int blue = Color.blue(i);
        int blue2 = Color.blue(i2);
        if (i6 != 0) {
            i7 = (((blue2 * alpha) * i5) + ((blue * Constants.MAX_HOST_LENGTH) * alpha2)) / (i6 * Constants.MAX_HOST_LENGTH);
        }
        return Color.argb(i6, i3, i4, i7);
    }

    public static int d(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (i & 16777215) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
