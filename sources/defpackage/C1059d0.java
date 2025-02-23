package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* renamed from: d0  reason: default package and case insensitive filesystem */
/* compiled from: AdwHomeBadger */
public final class C1059d0 implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", componentName.getPackageName());
        intent.putExtra("CNAME", componentName.getClassName());
        intent.putExtra("COUNT", i);
        if (C1252m3.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new Ew("unable to resolve intent: " + intent.toString());
    }
}
