package in.juspay.hypersdk.core;

import org.json.JSONArray;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f5507a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5508c;
    public final /* synthetic */ int d;

    public /* synthetic */ n(AndroidInterface androidInterface, String str, int i, Object obj, int i2) {
        this.c = i2;
        this.a = androidInterface;
        this.f5508c = str;
        this.d = i;
        this.f5507a = obj;
    }

    public final void run() {
        int i = this.c;
        int i2 = this.d;
        String str = this.f5508c;
        AndroidInterface androidInterface = this.a;
        Object obj = this.f5507a;
        switch (i) {
            case 0:
                androidInterface.lambda$updateAnim$19(str, i2, (JSONArray) obj);
                return;
            default:
                androidInterface.lambda$setImage$12(str, i2, (String) obj);
                return;
        }
    }
}
