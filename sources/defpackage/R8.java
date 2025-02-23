package defpackage;

import android.content.Context;

/* renamed from: R8  reason: default package */
/* compiled from: DeviceUtils */
public final class R8 {
    public static boolean a(Context context, int i, String str) {
        if (str == null) {
            return false;
        }
        for (String equals : context.getResources().getStringArray(i)) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context, int i, String str) {
        if (str == null) {
            return false;
        }
        for (String startsWith : context.getResources().getStringArray(i)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }
}
