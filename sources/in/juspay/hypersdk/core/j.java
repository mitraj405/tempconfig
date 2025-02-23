package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ AndroidInterface a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5501c;
    public final /* synthetic */ String d;

    public /* synthetic */ j(int i, AndroidInterface androidInterface, String str, String str2) {
        this.c = i;
        this.a = androidInterface;
        this.f5501c = str;
        this.d = str2;
    }

    public final void run() {
        int i = this.c;
        AndroidInterface androidInterface = this.a;
        String str = this.d;
        String str2 = this.f5501c;
        switch (i) {
            case 0:
                androidInterface.lambda$runCmdsInBg$9(str2, str);
                return;
            case 1:
                androidInterface.lambda$runInUI$8(str2, str);
                return;
            default:
                androidInterface.lambda$updateProperties$11(str2, str);
                return;
        }
    }
}
