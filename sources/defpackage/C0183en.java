package defpackage;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* renamed from: en  reason: default package and case insensitive filesystem */
/* compiled from: NotificationManagerCompat */
public final class C0183en {
    public final NotificationManager a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2911a;

    /* renamed from: en$a */
    /* compiled from: NotificationManagerCompat */
    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static {
        new HashSet();
    }

    public C0183en(Context context) {
        this.f2911a = context;
        this.a = (NotificationManager) context.getSystemService("notification");
    }

    public final boolean a() {
        return a.a(this.a);
    }
}
