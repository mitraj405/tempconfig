package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* renamed from: ED  reason: default package */
/* compiled from: WindowCompat */
public final class ED {

    /* renamed from: ED$a */
    /* compiled from: WindowCompat */
    public static class a {
        public static void a(Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    public static void a(Window window, boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            a.a(window, z);
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (z) {
            i = systemUiVisibility & -1793;
        } else {
            i = systemUiVisibility | 1792;
        }
        decorView.setSystemUiVisibility(i);
    }
}
