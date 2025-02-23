package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* renamed from: Q1  reason: default package and case insensitive filesystem */
/* compiled from: AsusHomeBadger */
public final class C0645Q1 implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"com.asus.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        intent.putExtra("badge_vip_count", 0);
        if (C1252m3.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new Ew("unable to resolve intent: " + intent.toString());
    }
}
