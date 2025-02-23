package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;

public final class CustomTabsSession {
    public final PendingIntent a;

    /* renamed from: a  reason: collision with other field name */
    public final ComponentName f1312a;

    /* renamed from: a  reason: collision with other field name */
    public final ICustomTabsCallback f1313a;

    /* renamed from: a  reason: collision with other field name */
    public final ICustomTabsService f1314a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f1315a = new Object();

    public CustomTabsSession(ICustomTabsService iCustomTabsService, J7 j7, ComponentName componentName) {
        this.f1314a = iCustomTabsService;
        this.f1313a = j7;
        this.f1312a = componentName;
        this.a = null;
    }

    public final void a(String str) {
        Bundle bundle = new Bundle();
        PendingIntent pendingIntent = this.a;
        if (pendingIntent != null) {
            bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
        }
        synchronized (this.f1315a) {
            try {
                this.f1314a.postMessage(this.f1313a, str, bundle);
            } catch (RemoteException unused) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
