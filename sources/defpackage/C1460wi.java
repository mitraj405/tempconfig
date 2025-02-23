package defpackage;

import in.juspay.hypersdk.analytics.LogSessioniserExp;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: wi  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1460wi implements Runnable {
    public final /* synthetic */ LogSessioniserExp a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ConcurrentHashMap f7034a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f7035a;

    public /* synthetic */ C1460wi(LogSessioniserExp logSessioniserExp, ConcurrentHashMap concurrentHashMap, boolean z) {
        this.a = logSessioniserExp;
        this.f7034a = concurrentHashMap;
        this.f7035a = z;
    }

    public final void run() {
        this.a.lambda$pushToPusher$3(this.f7034a, this.f7035a);
    }
}
