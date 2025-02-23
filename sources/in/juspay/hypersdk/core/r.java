package in.juspay.hypersdk.core;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import in.juspay.hypersdk.safe.JuspayWebView;
import org.json.JSONObject;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f5513c;

    public /* synthetic */ r(JsInterface jsInterface, String str, Object obj, int i) {
        this.c = i;
        this.b = jsInterface;
        this.a = str;
        this.f5513c = obj;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.f5513c;
        Object obj2 = this.a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                ((DynamicUI) obj3).lambda$addJavascriptInterface$1(obj, (String) obj2);
                return;
            case 1:
                ((DuiInterface) obj3).lambda$runInJuspayBrowser$3((String) obj2, (SdkTracker) obj);
                return;
            case 2:
                ((DuiInterface) obj3).lambda$runInJuspayWebView$5((String) obj2, (JuspayWebView) obj);
                return;
            case 3:
                ((JsInterface) obj3).lambda$requestPendingLogs$3((String) obj2, (String) obj);
                return;
            case 4:
                ((JuspayServices) obj3).lambda$logEncryptionSupport$1((JSONObject) obj, (SdkTracker) obj2);
                return;
            default:
                ((JuspayServices) obj3).lambda$process$4((FragmentActivity) obj, (ViewGroup) obj2);
                return;
        }
    }

    public /* synthetic */ r(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.b = obj;
        this.f5513c = obj2;
        this.a = obj3;
    }
}
