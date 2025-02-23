package defpackage;

import android.os.Bundle;
import androidx.core.app.NotificationCompat$Builder;

/* renamed from: Ym  reason: default package */
/* compiled from: NotificationCompat */
public abstract class Ym {
    public NotificationCompat$Builder a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f713a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f714a = false;
    public CharSequence b;

    public void a(Bundle bundle) {
        if (this.f714a) {
            bundle.putCharSequence("android.summaryText", this.b);
        }
        CharSequence charSequence = this.f713a;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String c = c();
        if (c != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c);
        }
    }

    public abstract void b(Zm zm);

    public abstract String c();

    public final void g(NotificationCompat$Builder notificationCompat$Builder) {
        if (this.a != notificationCompat$Builder) {
            this.a = notificationCompat$Builder;
            if (notificationCompat$Builder != null) {
                notificationCompat$Builder.m(this);
            }
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }
}
