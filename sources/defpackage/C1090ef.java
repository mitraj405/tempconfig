package defpackage;

import in.juspay.services.HyperServices;
import org.json.JSONObject;

/* renamed from: ef  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1090ef implements Runnable {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HyperServices f5451a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f5452a;

    public /* synthetic */ C1090ef(HyperServices hyperServices, long j, JSONObject jSONObject) {
        this.f5451a = hyperServices;
        this.a = j;
        this.f5452a = jSONObject;
    }

    public final void run() {
        this.f5451a.lambda$doProcess$6(this.a, this.f5452a);
    }
}
