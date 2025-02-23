package defpackage;

import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.services.HyperServices;
import org.json.JSONObject;

/* renamed from: df  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1069df implements Runnable {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HyperPaymentsCallback f5437a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HyperServices f5438a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f5439a;

    public /* synthetic */ C1069df(HyperServices hyperServices, long j, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        this.f5438a = hyperServices;
        this.a = j;
        this.f5439a = jSONObject;
        this.f5437a = hyperPaymentsCallback;
    }

    public final void run() {
        this.f5438a.lambda$initiate$3(this.a, this.f5439a, this.f5437a);
    }
}
