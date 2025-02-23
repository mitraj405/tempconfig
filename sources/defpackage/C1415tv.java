package defpackage;

import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.SdkTracker;

/* renamed from: tv  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1415tv implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ C1415tv(String str, String str2, String str3, String str4, Object obj) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.a = obj;
    }

    public final void run() {
        SdkTracker.bootLogs.add(SdkTracker.createLog(LogCategory.LIFECYCLE, this.c, this.d, this.e, this.f, this.a));
    }
}
