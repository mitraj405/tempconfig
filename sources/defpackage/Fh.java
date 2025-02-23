package defpackage;

import android.app.KeyguardManager;
import android.content.Context;

/* renamed from: Fh  reason: default package */
/* compiled from: KeyguardUtils */
public final class Fh {
    public static KeyguardManager a(Context context) {
        return (KeyguardManager) context.getSystemService(KeyguardManager.class);
    }

    public static boolean b(KeyguardManager keyguardManager) {
        return keyguardManager.isDeviceSecure();
    }
}
