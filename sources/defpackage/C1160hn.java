package defpackage;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.List;

/* renamed from: hn  reason: default package and case insensitive filesystem */
/* compiled from: NovaHomeBadger */
public final class C1160hn implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"com.teslacoilsw.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }
}
