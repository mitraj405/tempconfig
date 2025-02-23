package defpackage;

import android.app.Activity;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.safe.Godel;
import org.json.JSONObject;

/* renamed from: yv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1504yv implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f7073c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ C1504yv(SdkTracker sdkTracker, String str, String str2, String str3, Object obj, int i) {
        this.c = i;
        this.a = sdkTracker;
        this.f7073c = str;
        this.d = str2;
        this.e = str3;
        this.b = obj;
    }

    public final void run() {
        int i = this.c;
        String str = this.e;
        String str2 = this.d;
        String str3 = this.f7073c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((SdkTracker) obj2).lambda$trackLifecycle$7(str3, str2, str, (JSONObject) obj);
                return;
            case 1:
                ((SdkTracker) obj2).lambda$trackContext$12(str3, str2, str, obj);
                return;
            default:
                ((Godel) obj2).lambda$onBrowserReady$0((Activity) obj, str3, str2, str);
                return;
        }
    }

    public /* synthetic */ C1504yv(Godel godel, Activity activity, String str, String str2, String str3) {
        this.c = 2;
        this.a = godel;
        this.b = activity;
        this.f7073c = str;
        this.d = str2;
        this.e = str3;
    }
}
