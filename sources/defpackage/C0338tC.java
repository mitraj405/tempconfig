package defpackage;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* renamed from: tC  reason: default package and case insensitive filesystem */
/* compiled from: ViewGroupUtils */
public final class C0338tC {
    public static Method a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f3292a = true;
    public static boolean b;

    /* renamed from: tC$a */
    /* compiled from: ViewGroupUtils */
    public static class a {
        public static int a(ViewGroup viewGroup, int i) {
            return viewGroup.getChildDrawingOrder(i);
        }

        public static void b(ViewGroup viewGroup, boolean z) {
            viewGroup.suppressLayout(z);
        }
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            a.b(viewGroup, z);
        } else if (f3292a) {
            try {
                a.b(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                f3292a = false;
            }
        }
    }
}
