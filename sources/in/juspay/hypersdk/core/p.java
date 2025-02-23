package in.juspay.hypersdk.core;

import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5510c;
    public final /* synthetic */ String d;

    public /* synthetic */ p(AndroidInterface androidInterface, String str, JSONObject jSONObject, String str2) {
        this.a = androidInterface;
        this.f5510c = str;
        this.b = jSONObject;
        this.d = str2;
    }

    public final void run() {
        int i = this.c;
        String str = this.f5510c;
        String str2 = this.d;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((AndroidInterface) obj2).lambda$prepareAndStoreView$2(str, (JSONObject) obj, str2);
                return;
            default:
                ((DuiInterface) obj2).lambda$runInJuspayBrowser$4(str, str2, (SdkTracker) obj);
                return;
        }
    }

    public /* synthetic */ p(DuiInterface duiInterface, String str, String str2, SdkTracker sdkTracker) {
        this.a = duiInterface;
        this.f5510c = str;
        this.d = str2;
        this.b = sdkTracker;
    }
}
