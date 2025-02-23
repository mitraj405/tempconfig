package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* renamed from: yE  reason: default package and case insensitive filesystem */
/* compiled from: YandexLauncherBadger */
public final class C1496yE implements C1124g2 {
    public static final Uri a = Uri.parse("content://com.yandex.launcher.badges_external");

    public final List<String> a() {
        return Collections.singletonList("com.yandex.launcher");
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Bundle bundle = new Bundle();
        bundle.putString("class", componentName.getClassName());
        bundle.putString("package", componentName.getPackageName());
        bundle.putString("badges_count", String.valueOf(i));
        context.getContentResolver().call(a, "setBadgeNumber", (String) null, bundle);
    }
}
