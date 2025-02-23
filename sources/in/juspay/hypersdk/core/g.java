package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f5497a;
    public final /* synthetic */ String c;

    public /* synthetic */ g(AndroidInterface androidInterface, boolean z, String str) {
        this.a = androidInterface;
        this.f5497a = z;
        this.c = str;
    }

    public final void run() {
        this.a.lambda$setPrepareScreenTaskStatus$20(this.f5497a, this.c);
    }
}
