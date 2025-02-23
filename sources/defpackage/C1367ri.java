package defpackage;

import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogSessioniser;
import org.json.JSONObject;

/* renamed from: ri  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1367ri implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f6947c;

    public /* synthetic */ C1367ri(String str, JSONObject jSONObject) {
        this.f6947c = str;
        this.a = jSONObject;
    }

    public final void run() {
        int i = this.c;
        JSONObject jSONObject = this.a;
        String str = this.f6947c;
        switch (i) {
            case 0:
                LogPusher.lambda$setLogHeaderValues$7(str, jSONObject);
                return;
            default:
                LogSessioniser.lambda$addLogLine$4(jSONObject, str);
                return;
        }
    }

    public /* synthetic */ C1367ri(JSONObject jSONObject, String str) {
        this.a = jSONObject;
        this.f6947c = str;
    }
}
