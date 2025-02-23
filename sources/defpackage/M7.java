package defpackage;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsCallback;

/* renamed from: M7  reason: default package */
/* compiled from: CustomTabsSessionToken */
public final class M7 {
    public final PendingIntent a;

    /* renamed from: a  reason: collision with other field name */
    public final ICustomTabsCallback f394a;

    /* renamed from: M7$a */
    /* compiled from: CustomTabsSessionToken */
    public class a extends CustomTabsCallback {
        public a() {
        }

        public final void extraCallback(String str, Bundle bundle) {
            try {
                M7.this.f394a.extraCallback(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
            try {
                return M7.this.f394a.extraCallbackWithResult(str, bundle);
            } catch (RemoteException unused) {
                return null;
            }
        }

        public final void onActivityLayout(int i, int i2, int i3, int i4, int i5, Bundle bundle) {
            try {
                M7.this.f394a.onActivityLayout(i, i2, i3, i4, i5, bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onActivityResized(int i, int i2, Bundle bundle) {
            try {
                M7.this.f394a.onActivityResized(i, i2, bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onMessageChannelReady(Bundle bundle) {
            try {
                M7.this.f394a.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onMinimized(Bundle bundle) {
            try {
                M7.this.f394a.onMinimized(bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onNavigationEvent(int i, Bundle bundle) {
            try {
                M7.this.f394a.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onPostMessage(String str, Bundle bundle) {
            try {
                M7.this.f394a.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                M7.this.f394a.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onUnminimized(Bundle bundle) {
            try {
                M7.this.f394a.onUnminimized(bundle);
            } catch (RemoteException unused) {
            }
        }

        public final void onWarmupCompleted(Bundle bundle) {
            try {
                M7.this.f394a.onWarmupCompleted(bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    public M7(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.f394a = iCustomTabsCallback;
        this.a = pendingIntent;
        if (iCustomTabsCallback != null) {
            new a();
        }
    }

    public final IBinder a() {
        ICustomTabsCallback iCustomTabsCallback = this.f394a;
        if (iCustomTabsCallback != null) {
            return iCustomTabsCallback.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof M7)) {
            return false;
        }
        M7 m7 = (M7) obj;
        PendingIntent pendingIntent = m7.a;
        boolean z2 = true;
        PendingIntent pendingIntent2 = this.a;
        if (pendingIntent2 == null) {
            z = true;
        } else {
            z = false;
        }
        if (pendingIntent != null) {
            z2 = false;
        }
        if (z != z2) {
            return false;
        }
        if (pendingIntent2 != null) {
            return pendingIntent2.equals(pendingIntent);
        }
        return a().equals(m7.a());
    }

    public final int hashCode() {
        PendingIntent pendingIntent = this.a;
        if (pendingIntent != null) {
            return pendingIntent.hashCode();
        }
        return a().hashCode();
    }
}
