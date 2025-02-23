package in.juspay.hypersdk.core;

import android.graphics.drawable.Drawable;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f5495c;
    public final /* synthetic */ int d;

    public /* synthetic */ e(AndroidInterface androidInterface, String str, JSONObject jSONObject, int i) {
        this.a = androidInterface;
        this.b = str;
        this.f5495c = jSONObject;
        this.d = i;
    }

    public final void run() {
        int i = this.c;
        int i2 = this.d;
        Object obj = this.f5495c;
        Object obj2 = this.b;
        Object obj3 = this.a;
        switch (i) {
            case 0:
                ((AndroidInterface) obj3).lambda$replaceView$4((String) obj2, (JSONObject) obj, i2);
                return;
            default:
                ((JBridge) obj3).lambda$drawIcon$2(i2, (Drawable) obj2, (SdkTracker) obj);
                return;
        }
    }

    public /* synthetic */ e(JBridge jBridge, int i, Drawable drawable, SdkTracker sdkTracker) {
        this.a = jBridge;
        this.d = i;
        this.b = drawable;
        this.f5495c = sdkTracker;
    }
}
