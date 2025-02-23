package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

/* renamed from: V0  reason: default package */
/* compiled from: ApexHomeBadger */
public final class V0 implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"com.anddoes.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra("package", componentName.getPackageName());
        intent.putExtra("count", i);
        intent.putExtra("class", componentName.getClassName());
        if (C1252m3.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new Ew("unable to resolve intent: " + intent.toString());
    }
}
