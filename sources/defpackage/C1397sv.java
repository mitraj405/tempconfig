package defpackage;

import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: sv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1397sv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f6963a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ C1397sv(SdkTracker sdkTracker, String str, String str2, String str3, String str4, Object obj) {
        this.a = sdkTracker;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.f6963a = obj;
    }

    public final void run() {
        this.a.lambda$trackContext$11(this.c, this.d, this.e, this.f, this.f6963a);
    }
}
