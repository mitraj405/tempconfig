package in.juspay.hypersdk.core;

import android.util.Pair;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5509c;
    public final /* synthetic */ String d;

    public /* synthetic */ o(AndroidInterface androidInterface, Pair pair, String str, String str2) {
        this.a = androidInterface;
        this.b = pair;
        this.f5509c = str;
        this.d = str2;
    }

    public final void run() {
        int i = this.c;
        String str = this.d;
        String str2 = this.f5509c;
        Object obj = this.b;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((AndroidInterface) obj2).lambda$startAnim$17((Pair) obj, str2, str);
                return;
            default:
                ((JBridge) obj2).lambda$startDatePicker$6(str2, str, (String) obj);
                return;
        }
    }

    public /* synthetic */ o(JBridge jBridge, String str, String str2, String str3) {
        this.a = jBridge;
        this.f5509c = str;
        this.d = str2;
        this.b = str3;
    }
}
