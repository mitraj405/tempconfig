package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.List;

/* renamed from: kD  reason: default package and case insensitive filesystem */
/* compiled from: VivoHomeBadger */
public final class C1214kD implements C1124g2 {
    public final List<String> a() {
        return Arrays.asList(new String[]{"com.vivo.launcher"});
    }

    public final void b(Context context, ComponentName componentName, int i) throws Ew {
        Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, context.getPackageName());
        intent.putExtra("className", componentName.getClassName());
        intent.putExtra("notificationNum", i);
        context.sendBroadcast(intent);
    }
}
