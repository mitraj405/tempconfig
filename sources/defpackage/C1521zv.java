package defpackage;

import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: zv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1521zv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f7118a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ C1521zv(SdkTracker sdkTracker, String str, String str2, String str3, Throwable th, String str4, String str5) {
        this.a = sdkTracker;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f7118a = th;
        this.f = str4;
        this.g = str5;
    }

    public final void run() {
        this.a.lambda$trackAndLogException$15(this.c, this.d, this.e, this.f7118a, this.f, this.g);
    }
}
