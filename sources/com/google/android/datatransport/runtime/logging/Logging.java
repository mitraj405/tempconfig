package com.google.android.datatransport.runtime.logging;

import android.util.Log;

public final class Logging {
    private static final String LOG_PREFIX = "TRuntime.";
    private static final int MAX_LOG_TAG_SIZE_IN_SDK_N = 23;

    private Logging() {
    }

    private static String concatTag(String str, String str2) {
        String z = C1058d.z(str, str2);
        if (z.length() > 23) {
            return z.substring(0, 23);
        }
        return z;
    }

    public static void d(String str, String str2) {
        Log.isLoggable(getTag(str), 3);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.isLoggable(getTag(str), 6);
    }

    private static String getTag(String str) {
        return C0709Uj.i(LOG_PREFIX, str);
    }

    public static void i(String str, String str2, Object obj) {
        if (Log.isLoggable(getTag(str), 4)) {
            String.format(str2, new Object[]{obj});
        }
    }

    public static void w(String str, String str2, Object obj) {
        if (Log.isLoggable(getTag(str), 5)) {
            String.format(str2, new Object[]{obj});
        }
    }

    public static void d(String str, String str2, Object obj) {
        if (Log.isLoggable(getTag(str), 3)) {
            String.format(str2, new Object[]{obj});
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        if (Log.isLoggable(getTag(str), 3)) {
            String.format(str2, new Object[]{obj, obj2});
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (Log.isLoggable(getTag(str), 3)) {
            String.format(str2, objArr);
        }
    }
}
