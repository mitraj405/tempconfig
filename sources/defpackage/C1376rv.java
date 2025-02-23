package defpackage;

import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: rv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1376rv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Throwable f6948a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ C1376rv(SdkTracker sdkTracker, String str, String str2, String str3, String str4, Throwable th) {
        this.a = sdkTracker;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.f6948a = th;
    }

    public final void run() {
        this.a.lambda$trackException$13(this.c, this.d, this.e, this.f, this.f6948a);
    }
}
