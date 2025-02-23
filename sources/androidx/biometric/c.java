package androidx.biometric;

import android.os.Build;

/* compiled from: AuthenticatorUtils */
public final class c {
    public static boolean a(int i) {
        if ((i & 32768) != 0) {
            return true;
        }
        return false;
    }

    public static boolean b(int i) {
        if (i == 15 || i == 255) {
            return true;
        }
        if (i != 32768) {
            if (i == 32783) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 28 || i2 > 29) {
                    return true;
                }
                return false;
            } else if (i == 33023 || i == 0) {
                return true;
            } else {
                return false;
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            return true;
        } else {
            return false;
        }
    }
}
