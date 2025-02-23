package defpackage;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.Arrays;
import java.util.List;

/* renamed from: cb  reason: default package and case insensitive filesystem */
/* compiled from: EverythingMeHomeBadger */
public final class C0819cb implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"me.everything.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i));
        context.getContentResolver().insert(Uri.parse("content://me.everything.badger/apps"), contentValues);
    }
}
