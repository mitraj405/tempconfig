package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: wo  reason: default package */
/* compiled from: PackageManagerHelper */
public final class wo {
    static {
        zi.e("PackageManagerHelper");
    }

    public static void a(Context context, Class<?> cls, boolean z) {
        int i;
        String str;
        String str2 = "enabled";
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, cls.getName());
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            packageManager.setComponentEnabledSetting(componentName, i, 1);
            zi c = zi.c();
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            if (z) {
                str = str2;
            } else {
                str = "disabled";
            }
            objArr[1] = str;
            String.format("%s %s", objArr);
            c.a(new Throwable[0]);
        } catch (Exception e) {
            zi c2 = zi.c();
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z) {
                str2 = "disabled";
            }
            objArr2[1] = str2;
            String.format("%s could not be %s", objArr2);
            c2.a(e);
        }
    }
}
