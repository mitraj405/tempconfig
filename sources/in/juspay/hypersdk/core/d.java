package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ AndroidInterface a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5494c;

    public /* synthetic */ d(AndroidInterface androidInterface, String str, int i) {
        this.a = androidInterface;
        this.f5494c = str;
        this.c = i;
    }

    public final void run() {
        this.a.lambda$removeView$6(this.f5494c, this.c);
    }
}
