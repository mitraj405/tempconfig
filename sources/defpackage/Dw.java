package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: Dw  reason: default package */
/* compiled from: ShortcutBadger */
public final class Dw {
    public static ComponentName a;

    /* renamed from: a  reason: collision with other field name */
    public static C1124g2 f3568a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList f3569a;

    static {
        LinkedList linkedList = new LinkedList();
        f3569a = linkedList;
        linkedList.add(C1059d0.class);
        linkedList.add(V0.class);
        linkedList.add(C1275n8.class);
        linkedList.add(Im.class);
        linkedList.add(C1160hn.class);
        linkedList.add(C0454Ax.class);
        linkedList.add(C0645Q1.class);
        linkedList.add(C0802bf.class);
        linkedList.add(C1305on.class);
        linkedList.add(Qu.class);
        linkedList.add(C0483DE.class);
        linkedList.add(C1214kD.class);
        linkedList.add(C0448AE.class);
        linkedList.add(C0819cb.class);
        linkedList.add(C1496yE.class);
    }

    public static void a(Context context, int i) {
        C1124g2 g2Var;
        if (f3568a == null) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                context.getPackageName();
            } else {
                a = launchIntentForPackage.getComponent();
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null && !resolveActivity.activityInfo.name.toLowerCase().contains("resolver")) {
                    String str = resolveActivity.activityInfo.packageName;
                    Iterator it = f3569a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        try {
                            g2Var = (C1124g2) ((Class) it.next()).newInstance();
                        } catch (Exception unused) {
                            g2Var = null;
                        }
                        if (g2Var != null && g2Var.a().contains(str)) {
                            f3568a = g2Var;
                            break;
                        }
                    }
                    if (f3568a == null) {
                        String str2 = Build.MANUFACTURER;
                        if (str2.equalsIgnoreCase("ZUK")) {
                            f3568a = new C0483DE();
                        } else if (str2.equalsIgnoreCase("OPPO")) {
                            f3568a = new C1305on();
                        } else if (str2.equalsIgnoreCase("VIVO")) {
                            f3568a = new C1214kD();
                        } else {
                            f3568a = new C1275n8();
                        }
                    }
                }
            }
        }
        try {
            f3568a.b(context, a, i);
        } catch (Exception unused2) {
        }
    }
}
