package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AndroidInterface a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5493c;
    public final /* synthetic */ String d;

    public /* synthetic */ c(int i, AndroidInterface androidInterface, String str, String str2) {
        this.a = androidInterface;
        this.f5493c = str;
        this.c = i;
        this.d = str2;
    }

    public final void run() {
        this.a.lambda$toggleKeyboard$13(this.f5493c, this.c, this.d);
    }
}
