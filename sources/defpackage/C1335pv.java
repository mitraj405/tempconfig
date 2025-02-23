package defpackage;

import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: pv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1335pv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f6891a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f6892c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ C1335pv(SdkTracker sdkTracker, String str, String str2, String str3, String str4, Object obj, int i) {
        this.c = i;
        this.a = sdkTracker;
        this.f6892c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.f6891a = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.a.lambda$trackLifecycle$6(this.f6892c, this.d, this.e, this.f, this.f6891a);
                return;
            default:
                this.a.lambda$trackAction$8(this.f6892c, this.d, this.e, this.f, this.f6891a);
                return;
        }
    }
}
