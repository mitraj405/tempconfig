package in.juspay.hypersdk.core;

import in.juspay.hypersdk.safe.JuspayWebView;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5492c;
    public final /* synthetic */ String d;

    public /* synthetic */ b(AndroidInterface androidInterface, String str, String str2) {
        this.a = androidInterface;
        this.f5492c = str;
        this.d = str2;
    }

    public final void run() {
        int i = this.c;
        String str = this.d;
        String str2 = this.f5492c;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((AndroidInterface) obj).lambda$runCmdsInUI$10(str2, str);
                return;
            default:
                DuiInterface.lambda$loadUrl$6(str2, (JuspayWebView) obj, str);
                return;
        }
    }

    public /* synthetic */ b(String str, JuspayWebView juspayWebView, String str2) {
        this.f5492c = str;
        this.a = juspayWebView;
        this.d = str2;
    }
}
