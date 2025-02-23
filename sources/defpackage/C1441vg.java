package defpackage;

import in.juspay.hypersdk.core.JBridge;
import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: vg  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1441vg implements Runnable {
    public final /* synthetic */ float a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JBridge f6996a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SdkTracker f6997a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f6998a;
    public final /* synthetic */ float b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f6999c;

    public /* synthetic */ C1441vg(JBridge jBridge, int i, String str, boolean z, float f, float f2, SdkTracker sdkTracker) {
        this.f6996a = jBridge;
        this.c = i;
        this.f6999c = str;
        this.f6998a = z;
        this.a = f;
        this.b = f2;
        this.f6997a = sdkTracker;
    }

    public final void run() {
        this.f6996a.lambda$startLottieAnimation$7(this.c, this.f6999c, this.f6998a, this.a, this.b, this.f6997a);
    }
}
