package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsCallback;
import com.google.android.gms.internal.ads.zzbcu;

/* renamed from: J7  reason: default package */
/* compiled from: CustomTabsClient */
public final class J7 extends ICustomTabsCallback.Stub {
    public final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CustomTabsCallback f292a;

    /* renamed from: J7$a */
    /* compiled from: CustomTabsClient */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f293a;

        public a(Bundle bundle) {
            this.f293a = bundle;
        }

        public final void run() {
            J7.this.f292a.onUnminimized(this.f293a);
        }
    }

    /* renamed from: J7$b */
    /* compiled from: CustomTabsClient */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f294a;
        public final /* synthetic */ int c;

        public b(int i, Bundle bundle) {
            this.c = i;
            this.f294a = bundle;
        }

        public final void run() {
            J7.this.f292a.onNavigationEvent(this.c, this.f294a);
        }
    }

    /* renamed from: J7$c */
    /* compiled from: CustomTabsClient */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f295a;
        public final /* synthetic */ String c;

        public c(String str, Bundle bundle) {
            this.c = str;
            this.f295a = bundle;
        }

        public final void run() {
            J7.this.f292a.extraCallback(this.c, this.f295a);
        }
    }

    /* renamed from: J7$d */
    /* compiled from: CustomTabsClient */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f296a;

        public d(Bundle bundle) {
            this.f296a = bundle;
        }

        public final void run() {
            J7.this.f292a.onMessageChannelReady(this.f296a);
        }
    }

    /* renamed from: J7$e */
    /* compiled from: CustomTabsClient */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f297a;
        public final /* synthetic */ String c;

        public e(String str, Bundle bundle) {
            this.c = str;
            this.f297a = bundle;
        }

        public final void run() {
            J7.this.f292a.onPostMessage(this.c, this.f297a);
        }
    }

    /* renamed from: J7$f */
    /* compiled from: CustomTabsClient */
    public class f implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Uri f298a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f299a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ boolean f300a;
        public final /* synthetic */ int c;

        public f(int i, Uri uri, boolean z, Bundle bundle) {
            this.c = i;
            this.f298a = uri;
            this.f300a = z;
            this.f299a = bundle;
        }

        public final void run() {
            J7.this.f292a.onRelationshipValidationResult(this.c, this.f298a, this.f300a, this.f299a);
        }
    }

    /* renamed from: J7$g */
    /* compiled from: CustomTabsClient */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f301a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;

        public g(int i, int i2, Bundle bundle) {
            this.c = i;
            this.d = i2;
            this.f301a = bundle;
        }

        public final void run() {
            J7.this.f292a.onActivityResized(this.c, this.d, this.f301a);
        }
    }

    /* renamed from: J7$h */
    /* compiled from: CustomTabsClient */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f302a;

        public h(Bundle bundle) {
            this.f302a = bundle;
        }

        public final void run() {
            J7.this.f292a.onWarmupCompleted(this.f302a);
        }
    }

    /* renamed from: J7$i */
    /* compiled from: CustomTabsClient */
    public class i implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f303a;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;

        public i(int i, int i2, int i3, int i4, int i5, Bundle bundle) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.f303a = bundle;
        }

        public final void run() {
            J7.this.f292a.onActivityLayout(this.c, this.d, this.e, this.f, this.g, this.f303a);
        }
    }

    /* renamed from: J7$j */
    /* compiled from: CustomTabsClient */
    public class j implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Bundle f304a;

        public j(Bundle bundle) {
            this.f304a = bundle;
        }

        public final void run() {
            J7.this.f292a.onMinimized(this.f304a);
        }
    }

    public J7(zzbcu zzbcu) {
        this.f292a = zzbcu;
    }

    public final void extraCallback(String str, Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new c(str, bundle));
        }
    }

    public final Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
        CustomTabsCallback customTabsCallback = this.f292a;
        if (customTabsCallback == null) {
            return null;
        }
        return customTabsCallback.extraCallbackWithResult(str, bundle);
    }

    public final void onActivityLayout(int i2, int i3, int i4, int i5, int i6, Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new i(i2, i3, i4, i5, i6, bundle));
        }
    }

    public final void onActivityResized(int i2, int i3, Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new g(i2, i3, bundle));
        }
    }

    public final void onMessageChannelReady(Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new d(bundle));
        }
    }

    public final void onMinimized(Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new j(bundle));
        }
    }

    public final void onNavigationEvent(int i2, Bundle bundle) {
        if (this.f292a != null) {
            this.a.post(new b(i2, bundle));
        }
    }

    public final void onPostMessage(String str, Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new e(str, bundle));
        }
    }

    public final void onRelationshipValidationResult(int i2, Uri uri, boolean z, Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new f(i2, uri, z, bundle));
        }
    }

    public final void onUnminimized(Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new a(bundle));
        }
    }

    public final void onWarmupCompleted(Bundle bundle) throws RemoteException {
        if (this.f292a != null) {
            this.a.post(new h(bundle));
        }
    }
}
