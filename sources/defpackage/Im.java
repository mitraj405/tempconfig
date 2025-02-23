package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* renamed from: Im  reason: default package */
/* compiled from: NewHtcHomeBadger */
public final class Im implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"com.htc.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i);
        if (C1252m3.a(context, intent) || C1252m3.a(context, intent2)) {
            context.sendBroadcast(intent);
            context.sendBroadcast(intent2);
            return;
        }
        throw new Ew("unable to resolve intent: " + intent2.toString());
    }
}
