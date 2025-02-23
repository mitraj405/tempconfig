package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

/* renamed from: n8  reason: default package and case insensitive filesystem */
/* compiled from: DefaultBadger */
public final class C1275n8 implements C1124g2 {
    public final List<String> a() {
        return new ArrayList(0);
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        if (C1252m3.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new Ew("unable to resolve intent: " + intent.toString());
    }
}
