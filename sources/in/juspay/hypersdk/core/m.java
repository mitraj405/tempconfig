package in.juspay.hypersdk.core;

import androidx.fragment.app.FragmentActivity;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    public /* synthetic */ m(int i, Object obj, Object obj2) {
        this.c = i;
        this.b = obj;
        this.a = obj2;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                ((AndroidInterface) obj2).lambda$processPendingAddScreen$21((String) obj);
                return;
            case 1:
                ((DynamicUI) obj2).lambda$addJsToWebView$0((String) obj);
                return;
            case 2:
                ((JsInterface) obj2).lambda$addLogProperties$1((String) obj);
                return;
            case 3:
                ((JuspayServices) obj2).lambda$setBundleParameter$2((JSONObject) obj);
                return;
            case 4:
                ((JuspayServices) obj2).lambda$addFragment$7((FragmentActivity) obj);
                return;
            case 5:
                ((Renderer) obj2).lambda$replenishCache$1((String) obj);
                return;
            case 6:
                ((SdkTracker) obj2).lambda$track$17((JSONObject) obj);
                return;
            default:
                ((SdkTracker) obj2).lambda$setEndPointSandbox$18((Boolean) obj);
                return;
        }
    }
}
