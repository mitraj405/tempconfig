package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.StatusBarNotification;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import java.util.Locale;

public abstract class TrustedWebActivityService extends Service {
    public NotificationManager a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1316a = new a();
    public int c = -1;

    public class a extends ITrustedWebActivityService.Stub {
        public a() {
        }

        public final Bundle areNotificationsEnabled(Bundle bundle) {
            NotificationChannel notificationChannel;
            b();
            r1.o(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            String string = bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME");
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            trustedWebActivityService.b();
            boolean z = false;
            if (new C0183en(trustedWebActivityService).a() && ((notificationChannel = trustedWebActivityService.a.getNotificationChannel(TrustedWebActivityService.a(string))) == null || notificationChannel.getImportance() != 0)) {
                z = true;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z);
            return bundle2;
        }

        public final void b() {
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int i = trustedWebActivityService.c;
            if (i == -1) {
                trustedWebActivityService.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                trustedWebActivityService.c();
                throw null;
            } else if (i != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
        }

        public final void cancelNotification(Bundle bundle) {
            b();
            r1.o(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            r1.o(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            String string = bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG");
            int i = bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID");
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            trustedWebActivityService.b();
            trustedWebActivityService.a.cancel(string, i);
        }

        public final Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
            b();
            if (iBinder != null) {
                ITrustedWebActivityCallback.Stub.asInterface(iBinder);
            }
            TrustedWebActivityService.this.getClass();
            return null;
        }

        public final Bundle getActiveNotifications() {
            b();
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            trustedWebActivityService.b();
            StatusBarNotification[] activeNotifications = trustedWebActivityService.a.getActiveNotifications();
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", activeNotifications);
            return bundle;
        }

        public final Bundle getSmallIconBitmap() {
            b();
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            int d = trustedWebActivityService.d();
            Bundle bundle = new Bundle();
            if (d != -1) {
                bundle.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(trustedWebActivityService.getResources(), d));
            }
            return bundle;
        }

        public final int getSmallIconId() {
            b();
            return TrustedWebActivityService.this.d();
        }

        public final Bundle notifyNotificationWithChannel(Bundle bundle) {
            Notification notification;
            boolean z;
            b();
            r1.o(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
            r1.o(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
            r1.o(bundle, "android.support.customtabs.trusted.NOTIFICATION");
            r1.o(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
            String string = bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG");
            int i = bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID");
            Notification notification2 = (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION");
            String string2 = bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME");
            TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
            trustedWebActivityService.b();
            boolean z2 = false;
            if (new C0183en(trustedWebActivityService).a()) {
                String a2 = TrustedWebActivityService.a(string2);
                NotificationManager notificationManager = trustedWebActivityService.a;
                notificationManager.createNotificationChannel(new NotificationChannel(a2, string2, 3));
                if (notificationManager.getNotificationChannel(a2).getImportance() == 0) {
                    notification = null;
                } else {
                    Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(trustedWebActivityService, notification2);
                    recoverBuilder.setChannelId(a2);
                    notification = recoverBuilder.build();
                }
                NotificationChannel notificationChannel = trustedWebActivityService.a.getNotificationChannel(a2);
                if (notificationChannel == null || notificationChannel.getImportance() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    trustedWebActivityService.a.notify(string, i, notification);
                    z2 = true;
                }
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z2);
            return bundle2;
        }
    }

    public static String a(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public final void b() {
        if (this.a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
    }

    public abstract C0176eA c();

    public final int d() {
        try {
            Bundle bundle = getPackageManager().getServiceInfo(new ComponentName(this, getClass()), 128).metaData;
            if (bundle == null) {
                return -1;
            }
            return bundle.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public final IBinder onBind(Intent intent) {
        return this.f1316a;
    }

    public final void onCreate() {
        super.onCreate();
        this.a = (NotificationManager) getSystemService("notification");
    }

    public final boolean onUnbind(Intent intent) {
        this.c = -1;
        return super.onUnbind(intent);
    }
}
