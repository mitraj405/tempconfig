package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: AE  reason: default package and case insensitive filesystem */
/* compiled from: ZTEHomeBadger */
public final class C0448AE implements C1124g2 {
    public final List<String> a() {
        return new ArrayList(0);
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        bundle.putString("app_badge_component_name", componentName.flattenToString());
        context.getContentResolver().call(Uri.parse("content://com.android.launcher3.cornermark.unreadbadge"), "setAppUnreadCount", (String) null, bundle);
    }
}
