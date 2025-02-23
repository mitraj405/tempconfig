package defpackage;

import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: vv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1447vv implements Runnable {
    public final /* synthetic */ SdkTracker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Integer f7001a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Long f7002a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f7003a;
    public final /* synthetic */ Long b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ Object f7004b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ C1447vv(SdkTracker sdkTracker, String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5) {
        this.a = sdkTracker;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f7001a = num;
        this.f = str4;
        this.f7002a = l;
        this.b = l2;
        this.f7003a = obj;
        this.f7004b = obj2;
        this.g = str5;
    }

    public final void run() {
        this.a.lambda$trackApiCalls$9(this.c, this.d, this.e, this.f7001a, this.f, this.f7002a, this.b, this.f7003a, this.f7004b, this.g);
    }
}
