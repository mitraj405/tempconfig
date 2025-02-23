package defpackage;

import android.content.pm.PackageManager;

/* renamed from: yo  reason: default package */
/* compiled from: PackageUtils */
public final class yo {
    public static boolean a(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.hardware.fingerprint");
    }
}
