package defpackage;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;

/* renamed from: DE  reason: default package and case insensitive filesystem */
/* compiled from: ZukHomeBadger */
public final class C0483DE implements C1124g2 {
    public final Uri a = Uri.parse("content://com.android.badge/badge");

    public final List<String> a() {
        return Collections.singletonList("com.zui.launcher");
    }

    @TargetApi(11)
    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i);
        context.getContentResolver().call(this.a, "setAppBadgeCount", (String) null, bundle);
    }
}
