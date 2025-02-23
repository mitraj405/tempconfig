package defpackage;

import android.view.ViewConfiguration;

/* renamed from: oC  reason: default package */
/* compiled from: ViewConfigurationCompat */
public final class oC {
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
