package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.support.customtabs.IEngagementSignalsCallback;
import androidx.collection.SimpleArrayMap;
import java.util.List;

public abstract class CustomTabsService extends Service {
    public final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final SimpleArrayMap<IBinder, IBinder.DeathRecipient> f1311a = new SimpleArrayMap<>();

    public class a extends ICustomTabsService.Stub {
        public a() {
        }

        public static PendingIntent b(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("android.support.customtabs.extra.SESSION_ID");
            bundle.remove("android.support.customtabs.extra.SESSION_ID");
            return pendingIntent;
        }

        public final boolean c(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
            try {
                L7 l7 = new L7(this, new M7(iCustomTabsCallback, pendingIntent));
                synchronized (CustomTabsService.this.f1311a) {
                    iCustomTabsCallback.asBinder().linkToDeath(l7, 0);
                    CustomTabsService.this.f1311a.put(iCustomTabsCallback.asBinder(), l7);
                }
                return CustomTabsService.this.c();
            } catch (RemoteException unused) {
                return false;
            }
        }

        public final Bundle extraCommand(String str, Bundle bundle) {
            return CustomTabsService.this.a();
        }

        public final boolean isEngagementSignalsApiAvailable(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            new M7(iCustomTabsCallback, b(bundle));
            CustomTabsService.this.getClass();
            return false;
        }

        public final boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
            new M7(iCustomTabsCallback, b(bundle));
            return CustomTabsService.this.b();
        }

        public final boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
            return c(iCustomTabsCallback, (PendingIntent) null);
        }

        public final boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            return c(iCustomTabsCallback, b(bundle));
        }

        public final int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
            new M7(iCustomTabsCallback, b(bundle));
            return CustomTabsService.this.d();
        }

        public final boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i, Bundle bundle) {
            new M7(iCustomTabsCallback, b(bundle));
            return CustomTabsService.this.e();
        }

        public final boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
            new M7(iCustomTabsCallback, (PendingIntent) null);
            new Bundle();
            return CustomTabsService.this.f();
        }

        public final boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) {
            new M7(iCustomTabsCallback, b(bundle));
            if (bundle != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    Uri uri2 = (Uri) W0.a(bundle, "target_origin", Uri.class);
                } else {
                    Uri uri3 = (Uri) bundle.getParcelable("target_origin");
                }
            }
            return CustomTabsService.this.f();
        }

        public final boolean setEngagementSignalsCallback(ICustomTabsCallback iCustomTabsCallback, IBinder iBinder, Bundle bundle) {
            IEngagementSignalsCallback.Stub.asInterface(iBinder);
            new M7(iCustomTabsCallback, b(bundle));
            CustomTabsService.this.getClass();
            return false;
        }

        public final boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
            new M7(iCustomTabsCallback, b(bundle));
            return CustomTabsService.this.g();
        }

        public final boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) {
            new M7(iCustomTabsCallback, b(bundle));
            return CustomTabsService.this.h();
        }

        public final boolean warmup(long j) {
            return CustomTabsService.this.i();
        }
    }

    public abstract Bundle a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract int d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    public final IBinder onBind(Intent intent) {
        return this.a;
    }
}
