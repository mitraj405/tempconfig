package androidx.media.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.KeyEvent;
import defpackage.d7;
import java.util.List;
import java.util.Objects;

public class MediaButtonReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static ForegroundServiceStartNotAllowedException a(IllegalStateException illegalStateException) {
            return (ForegroundServiceStartNotAllowedException) illegalStateException;
        }

        public static boolean b(IllegalStateException illegalStateException) {
            return illegalStateException instanceof ForegroundServiceStartNotAllowedException;
        }
    }

    public static class b extends MediaBrowserCompat.ConnectionCallback {
        public final BroadcastReceiver.PendingResult a;

        /* renamed from: a  reason: collision with other field name */
        public final Context f2254a;

        /* renamed from: a  reason: collision with other field name */
        public final Intent f2255a;

        /* renamed from: a  reason: collision with other field name */
        public MediaBrowserCompat f2256a;

        public b(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f2254a = context;
            this.f2255a = intent;
            this.a = pendingResult;
        }

        public final void onConnected() {
            new MediaControllerCompat(this.f2254a, this.f2256a.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.f2255a.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            this.f2256a.disconnect();
            this.a.finish();
        }

        public final void onConnectionFailed() {
            this.f2256a.disconnect();
            this.a.finish();
        }

        public final void onConnectionSuspended() {
            this.f2256a.disconnect();
            this.a.finish();
        }
    }

    public static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            return new ComponentName(serviceInfo.packageName, serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            StringBuilder K = xx.K("Expected 1 service that handles ", str, ", found ");
            K.append(queryIntentServices.size());
            throw new IllegalStateException(K.toString());
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Objects.toString(intent);
            return;
        }
        ComponentName a2 = a(context, "android.intent.action.MEDIA_BUTTON");
        if (a2 != null) {
            intent.setComponent(a2);
            try {
                Object obj = d7.a;
                d7.d.b(context, intent);
            } catch (IllegalStateException e) {
                if (Build.VERSION.SDK_INT < 31 || !a.b(e)) {
                    throw e;
                }
                a.a(e).getMessage();
            }
        } else {
            ComponentName a3 = a(context, "android.media.browse.MediaBrowserService");
            if (a3 != null) {
                BroadcastReceiver.PendingResult goAsync = goAsync();
                Context applicationContext = context.getApplicationContext();
                b bVar = new b(applicationContext, intent, goAsync);
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a3, bVar, (Bundle) null);
                bVar.f2256a = mediaBrowserCompat;
                mediaBrowserCompat.connect();
                return;
            }
            throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
        }
    }
}
