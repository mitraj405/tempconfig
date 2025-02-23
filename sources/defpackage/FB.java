package defpackage;

import android.content.Context;
import android.os.UserManager;

/* renamed from: FB  reason: default package */
/* compiled from: UserManagerCompat */
public final class FB {
    public static boolean a(Context context) {
        return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
