package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Window;
import androidx.core.view.g;
import com.google.android.material.color.MaterialColors;

public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(Window window, boolean z) {
        applyEdgeToEdge(window, z, (Integer) null, (Integer) null);
    }

    @TargetApi(21)
    private static int getNavigationBarColor(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return MaterialColors.getColor(context, 16843858, -16777216);
    }

    @TargetApi(21)
    private static int getStatusBarColor(Context context, boolean z) {
        if (z) {
            return 0;
        }
        return MaterialColors.getColor(context, 16843857, -16777216);
    }

    private static boolean isUsingLightSystemBar(int i, boolean z) {
        if (MaterialColors.isColorLight(i) || (i == 0 && z)) {
            return true;
        }
        return false;
    }

    public static void setLightNavigationBar(Window window, boolean z) {
        new g(window, window.getDecorView()).a.c(z);
    }

    public static void setLightStatusBar(Window window, boolean z) {
        new g(window, window.getDecorView()).a.d(z);
    }

    public static void applyEdgeToEdge(Window window, boolean z, Integer num, Integer num2) {
        boolean z2 = false;
        boolean z3 = num == null || num.intValue() == 0;
        if (num2 == null || num2.intValue() == 0) {
            z2 = true;
        }
        if (z3 || z2) {
            int color = MaterialColors.getColor(window.getContext(), 16842801, -16777216);
            if (z3) {
                num = Integer.valueOf(color);
            }
            if (z2) {
                num2 = Integer.valueOf(color);
            }
        }
        ED.a(window, !z);
        int statusBarColor = getStatusBarColor(window.getContext(), z);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        setLightStatusBar(window, isUsingLightSystemBar(statusBarColor, MaterialColors.isColorLight(num.intValue())));
        setLightNavigationBar(window, isUsingLightSystemBar(navigationBarColor, MaterialColors.isColorLight(num2.intValue())));
    }
}
