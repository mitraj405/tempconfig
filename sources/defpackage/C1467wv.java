package defpackage;

import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: wv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1467wv implements Runnable {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ C1467wv(String str, String str2, Throwable th, String str3, String str4, String str5) {
        this.c = str;
        this.d = str2;
        this.a = th;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    public final void run() {
        SdkTracker.lambda$trackAndLogBootException$5(this.c, this.d, this.a, this.e, this.f, this.g);
    }
}
