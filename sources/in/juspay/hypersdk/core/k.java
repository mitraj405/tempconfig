package in.juspay.hypersdk.core;

import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f5502a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f5503a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5504c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ k(AndroidInterface androidInterface, String str, JSONObject jSONObject, int i, boolean z, String str2, String str3) {
        this.a = androidInterface;
        this.f5504c = str;
        this.f5502a = jSONObject;
        this.c = i;
        this.f5503a = z;
        this.d = str2;
        this.e = str3;
    }

    public final void run() {
        this.a.lambda$addViewToParent$1(this.f5504c, this.f5502a, this.c, this.f5503a, this.d, this.e);
    }
}
