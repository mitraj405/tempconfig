package defpackage;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.common.net.HttpHeaders;

/* renamed from: K7  reason: default package */
/* compiled from: CustomTabsIntent */
public final class K7 {
    public final Intent a;

    /* renamed from: a  reason: collision with other field name */
    public final Bundle f333a;

    /* renamed from: K7$a */
    /* compiled from: CustomTabsIntent */
    public static class a {
        public static ActivityOptions a() {
            return ActivityOptions.makeBasic();
        }
    }

    /* renamed from: K7$b */
    /* compiled from: CustomTabsIntent */
    public static class b {
        public static String a() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    /* renamed from: K7$c */
    /* compiled from: CustomTabsIntent */
    public static class c {
        public static void a(ActivityOptions activityOptions, boolean z) {
            activityOptions.setShareIdentityEnabled(z);
        }
    }

    public K7(Intent intent, Bundle bundle) {
        this.a = intent;
        this.f333a = bundle;
    }

    /* renamed from: K7$d */
    /* compiled from: CustomTabsIntent */
    public static final class d {
        public ActivityOptions a;

        /* renamed from: a  reason: collision with other field name */
        public final Intent f334a;

        /* renamed from: a  reason: collision with other field name */
        public final C1354qp f335a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f336a;

        public d() {
            this.f334a = new Intent("android.intent.action.VIEW");
            this.f335a = new C1354qp();
            this.f336a = true;
        }

        public final K7 a() {
            Bundle bundle;
            Intent intent = this.f334a;
            Bundle bundle2 = null;
            if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle3 = new Bundle();
                bundle3.putBinder("android.support.customtabs.extra.SESSION", (IBinder) null);
                intent.putExtras(bundle3);
            }
            intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f336a);
            this.f335a.getClass();
            intent.putExtras(new Bundle());
            intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
            int i = Build.VERSION.SDK_INT;
            String a2 = b.a();
            if (!TextUtils.isEmpty(a2)) {
                if (intent.hasExtra("com.android.browser.headers")) {
                    bundle = intent.getBundleExtra("com.android.browser.headers");
                } else {
                    bundle = new Bundle();
                }
                if (!bundle.containsKey(HttpHeaders.ACCEPT_LANGUAGE)) {
                    bundle.putString(HttpHeaders.ACCEPT_LANGUAGE, a2);
                    intent.putExtra("com.android.browser.headers", bundle);
                }
            }
            if (i >= 34) {
                if (this.a == null) {
                    this.a = a.a();
                }
                c.a(this.a, false);
            }
            ActivityOptions activityOptions = this.a;
            if (activityOptions != null) {
                bundle2 = activityOptions.toBundle();
            }
            return new K7(intent, bundle2);
        }

        public d(CustomTabsSession customTabsSession) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f334a = intent;
            this.f335a = new C1354qp();
            this.f336a = true;
            if (customTabsSession != null) {
                intent.setPackage(customTabsSession.f1312a.getPackageName());
                IBinder asBinder = customTabsSession.f1313a.asBinder();
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", asBinder);
                PendingIntent pendingIntent = customTabsSession.a;
                if (pendingIntent != null) {
                    bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                }
                intent.putExtras(bundle);
            }
        }
    }
}
