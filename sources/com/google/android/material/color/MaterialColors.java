package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;
import com.google.firebase.perf.util.Constants;
import defpackage.d7;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    public static int compositeARGBWithAlpha(int i, int i2) {
        return A5.d(i, (Color.alpha(i) * i2) / Constants.MAX_HOST_LENGTH);
    }

    public static int getColor(View view, int i) {
        return resolveColor(view.getContext(), MaterialAttributes.resolveTypedValueOrThrow(view, i));
    }

    public static Integer getColorOrNull(Context context, int i) {
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        if (resolve != null) {
            return Integer.valueOf(resolveColor(context, resolve));
        }
        return null;
    }

    private static int getColorRole(int i, int i2) {
        Hct fromInt = Hct.fromInt(i);
        fromInt.setTone((double) i2);
        return fromInt.toInt();
    }

    public static ColorRoles getColorRoles(Context context, int i) {
        return getColorRoles(i, isLightTheme(context));
    }

    public static ColorStateList getColorStateList(Context context, int i, ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        if (resolve != null) {
            colorStateList2 = resolveColorStateList(context, resolve);
        } else {
            colorStateList2 = null;
        }
        if (colorStateList2 == null) {
            return colorStateList;
        }
        return colorStateList2;
    }

    public static ColorStateList getColorStateListOrNull(Context context, int i) {
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        if (resolve == null) {
            return null;
        }
        int i2 = resolve.resourceId;
        if (i2 != 0) {
            return d7.c(context, i2);
        }
        int i3 = resolve.data;
        if (i3 != 0) {
            return ColorStateList.valueOf(i3);
        }
        return null;
    }

    public static int getSurfaceContainerFromSeed(Context context, int i) {
        int i2;
        if (isLightTheme(context)) {
            i2 = 94;
        } else {
            i2 = 12;
        }
        return getColorRole(i, i2, 6);
    }

    public static int getSurfaceContainerHighFromSeed(Context context, int i) {
        int i2;
        if (isLightTheme(context)) {
            i2 = 92;
        } else {
            i2 = 17;
        }
        return getColorRole(i, i2, 6);
    }

    public static int harmonize(int i, int i2) {
        return Blend.harmonize(i, i2);
    }

    public static int harmonizeWithPrimary(Context context, int i) {
        return harmonize(i, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(int i) {
        boolean z;
        double d;
        double d2;
        double d3;
        if (i != 0) {
            ThreadLocal<double[]> threadLocal = A5.a;
            double[] dArr = threadLocal.get();
            if (dArr == null) {
                dArr = new double[3];
                threadLocal.set(dArr);
            }
            int red = Color.red(i);
            int green = Color.green(i);
            int blue = Color.blue(i);
            if (dArr.length == 3) {
                double d4 = ((double) red) / 255.0d;
                if (d4 < 0.04045d) {
                    d = d4 / 12.92d;
                } else {
                    d = Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
                }
                double d5 = ((double) green) / 255.0d;
                if (d5 < 0.04045d) {
                    d2 = d5 / 12.92d;
                } else {
                    d2 = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
                }
                double d6 = ((double) blue) / 255.0d;
                if (d6 < 0.04045d) {
                    d3 = d6 / 12.92d;
                } else {
                    d3 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
                }
                z = false;
                dArr[0] = ((0.1805d * d3) + (0.3576d * d2) + (0.4124d * d)) * 100.0d;
                double d7 = ((0.0722d * d3) + (0.7152d * d2) + (0.2126d * d)) * 100.0d;
                dArr[1] = d7;
                double d8 = d3 * 0.9505d;
                dArr[2] = (d8 + (d2 * 0.1192d) + (d * 0.0193d)) * 100.0d;
                if (d7 / 100.0d > 0.5d) {
                    return true;
                }
            } else {
                throw new IllegalArgumentException("outXyz must have a length of 3.");
            }
        } else {
            z = false;
        }
        return z;
    }

    public static boolean isLightTheme(Context context) {
        return MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true);
    }

    public static int layer(View view, int i, int i2) {
        return layer(view, i, i2, 1.0f);
    }

    private static int resolveColor(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        if (i == 0) {
            return typedValue.data;
        }
        Object obj = d7.a;
        return d7.b.a(context, i);
    }

    private static ColorStateList resolveColorStateList(Context context, TypedValue typedValue) {
        int i = typedValue.resourceId;
        if (i != 0) {
            return d7.c(context, i);
        }
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ColorRoles getColorRoles(int i, boolean z) {
        if (z) {
            return new ColorRoles(getColorRole(i, 40), getColorRole(i, 100), getColorRole(i, 90), getColorRole(i, 10));
        }
        return new ColorRoles(getColorRole(i, 80), getColorRole(i, 20), getColorRole(i, 30), getColorRole(i, 90));
    }

    public static int layer(View view, int i, int i2, float f) {
        return layer(getColor(view, i), getColor(view, i2), f);
    }

    public static int getColor(Context context, int i, String str) {
        return resolveColor(context, MaterialAttributes.resolveTypedValueOrThrow(context, i, str));
    }

    private static int getColorRole(int i, int i2, int i3) {
        Hct fromInt = Hct.fromInt(getColorRole(i, i2));
        fromInt.setChroma((double) i3);
        return fromInt.toInt();
    }

    public static int layer(int i, int i2, float f) {
        return layer(i, A5.d(i2, Math.round(((float) Color.alpha(i2)) * f)));
    }

    public static int getColor(View view, int i, int i2) {
        return getColor(view.getContext(), i, i2);
    }

    public static int getColor(Context context, int i, int i2) {
        Integer colorOrNull = getColorOrNull(context, i);
        return colorOrNull != null ? colorOrNull.intValue() : i2;
    }

    public static int layer(int i, int i2) {
        return A5.c(i2, i);
    }
}
