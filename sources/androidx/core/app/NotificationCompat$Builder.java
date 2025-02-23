package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public final class NotificationCompat$Builder {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public long f1733a;

    /* renamed from: a  reason: collision with other field name */
    public Ym f1734a;

    /* renamed from: a  reason: collision with other field name */
    public final Notification f1735a;

    /* renamed from: a  reason: collision with other field name */
    public PendingIntent f1736a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1737a;

    /* renamed from: a  reason: collision with other field name */
    public Bundle f1738a;

    /* renamed from: a  reason: collision with other field name */
    public RemoteViews f1739a;

    /* renamed from: a  reason: collision with other field name */
    public IconCompat f1740a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f1741a;

    /* renamed from: a  reason: collision with other field name */
    public String f1742a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f1743a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f1744a = true;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public RemoteViews f1745b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f1746b;

    /* renamed from: b  reason: collision with other field name */
    public String f1747b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<C0370vp> f1748b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public boolean f1749b;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f1750c;

    /* renamed from: c  reason: collision with other field name */
    public final ArrayList<a> f1751c = new ArrayList<>();

    /* renamed from: c  reason: collision with other field name */
    public boolean f1752c = false;
    public int d = 0;
    @Deprecated

    /* renamed from: d  reason: collision with other field name */
    public final ArrayList<String> f1753d;

    /* renamed from: d  reason: collision with other field name */
    public final boolean f1754d;

    public static class a {
        public static AudioAttributes a(AudioAttributes.Builder builder) {
            return builder.build();
        }

        public static AudioAttributes.Builder b() {
            return new AudioAttributes.Builder();
        }

        public static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i) {
            return builder.setContentType(i);
        }

        public static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i) {
            return builder.setLegacyStreamType(i);
        }

        public static AudioAttributes.Builder e(AudioAttributes.Builder builder, int i) {
            return builder.setUsage(i);
        }
    }

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.f1735a = notification;
        this.f1737a = context;
        this.f1747b = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.b = 0;
        this.f1753d = new ArrayList<>();
        this.f1754d = true;
    }

    public static CharSequence c(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }

    public final void a(a aVar) {
        this.f1743a.add(aVar);
    }

    public final Notification b() {
        Bundle bundle;
        Zm zm = new Zm(this);
        NotificationCompat$Builder notificationCompat$Builder = zm.f767a;
        Ym ym = notificationCompat$Builder.f1734a;
        if (ym != null) {
            ym.b(zm);
        }
        if (ym != null) {
            ym.e();
        }
        Notification build = zm.a.build();
        RemoteViews remoteViews = notificationCompat$Builder.f1739a;
        if (remoteViews != null) {
            build.contentView = remoteViews;
        }
        if (ym != null) {
            ym.d();
        }
        if (ym != null) {
            notificationCompat$Builder.f1734a.f();
        }
        if (!(ym == null || (bundle = build.extras) == null)) {
            ym.a(bundle);
        }
        return build;
    }

    public final void d(int i) {
        this.c = i;
    }

    public final void e(PendingIntent pendingIntent) {
        this.f1736a = pendingIntent;
    }

    public final void f(CharSequence charSequence) {
        this.f1746b = c(charSequence);
    }

    public final void g(String str) {
        this.f1741a = c(str);
    }

    public final void h(RemoteViews remoteViews) {
        this.f1745b = remoteViews;
    }

    public final void i(RemoteViews remoteViews) {
        this.f1739a = remoteViews;
    }

    public final void j(int i, boolean z) {
        Notification notification = this.f1735a;
        if (z) {
            notification.flags = i | notification.flags;
            return;
        }
        notification.flags = (~i) & notification.flags;
    }

    public final void k(boolean z) {
        j(2, z);
    }

    public final void l(int i) {
        this.f1735a.icon = i;
    }

    public final void m(Ym ym) {
        if (this.f1734a != ym) {
            this.f1734a = ym;
            if (ym != null) {
                ym.g(this);
            }
        }
    }

    public final void n(long j) {
        this.f1733a = j;
    }
}
