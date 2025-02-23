package defpackage;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

/* renamed from: Ax  reason: default package and case insensitive filesystem */
/* compiled from: SonyHomeBadger */
public final class C0454Ax implements C1124g2 {
    public final Uri a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");

    /* renamed from: a  reason: collision with other field name */
    public C1522zx f3526a;

    public final List<String> a() {
        return Arrays.asList(new String[]{"com.sonyericsson.home", "com.sonymobile.home"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        boolean z;
        boolean z2 = false;
        if (context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i));
            if (i > 0) {
                z2 = true;
            }
            intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", z2);
            context.sendBroadcast(intent);
        } else if (i >= 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("badge_count", Integer.valueOf(i));
            contentValues.put("package_name", componentName.getPackageName());
            contentValues.put("activity_name", componentName.getClassName());
            Looper myLooper = Looper.myLooper();
            Looper mainLooper = Looper.getMainLooper();
            Uri uri = this.a;
            if (myLooper == mainLooper) {
                if (this.f3526a == null) {
                    this.f3526a = new C1522zx(context.getApplicationContext().getContentResolver());
                }
                this.f3526a.startInsert(0, (Object) null, uri, contentValues);
                return;
            }
            context.getApplicationContext().getContentResolver().insert(uri, contentValues);
        }
    }
}
