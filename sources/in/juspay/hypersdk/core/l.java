package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f5505a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5506c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ l(AndroidInterface androidInterface, String str, String str2, int i, String str3, boolean z, String str4, String str5) {
        this.a = androidInterface;
        this.f5506c = str;
        this.d = str2;
        this.c = i;
        this.e = str3;
        this.f5505a = z;
        this.f = str4;
        this.g = str5;
    }

    public final void run() {
        this.a.lambda$addStoredViewToParent$3(this.f5506c, this.d, this.c, this.e, this.f5505a, this.f, this.g);
    }
}
