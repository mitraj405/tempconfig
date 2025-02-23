package in.juspay.hypersdk.core;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String[] f5511a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5512c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ q(AndroidInterface androidInterface, String str, String str2, int i, String[] strArr, String str3) {
        this.a = androidInterface;
        this.f5512c = str;
        this.d = str2;
        this.c = i;
        this.f5511a = strArr;
        this.e = str3;
    }

    public final void run() {
        this.a.lambda$generateUIElement$15(this.f5512c, this.d, this.c, this.f5511a, this.e);
    }
}
